import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class FunctionalInterfaces {
    // Method that accepts functions as parameters
    public static void processPerson(Person person,
                                     Predicate<Person> predicate,
                                     Function<Person, Person> function,
                                     Consumer<Person> consumer,
                                     Supplier<Person> supplier) {
        if (predicate.test(person)) {
            Person modifiedPerson = function.apply(person);
            consumer.accept(modifiedPerson);
        } else {
            Person newPerson = supplier.get();
            consumer.accept(newPerson);
        }
    }

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30);

        // Example functions
        Predicate<Person> isAdult = p -> p.getAge() >= 18;
        Function<Person, Person> makeOlder = p -> {
            p.setAge(p.getAge() + 1);
            return p;
        };
        Consumer<Person> printPerson = p -> System.out.println("Processed Person: " + p);
        Supplier<Person> createNewPerson = () -> new Person("Unknown", 18);

        // Process the Person object using the functions
        processPerson(person, isAdult, makeOlder, printPerson, createNewPerson);
    }
}

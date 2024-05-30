import java.io.*;

// Define a custom class that implements Serializable
class CustomObject implements Serializable {
    private String name;
    private int age;

    // Constructor
    public CustomObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an instance of the custom object
        CustomObject obj = new CustomObject("John", 30);

        // Serialize the object to a file
        try (FileOutputStream fileOut = new FileOutputStream("object.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            System.out.println("Object has been serialized to object.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("object.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            CustomObject deserializedObj = (CustomObject) objectIn.readObject();
            System.out.println("Object has been deserialized from object.ser");
            System.out.println("Name: " + deserializedObj.getName());
            System.out.println("Age: " + deserializedObj.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
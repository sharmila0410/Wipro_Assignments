import java.lang.reflect.Field;

public class ReflectionExample {
    @SuppressWarnings("unused")
    private String privateField = "hello,it is private";
    public static void main(String[]args) throws Exception{
        Class<?> cs = ReflectionExample.class;
        Field field = cs.getDeclaredField("privateField");
        ReflectionExample obj = new ReflectionExample();
        System.out.println("Before:"+field.get(obj));
        field.set(obj, "hi this is modified value");
        System.out.println("After:"+field.get(obj));

    }
    
}

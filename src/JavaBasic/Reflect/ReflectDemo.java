package JavaBasic.Reflect;


public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException{
        Class cls1 = Class.forName("JavaBasic.Reflect.Person");
        System.out.println(cls1);
        Class cls2 = Person.class;
        System.out.println(cls2);
    }
}

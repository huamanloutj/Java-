package JavaBasic.Reflect;

public class Person {
    private int age;
    private String name;

    /**
     *
     * @param age
     * @param name
     */
    private Person(int age,String name){this.age = age; this.name = name;}
    private Person(){}

    @Override
    public String toString() {
        return super.toString();
    }
}

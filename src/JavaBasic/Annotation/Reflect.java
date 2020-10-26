package JavaBasic.Annotation;

@Pro(className = "JavaBasic.Annotation.Demo1",methodName = "show")
public class Reflect {
    public static void main(String[] args){
        //1.解析注解
        //1.1 获取该类的字节码文件
        Class<Reflect> reflectClass = Reflect.class;
        //2 获取这上面的注解对象
        /**
         *  本次代码相当于
         *  public class ProImpl implements Pro{
         *      public String className(){
         *          return "cn.JavaBasic.annotation.Demo1"
         *      }
         *      public String methodName(){
         *          return ""show;
         *      }
         *  }
         */
        Pro an = reflectClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className + "*******"+ methodName);
        System.out.println();
    }
}

package JavaBasic;

public class TryCathch {
    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                value ++;
            }
        }

    }
    public static int test(){
        try{
            int i=1;
            return i;
        }
        finally{
            int i=2;
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int pow = (int)Math.pow(10,String.valueOf(3234).length() - 1 );
       // System.out.println(pow);
        TryCathch.test();
    }
}

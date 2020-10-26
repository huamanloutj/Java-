import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Test {
    public int helper(int n){
        String str = String.valueOf(n);
        int res = 0;
        for (int i = 0 ; i < str.length() ; i ++){
            res += (str.charAt(i) - '0') * (str.charAt(i) - '0');
        }
        return res;
    }
    public boolean isHappy(int n) {
        n = helper(n);
        while (n != 1){
            n = helper(n);
            System.out.println(n);

        }
        return true;
    }

    public static void main(String[] args) {

//      System.out.println(new Test().isHappy(19));

//        List<Character> res = new ArrayList<>();
//        res.add('1');
//        res.add('2');
        StringBuilder res = new StringBuilder();
        res.append('1');
        res.append('2');
        res.reverse();
        System.out.println(res.toString());
        String str = res.toString();
        System.out.println(Integer.parseInt(str) > 10);
        //System.out.println(str);
    }

}

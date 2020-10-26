package Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "rgb(100,100,100)".substring(4,"rgb(192,192,192)".length() - 1);
        String[] str = s.split("\\,");
        String res = "";
        for (int i = 0 ; i < 3; i ++)
            res+=Integer.toBinaryString(Integer.parseInt(str[i]));
        System.out.println(Long.parseLong(res,2));
    }

}

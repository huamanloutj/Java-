package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TelNumber {
    static  char[][] ch= {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    static ArrayList<String> res = new ArrayList<>();
    static StringBuffer tmp = new StringBuffer();
    public static void telNumber(int level,String s){


        if (level > s.length() - 1) {
            System.out.println("添加" + tmp.toString());
            res.add(tmp.toString());
            System.out.println("res:" + res);
            return;
        }
        int num = (int)s.charAt(level) - (int)'0';
        for (int i = 0 ; i < ch[num].length ; i ++){
             tmp.append(ch[num][i]);
             System.out.println("递归之前" + tmp);
             telNumber(level + 1,s);
             System.out.println("递归之后" + tmp);
             tmp.deleteCharAt(tmp.length() - 1);

        }


    }
    public static void main(String[] args){
        TelNumber tn = new TelNumber();
        String digits = "239";
        int level = 0;
        tn.telNumber(level,digits);
        System.out.println("最终结果" + TelNumber.res);
    }
}

package leetcode;

import java.util.Stack;

public class LeetCode227 {
    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i ++){
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (Character.isDigit(ch)) {
                    //+=惹的不对
                    num = 10 * num + (ch - '0');
                }
                //System.out.println(num);
                if ((!Character.isDigit(ch) ) || i == s.length() - 1) {
                    int pre;
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            pre = stack.peek();
                            stack.pop();
                            stack.push(pre * num);
                            break;
                        case '/':
                            pre = stack.peek();
                            stack.pop();
                            stack.push(pre / num);
                            break;
                    }
                    System.out.println(stack);
                    sign = ch;
                    num = 0;
                }
            }
        }
        int res = 0 ;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args){
        String s = "  hell  o";
        String str2 = s.trim();
        System.out.println(s);
        String str = s.replaceAll(" ","");
        System.out.println(str2);
        //new LeetCode227().calculate(s);
    }
}

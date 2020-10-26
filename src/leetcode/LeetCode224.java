package leetcode;

import java.util.Stack;

/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。

        字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

        示例 1:

        输入: "1 + 1"
        输出: 2
        示例 2:

        输入: " 2-1 + 2 "
        输出: 3
        示例 3:

        输入: "(1+(4+5+2)-3)+(6+8)"
        输出: 23
        说明：

        你可以假设所给定的表达式都是有效的。
        请不要使用内置的库函数 eval。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/basic-calculator
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class LeetCode224 {
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        System.out.println(s);
        return core(s.toCharArray());
    }
    //全局索引
    private int i = 0;
    private int core(char[] chs){
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        //核心
        char operation = '+';
        for (; i < chs.length; i++) {
            if(chs[i]==' '){
                continue;
            }
            if (Character.isDigit(chs[i])) {
        num = num * 10 + (chs[i] - '0');
        } else if (chs[i] == '(') {
        i++;
        num = core(chs.toString().substring(i,chs.length - 1).toCharArray());
        //i++;
        } else if (chs[i] == ')') {
        break;
        }

        //i ==chs.length-1 是为了处理最后一个数字
        if (!Character.isDigit(chs[i]) || i == chs.length - 1) {
        //遇到加减直接压栈
        if (operation == '+') {
        stack.push(num);
        } else if (operation == '-') {
        stack.push(-num);
        //遇到乘除得先计算
        } else if (operation == '*') {
        int a = stack.pop();
        stack.push(a * num);
        } else if (operation == '/') {
        int a = stack.pop();
        stack.push(a / num);
        }
        //update
//                if(i>=chs.length-1){
//                    break;
//                }
        operation = chs[i];
        num = 0;
        }
        }
        int sum = 0;
        //将栈中的结果相加
        while (!stack.isEmpty()) {
        sum += stack.pop();
        }
        System.out.println(sum);
        return sum;
        }
public static void main(String[] args){
        new LeetCode224().calculate("(1+(4+5+2)-3)+(6+8)");
        }
        }


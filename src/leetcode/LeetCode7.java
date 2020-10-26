package leetcode;
/*
整数反转:123->321，考虑整数溢出的问题
 */
public class LeetCode7 {

        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;//这里是-1，不用单独处理负数
                x /= 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
                System.out.println(rev);
            }
            return rev;
        }

    public static void main(String[] args){
        new LeetCode7().reverse(-123);
    }
}

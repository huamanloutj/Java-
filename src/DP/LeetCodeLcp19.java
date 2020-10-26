package DP;

public class LeetCodeLcp19 {
    /*
    动态规划
     */
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        if (n < 3) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        //这里修改的值因为最大值加一会造成整数溢出问题，所以不能使用加1的操作
        //dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        //修改成 n + 1通过了;
        //动态规划状态如何理解，状态初始值怎么理解，怎么设置影响到全局的求解
        dp[0][1] = dp[0][2] = dp[1][2] = n + 1;
        for (int i = 1 ; i < n ; i ++){
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = 1 - isRed;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][1],dp[i - 1][0]) + isRed;
            //if (i >=2)
            //由于超过了上限，加一之后变得最小
            dp[i][2] = Math.min(dp[i - 1][1],dp[i - 1][2]) + isYellow;
        }
        return dp[n - 1][2];
    }
    /*
   数学分析，前缀和的求解，前缀和表示什么
     */

}

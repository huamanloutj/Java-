package leetcode;
/*
折线图题解，平移所有点到x轴之上
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        //求最低点下降到最低开始增加
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        //为什么返回minIndex + 1,因为从minIndex加一的位置开始增加的
        //为什么判断spare < 0 ? 因为可以判断是否能够有一个序列可以返回 < 0 代表没有序列可以 > 0 代表可以返回
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }



}

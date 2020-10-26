package leetcode;
/*
平移数组:向右平移k个单位，因此每个位置最后的位置是确定的
从第0个位置来调整,因此当前位置和要表达的位置相等时
 */
public class LeetCode189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int len  = nums.length;
            k = k % len;
            int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
            for(int start = 0; count < len; start++) {
                int cur = start;       // 从0位置开始换位子
                int pre = nums[cur];
                do{
                    int next = (cur + k) % len;
                    int temp = nums[next];    // 来到角落...
                    nums[next] = pre;
                    pre = temp;
                    cur = next;
                    count++;
                }while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人

            }
        }
    }
}

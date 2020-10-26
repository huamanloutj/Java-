package Link.Stack;

import java.util.Stack;

/*
132模式
给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

注意：n 的值小于15000。

示例1:

输入: [1, 2, 3, 4]

输出: False

解释: 序列中不存在132模式的子序列。

 */
/*
如何建立单调栈
 */
public class LeetCode456 {
    public boolean find132pattern(int[] nums) {
        int[] minJ = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        minJ[0] = nums[0];
        for (int i = 1 ; i <nums.length ; i ++)
            minJ[i] = Math.min(minJ[i - 1],nums[i]);
        for (int i = nums.length - 1 ; i >=0 ; i--){
            if(nums[i] > minJ[i]){
                //一个等号没通过
                while (!stack.isEmpty() && stack.peek() <= minJ[i])
                    stack.pop();
                if(!stack.isEmpty() && nums[i] > stack.peek())
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}

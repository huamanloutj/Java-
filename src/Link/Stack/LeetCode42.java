package Link.Stack;
/*
接雨水问题
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9
题解链接
https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/jie-yu-shui

 */
public class LeetCode42 {
    public int trap(int[] height) {
        //99.99,99.26,备忘录解法
        // if (height.length == 0) return 0;
        // int area = 0;
        // int[] leftmax = new int[height.length];
        // int[] rightmax = new int[height.length];
        // leftmax[0] = height[0];
        // rightmax[height.length - 1] = height[height.length - 1];
        // for (int i = 1 ; i < height.length ; i ++){
        //     leftmax[i] = Math.max(leftmax[i - 1],height[i]);
        // }
        // for (int i = height.length - 2 ; i >=0 ; i --){
        //     rightmax[i] = Math.max(rightmax[i + 1],height[i]);
        // }
        // for (int i = 1 ; i < height.length ; i ++){
        //     area += Math.min(rightmax[i],leftmax[i]) - height[i];
        // }
        // return area;
        //双指针解法
        int n = height.length;
        if (n == 0) return 0;
        int leftmax = height[0];
        int rightmax = height[n - 1];
        int left = 0 , right = n - 1;
        int area = 0;
        //使用<=,因为等于的时候还不会退出
        while (left <= right){
            leftmax = Math.max(leftmax,height[left]);
            rightmax = Math.max(rightmax,height[right]);
            if (leftmax < rightmax){
                area += leftmax - height[left];
                left ++;
            }else{
                area += rightmax - height[right];
                right --;
            }
        }
        return area;
    }
}

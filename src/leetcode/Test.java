package leetcode;

import DataStructure.HSort;
import DataStructure.Sort.QuickSort;

import java.util.*;

public class Test {
    void print(int[] nums){
        for (int x : nums)
            System.out.print(x + " ");
        System.out.print("\n ");
    }

    void swap(int nums[],int low,int high){
        int temp;
        temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
    public static void main(String[] args){



        int[] nums = new int[]{1,2,3,4,5,7};
        int i = 0;
        for (; i < nums.length ; i ++ ) {
            System.out.println(nums[i]);

        }
//        new Test().swap(nums,0,nums.length - 1);
//        new Test().print(nums);
    }
}


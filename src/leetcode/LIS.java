package leetcode;
import java.lang.*;
import java.util.Map;
import java.util.Scanner;
class LIS{
    static int[] nums ;
    private int lisN(int nums[]){
        int i = 0,j = 1;
        int max = 1;
        while ( i < nums.length && j < nums.length){
            while (j < nums.length && nums[i] < nums[j]) j ++;
            max = Math.max(max, j -i);
            i = j;
            j ++;

        }
        return max;
    }
    public static void main(String[] args){

    }
}




package DataStructure.Sort;

import java.util.Queue;

public class QuickSort {
    /**
     *交换尽量不采用另外的函数，避免值传递和地址传递的区别
     */

    void swap(int num1,int num2){
        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;
    }
    void print(int nums[]){
        for (int i = 0; i < nums.length ; i++)
            System.out.print(nums[i] + " ");
        System.out.println("\n");
    }
    int partition(int nums[],int i,int j){
        int pivot = nums[i];
        while( i < j) {
            while (i < j && pivot <= nums[j]) --j;
//            if (i < j){
//                int temp;
//                temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
            nums[i] = nums[j];
            while (i < j && pivot >= nums[i]) ++i;
            //System.out.println("位置i,j " + i + " " + j);
//            if (i < j){
//                int temp;
//                temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
            nums[j] = nums[i];
        }

        nums[i] = pivot;
        return i;
    }
    void quickSort(int nums[],int start,int end){
        if (start < end){
            int pivotpos = partition(nums,start,end);
//            if (pivotpos == nums.length - 2){
//                System.out.println(nums[pivotpos]);
//                System.exit(0);
//            }
            for (int x : nums){
                System.out.print(x + " ");
            }
            System.out.println();
            quickSort(nums,start,pivotpos - 1);
            quickSort(nums,pivotpos + 1,end);
        }

    }
    public static void main(String[] args){
        int[] nums = new int[]{3,1,6,9,2,10,9,4,6};
        QuickSort qs = new QuickSort();
        qs.quickSort(nums,0 ,nums.length - 1);
        qs.print(nums);
//        for (int x : nums)
//            System.out.print(x + " ");
    }
}

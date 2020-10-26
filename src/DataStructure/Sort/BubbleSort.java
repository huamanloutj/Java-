package DataStructure.Sort;

public class BubbleSort {
    public void bubbleSort(int[] nums){
        for (int i = 0 ; i < nums.length - 1 ;i ++) {
            boolean flag = false;
//            for (int j = nums.length - 1 ; j > i ; j --){
                for(int j = 1; j < nums.length - i;j ++){
                if (nums[j - 1] > nums[j]){
                    flag = true;
                    int temp;
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }

            if (flag = false)
                break;
            for (int x : nums)
                System.out.print(x + " ");
            System.out.println();

        }
        for (int x : nums)
            System.out.print(x + " ");

    }
    public static void main(String[] args){
        new BubbleSort().bubbleSort(new int[]{6,7,8,3,2,1});
    }
}

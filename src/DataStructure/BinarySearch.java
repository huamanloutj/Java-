package DataStructure;

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,5,5,7,9};
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid  = left + (right - left)/2;
            if ( nums[mid] < 5 ) left = mid + 1;
            else right = mid;
        }
        if (nums[left] == 5)
            System.out.println(left);
        else
            System.out.println("Not Found");
    }
}

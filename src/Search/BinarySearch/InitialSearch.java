package Search.BinarySearch;
//目标找到一个就行
public class InitialSearch {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意
        int l = 0,r = 0,m;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1; // 注意
                System.out.println("left:" + left);
//                l ++;
//                System.out.println("left:" + l + " left is:" + left);
            }
            else if (nums[mid] > target) {
                right = mid - 1; // 注意
                System.out.println("right:" + right);
//                r ++;
//                System.out.println("right:" + r);
            }
        }
        return left;
    }
    public static void main(String[] args){
        System.out.println(new InitialSearch().binarySearch(new int[]{10,30,50,60},40));
    }
}

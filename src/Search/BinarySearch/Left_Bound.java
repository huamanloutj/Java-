package Search.BinarySearch;

public class Left_Bound {
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        if (nums[left] != target) return  -1;
        System.out.println(left);
        return left;
    }
    //多了一个下划线,与上面的那个还是有差别的，这个找不到会返回-1，另外一个找不到会返回插入位置
    int left_bound_(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况，边界情况需要单独处理
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        //if (v > a[n - 1]) return n + 1;
        int res = 0;
        int left = 0, right = n - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (a[mid] >= v)
                right = mid - 1;
            else if(a[mid] < v){
                left = mid + 1;

            }

        }
        System.out.println(left);
        if ( left >= n || a[left] < v )
            return n + 1;
        return left + 1;
    }
    public static void main(String[] args){
        int a[] = new int[]{5,7,7,8,8,10};
        System.out.println(new Left_Bound().left_bound(a,6));

    }
}

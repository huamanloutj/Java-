package DataStructure.Sort;

public class Finder {
    public int partition(int[] a,int left,int right,int K){
        int value = a[left];
        while (left < right){
            while (left< right && a[right] >= value) right --;
            a[left] = a[right];
            while (left< right && a[left] <= value)  left --;
            a[right] = a[left];

        }
        a[left] = value;
        return left;
    }
    public int quickSort(int[] a,int start,int end,int K){
        if (start < end){
            int pivot = partition(a,start,end,K);
            if (pivot == K - 1)
                //return
                return a[pivot];
//            for (int x : a )
//                System.out.println(x);
            quickSort(a,start,pivot - 1,K);
            quickSort(a,pivot + 1,end, K);
        }
        return -1;
    }
    public int findKth(int[] a, int n, int K) {
        // write code here
        return quickSort(a,0,n - 1,K);


    }
    public static void main(String[] args){
        new Finder().findKth(new int[]{1,3,2,9,5,3},6,3);

    }
}
package DataStructure;

public class HSort {
    //构建最小堆
    public static void adjustHeap(int []arr,int i,int length) {
        int temp=arr[i];
        for(int k=2*i+1;k<length;k=k*2+1) {
            if(k+1<length&&arr[k]<arr[k+1]) {
                k++;
            }
            if(arr[k]>temp) {
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }

    public static void swap(int []arr,int a,int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void hSort(int []arr) {
        int i;
        //从第一个非叶子节点开始调整堆结构
        for(i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //交换根元素和第一个元素
        for(i=arr.length-1;i>0;i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[]= {5,4,9,8,7,6,0,1,3,2};
        hSort(arr);
        for(int a:arr) {
            System.out.print(a);
        }
    }

}
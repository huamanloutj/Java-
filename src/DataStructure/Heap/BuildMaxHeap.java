package DataStructure.Heap;
import java.util.*;
import java.lang.*;

class BuildMaxHeap {
    int[] data = new int[]{0,53,17,78,9,45,65,87,32};
    //BuildMaxHeap(int n){this.n = n;}

    void initData(){
        //this.data = {0,87,45,78,32,17,65,53,9};
//        Scanner in = new Scanner(System.in);
//        for (int i = 1 ; i <= n ; i++ )
//            data[i] = in.nextInt();

    }
    void adjustDown (int[] data,int k){
        int n  = data.length;
        data[0] = data[k];
        try {
            for (int i = 2 * k; i <= n - 1; i *= 2) {
                if (i  < n && data[i] < data[i + 1])//数组越界问题
                {
                    i++;
                    System.out.println(i);
                }

                if (i  < n && data[0] >= data[i]) break;
                else {
                    data[k] = data[i + 1];
                    k = i;
                }
            }
            data[k] = data[0];
        }catch (ArrayIndexOutOfBoundsException e){System.out.println(e.getStackTrace());}
    }
    void adjustUp(int[] data,int n){}
    void buildHeap(){
        int n = this.data.length;
        for (int i = n/2 ; i >= 1 ; i++){
            adjustDown(this.data,i);
        }
    }
    void insertData(){}
    void deleteData(){}
    void heapSort(){

    }
    void printHeap(){for (int x : data) System.out.println(x);}
    public static void main(String[] args){
        BuildMaxHeap bmp = new BuildMaxHeap();
        bmp.buildHeap();
        bmp.printHeap();


    }
}

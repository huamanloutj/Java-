package DataStructure.Sort;

public class SelectSort {
    public static void main(String[] args){
        int s[] = new int[]{15,6,1,6,8,3,9,10};
        for (int i = 0; i <s.length ; i ++){
            int min = i;
            for (int j = i + 1 ; j < s.length ; j ++){
                if (s[min] > s[j]) min = j;
            }
            if (min != i) {
                int tmp = 0;
                tmp = s[min];
                s[min] = s[i];
                s[i] = tmp;

            }
            System.out.println("第" + i + "次的结果为");
            for (int k = 0 ; k < s.length ; k ++)
                System.out.print(s[k] + " ");
            System.out.println("\n");
        }
    }
}

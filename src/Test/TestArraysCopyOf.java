package Test;

import java.util.Arrays;

public class TestArraysCopyOf {



        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = Arrays.copyOf(arr1, 3);
            int[] arr3 = Arrays.copyOf(arr1, 10);
            for(int i = 0; i < arr2.length; i++)
                System.out.print(arr2[i] + " ");
            System.out.println();
            for(int i = 0; i < arr3.length; i++)
                System.out.print(arr3[i] + " ");

    }
}

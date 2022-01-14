package lzy.cs.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 9, 7, 6, 1, 5, 4};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; ++j) {
                if(array[maxIndex] < array[j]){
                    maxIndex = j;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}

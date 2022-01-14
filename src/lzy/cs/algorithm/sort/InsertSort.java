package lzy.cs.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {3,8,2,9,7,6,1,5,4};
        System.out.println(Arrays.toString(insertSort(array)));
    }

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length ; ++i) {
            int iIndexValue = array[i];
            int jIndex = i;
            for (int j = i; j > 0; --j) {
                if(array[j-1] > iIndexValue){
                    array[j] = array[j-1];
                    --jIndex;
                }
            }
            if(jIndex != i){
                array[jIndex] = iIndexValue;
            }
        }
        return array;
    }
}

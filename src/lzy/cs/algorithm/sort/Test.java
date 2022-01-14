package lzy.cs.algorithm.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 9, 7, 6, 1, 5, 4};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        quickSort(array,0,array.length-1);
        return array;
    }

    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int index = partition(array, low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);
        }

    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[low];
        while (low < high){
            while (low < high && array[high] >= pivot){
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}

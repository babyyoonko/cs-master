package lzy.cs.algorithm.sort;

import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 8, 2, 9, 7, 6, 1, 5, 4};
        System.out.println(Arrays.toString(new QuickSort().sort(array)));
    }

    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
        return array;
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high){
            while (low < high && array[high] >= pivot){
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot){
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}



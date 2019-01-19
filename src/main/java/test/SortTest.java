package test;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： test
 * 类名称：Demo2.java
 * 类描述：复习5种排序算法：冒泡、插入、选择、归并、快排
 * 创建人：wufuming
 * 创建时间：2019年01月19日
 */
public class SortTest {
    public static void main(String[] arges) {
        int[] arr = {6, 4, 5, 2, 1, 3, 4};
        //bubbleSort(arr, arr.length);
        //insertSort(arr, arr.length);
        //selectSort(arr, arr.length);
        //mergeSort(arr, arr.length);
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i, j = i + 1;
            for (; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int n) {
        if (n <= 1) return;
        mergeSortInternally(arr, 0, n - 1);
    }

    private static void mergeSortInternally(int[] arr, int l, int r) {
        if (l == r) return;
        int p = l + (r - l) / 2;
        mergeSortInternally(arr, l, p);
        mergeSortInternally(arr, p + 1, r);
        merge(arr, l, p, r);
    }

    private static void merge(int[] arr, int l, int p, int r) {
        int i = l, j = p + 1, k = 0, len = r - l + 1;
        int[] tmp = new int[len];
        while (i <= p && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        int start = i;
        int end = p;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        for (int q = 0; q < len; q++)
            arr[l + q] = tmp[q];
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int n) {
        if (n <= 1) return;
        quickSortInternally(arr, 0, n - 1);
    }

    private static void quickSortInternally(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSortInternally(arr, l, p - 1);
        quickSortInternally(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l, j = l;
        for (; j < r; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[i];
        arr[i] = tmp;
        return i;
    }
}
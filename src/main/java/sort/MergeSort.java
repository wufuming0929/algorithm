package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：MergeSort.java
 * 类描述：归并排序-递归合并排序
 * 创建人：wufuming
 * 创建时间：2019年01月18日
 */
public class MergeSort implements Sort {
    public static void main(String[] arges) {
        MergeSort sort = new MergeSort();
        int[] arr = {6, 5, 4, 1, 3, 2};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序算法分析：
     * 1）不是原地排序，空间复杂度为O(n)
     * 2）时间复杂度为O(nlogn)
     * 3）稳定的排序算法
     */
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private void merge(int[] arr, int l, int m, int r) {
        int i = l, j = m + 1, k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        int start = i;
        int end = m;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        for (int q = 0; q < tmp.length; q++)
            arr[l++] = tmp[q];
    }
}
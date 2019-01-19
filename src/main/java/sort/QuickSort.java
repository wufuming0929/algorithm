package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：QuickSort.java
 * 类描述：快速排序
 * 创建人：wufuming
 * 创建时间：2019年01月19日
 */
public class QuickSort implements Sort {

    public static void main(String[] arges) {
        QuickSort sort = new QuickSort();
        int[] arr = {6, 7, 3, 1, 2, 4, 9, 5};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序算法分析：
     * 1）原地排序，空间复杂度为O(1)
     * 2）时间复杂度为O(nlogn)
     * 3）不是稳定的排序算法,由于有数据交换，所以相等值的数据顺序会改变。
     * 例如：6，8，7，6，3，5，9，4 在第一次交换时就会把前面的6交换到后面了
     */
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r], i = l, j = l;
        for (; j < r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}




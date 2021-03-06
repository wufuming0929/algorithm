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

    /**
     * 分区函数优化:采用三数取中法来优化分区,防止快排在极端情况下
     * 时间复杂度退化为O(n²)
     */
    private int partition(int[] arr, int l, int r) {
        int p = l + (r - l) / 2;
        //三数取中优化快排(左,中,右三数按从小到大排序)
        if (arr[l] > arr[r]) {
            swap(arr, l, r);
        }
        if (arr[l] > arr[p]) {
            swap(arr, l, p);
        }
        if (arr[p] > arr[r]) {
            swap(arr, p, r);
        }

        r = r - 1;
        swap(arr, p, r);

        int pivot = arr[r], i = l;
        for (int j = l; j < r; j++) {
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

    /**
     * 优化前的分区函数:用来跟优化后做对比
     */
    private int partition1(int[] arr, int l, int r) {
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


}




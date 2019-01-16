package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：BubbleSort.java
 * 类描述：冒泡排序算法
 * 创建人：wufuming
 * 创建时间：2018年10月18日
 */
public class BubbleSort {
    public static void main(String[] arges) {
        int[] arr = {4,3,6,3,1,8};
        //bubbleSort(arr, arr.length);
        recursionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 双循环实现冒泡排序。这个算法的分析如下：
     * 1）时间复杂度为 O(n²)
     * 2）原地算法,空间复杂度为O(1)
     * 3）稳定的排序算法
     */
    private static void bubbleSort(int[] arr, int len) {
        if (len <= 1) return;
        boolean sorted = true;
        for (int i = 0; i < len && sorted; i++) {
            sorted = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sorted = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /**
     * 用递归的方式实现冒泡排序,因为冒泡排序满足递归的三要素。
     * 不推荐这种算法，只是用来练习递归，这种排序算法的分析如下：
     * 1）时间复杂度为O(n²)
     * 2）不是原地算法，空间复杂度为O(n)
     * 3）稳定的排序算法
     */
    private static void recursionSort(int[] arr, int len) {
        if (len <= 1) return;
        boolean flag = true;
        for (int i = 0; i < len-1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = false;
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        if (flag)return;
        recursionSort(arr,len-1);
    }

}
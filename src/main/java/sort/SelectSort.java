package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：SelectSort.java
 * 类描述：选择排序
 * 创建人：wufuming
 * 创建时间：2019年01月17日
 */
public class SelectSort implements Sort{

    public static void main(String[] arges) {
        int[] arr = {6, 5,6,2,1,3};
        new SelectSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * 1）原地排序,空间复杂度为O(1)
     * 2）时间复杂度:最好情况时间复杂度O(n²),最坏情况时间复杂度O(n²),平均情况时间复杂度O(n²)
     * 3）不是稳定的排序算法。因为会发生交换，相同元素的顺序会发生改变，例如:5,3,6,5,2,1
     */
    public void sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

}
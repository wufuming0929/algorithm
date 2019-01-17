package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：InsertSort.java
 * 类描述：插入排序
 * 创建人：wufuming
 * 创建时间：2019年01月17日
 */
public class InsertSort implements Sort{
    public static void main(String[] arges) {
        int[] arr = {6, 5, 4, 1, 3, 2};
        new InsertSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 插入排序
     * 1)原地排序，空间复杂度为O(1)
     * 2)时间复杂度,最好情况时间复杂度O(n),最坏情况时间复杂度O(n²),平均情况时间复杂度O(n²)
     * 3)稳定的排序算法
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        for (int i = 1; i < len; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];//数据移动
                } else {
                    break;
                }
            }
            arr[j + 1] = value;//数据插入
        }

    }
}
package sort;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：CountSort.java
 * 类描述：计数排序
 * 创建人：wufuming
 * 创建时间：2019年01月21日
 */
public class CountSort implements Sort {
    public static void main(String[] arges) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        new CountSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] c = new int[max + 1];
        for (int i = 0; i < n; i++)
            c[arr[i]]++;

        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i - 1];
        }

        int[] tmp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = c[arr[i]]-1;
            tmp[index] = arr[i];
            c[arr[i]]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = tmp[i];
    }


}
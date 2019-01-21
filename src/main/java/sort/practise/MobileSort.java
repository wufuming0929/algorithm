package sort.practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;


/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：MobileSort.java
 * 类描述：手机号按小到大排序
 * 创建人：wufuming
 * 创建时间：2019年01月21日
 */
public class MobileSort {
    public static void main(String[] arges) {
        File f = new File("E:/mobile.csv");
        String[] arr = new String[1130];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String mobile = null;
            while ((mobile = reader.readLine()) != null)
                arr[index++] = mobile;
        } catch (Exception e) {
        }
       /* String[] arr = {
                "13910627762",
                "13910219399",
                "13911784120",
                "13901210098",
                "13910210818",
                "13901287126",
                "13911180470",
        };*/
        sort(arr, arr.length, 10);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(String[] arr, int n, int sortIndex) {
        if (sortIndex < 0) return;
        sortInternally(arr, n, sortIndex);
        sort(arr, n, --sortIndex);
    }

    private static void sortInternally(String[] arr, int n, int sortIndex) {
        int[] c = new int[10];
        for (int i = 0; i < n; i++)
            c[arr[i].charAt(sortIndex) - '0']++;

        for (int i = 1; i < c.length; i++)
            c[i] = c[i] + c[i - 1];

        String[] tmp = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            int p = arr[i].charAt(sortIndex) - '0';
            int index = c[p] - 1;
            tmp[index] = arr[i];
            c[p]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = tmp[i];
    }

}
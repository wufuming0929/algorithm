package sort.practise;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：FindK.java
 * 类描述：在O(n)时间复杂度内查找第K大元素
 * 创建人：wufuming
 * 创建时间：2019年01月19日
 */
public class FindK {
    public static void main(String[] arges) {
        int[] arr = {6, 5, 2, 1, 4, 3};
        int ret = find(arr, 3);
        System.out.println(ret);
    }

    public static int find(int[] arr, int k) {
        return findInternally(arr, 0, arr.length - 1, k);
    }

    private static int findInternally(int[] arr, int l, int r, int k) {
        int p = partition(arr, l, r);
        if (p + 1 == k) return arr[p];
        if (k > p + 1) {
            return findInternally(arr, p + 1, r, k);
        }
        return findInternally(arr, l, p - 1, k);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r], i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] > pivot) {
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
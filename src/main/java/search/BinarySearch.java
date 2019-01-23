package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：BinarySearch.java
 * 类描述：二分查找简单实现
 * 创建人：wufuming
 * 创建时间：2019年01月23日
 */
public class BinarySearch {

    public static void main(String[] arges) {
        int[] arr = {3, 5, 7, 8, 10, 13};
        System.out.println(bSearch(arr, arr.length, 10));
        System.out.println(bSearchRecursion(arr, arr.length, 10));


    }

    /**
     * 循环实现
     */
    public static int bSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     */
    public static int bSearchRecursion(int[] arr, int n, int value) {
        return bSearchInternally(arr, 0, n - 1, value);
    }

    private static int bSearchInternally(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high-low) >> 2);
        if (arr[mid] == value) return mid;
        if (arr[mid] > value) return bSearchInternally(arr, low, mid - 1, value);
        return bSearchInternally(arr, mid + 1, high, value);
    }

}
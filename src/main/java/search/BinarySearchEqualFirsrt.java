package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：ComplexBinarySearch.java
 * 类描述：二分查找的变形一：查找第一个等于指定值的元素
 * 创建人：wufuming
 * 创建时间：2019年01月23日
 */
public class BinarySearchEqualFirsrt {
    public static void main(String[] arges) {
        int[] arr = {1, 2, 3, 3, 5, 7, 9, 9, 11};
        System.out.println(bSearchFirstLoop(arr, arr.length, 3));
        System.out.println(bSearchFirstRecursion(arr, arr.length, 3));
    }

    /**
     * 循环实现一
     */
    public static int bSearchFirstLoop(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && arr[low] == value) return low;
        return -1;
    }

    /**
     * 循环实现二
     */
    public static int bSearchFirstLoop2(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }
    /*=========================递归实现================================*/
    public static int bSearchFirstRecursion(int[] arr, int n, int value) {
        return bSearchFirstInternally2(arr, 0, n - 1, value);
    }

    /**
     * 循环一 >>>递归实现
     */
    private static int bSearchFirstInternally(int[] arr, int low, int high, int value) {
        if (low > high) {
            if (low < arr.length && arr[low] == value) return low;
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] >= value) return bSearchFirstInternally(arr, low, mid - 1, value);
        return bSearchFirstInternally(arr, mid + 1, high, value);
    }

    /**
     * 循环二 >>>递归实现
     */
    private static int bSearchFirstInternally2(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] > value) return bSearchFirstInternally2(arr, low, mid - 1, value);
        if (arr[mid] < value) return bSearchFirstInternally2(arr, mid + 1, high, value);
        if (mid==0||arr[mid-1]!=value) return mid;
        return bSearchFirstInternally2(arr, low, mid - 1, value);
    }
}
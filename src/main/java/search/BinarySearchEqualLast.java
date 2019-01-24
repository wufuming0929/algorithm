package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：BinarySearchEqualLast.java
 * 类描述：二分查找变形二：查找最后一个等于指定值的元素
 * 创建人：wufuming
 * 创建时间：2019年01月24日
 */
public class BinarySearchEqualLast {
    public static void main(String[] arges) {
        int[] arr = {1, 2, 3, 3, 3, 5, 7, 7, 7, 9, 11};
        System.out.println(bSearchLastLoop2(arr, arr.length, 7));
        System.out.println(bSearchLastRecursion(arr, arr.length, 7));
    }

    /**
     * 循环实现一
     */
    public static int bSearchLastLoop(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high < n && arr[high] == value) return high;
        return -1;
    }

    /**
     * 循环实现二
     */
    public static int bSearchLastLoop2(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    /*=========================递归实现================================*/
    public static int bSearchLastRecursion(int[] arr, int n, int value) {
        return bSearchLastInternally2(arr, 0, n - 1, value);
    }

    /**
     * 循环一 >>> 递归实现
     */
    private static int bSearchLastInternally(int[] arr, int low, int high, int value) {
        if (low > high) {
            if (high < arr.length && arr[high] == value) return high;
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] <= value) return bSearchLastInternally(arr, mid + 1, high, value);
        return bSearchLastInternally(arr, low, mid - 1, value);
    }

    /**
     * 循环二 >>> 递归实现
     */
    private static int bSearchLastInternally2(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] > value) return bSearchLastInternally2(arr, low, mid - 1, value);
        if (arr[mid] < value) return bSearchLastInternally2(arr, mid + 1, high, value);
        if (mid == arr.length - 1 || arr[mid + 1] != value) return mid;
        return bSearchLastInternally2(arr, mid + 1, high, value);
    }
}
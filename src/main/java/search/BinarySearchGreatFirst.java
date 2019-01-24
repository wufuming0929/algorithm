package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：BinarySearchGreatFirst.java
 * 类描述：二分查找变形三：查找第一个大于等于指定值的元素
 * 创建人：wufuming
 * 创建时间：2019年01月24日
 */
public class BinarySearchGreatFirst {
    public static void main(String[] arges) {
        int[] arr = {2, 3, 3, 5, 7, 9, 9, 11};
        System.out.println(bSearchGreatFirstLoop(arr, arr.length, 1));
        System.out.println(bSearchGreatFirstRecursion(arr, arr.length, 1));
    }

    /**
     * 循环实现
     */
    public static int bSearchGreatFirstLoop(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] < value) return mid;
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bSearchGreatFirstRecursion(int[] arr, int n, int value) {
        return bSearchGreatFirstInternally(arr, 0, n - 1, value);
    }

    /**
     * 递归实现
     */
    private static int bSearchGreatFirstInternally(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] < value) return bSearchGreatFirstInternally(arr, mid + 1, high, value);
        if (mid == 0 || arr[mid - 1] < value) return mid;
        return bSearchGreatFirstInternally(arr, low, mid - 1, value);
    }

}
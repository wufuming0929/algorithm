package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：BinarySearchLessLast.java
 * 类描述：二分查找变形四：查找最后一个小于等于指定值的元素
 * 创建人：wufuming
 * 创建时间：2019年01月24日
 */
public class BinarySearchLessLast {
    public static void main(String[] arges) {
        int[] arr = {2, 3, 3, 5, 7, 9, 9, 11};
        System.out.println(bSearchLessLastLoop(arr, arr.length, 10));
        System.out.println(bSearchLessLastRecursion(arr, arr.length, 10));
    }

    /**
     * 循环实现
     */
    public static int bSearchLessLastLoop(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] > value) return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int bSearchLessLastRecursion(int[] arr, int n, int value) {
        return bSearchLessLastInternally(arr, 0, n - 1, value);
    }

    /**
     * 递归实现
     */
    private static int bSearchLessLastInternally(int[] arr, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] > value) return bSearchLessLastInternally(arr, low, mid - 1, value);
        if (mid == arr.length - 1 || arr[mid + 1] > value) return mid;
        return bSearchLessLastInternally(arr, mid + 1, high, value);
    }

}
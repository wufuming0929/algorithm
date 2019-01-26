package search;

/**
 * 项目名称：algorithm
 * 包： search
 * 类名称：BinarySeachForLoop.java
 * 类描述：二分法在循环数组中查询给定值的元素-无重复元素
 * 创建人：wufuming
 * 创建时间：2019年01月25日
 */
public class BinarySeachForLoop {

    public static void main(String[] arges) {
        int[] nums = {3,5,6,7,8,1};
        System.out.println(bSearchForLoop(nums, 3));
    }

    /**
     * 这个实现好理解，实现思路：
     * 1.用二分法先找到分界点，根据分界点分成两个有序区间数组。
     * 2.判断指定值在哪一个有序区间，再用二分法查找指定值。
     * 3.时间复杂度：O(logn)。
     */
    private static int bSearchForLoop(int[] nums, int target) {
        int low = 0, n = nums.length, high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        //pivot就是分界点
        int pivot = low;
        high = n - 1;
        //判断指定值的区间位置
        if (nums[high] < target) {
            low = 0;
            if (pivot != 0) high = pivot - 1;
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 这个实现不好理解，留作参考。
     */
    public static int search(int[] nums, int target) {
        //1.找出循环的分界点
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {//这里不能<=,会发生死循环
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid; //这里不能有减一操作，因为nums[mid] 有可能是最小值
            }
        }
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;
        //对mid也进行旋转来直接使用二分查找
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realMid = (mid + rot) % nums.length; // 对mid进行逻辑上的旋转
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target)
                lo = mid + 1;  //注意最后赋值是mid,而非旋转后的realMId
            else
                hi = mid - 1;
        }
        return -1;
    }

}
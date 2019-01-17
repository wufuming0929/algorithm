package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：algorithm
 * 包： leetcode
 * 类名称：L1.java
 * 类描述：两数之和,掌握空间换时间的方法
 * 创建人：wufuming
 * 创建时间：2019年01月17日
 */
public class L1 {
    public static void main(String[] arges) {

        int[] nums = {2, 7, 11, 15,8,3};
        int tartget = 11;
        int[] index1 = twoSum1(nums, tartget);
        int[] index2 = twoSum2(nums, tartget);
        int[] index3 = twoSum3(nums, tartget);
        System.out.println(Arrays.toString(index1));
        System.out.println(Arrays.toString(index2));
        System.out.println(Arrays.toString(index3));
    }
    /**
     * 时间复杂度O(n²),空间复杂度O(1)
     */
    private static int[] twoSum1(int[] nums, int tartge) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tartge - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("No Such Two Nums");
    }
    /**
     *时间复杂度O(n),空间复杂度O(n)
     */
    private static int[] twoSum2(int[] nums, int tartge) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int ret = tartge - nums[i];
            if (map.containsKey(ret) && map.get(ret) != i) {
                return new int[]{i, map.get(ret)};
            }
        }
        throw new RuntimeException("No Such Two Nums");
    }
    /**
     *时间复杂度O(n),空间复杂度O(n)
     */
    private static int[] twoSum3(int[] nums, int tartge) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ret = tartge - nums[i];
            if (map.containsKey(ret)) {
                return new int[]{map.get(ret), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No Such Two Nums");
    }
}
package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：algorithm
 * 包： recursion
 * 类名称：Step.java
 * 类描述：台阶的走法：
 * 假设有n个台阶，一次走1步或者2步或者交叉1步2步走，求走完n个台阶总共有几种走法？
 * 创建人：wufuming
 * 创建时间：2019年01月14日
 */
public class Step {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] arges) {
        System.out.println(count(20));
        System.out.println(count2(20));
        System.out.println(f(20));
    }

    /**
     * 递归实现1：这种方式避免重复计算，其实计算结果跟实现2是相同的。所谓的计算重复是方法栈重复调用，不是数值
     * 重复计算导致计算结果变大，采用map存储之前调用的结果是一种优化，避免过多方法栈的调用！
     */
    static int count(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        int ret = count(n - 1) + count(n - 2);
        map.put(n, ret);
        return ret;
    }

    /**
     * 递归实现2：这种方式会产生重复计算
     */
    static int count2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return count2(n - 1) + count(n - 2);
    }

    /**
     * 循环实现
     */
    static int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;//f(n-1)+f(n-2)
            prepre = pre;//f(n-2)
            pre = ret;//f(n-1)
        }
        return ret;
    }

}
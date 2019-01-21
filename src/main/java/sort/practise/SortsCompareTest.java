package sort.practise;

import sort.*;

import java.util.Random;

/**
 * 项目名称：algorithm
 * 包： sort
 * 类名称：SortsCompareTest.java
 * 类描述：排序算法比较
 * 创建人：wufuming
 * 创建时间：2019年01月17日
 */
public class SortsCompareTest {

    static int maxSize = 1;
    static int eachSize = 100000000;

    public static void main(String[] arges) {
        int[][] arrs = genArrs(maxSize, eachSize);
        //int[][] copyArrs1 = copyArrs(arrs, eachSize);
        //int[][] copyArrs2 = copyArrs(arrs, eachSize);
        int[][] copyArrs3 = copyArrs(arrs, eachSize);
        int[][] copyArrs4 = copyArrs(arrs, eachSize);

        Sort bubbleSort = new BubbleSort();
        Sort insertSort = new InsertSort();
        Sort selectSort = new SelectSort();
        Sort mergeSort = new MergeSort();
        Sort QuickSort = new QuickSort();
        System.out.println("start sort...");
        //System.out.println("BubbleSort：" + count(arrs, bubbleSort) + "ms");
        //System.out.println("InsertSort：" + count(copyArrs1, insertSort) + "ms");
        //System.out.println("SelectSort：" + count(copyArrs2, selectSort) + "ms");
        System.out.println("QuickSort：" + count(copyArrs4, QuickSort) + "ms");
        System.out.println("MergeSort：" + count(copyArrs3, mergeSort) + "ms");
        System.out.println("end sort...");

    }

    private static int[][] genArrs(int maxSize, int eachSize) {
        int[][] arrs = new int[maxSize][eachSize];
        Random random = new Random();
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                arrs[i][j] = random.nextInt(Integer.MAX_VALUE);
            }
        }
        return arrs;
    }

    private static long count(int[][] arrs, Sort sort) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arrs.length; i++) {
            sort.sort(arrs[i]);
        }
        long end = System.currentTimeMillis() - start;
        return end;
    }

    private static int[][] copyArrs(int[][] arrs, int eachSize) {
        int[][] copyArrs = new int[arrs.length][eachSize];
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                copyArrs[i][j] = arrs[i][j];
            }
        }
        return copyArrs;
    }

}

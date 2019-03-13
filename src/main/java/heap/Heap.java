package heap;

import java.util.Arrays;

/**
 * 项目名称：algorithm
 * 包： heap
 * 类名称：Heap.java
 * 类描述：堆(大顶堆为例)及相关操作，包括入堆、删除堆顶元素、堆排序。
 * 创建人：wufuming
 * 创建时间：2019年03月13日
 */
public class Heap {

    private int[] heap;
    private int len;
    private int count;

    public Heap() {
        this(11);
    }

    public Heap(int capacity) {
        heap = new int[capacity];
        len = capacity;
        count = -1;
    }

    /**
     * 入堆操作，时间复杂度为O(logn)
     */
    public void insert(int data) {
        if (count >= len) return;
        ++count;
        heap[count] = data;
        heapfiy(heap, count);
    }

    /**
     * 删除堆顶元素,时间复杂度为O(logn)
     */
    public int remove() {
        if (count < 0) return -1;
        int first = heap[0];
        int last = heap[count];
        heap[0] = last;
        --count;
        heapfiy(heap, count, 0);
        return first;
    }

    /**
     * 堆排序，时间复杂度O(nlogn),空间复杂度O(1),非稳定。
     */
    public int[] sort(int[] arr) {
        buildHeap(arr, arr.length - 1);
        for (int last = arr.length - 1; last >= 1; last--) {
            swap(arr, 0, last);
            heapfiy(arr, last - 1, 0);
        }
        return arr;
    }

    /**
     * 建堆
     */
    private void buildHeap(int[] arr, int i) {
        int j = (i - 1) / 2;
        for (; j >= 0; j--) {
            heapfiy(arr, arr.length - 1, j);
        }
    }

    /**
     * 自下往上堆化
     */
    private void heapfiy(int[] arr, int i) {
        int j;
        while ((j = (i - 1) / 2) >= 0 && arr[i] > arr[j]) {
            swap(arr, i, j);
            i = j;
        }
    }

    /**
     * 自上往下堆化
     */
    private void heapfiy(int[] arr, int ct, int cur) {
        for (; ; ) {
            int maxPos = cur;
            int left = 2 * cur + 1;
            int right = 2 * cur + 2;
            if (left <= ct && arr[cur] < arr[left]) maxPos = left;
            if (right <= ct && arr[maxPos] < arr[right]) maxPos = right;
            if (maxPos == cur) break;
            swap(arr, cur, maxPos);
            cur = maxPos;
        }
    }

    /**
     * 交换数据
     */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] arges) {
        Heap heap = new Heap();
        int[] arr = heap.sort(new int[]{15, 11, 4, 3, 9, 5, 6, 2, 1});
        System.out.println(Arrays.toString(arr));
    }
}
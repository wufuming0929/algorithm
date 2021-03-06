package arrayqueue;

import linkedlist.LinkedListQueue;

import java.util.Random;

/**
 * 项目名称：algorithm
 * 包： arrayqueue
 * 类名称：TestClient.java
 * 类描述：测试类
 * 创建人：wufuming
 * 创建时间：2019年01月08日
 */
public class QueueTest {

    private static int count = 1000000;

    public static void main(String[] arges) {

        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();

        //double t1 = countTime(arrayQueue, count);
        double t2 = countTime(loopQueue, count);
        double t3 = countTime(linkedListQueue, count);
        //System.out.println("ArrayQueue 操作耗时:" + t1 + " s");
        System.out.println("LoopQueue 操作耗时:" + t2 + " s");
        System.out.println("linkedListQueue 操作耗时:" + t3 + " s");

    }

    private static double countTime(Queue<Integer> q, int count) {

        long start = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < count; i++)
            q.enqueue(rand.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < count; i++)
            q.dequeue();
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }

}
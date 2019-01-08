package arrayqueue;

/**
 * 项目名称：algorithm
 * 包： arrayqueue
 * 类名称：TestClient.java
 * 类描述：测试类
 * 创建人：wufuming
 * 创建时间：2019年01月08日
 */
public class TestClient {

    public static void main(String[] arges) {

        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3==2) {
                queue.dequeue();
            }
        }

    }

}
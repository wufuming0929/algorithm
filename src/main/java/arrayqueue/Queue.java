package arrayqueue;

/**
 * 项目名称：algorithm
 * 包： arrayqueue
 * 类名称：Queue.java
 * 类描述：队列接口
 * 创建人：wufuming
 * 创建时间：2019年01月08日
 */
public interface Queue<E> {
    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出队
     */
    E dequeue();

    /**
     * 查看队首数据
     */
    E getFront();

    /**
     * 查看size
     */
    int getSize();

    /**
     * 判空
     */
    boolean isEmpty();

}
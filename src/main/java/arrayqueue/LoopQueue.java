package arrayqueue;

/**
 * 项目名称：algorithm
 * 包： arrayqueue
 * 类名称：LoopQueue.java
 * 类描述：基于循环数组实现队列功能,由于普通数组实现的队列出队操作时间复杂度为O(n),
 * 性能不好，而用循环数组实现的队列出队操作时间复杂度为O(1)。
 * 创建人：wufuming
 * 创建时间：2019年01月08日
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        //循环数组会浪费一个空间,但是对用户来说是透明的,所以底层+1容量。
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            //扩容
            resize(data.length * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(front + i) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }
        E first = data[front];
        data[front] = null;//for GC
        front = (front + 1) % data.length;
        size--;
        if (size == data.length / 4 && data.length / 2 != 0) {
            //缩容
            resize(data.length / 2);
        }
        return first;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        //底层+1容量,用户查询时-1,确保用户的期望。
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue ：size=%d,capacity=%d\n", size, getCapacity()));
        sb.append("front [");
        for (int i=front;i!=tail;i=(i+1)%data.length){
            sb.append(data[i]);
            if ((i+1)%data.length!=tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
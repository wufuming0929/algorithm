package array;

/**
 * 项目名称：algorithm
 * 包： array
 * 类名称：SelfArray.java
 * 类描述：自定义数组类，封装动态数组的增删改查等功能
 * 创建人：wufuming
 * 创建时间：2019年01月06日
 */
public class SelfArray<E> {

    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 2 << 2;

    /**
     * 带参构造
     *
     * @param capacity 数组容量
     */
    public SelfArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is illegal:capacity=" + capacity);
        }
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        data = (E[])new Object[capacity];
    }

    /**
     * 无参构造
     */
    public SelfArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 尾部追加数据
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 头部插入数据
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定位置插入数据
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkIndex(index);
        if (size == data.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    /**
     * 删除最后一个数据
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除第一个数据
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除指定位置数据
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index outof bound:size=" + size + ",index=" + index);
        }
        E old = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        data[size - 1] = null;//for GC
        size--;
        return old;
    }

    /**
     * 替换指定位置的数据
     * @param index
     * @param e
     * @return
     */
    public E set(int index,E e){
        checkIndex(index);
        E old = data[index];
        data[index]=e;
        return old;
    }

    /**
     * 查询指定位置的数据
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index outof bound:size=" + size + ",index=" + index);
        }
        return data[index];
    }

    /**
     * 查询最后一个数据
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 查询第一个数据
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 查询数组是否包含指定的数据
     * @param e
     * @return
     */
    public boolean contains(E e){
        return indexOf(e)>0;
    }

    /**
     * 获取指定数据的下标索引，不存在返回-1
     * @param e
     * @return
     */
    public int indexOf(E e){
        if (e==null) {
            for (int i = 0; i < size; i++) {
                if (data[i]==null) {
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    //检查索引是否越界
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index outof bound:size=" + size + ",index=" + index);
        }
    }
    //扩容
    private void resize() {
        E[] newArr = (E[])new Object[data.length * 2];
        for (int i = 0; i < size; i++)
            newArr[i] = data[i];
        data = newArr;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }
    /**
     * 获取数组元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String info = "SelfArray:{size=" + size + ",capacity=" + data.length + "}\n";
        sb.append(info);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != (size - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
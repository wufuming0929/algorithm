package arraystack;

/**
 * 项目名称：algorithm
 * 包： arraystack
 * 类名称：SelfStack.java
 * 类描述：栈接口
 * 创建人：wufuming
 * 创建时间：2019年01月07日
 */
public interface Stack<E> {
    /**
     * 查询栈中元素的数量
     * @return
     */
    int getSize();

    /**
     * 查询栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 压栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查询栈顶元素
     * @return
     */
    E peek();

}
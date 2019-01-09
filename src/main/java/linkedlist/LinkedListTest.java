package linkedlist;

/**
 * 项目名称：algorithm
 * 包： linkedlist
 * 类名称：LinkedListTest.java
 * 类描述：链表测试
 * 创建人：wufuming
 * 创建时间：2019年01月09日
 */
public class LinkedListTest {
    public static void main(String[] arges) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        System.out.println(linkedList.removeElement(10));
        System.out.println(linkedList);


    }

}
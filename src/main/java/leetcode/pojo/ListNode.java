package leetcode.pojo;

/**
 * 项目名称：algorithm
 * 包： leetcode.pojo
 * 类名称：ListNode.java
 * 类描述：单链表实体类
 * 创建人：wufuming
 * 创建时间：2019年01月12日
 */
public class ListNode<E> {

    public E val;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(E val) {
        this.val = val;
    }
    public ListNode assemblyNode(E[] arr){
        if (arr==null||arr.length<=0) return null;
        this.val=arr[0];
        ListNode head=this;
        for(int i=1;i<arr.length;i++){
            head.next=new ListNode(arr[i]);
            head=head.next;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head=this;
        while (head!=null){
            sb.append(head.val+"->");
            head=head.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
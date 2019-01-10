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
        LinkedList<Character> linkedList = new LinkedList<>();
        String str = "12";
        for (int i = 0; i < str.length(); i++) {
            linkedList.addLast(str.charAt(i));
        }
        System.out.println(plalindromeString(linkedList));
        System.out.println(linkedList);

    }

    /**
     * 判断字符串回文
     * 时间复杂度O(n²)，空间复杂度O(1)
     * @param strList
     * @return
     */
    private static boolean plalindromeString(LinkedList<Character> strList){

        while (strList.getSize()>1){
            char first = strList.removFirst();
            char last = strList.removeLast();
            if (first!=last) {
                return false;
            }
        }
        return true;


    }

}
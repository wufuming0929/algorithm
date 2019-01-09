package arraystack;

/**
 * 项目名称：algorithm
 * 包： arraystack
 * 类名称：TestClient.java
 * 类描述：测试类
 * 创建人：wufuming
 * 创建时间：2019年01月07日
 */
public class StackTest {

    public static void main(String[] arges) {

        Stack<String> stack = new ArrayStack<>();
        stack.push("william");
        stack.push("michelle");
        stack.push("angel");
        stack.push("formain");
        stack.push("jessie");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());


    }

}
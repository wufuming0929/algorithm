package stackarray;

/**
 * 项目名称：algorithm
 * 包： stackarray
 * 类名称：TestClient.java
 * 类描述：测试类
 * 创建人：wufuming
 * 创建时间：2019年01月07日
 */
public class TestClient {

    public static void main(String[] arges) {

        SelfStack<String> stack = new StackArray<>();
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
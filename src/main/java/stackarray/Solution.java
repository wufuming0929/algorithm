package stackarray;

import java.util.Stack;

/**
 * 项目名称：algorithm
 * 包： stackarray
 * 类名称：Solution.java
 * 类描述：利用栈来解决括号匹配问题
 * 创建人：wufuming
 * 创建时间：2019年01月07日
 */
public class Solution {

    public static void main(String[] arges) {
        System.out.println(isValid("{[()]}"));
    }
    private static boolean isValid(String input) {

        SelfStack<Character> stack = new StackArray<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('('==c||'['==c||'{'==c) {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (')'==c&&top!='('||']'==c&&top!='['||'}'==c&&top!='{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
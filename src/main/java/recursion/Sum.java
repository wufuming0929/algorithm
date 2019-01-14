package recursion;

/**
 * 项目名称：algorithm
 * 包： recursion
 * 类名称：Sum.java
 * 类描述：用递归求数组和
 * 创建人：wufuming
 * 创建时间：2019年01月12日
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }
    private static int sum(int[] arr,int l){
        if (l==arr.length) {
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }
    public static void main(String[] arges) {
        int[]arr={1,2,3,4,5,6};
        System.out.println(sum(arr));
    }

}
package chapter11;

/**
 * 项目名称：algorithm
 * 包： chapter11
 * 类名称：BubbleSort.java
 * 类描述：冒泡排序算法
 * 创建人：wufuming
 * 创建时间：2018年10月18日
 */
public class BubbleSort {

    public static void main(String[] arges) {


    }

    private static void bubbleSort(int[] arr,int len) {

        if (len<=1) return;

        for (int i = 0; i < len; i++) {
            for (int j=0;j<len-j-1;j++){
                if (arr[j]>arr[j+1]) {
                    int temp =arr[j];
                    arr[i]=arr[j+1];
                    arr[j]=temp;
                }
            }
        }



    }

}
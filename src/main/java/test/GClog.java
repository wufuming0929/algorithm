package test;

import chapter11.BubbleSort;

/**
 * 项目名称：algorithm
 * 包： test
 * 类名称：GClog.java
 * 类描述：
 * 创建人：wufuming
 * 创建时间：2018年10月20日
 */
public class GClog {

    private Object obj;

    public static void main(String[] arges) throws InterruptedException {

        Thread.sleep(1000);

        GClog objA = new GClog();
        GClog objB = new GClog();

        objA.obj = objB;
        objB.obj = objA;
        Thread.sleep(1000);
        objA=null;
        objB=null;

        System.gc();
        while (true){
            Thread.sleep(1000);
        }



    }

}
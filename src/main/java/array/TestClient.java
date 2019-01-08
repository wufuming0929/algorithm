package array;

/**
 * 项目名称：algorithm
 * 包： array
 * 类名称：TestClient.java
 * 类描述：测试
 * 创建人：wufuming
 * 创建时间：2019年01月06日
 */
public class TestClient {

    public static void main(String[] arges) {

        Array<Student> students = new Array<>();

        students.addFirst(new Student("jessie",80));
        students.addFirst(new Student("william",100));
        students.addLast(new Student("formain",99));
        students.addLast(new Student("michelle",66));
        System.out.println(students);

        System.out.println(students.get(1));

        System.out.println(students.indexOf(new Student("william",100)));

        System.out.println(students.contains(new Student("william",101)));


    }

}
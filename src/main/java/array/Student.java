package array;

import java.util.Objects;

/**
 * 项目名称：algorithm
 * 包： array
 * 类名称：Student.java
 * 类描述：学生实体类
 * 创建人：wufuming
 * 创建时间：2019年01月06日
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
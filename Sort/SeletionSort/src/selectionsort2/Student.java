package selectionsort2;

/**
 * @author Jiani WANG
 * @create 2020-03-31 17:18
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        if(this.score<s.score)
            return -1;
        else if (this.score == s.score)
            return this.name.compareTo(s.name);
        else
            return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

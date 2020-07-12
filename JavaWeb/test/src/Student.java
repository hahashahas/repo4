/**
 * @author FLD
 * @create 2020-06-17 13:10
 */
public class Student implements Comparable{
    public String name;
    public int age;
    static int id;
    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student s= (Student)o;
            return this.name.compareTo(s.name);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
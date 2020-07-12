package _01;
public class Student extends Person implements  Comparable{
    String id;

    public Student(String name,String id) {
        this.name=name;
        this.id=id;
    }
    public Student() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student s= (Student)o;
            return this.id.compareTo(s.id);
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}

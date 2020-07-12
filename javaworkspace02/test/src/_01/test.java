package _01;
public class test {
    public static void main(String[] args) throws Exception{
        StudentList studentList = new StudentList();
        studentList.add(new Student("随世典","20184103281"));
        studentList.add(new Student("张三","123456789"));
        studentList.add(new Student("李四","987654321"));
        studentList.add(new Student("王五","562872584"));
        studentList.show();
        System.out.println("**********************************************");
        studentList.search("123456789");
        studentList.show();
    }
}

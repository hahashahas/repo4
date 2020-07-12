/**
 * @author FLD
 * @create 2020-06-17 13:11
 */
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02 {
    private String str;

    public static void main(String[] args) throws Exception{
        Set<Student> set =new TreeSet<Student>();
        Student s1 = new Student("a",15);
        Student s2 = new Student("b",16);
        Student s3 = new Student("c",16);
        Student s4 = new Student("d",17);
        set.add(s1);
        set.add(s3);
        set.add(s2);
        set.add(s4);
        for(Object s:set){
            System.out.println(s);
        }
        int i=1;
            Iterator it = set.iterator();
            while(it.hasNext()){
                File file =new File("d:/"+i+".txt");
                FileWriter fw =new FileWriter(file);
                Student s= (Student) it.next();
                fw.write(s.toString());
                i++;
                fw.close();
            }
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要删除的学生姓名");
        str=scanner.next();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Student s= (Student) iterator.next();
            if(str.equals(s.name)){
                iterator.remove();
            }
        }
        for(Object s:set){
            System.out.println(s);
        }


    }

}

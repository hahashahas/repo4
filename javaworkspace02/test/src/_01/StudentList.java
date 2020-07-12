package _01;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class StudentList{
    public Set<Student> set =new TreeSet<Student>();
    public void add(Student s){
        set.add(s);
    }
    public void search(String id) throws Exception{
        boolean vis=false;
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Student s= (Student) iterator.next();
            if(id.equals(s.id)){
                vis=true;
                File file =new File("d:/"+id+".txt");
                FileWriter fw =new FileWriter(file);
                fw.write(s.toString());
                fw.close();
                iterator.remove();
            }
        }
        if(!vis){
            System.out.println("查无此学生");
        }
    }
    public void show(){
        for(Object s:set){
            System.out.println(s);
        }
    }
    public void save(){

    }
}

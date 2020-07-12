package second;

import java.util.Set;
import java.util.TreeSet;

public class _02 {
	public static void main(String[] args) {
		Set<Student> set =new TreeSet<Student>();
		Student s1 = new Student("a",15);
		Student s2 = new Student("b",16);
		Student s3 = new Student("c",16);
		set.add(s1);
		set.add(s3);
		set.add(s2);
		System.out.println(set);
	}
}


public class Student extends Person implements  Comparable{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student(String name, String id) {
		this.setName(name);
		this.id = id;
	}

	public Student() {

	}

	public Student(String id) {
		super();
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + getName() + "]";
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

}

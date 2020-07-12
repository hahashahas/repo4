/*import java.io.File;
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
}*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.TreeSet;

public class StudentList {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ssd";
    static final String USER = "root";
    static final String PASS = "root";

    private TreeSet<Student> treeSet;

    public static void main(String[] args) {
        StudentList sl = new StudentList();

//		try {
        sl.add();
        //sl.show();
        //sl.search("20184103281");
        //sl.show();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
        sl.save();
    }

    /**
     * 添加学生信息,包含自己信息
     */
    public void add() {
        treeSet.add(new Student("随世典","20184103281"));
        treeSet.add(new Student("张三","123456789"));
        treeSet.add(new Student("李四","987654321"));
        treeSet.add(new Student("王五","562872584"));

    }

    /**
     * 根据学生id查找学生
     *
     * @param id
     */
    public void search(String id) throws FileNotFoundException {
        Student stu = new Student();
        String path = "D://xuehao.txt";
        String content = "";
        stu.setId(id);
        if (this.treeSet.isEmpty()) {
            System.out.println("查无此学生");
            return;
        } else {
            if (this.treeSet.contains(stu)) {
                for (Iterator<Student> iter = this.treeSet.iterator(); iter.hasNext();) {
                    Student s = iter.next();
                    if (s.getId().equals(id)) {
                        content = s.toString() + "\n";
                        File file = new File(path);
                        FileOutputStream fileOutputStream = null;
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(content.getBytes());

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                System.out.println("查无此学生");
            }
        }

    }

    /**
     * 展示TreeSet集合对象
     */
    public void show() {
        for (Iterator<Student> iter = this.treeSet.iterator(); iter.hasNext();) {
            System.out.print("\n ---- 展示TreeSet集合对象 ----\n");
            System.out.printf("asc : %s\n", iter.next());
        }
    }

    /**
     *
     */
    public void save() {
        String insertSql = "insert into 20184103281_info(id,name) values(?,?)";
        String selectSql = "select id,name from 20184103281_info";
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(insertSql);
            conn.setAutoCommit(false);
            while (this.treeSet.iterator().hasNext()) {
                Student s = this.treeSet.iterator().next();
                pstmt.setString(0, s.getId());
                pstmt.setString(1, s.getName());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            conn.commit();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("学生信息如下:");
                System.out.println(new Student(id, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                freeResultSet(rs);
                freePreparedStatement(pstmt);
                freeStatement(stmt);
                freeConn(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;

    }

    /**
     *
     * @param conn
     * @throws SQLException
     */
    public void freeConn(Connection conn) throws SQLException {
        if (conn != null)
            conn.close();
    }

    /**
     *
     * @param stmt
     * @throws SQLException
     */
    public void freeStatement(Statement stmt) throws SQLException {
        if (stmt != null)
            stmt.close();
    }

    /**
     *
     * @param pstmt
     * @throws SQLException
     */
    public void freePreparedStatement(PreparedStatement pstmt) throws SQLException {
        if (pstmt != null)
            pstmt.close();
    }

    /**
     *
     * @param rs
     * @throws SQLException
     */
    public void freeResultSet(ResultSet rs) throws SQLException {
        if (rs != null)
            rs.close();
    }

    public TreeSet<Student> getTreeSet() {
        return treeSet;
    }

    public void setTreeSet(TreeSet<Student> treeSet) {
        this.treeSet = treeSet;
    }

}


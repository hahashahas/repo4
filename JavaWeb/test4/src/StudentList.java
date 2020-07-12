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
	static final String DB_URL = "jdbc:mysql://localhost:3306/wcy";
	static final String USER = "root";
	static final String PASS = "2039527370abc";
	static final String FILE_PAHT = "20184103295";
	private TreeSet<Student> treeSet;

	public static void main(String[] args) {
		StudentList sl = new StudentList();

		try {
			sl.add();
			sl.show();
			sl.search(FILE_PAHT);
			sl.show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sl.save();
	}

	/**
	 * 添加学生信息,包含自己信息
	 */
	public void add() {
		treeSet = new TreeSet<Student>();
		treeSet.add(new Student("王晨雨", FILE_PAHT));
		treeSet.add(new Student("嗷嗷", "126656333"));
		treeSet.add(new Student("是是", "98785821"));
		treeSet.add(new Student("宿舍", "12585852584"));

	}

	/**
	 * 根据学生id查找学生
	 * 
	 * @param id
	 */
	public void search(String id) throws FileNotFoundException {
		Student stu = new Student();
		String path = "D://"+FILE_PAHT+".txt";
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
		System.out.print("\n ---- 展示TreeSet集合对象 ----\n");
		for (Iterator<Student> iter = this.treeSet.iterator(); iter.hasNext();) {
			System.out.printf("%s\n", iter.next());
		}
	}

	/**
	 * 
	 */
	public void save() {
		String insertSql = "insert into "+FILE_PAHT+"_info(id,name) values(?,?)";
		String selectSql = "select id,name from "+FILE_PAHT+"_info";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertSql);
			conn.setAutoCommit(false);
			Iterator<Student> iter = this.treeSet.iterator();
			while (iter.hasNext()) {
				Student s = iter.next();
				pstmt.setString(1, s.getId());
				pstmt.setString(2, s.getName());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();

			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			System.out.println("学生信息如下:");
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
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

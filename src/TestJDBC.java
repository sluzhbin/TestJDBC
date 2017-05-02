import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/forum";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "123qwe");
			String sqlQuery = "Select * FROM topics";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			while(rs.next()){
				int id_Topic = rs.getInt("id_topic");
				String topic_Name = rs.getString("topic_name");
				int id_Author = rs.getInt("id_author");
				System.out.println(" " + id_Topic + " " + topic_Name + " "+ id_Author);
			}
		} catch(SQLException se){
			System.out.println("SQLError: " + se.getMessage() + "code: " + se.getErrorCode());
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception fe){
				fe.printStackTrace();
			}
		}
	}

}

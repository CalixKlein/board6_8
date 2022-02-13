import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	 public static void main(String[] args) {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection conn = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	            System.out.println("DB 연결 완료");
	        } catch(ClassNotFoundException e) {
	            System.out.println("JDBC 드라이버 로드 에러");
	        } catch (SQLException e) {
	            System.out.println("DB 연결 오류");
	        }
	 
	    }
}

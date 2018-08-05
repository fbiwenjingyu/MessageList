import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class FriendStore {
	public Vector getCompany(Connection conn,String sql) {
		Vector v = new Vector();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				String name = rs.getString(1);
				String sex = rs.getString(2);
				String birthday = rs.getString(3);
				String address = rs.getString(4);
				String company = rs.getString(5);
				String duty = rs.getString(6);
				String salary = rs.getString(7);
				String tel = rs.getString(8);
				String phone = rs.getString(9); 
				Friend f = new Friend(name);
				f.setSex(sex);
				f.setBirthday(birthday);
				f.setAddress(address);
				f.setCompany(company);
				f.setDuty(duty);
				f.setSalary(salary);
				f.setTel(tel);
				f.setPhone(phone);
				v.add(f);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Friend getObject(Connection conn,String name) {
		Friend f = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from comfriend where name = '" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				name = rs.getString(1);
				String sex = rs.getString(2);
				String birthday = rs.getString(3);
				String address = rs.getString(4);
				String company = rs.getString(5);
				String duty = rs.getString(6);
				String salary = rs.getString(7);
				String tel = rs.getString(8);
				String phone = rs.getString(9); 
				f = new Friend(name);
				f.setSex(sex);
				f.setBirthday(birthday);
				f.setAddress(address);
				f.setCompany(company);
				f.setDuty(duty);
				f.setSalary(salary);
				f.setTel(tel);
				f.setPhone(phone);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/combook";
		String username = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

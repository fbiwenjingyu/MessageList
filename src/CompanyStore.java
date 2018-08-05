import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class CompanyStore {
	public Vector getCompany(Connection conn,String sql) {
		Vector v = new Vector();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				String name = rs.getString(1);
				String code = rs.getString(2);
				String department = rs.getString(3);
				String sex = rs.getString(4);
				String address = rs.getString(5);
				String birthday = rs.getString(6);
				String duty = rs.getString(7);
				String salary = rs.getString(8);
				String tel = rs.getString(9); 
				String motel = rs.getString(10);
				Company c = new Company(name);
				c.setCode(code);
				c.setDepartment(department);
				c.setSex(sex);
				c.setAddress(address);
				c.setBirthday(birthday);
				c.setDuty(duty);
				c.setSalary(salary);
				c.setTel(tel);
				c.setMotel(motel);
				v.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Company getObject(Connection conn,String name) {
		Company c = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from company where name = '" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				name = rs.getString(1);
				String code = rs.getString(2);
				String department = rs.getString(3);
				String sex = rs.getString(4);
				String address = rs.getString(5);
				String birthday = rs.getString(6);
				String duty = rs.getString(7);
				String salary = rs.getString(8);
				String tel = rs.getString(9); 
				String motel = rs.getString(10);
				c = new Company(name);
				c.setCode(code);
				c.setDepartment(department);
				c.setSex(sex);
				c.setAddress(address);
				c.setBirthday(birthday);
				c.setDuty(duty);
				c.setSalary(salary);
				c.setTel(tel);
				c.setMotel(motel);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
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

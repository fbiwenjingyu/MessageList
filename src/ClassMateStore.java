import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ClassMateStore {
	public Vector getClassMate(Connection conn,String sql) {
		Vector v = new Vector();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				String sex = rs.getString(2);
				String address = rs.getString(3);
				String homeaddress = rs.getString(4);
				String city = rs.getString(5);
				String company = rs.getString(6); 
				String duty = rs.getString(7);
				String salary = rs.getString(8);
				String contact = rs.getString(9);
				String homephone = rs.getString(10);
				ClassMate cm = new ClassMate(name);
				cm.setSex(sex);
				cm.setAddress(address);
				cm.setHomeaddress(homeaddress);
				cm.setCity(city);
				cm.setCompany(company);
				cm.setDuty(duty);
				cm.setSalary(salary);
				cm.setContact(contact);
				cm.setHomephone(homephone);
				v.add(cm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public ClassMate getObject(Connection conn,String name) {
		ClassMate cm = null;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from classmate where name = '" + name + "'";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) { 
				name = rs.getString(1);
				String sex = rs.getString(2);
				String address = rs.getString(3);
				String homeaddress = rs.getString(4);
				String city = rs.getString(5);
				String company = rs.getString(6); 
				String duty = rs.getString(7);
				String salary = rs.getString(8);
				String contact = rs.getString(9);
				String homephone = rs.getString(10);
				cm = new ClassMate(name);
				cm.setSex(sex);
				cm.setAddress(address);
				cm.setHomeaddress(homeaddress);
				cm.setCity(city);
				cm.setCompany(company);
				cm.setDuty(duty);
				cm.setSalary(salary);
				cm.setContact(contact);
				cm.setHomephone(homephone);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cm;
		
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

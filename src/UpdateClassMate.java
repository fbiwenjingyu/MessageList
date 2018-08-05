import java.sql.Connection;
import java.sql.Statement;

public class UpdateClassMate {
	ClassMateStore store = new ClassMateStore();
	Connection conn = store.getConnection();
	public UpdateClassMate() {
		try {
			Statement statement = conn.createStatement();
			String sex = ClassInfo.sexinput.getText();
			String name = (String) ClassInfo.nameinput.getSelectedItem();
			String address = ClassInfo.addressinput.getText();
			String homeaddress = ClassInfo.homeaddressinput.getText(); 
			String city = ClassInfo.cityinput.getText();
			String company = ClassInfo.companyinput.getText();
			String duty = ClassInfo.dutyinput.getText();
			String salary = ClassInfo.salaryinput.getText();
			String sql1 = "update classmate set sex='" + sex +"' where name='" + name + "'";
			String sql2 = "update classmate set address='" + address +"' where name='" + name + "'";
			String sql3 = "update classmate set homeaddress='" + homeaddress +"' where name='" + name + "'";
			String sql4 = "update classmate set city='" + city +"' where name='" + name + "'";
			String sql5 = "update classmate set company='" + company +"' where name='" + name + "'";
			String sql6 = "update classmate set duty='" + duty +"' where name='" + name + "'";
			String sql7 = "update classmate set salary='" + salary +"' where name='" + name + "'";
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			statement.executeUpdate(sql4);
			statement.executeUpdate(sql5);
			statement.executeUpdate(sql6);
			statement.executeUpdate(sql7);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}	

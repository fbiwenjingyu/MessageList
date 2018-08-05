import java.sql.Connection;
import java.sql.Statement;

public class UpdateCompany {
	CompanyStore store = new CompanyStore();
	Connection conn = store.getConnection();
	
	public UpdateCompany() {
		try {
			Statement statement = conn.createStatement();
			String sex = CompanyInfo.sexinput.getText();
			String name = (String) CompanyInfo.nameinput.getSelectedItem();
			String address = CompanyInfo.addressinput.getText();
			String code = CompanyInfo.codeinput.getText(); 
			String department = CompanyInfo.departmentinput.getText();
			String duty = CompanyInfo.dutyinput.getText();
			String salary = CompanyInfo.salaryinput.getText();
			String birthday = CompanyInfo.birthdayinput.getText();
			String sql1 = "update company set sex='" + sex +"' where name='" + name + "'";
			String sql2 = "update company set address='" + address +"' where name='" + name + "'";
			String sql3 = "update company set code='" + code +"' where name='" + name + "'";
			String sql4 = "update company set department='" + department +"' where name='" + name + "'";
			String sql5 = "update company set birthday='" + birthday +"' where name='" + name + "'";
			String sql6 = "update company set duty='" + duty +"' where name='" + name + "'";
			String sql7 = "update company set salary='" + salary +"' where name='" + name + "'";
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

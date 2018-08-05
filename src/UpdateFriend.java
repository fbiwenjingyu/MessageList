import java.sql.Connection;
import java.sql.Statement;

public class UpdateFriend {
	FriendStore store = new FriendStore();
	Connection conn = store.getConnection();
	
	public UpdateFriend() {
		try {
			Statement statement = conn.createStatement();
			String sex = FriendInfo.sexinput.getText();
			String name = (String) FriendInfo.nameinput.getSelectedItem();
			String address = FriendInfo.addressinput.getText();
			String birthday = FriendInfo.birthdayinput.getText(); 
			String duty = FriendInfo.dutyinput.getText();
			String salary = FriendInfo.salaryinput.getText();
			String company = FriendInfo.companyinput.getText();
			String sql1 = "update comfriend set sex='" + sex +"' where name='" + name + "'";
			String sql2 = "update comfriend set address='" + address +"' where name='" + name + "'";
			String sql3 = "update comfriend set birthday='" + birthday +"' where name='" + name + "'";
			String sql4 = "update comfriend set company='" + company +"' where name='" + name + "'";
			String sql5 = "update comfriend set duty='" + duty +"' where name='" + name + "'";
			String sql6 = "update comfriend set salary='" + salary +"' where name='" + name + "'";
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			statement.executeUpdate(sql4);
			statement.executeUpdate(sql5);
			statement.executeUpdate(sql6);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

import java.sql.Connection;
import java.sql.Statement;

public class DeleteFriend {
	public DeleteFriend() {
		String namestring = (String) FriendInfo.nameinput.getSelectedItem();
		FriendStore store = new FriendStore();
		try {
			Connection connection = store.getConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from comfriend where name ='" + namestring + "'";
			statement.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		FriendInfo.nameinput.removeItem(namestring);
	}
}

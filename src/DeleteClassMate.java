import java.sql.Connection;
import java.sql.Statement;

public class DeleteClassMate {
	public DeleteClassMate() {
		String namestring = (String) ClassInfo.nameinput.getSelectedItem();
		ClassMateStore store = new ClassMateStore();
		try {
			Connection connection = store.getConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from classmate where name ='" + namestring + "'";
			statement.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ClassInfo.nameinput.removeItem(namestring);
	}
}

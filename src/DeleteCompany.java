import java.sql.Connection;
import java.sql.Statement;

public class DeleteCompany {
	public DeleteCompany() {
		String namestring = (String) CompanyInfo.nameinput.getSelectedItem();
		CompanyStore store = new CompanyStore();
		try {
			Connection connection = store.getConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from company where name ='" + namestring + "'";
			statement.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		CompanyInfo.nameinput.removeItem(namestring);
	}
}

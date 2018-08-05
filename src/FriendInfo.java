import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FriendInfo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sql = "select * from comfriend";
	static JComboBox nameinput;
	FriendStore store = new FriendStore();
	Connection conn = store.getConnection();
	static JTextField sexinput;
	static JTextField birthdayinput;
	static JTextField addressinput;
	static JTextField companyinput;
	static JTextField dutyinput;
	static JTextField salaryinput;
	
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c,constraints);
	}
	
	public FriendInfo() {
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		JLabel name = new JLabel("姓名");
		JLabel sex = new JLabel("性别");
		JLabel birthday = new JLabel("出生年月");
		JLabel address = new JLabel("家庭地址");
		JLabel company = new JLabel("所在公司");
		JLabel duty = new JLabel("职位");
		JLabel salary = new JLabel("薪水");
		
		salaryinput = new JTextField(10);
		nameinput = new JComboBox();
		sexinput = new JTextField(10);
		birthdayinput = new JTextField(10);
		addressinput = new JTextField(10);
		companyinput = new JTextField(20);
		dutyinput = new JTextField(10);
		
		JLabel title = new JLabel("朋友基本信息");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 4;
		constraints.weighty = 6;
		add(title,constraints,0,0,4,1);
		add(name,constraints,0,1,1,1);
		add(sex,constraints,0,2,1,1);
		add(birthday,constraints,0,3,1,1);
		add(address,constraints,0,4,1,1);
		add(nameinput,constraints,1,1,1,1);
		add(sexinput,constraints,1,2,1,1);
		add(birthdayinput,constraints,1,3,1,1);
		add(addressinput,constraints,1,4,1,1);
		add(company,constraints,2,1,1,1);
		add(duty,constraints,2,2,1,1);
		add(salary,constraints,2,3,1,1);
		add(companyinput,constraints,3,1,1,1);
		add(dutyinput,constraints,3,2,1,1);
		add(salaryinput,constraints,3,3,1,1);
		
		Vector vec = store.getCompany(conn, sql);
		for(int i=0;i<vec.size();i++) {
			Friend one = (Friend) vec.get(i);
			String nameselect = one.getName();
			nameinput.addItem(nameselect);
		}
		String namestring = (String) nameinput.getSelectedItem();
		Friend p = store.getObject(conn, namestring);
		String inputsex = p.getSex();
		String inputbirthday = p.getBirthday();
		String inputaddress = p.getAddress();
		String inputcompany = p.getCompany();
		String inputduty = p.getDuty();
		String inputsalary = p.getSalary();
		
		sexinput.setText(inputsex);
		birthdayinput.setText(inputbirthday);
		addressinput.setText(inputaddress);
		companyinput.setText(inputcompany);
		dutyinput.setText(inputduty);
		salaryinput.setText(inputsalary);
		
		nameinput.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String namestring = (String) nameinput.getSelectedItem();
				Friend p = store.getObject(conn, namestring);
				String inputsex = p.getSex();
				String inputbirthday = p.getBirthday();
				String inputaddress = p.getAddress();
				String inputcompany = p.getCompany();
				String inputduty = p.getDuty();
				String inputsalary = p.getSalary();
				
				sexinput.setText(inputsex);
				birthdayinput.setText(inputbirthday);
				addressinput.setText(inputaddress);
				companyinput.setText(inputcompany);
				dutyinput.setText(inputduty);
				salaryinput.setText(inputsalary);
			}
		});
	}
}

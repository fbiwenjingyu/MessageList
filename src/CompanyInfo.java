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

public class CompanyInfo extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sql = "select * from company";
	static JComboBox nameinput;
	CompanyStore store = new CompanyStore();
	Connection conn = store.getConnection();
	static JTextField codeinput;
	static JTextField sexinput;
	static JTextField departmentinput;
	static JTextField addressinput;
	static JTextField birthdayinput;
	static JTextField dutyinput;
	static JTextField salaryinput;
	
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c,constraints);
	}
	
	public CompanyInfo() {
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		JLabel name = new JLabel("姓名");
		JLabel code = new JLabel("工号");
		JLabel department = new JLabel("部门");
		JLabel sex = new JLabel("性别");
		JLabel address = new JLabel("家庭地址");
		JLabel birthday = new JLabel("出生年月");
		JLabel duty = new JLabel("职位");
		JLabel salary = new JLabel("薪水");
		
		codeinput = new JTextField(10);
		nameinput = new JComboBox();
		departmentinput = new JTextField(10);
		sexinput = new JTextField(10);
		addressinput = new JTextField(10);
		birthdayinput = new JTextField(10);
		dutyinput = new JTextField(10);
		salaryinput = new JTextField(10);
		JLabel title = new JLabel("同事基本信息");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 4;
		constraints.weighty = 6;
		
		add(title,constraints,0,0,4,1);
		add(name,constraints,0,1,1,1);
		add(code,constraints,0,2,1,1);
		add(department,constraints,0,3,1,1);
		add(sex,constraints,0,4,1,1);
		add(nameinput,constraints,1,1,1,1);
		add(codeinput,constraints,1,2,1,1);
		add(departmentinput,constraints,1,3,1,1);
		add(sexinput,constraints,1,4,1,1);
		add(address,constraints,2,1,1,1);
		add(birthday,constraints,2,2,1,1);
		add(duty,constraints,2,3,1,1);
		add(salary,constraints,2,4,1,1);
		add(addressinput,constraints,3,1,1,1);
		add(birthdayinput,constraints,3,2,1,1);
		add(dutyinput,constraints,3,3,1,1);
		add(salaryinput,constraints,3,4,1,1);
		
		Vector vec = store.getCompany(conn, sql);
		for(int i=0;i<vec.size();i++) {
			Company one = (Company) vec.get(i);
			String nameselect = one.getName();
			nameinput.addItem(nameselect);
		}
		String namestring = (String) nameinput.getSelectedItem();
		Company p = store.getObject(conn, namestring);
		String inputcode = p.getCode();
		String inputsex = p.getSex();
		String inputbirthday = p.getBirthday();
		String inputdepartment = p.getDepartment();
		String inputaddress = p.getAddress();
		String inputduty = p.getDuty();
		String inputsalary = p.getSalary();
		sexinput.setText(inputsex);
		codeinput.setText(inputcode);
		birthdayinput.setText(inputbirthday);
		addressinput.setText(inputaddress);
		departmentinput.setText(inputdepartment);
		dutyinput.setText(inputduty);
		salaryinput.setText(inputsalary);
		nameinput.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String namestring = (String) nameinput.getSelectedItem();
				Company p = store.getObject(conn, namestring);
				String inputcode = p.getCode();
				String inputsex = p.getSex();
				String inputbirthday = p.getBirthday();
				String inputdepartment = p.getDepartment();
				String inputaddress = p.getAddress();
				String inputduty = p.getDuty();
				String inputsalary = p.getSalary();
				sexinput.setText(inputsex);
				codeinput.setText(inputcode);
				birthdayinput.setText(inputbirthday);
				addressinput.setText(inputaddress);
				departmentinput.setText(inputdepartment);
				dutyinput.setText(inputduty);
				salaryinput.setText(inputsalary);
			}
		});
	}
}

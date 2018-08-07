import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCompany extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JTextField nameinput;
	static final int WIDTH = 600;
	static final int HEIGHT = 300;
	JFrame frame;
	final JTextField departmentinput;
	final JTextField sexinput;
	final JTextField addressinput;
	final JTextField birthdayinput;
	final JTextField dutyinput;
	final JTextField salaryinput;
	final JTextField telinput;
	final JTextField motelinput;
	
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c,constraints);
	}
	
	public AddCompany() {
		frame = new JFrame("添加同事信息窗口");
		frame.setContentPane(this);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) /2;
		
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
		JLabel tel = new JLabel("公司电话");
		JLabel motel = new JLabel("移动电话");
		
		final JTextField codeinput = new JTextField(10);
		nameinput = new JTextField(10);
		departmentinput = new JTextField(10);
		sexinput = new JTextField(10);
		addressinput = new JTextField(10);
		birthdayinput = new JTextField(10);
		dutyinput = new JTextField(10);
		salaryinput = new JTextField(10);
		telinput = new JTextField(10);
		motelinput = new JTextField(10);
		
		JLabel title = new JLabel("同事基本信息");
		JButton addbutton = new JButton("添加同事信息数据");
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
		add(tel,constraints,0,5,1,1);
		add(motel,constraints,2,5,1,1);
		add(telinput,constraints,1,5,1,1);
		add(motelinput,constraints,3,5,1,1);
		add(addbutton,constraints,0,6,2,1);
		frame.setLocation(x, y);
		frame.setVisible(true);
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		addbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nametext = nameinput.getText();
					String codetext = codeinput.getText();
					String departmenttext = departmentinput.getText();
					String sextext = sexinput.getText();
					String birthdaytext = birthdayinput.getText();
					String addresstext = addressinput.getText();
					String dutytext = dutyinput.getText();
					String salarytext = salaryinput.getText();
					String moteltext = motelinput.getText();
					String teltext = telinput.getText();
					CompanyStore store = new CompanyStore();
					Connection connection = store.getConnection();
					Statement statement = connection.createStatement();
					String sql = "insert into company values('" + nametext + "','" + codetext + "','" + departmenttext + 
							"','" + sextext + "','" + addresstext + "','" + birthdaytext +  "','" + dutytext + "','" + salarytext +
							"','" + teltext + "','" + moteltext + "')";
					
					statement.executeUpdate(sql);
					Company ss = new Company(nametext);
					ss.setCode(codetext);
					ss.setDepartment(departmenttext);
					ss.setSex(sextext);
					ss.setBirthday(birthdaytext);
					ss.setDuty(dutytext);
					ss.setSalary(salarytext);
					ss.setTel(teltext);
					ss.setMotel(moteltext);
					Vector vec = new Vector();
					vec.add(ss);
					CompanyInfo.nameinput.addItem(nametext);
					CompanyInfo.nameinput.setSelectedItem(nametext);
					CompanyInfo.codeinput.setText(codetext);
					CompanyInfo.departmentinput.setText(departmenttext);
					CompanyInfo.sexinput.setText(sextext);
					CompanyInfo.birthdayinput.setText(birthdaytext);
					CompanyInfo.dutyinput.setText(dutytext);
					CompanyInfo.salaryinput.setText(salarytext);
					
				}catch(Exception ee) {
					ee.printStackTrace();
				}
				frame.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new AddCompany();
	}
}

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FriendFind extends JPanel{
	String sql = "select * from comfriend";
	FriendStore store = new FriendStore();
	Connection conn = store.getConnection();
	static JPanel pane;
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		pane.add(c,constraints);
	}
	
	public FriendFind() {
		pane = new JPanel();
		GridBagLayout lay = new GridBagLayout();
		pane.setLayout(lay);
		JLabel name = new JLabel("姓名");
		JLabel sex = new JLabel("性别");
		JLabel birthday = new JLabel("出生年月");
		JLabel address = new JLabel("家庭地址");
		JLabel company = new JLabel("所在公司");
		JLabel duty = new JLabel("职位");
		JLabel salary = new JLabel("薪水");
		JLabel namefindlabel = new JLabel("按姓名查询");
		JButton namefindbutton = new JButton("查询");
		JButton closebutton = new JButton("关闭窗口");
		final JTextField nameinput = new JTextField(10);
		final JTextField sexinput = new JTextField(10);
		final JTextField addressinput = new JTextField(10);
		final JTextField birthdayinput = new JTextField(10);
		final JTextField companyinput = new JTextField(10);
		final JTextField dutyinput = new JTextField(10);
		final JTextField salaryinput = new JTextField(10);
		final JTextField namefind = new JTextField(10);
		JLabel title = new JLabel("朋友查询结果信息");
		JLabel title1 = new JLabel("查询系统");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 4;
		constraints.weighty = 6;
		add(title,constraints,0,0,4,1);
		add(name,constraints,0,1,1,1);
		add(sex,constraints,0,2,1,1);
		add(address,constraints,0,3,1,1);
		add(birthday,constraints,0,4,1,1);
		add(nameinput,constraints,1,1,1,1);
		add(sexinput,constraints,1,2,1,1);
		add(addressinput,constraints,1,3,1,1);
		add(birthdayinput,constraints,1,4,1,1);
		add(company,constraints,2,1,1,1);
		add(duty,constraints,2,2,1,1);
		add(salary,constraints,2,3,1,1);
		add(companyinput,constraints,2,4,1,1);
		add(birthdayinput,constraints,3,1,1,1);
		add(dutyinput,constraints,3,2,1,1);
		add(salaryinput,constraints,3,3,1,1);
		add(title1,constraints,0,5,4,1);
		add(namefindlabel,constraints,0,6,1,1);
		add(namefind,constraints,1,6,1,1);
		add(namefindbutton,constraints,2,6,1,1);
		add(closebutton,constraints,3,6,1,1);
		namefindbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String namestring = namefind.getText();
				Friend p = store.getObject(conn, namestring);
				String inputsex = p.getSex();
				String inputbirthday = p.getBirthday();
				String inputaddress = p.getAddress();
				String inputcompany = p.getCompany();
				String inputduty = p.getDuty();
				String inputsalary = p.getSalary();
				nameinput.setText(namefind.getText());
				sexinput.setText(inputsex);
				birthdayinput.setText(inputbirthday);
				addressinput.setText(inputaddress);
				companyinput.setText(inputcompany);
				dutyinput.setText(inputduty);
				salaryinput.setText(inputsalary);
			}
		});
		closebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setVisible(false);
			}
		});
		pane.setVisible(false);
	}
}

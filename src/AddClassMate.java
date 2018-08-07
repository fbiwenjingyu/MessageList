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

public class AddClassMate extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JTextField nameinput;
	static final int WIDTH = 600;
	static final int HEIGHT = 300;
	JFrame frame;
	static ClassMate ss;
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c,constraints);
	}
	
	public AddClassMate() {
		frame = new JFrame("ͬѧ��Ϣ��Ӵ���");
		frame.setContentPane(this);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) /2;
		
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		JLabel name = new JLabel("����");
		JLabel sex = new JLabel("�Ա�");
		JLabel address = new JLabel("��ס��ַ");
		JLabel homeaddress = new JLabel("��ͥ��ַ");
		JLabel city = new JLabel("���ڳ���");
		JLabel company = new JLabel("���ڹ�˾");
		JLabel duty = new JLabel("ְλ");
		JLabel salary = new JLabel("нˮ");
		JLabel contact = new JLabel("�ƶ��绰");
		JLabel homephone = new JLabel("��ͥ�绰");
		nameinput = new JTextField(10);
		final JTextField sexinput = new JTextField(10);
		final JTextField addressinput = new JTextField(10);
		final JTextField homeaddressinput = new JTextField(10);
		final JTextField cityinput = new JTextField(10);
		final JTextField companyinput = new JTextField(10);
		final JTextField dutyinput = new JTextField(10);
		final JTextField salaryinput = new JTextField(10);
		final JTextField contactinput = new JTextField(10);
		final JTextField homephoneinput = new JTextField(10);
		JLabel title = new JLabel("ͬѧ������Ϣ");
		JButton addbutton = new JButton("���ͬѧ��Ϣ����");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 4;
		constraints.weighty = 6;
		
		add(title,constraints,0,0,4,1);
		add(name,constraints,0,1,1,1);
		add(sex,constraints,0,2,1,1);
		add(address,constraints,0,3,1,1);
		add(homeaddress,constraints,0,4,1,1);
		add(nameinput,constraints,1,1,1,1);
		add(sexinput,constraints,1,2,1,1);
		add(addressinput,constraints,1,3,1,1);
		add(homephoneinput,constraints,1,4,1,1);
		add(city,constraints,2,1,1,1);
		add(company,constraints,2,2,1,1);
		add(duty,constraints,2,3,1,1);
		add(salary,constraints,2,4,1,1);
		add(cityinput,constraints,3,1,1,1);
		add(companyinput,constraints,3,2,1,1);
		add(dutyinput,constraints,3,3,1,1);
		add(salaryinput,constraints,3,4,1,1);
		add(contact,constraints,0,5,1,1);
		add(homephone,constraints,2,5,1,1);
		add(contactinput,constraints,1,5,1,1);
		add(homeaddressinput,constraints,3,5,1,1);
		add(addbutton,constraints,0,6,2,1);
		frame.setLocation(x, y);
		frame.setVisible(true);
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		addbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nametext = nameinput.getText();
					String sextext = sexinput.getText();
					String addresstext = addressinput.getText();
					String homeaddresstext = homeaddressinput.getText();
					String citytext = cityinput.getText();
					String companytext = companyinput.getText();
					String dutytext = dutyinput.getText();
					String salarytext = salaryinput.getText();
					String contacttext = contactinput.getText();
					String homephonetext = homephoneinput.getText();
					ClassMateStore store = new ClassMateStore();
					Connection connection = store.getConnection();
					Statement statement = connection.createStatement();
					String sql = "insert into classmate values('" + nametext + "','" + sextext + "','" + addresstext + 
							"','" + homeaddresstext + "','" + citytext + "','" + companytext +  "','" + dutytext + "','" + salarytext +
							"','" + contacttext + "','" + homephonetext + "')";
					
					statement.executeUpdate(sql);
					ss = new ClassMate(nametext);
					ss.setSex(sextext);
					ss.setAddress(addresstext);
					ss.setHomeaddress(homeaddresstext);
					ss.setCity(citytext);
					ss.setCompany(companytext);
					ss.setDuty(dutytext);
					ss.setSalary(salarytext);
					ss.setContact(contacttext);
					ss.setHomephone(homephonetext);
					Vector vec = new Vector();
					vec.add(ss);
					ClassInfo.nameinput.addItem(nametext);
					ClassInfo.nameinput.setSelectedItem(nametext);
					ClassInfo.sexinput.setText(sextext);
					ClassInfo.addressinput.setText(addresstext);
					ClassInfo.homeaddressinput.setText(homeaddresstext);
					ClassInfo.companyinput.setText(companytext);
					ClassInfo.dutyinput.setText(dutytext);
					ClassInfo.salaryinput.setText(salarytext);
				}catch(Exception ee) {
					ee.printStackTrace();
				}
				frame.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new AddClassMate();
	}
}

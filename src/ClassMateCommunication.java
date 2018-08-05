import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClassMateCommunication {
	static JComboBox nameinput;
	String sql = "select * from classmate";
	ClassMateStore store = new ClassMateStore();
	Connection conn = store.getConnection();
	static JTextField homephonetext;
	static JTextField moteltext;
	static JLabel name;
	static JLabel title;
	static JLabel title1;
	static JButton closeButton;
	static JPanel pane;
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		pane.add(c,constraints);
	}
	
	public ClassMateCommunication() {
		pane = new JPanel();
		GridBagLayout lay = new GridBagLayout();
		pane.setLayout(lay);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 5;
		constraints.weighty = 3;
		name = new JLabel("姓名");
		nameinput = new JComboBox();
		title = new JLabel("家庭电话号码");
		title1 = new JLabel("个人移动电话号码");
		homephonetext =  new JTextField(20);
		moteltext = new JTextField(20);
		closeButton = new JButton("关闭此窗口");
		add(title,constraints,1,0,3,1);
		add(homephonetext,constraints,1,1,3,1);
		add(title1,constraints,1,2,3,1);
		add(moteltext,constraints,1,3,3,1);
		add(closeButton,constraints,2,4,3,1);
		add(name,constraints,1,0,1,1);
		add(nameinput,constraints,2,0,1,1);
		
		Vector vec = store.getClassMate(conn, sql);
		for(int i=0;i<vec.size();i++) {
			ClassMate one = (ClassMate) vec.get(i);
			String nameselect = one.getName();
			nameinput.addItem(nameselect);
		}
		String namestring = (String) nameinput.getSelectedItem();
		ClassMate p = store.getObject(conn, namestring);
		String inputtel = p.getContact();
		String inputmotel = p.getHomephone();
		homephonetext.setText(inputtel);
		moteltext.setText(inputmotel);
		nameinput.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String namestring = (String) nameinput.getSelectedItem();
				ClassMate p = store.getObject(conn, namestring);
				String inputtel = p.getContact();
				String inputmotel = p.getHomephone();
				homephonetext.setText(inputtel);
				moteltext.setText(inputmotel);
			}
		});
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setVisible(false);
			}
		});
		pane.setVisible(false);
	}
}

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loggins extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 150;
	JFrame loginframe;
	
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c,constraints);
	}
	
	public Loggins() {
		loginframe = new JFrame("我的通讯簿系统");
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		loginframe.add(this,BorderLayout.WEST);
		loginframe.setSize(WIDTH, HEIGHT);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) /2;
		loginframe.setLocation(x, y);
		JButton ok = new JButton("登录");
		JButton cancel = new JButton("放弃");
		JLabel title = new JLabel("通讯簿系统登录窗口");
		JLabel name = new JLabel("用户名");
		JLabel password = new JLabel("密 码");
		final JTextField nameinput = new JTextField(15);
		final JPasswordField passwordinput = new JPasswordField(15);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.weightx = 4;
		constraints.weighty = 4;
		add(title,constraints,2,0,2,1);
		add(name,constraints,1,1,2,1);
		add(password,constraints,1,2,2,1);
		add(nameinput,constraints,3,1,2,1);
		add(passwordinput,constraints,3,2,2,1);
		add(ok,constraints,1,3,1,1);
		add(cancel,constraints,3,3,1,1);
		loginframe.setResizable(false);
		loginframe.setVisible(true);		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameinput.getText().equals("admin") && passwordinput.getText().equals("123456")) {
					new MainFrame();
					loginframe.dispose();
				}else{
					nameinput.setText("");
					passwordinput.setText("");
				}
			}
		});		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginframe.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new Loggins();
	}
	
}

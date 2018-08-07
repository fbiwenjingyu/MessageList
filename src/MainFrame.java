import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public class MainFrame {
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	JPopupMenu pop;
	JMenuItem item2;
	JFrame f;
	JMenuItem item1;
	JPanel p;
	JToolBar bar;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	Tabpane tab1;
	Tabpane tab2;
	Tabpane tab3;
	JButton closebutton1;
	JButton closebutton2;
	JButton closebutton3;
	JButton addbutton1;
	JButton addbutton2;
	JButton addbutton3;
	JButton delbutton1;
	JButton delbutton2;
	JButton delbutton3;
	JButton updatebutton1;
	JButton updatebutton2;
	JButton updatebutton3;
	
	public MainFrame() {
		f = new JFrame("�ҵ�ͨѶ¼ϵͳ������");
		JMenuBar menuBar1 = new JMenuBar();
		p = new JPanel();
		f.setContentPane(p);
		f.setJMenuBar(menuBar1);
		JMenu menu1 = new JMenu("ͬѧͨѶϵͳ");
		JMenu menu2 = new JMenu("ͬ��ͨѶϵͳ");
		JMenu menu3 = new JMenu("����ͨѶϵͳ");
		JMenu menu4 = new JMenu("��ѯϵͳ");
		JMenu menu5 = new JMenu("����ϵͳ");
		menuBar1.add(menu1);
		menuBar1.add(menu2);
		menuBar1.add(menu3);
		menuBar1.add(menu4);
		menuBar1.add(menu5);
		item1 = new JMenuItem("ͬѧ������Ϣϵͳ");
		item2 = new JMenuItem("ͬѧ��ϵ��ʽϵͳ");
		JMenuItem item3 = new JMenuItem("�˳�ͨѶ¼ϵͳ");
		JMenuItem item4 = new JMenuItem("ͬ�»�����Ϣϵͳ");
		JMenuItem item5 = new JMenuItem("ͬ����ϵ��ʽϵͳ");
		JMenuItem item6 = new JMenuItem("���ѻ�����Ϣϵͳ");
		JMenuItem item7 = new JMenuItem("������ϵ��ʽϵͳ");
		JMenuItem item8 = new JMenuItem("ͬѧ��ѯϵͳ");
		JMenuItem item9 = new JMenuItem("ͬ�²�ѯϵͳ");
		JMenuItem item10 = new JMenuItem("���Ѳ�ѯϵͳ");
		JMenuItem item11 = new JMenuItem("�汾��Ϣ");
		JMenuItem item12 = new JMenuItem("������Ϣ");
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu3.add(item6);
		menu3.addSeparator();
		menu3.add(item7);
		menu4.add(item8);
		menu4.addSeparator();
		menu4.add(item9);
		menu4.addSeparator();
		menu4.add(item10);
		menu5.add(item11);
		menu5.addSeparator();
		menu5.add(item12);
		JButton button1 = new JButton("ͬѧ��ѯϵͳ");
		JButton button2 = new JButton("ͬ�²�ѯϵͳ");
		JButton button3 = new JButton("���Ѳ�ѯϵͳ");
		closebutton1 = new JButton("�ر�");
		closebutton2 = new JButton("�ر�");
		closebutton3 = new JButton("�ر�");
		addbutton1 = new JButton("���ͬѧ��Ϣ����");
		addbutton2 = new JButton("���ͬ����Ϣ����");
		addbutton3 = new JButton("���������Ϣ����");
		delbutton1 = new JButton("ɾ��ͬѧ��Ϣ����");
		delbutton2 = new JButton("ɾ��ͬ����Ϣ����");
		delbutton3 = new JButton("ɾ��������Ϣ����");
		updatebutton1 = new JButton("����ͬѧ��Ϣ����");
		updatebutton2 = new JButton("����ͬ����Ϣ����");
		updatebutton3 = new JButton("����������Ϣ����");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(closebutton1);
		p1.add(addbutton1);
		p1.add(delbutton1);
		p1.add(updatebutton1);
		p2.add(closebutton2);
		p2.add(addbutton2);
		p2.add(delbutton2);
		p2.add(updatebutton2);
		p3.add(closebutton3);
		p3.add(addbutton3);
		p3.add(delbutton3);
		p3.add(updatebutton3);
		bar = new JToolBar();
		bar.add(button1);
		bar.add(button2);
		bar.add(button3);
		p.setLayout(new BorderLayout());
		p.add("North",bar);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(WIDTH, HEIGHT);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH) / 2;
		int y = (height - HEIGHT) /2;
		f.setLocation(x, y);
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab1 = new Tabpane();
				p.add("Center",tab1);
				tab1.panel1.add(new ClassInfo());
				p.add("South",p1);
				Tabpane.tp.setVisible(true);
				p1.setVisible(true);
			}
		});
		
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMateCommunication cc = new ClassMateCommunication();
				p.add("Center",cc.pane);
				cc.pane.setVisible(true);
			}
		});
		
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ����Ҫ�˳�ϵͳ", "�˳�ȷ�϶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					f.dispose();
				}
			}
		});
		
		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab2 = new Tabpane();
				p.add("Center",tab2);
				tab2.panel1.add(new CompanyInfo());
				p.add("South",p2);
				Tabpane.tp.setVisible(true);
				p2.setVisible(true);
			}
		});
		
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CompanyCommunication ccl = new CompanyCommunication();
				p.add("Center",ccl.pane);
				ccl.pane.setVisible(true);
			}
		});
		
		item6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab3 = new Tabpane();
				p.add("Center",tab3);
				tab3.panel1.add(new FriendInfo());
				p.add("South",p3);
				Tabpane.tp.setVisible(true);
				p3.setVisible(true);
			}
		});
		
		item7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FriendCommunication fc = new FriendCommunication();
				p.add("Center",fc.pane);
				fc.pane.setVisible(true);
			}
		});
		
		item8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMateFind cf = new ClassMateFind();
				p.add("Center",cf.pane);
				cf.pane.setVisible(true);
			}
		});
		
		item9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CompanyFind cf = new CompanyFind();
				p.add("Center",cf.pane);
				cf.pane.setVisible(true);
			}
		});
		
		item10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FriendFind ff = new FriendFind();
				p.add("Center",ff.pane);
				ff.pane.setVisible(true);
			}
		});
		
		item11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Version();
			}
		});
		
		item12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Help();
			}
		});
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClassMateFind cf = new ClassMateFind();
				p.add("Center",cf.pane);
				cf.pane.setVisible(true);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CompanyFind cf = new CompanyFind();
				p.add("Center",cf.pane);
				cf.pane.setVisible(true);
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FriendFind ff = new FriendFind();
				p.add("Center",ff.pane);
				ff.pane.setVisible(true);
			}
		});
		
		closebutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab1.setVisible(false);
				p1.setVisible(false);
			}
		});
		
		closebutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab2.setVisible(false);
				p2.setVisible(false);
			}
		});
		
		closebutton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tab3.setVisible(false);
				p3.setVisible(false);
			}
		});
		
		addbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddClassMate();
			}
		});
		
		addbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCompany();
			}
		});
		
		addbutton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFriend();
			}
		});
		
		delbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ����ɾ������", "ɾ��ȷ�϶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new DeleteClassMate();
				}
			}
		});
		
		delbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ����ɾ������", "ɾ��ȷ�϶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new DeleteCompany();
				}
			}
		});
		
		delbutton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ����ɾ������", "ɾ��ȷ�϶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new DeleteFriend();
				}
			}
		});
		
		updatebutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ���ĸ��´���", "ȷ�ϸ��¶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new UpdateClassMate();
				}
			}
		});
		
		updatebutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ���ĸ��´���", "ȷ�ϸ��¶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new UpdateCompany();
				}
			}
		});
		
		updatebutton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ���ĸ��´���", "ȷ�ϸ��¶Ի��� ",JOptionPane.YES_NO_CANCEL_OPTION);
				if(i == 0) {
					new UpdateFriend();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}

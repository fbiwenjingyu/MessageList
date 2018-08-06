import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class Help {
	static final int WIDTH = 700;
	static final int HEIGHT = 400;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode node1;
	DefaultMutableTreeNode node2;
	DefaultMutableTreeNode node3;
	DefaultMutableTreeNode node4;
	static TextArea text;
	
	public Help() {
		JFrame frame = new JFrame();
		frame.setTitle("通讯录系统帮助文档");
		frame.setSize(WIDTH, HEIGHT);
		root = new DefaultMutableTreeNode("通讯录系统帮助文档");
		node1 = new DefaultMutableTreeNode("如何操作同学通讯系统");
		node2 = new DefaultMutableTreeNode("如何操作同事通讯系统");
		node3 = new DefaultMutableTreeNode("如何操作朋友通讯系统");
		node4 = new DefaultMutableTreeNode("如何操作查询系统");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		
		DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("如何使用同学信息模块");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("如何使用同学通讯模块");
		node1.add(leafnode);
		leafnode = new DefaultMutableTreeNode("如何使用同事信息模块");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("如何使用同事通讯模块");
		node2.add(leafnode);
		leafnode = new DefaultMutableTreeNode("如何使用朋友信息模块");
		node3.add(leafnode);
		leafnode = new DefaultMutableTreeNode("如何使用朋友通讯模块");
		node3.add(leafnode);
		tree = new JTree(root);
		JScrollPane scrollPane = new JScrollPane(tree);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setPreferredSize(new Dimension(100, 200));
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(p1);
		splitPane.setRightComponent(p2);
		splitPane.setDividerSize(3);
		splitPane.setDividerLocation(200);
		frame.setContentPane(splitPane);
		p1.add(scrollPane);
		frame.setVisible(true);
		tree.addMouseListener(new MouseHandler());
		text = new TextArea();
		p2.add(text);
		
	}
	public static void main(String[] args) {
		new Help();
	}
}

class MouseHandler extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		String nodename;
		JTree tree = (JTree) e.getSource();
		int rowForLocation = tree.getRowForLocation(e.getX(), e.getY());
		TreePath treePath = tree.getPathForRow(rowForLocation);
		TreeNode treenode =  (TreeNode) treePath.getLastPathComponent();
		nodename = treenode.toString();
		Help.text.setText("要想查询如何使用" + nodename + "模块相关知识，请查阅光盘");
		
	}
	
}
 
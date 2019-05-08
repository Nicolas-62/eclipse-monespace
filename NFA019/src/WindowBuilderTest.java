import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JList;

public class WindowBuilderTest {

	private JFrame frame = new JFrame();
	private JTextField textField = new JTextField();;
	private JTextField textField_1 = new JTextField();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderTest window = new WindowBuilderTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilderTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField.setBounds(10, 11, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1.setBounds(10, 42, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnCopier = new JButton("copier");
		btnCopier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				textField_1.setText(t);
			}
		});
		btnCopier.setBounds(10, 73, 96, 23);
		frame.getContentPane().add(btnCopier);
		
		JList list = new JList();
		list.setBounds(10, 112, 143, 81);
		frame.getContentPane().add(list);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem_1);
	}
}

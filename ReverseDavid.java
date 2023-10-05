package Lab31;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Reverse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtReverse;
	String txt = new String();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reverse frame = new Reverse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reverse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtReverse = new JTextField();
		txtReverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtReverse.setBounds(53, 44, 331, 70);
		contentPane.add(txtReverse);
		txtReverse.setColumns(10);
		
		JButton btnReverse = new JButton("Reverse");
		
		btnReverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReverse.setBounds(101, 198, 232, 52);
		contentPane.add(btnReverse);
		
		JLabel lbReverse = new JLabel("New label");
		lbReverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbReverse.setBounds(53, 126, 331, 61);
		contentPane.add(lbReverse);
		btnReverse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String TXTreverse = txtReverse.getText().toString();
				char ch;
				for(int i=0; i<TXTreverse.length();i++) {
					
					ch = TXTreverse.charAt(i);
					txt= ch+txt;
					
				}
				lbReverse.setText(txt);
				if(lbReverse.equals(txt)) {
					lbReverse.setText("");
				}else {
					lbReverse.setText(txt);
				}
			}
		});
	}
	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

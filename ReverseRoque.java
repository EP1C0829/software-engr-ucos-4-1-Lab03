package Lab31;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public Reverse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REVERSE SEQUENCE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(210, 180, 140));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(76, 0, 269, 37);
		contentPane.add(lblNewLabel);
		
		JLabel Label = new JLabel("Enter a number:");
		Label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label.setBounds(22, 49, 194, 38);
		contentPane.add(Label);
		
		txtReverse = new JTextField();
		txtReverse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtReverse.setBounds(22, 79, 388, 39);
		contentPane.add(txtReverse);
		txtReverse.setColumns(10);
		
		JTextArea lbReverse = new JTextArea();
		lbReverse.setEditable(false);
		lbReverse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbReverse.setBounds(22, 129, 388, 72);
		contentPane.add(lbReverse);
		
		JButton btnReverse = new JButton("Reverse");
		btnReverse.setBackground(new Color(250, 235, 215));
		btnReverse.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReverse.setForeground(new Color(0, 0, 0));
		btnReverse.setBounds(140, 212, 137, 38);	
		contentPane.add(btnReverse);
		
	
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
		
	}}
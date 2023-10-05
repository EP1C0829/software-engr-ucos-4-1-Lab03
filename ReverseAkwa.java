package Reverse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReverseAkwa {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReverseAkwa window = new ReverseAkwa();
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
	public ReverseAkwa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(166, 53, 170, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(166, 146, 170, 52);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Reverse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				String[] numbers = input.split(" ");
				if(input.matches(".*\\d\\s\\d.*")) {
				
					try {
						for(String num: numbers) {
							Integer.parseInt(num);
						}
						StringBuilder reversed = new StringBuilder();
						for(int i = numbers.length-1; i>=0; i--) {
							reversed.append(numbers[i]).append(" ");
						}
						textArea.setText(reversed.toString().trim());
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Invalid input, only integers allowed!!", "Error",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Invalid spacing, single spacing between integers required!!", "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(247, 103, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}

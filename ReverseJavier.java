package Lab31;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Reverse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbReverse;
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
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();
			        if ((c < '0') || (c > '9') && (c != KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_SPACE)) {
			            e.consume();  // if it's not a number, ignore the event
			        }
			     }
			});

		textField.setBounds(77, 107, 279, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnReverse = new JButton("Reverse");
		btnReverse.setBounds(172, 175, 89, 23);
		contentPane.add(btnReverse);
		
		
		JLabel lblNewLabel = new JLabel("Enter Numbers:");
		lblNewLabel.setBounds(77, 82, 143, 14);
		contentPane.add(lblNewLabel);
		
		lbReverse = new JLabel("Numbers in Reverse");
		lbReverse.setBounds(77, 141, 143, 23);
		contentPane.add(lbReverse);
		
		btnReverse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String TXTreverse = textField.getText().toString();
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
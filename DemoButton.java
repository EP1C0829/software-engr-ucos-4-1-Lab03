package Demo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoButton extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public DemoButton() {
        setTitle("Reverse Sequence");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        inputField = new JTextField();
        inputField.setBounds(44, 21, 184, 26);
        contentPane.add(inputField);

        JButton reverseButton = new JButton("Reverse");
        reverseButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        reverseButton.setBounds(74, 58, 119, 31);
        reverseButton.addActionListener(new ReverseButtonListener());
        contentPane.add(reverseButton);

        setContentPane(contentPane);
        
                outputArea = new JTextArea();
                outputArea.setBounds(44, 100, 184, 26);
                contentPane.add(outputArea);
                outputArea.setEditable(false);
    }

    private class ReverseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            String[] numbers = input.split(" ");

            try {
            	for (String number: numbers) {
            		Integer.parseInt(number);
            		
            	}  
            	StringBuilder reversed = new StringBuilder();
                for (int i = numbers.length - 1; i >= 0; i--) {
                    reversed.append(numbers[i]).append(" ");
                }
                outputArea.setText(reversed.toString().trim());
            } catch(NumberFormatException ex) {
            	JOptionPane.showMessageDialog(null,"Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            

          
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DemoButton app = new DemoButton();
                app.setVisible(true);
            }
        });
    }
}
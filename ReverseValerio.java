package Trial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReverseValerio extends JFrame implements ActionListener {
    private JTextField inputTextField;
    private JTextArea outputTextArea;
    private JButton reverseButton;

    public ReverseValerio() {
        setTitle("Reverse Sequence App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel inputLabel = new JLabel("Enter sequence:");
        inputTextField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputTextField);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputTextArea = new JTextArea(10, 20);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);
        JLabel outputLabel = new JLabel("Reversed sequence:");
        outputScrollPane.setColumnHeaderView(outputLabel);

        JPanel buttonPanel = new JPanel();

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        reverseButton = new JButton("Reverse");
        inputPanel.add(reverseButton);
        reverseButton.addActionListener(this);
        getContentPane().add(outputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reverseButton) {
            String input = inputTextField.getText();

            if (!isValidInput(input)) {
                JOptionPane.showMessageDialog(this, "Invalid input! Only numeric values separated by spaces are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] numbers = input.split("\\s+");
            ArrayList<String> reversedNumbers = new ArrayList<>();

            for (int i = numbers.length - 1; i >= 0; i--) {
                reversedNumbers.add(numbers[i]);
            }

            StringBuilder reversedSequence = new StringBuilder();
            for (String number : reversedNumbers) {
                reversedSequence.append(number).append(" ");
            }

            outputTextArea.setText(reversedSequence.toString());
        }
    }

    private boolean isValidInput(String input) {
        return input.matches("^[0-9]+(\\s+[0-9]+)*$");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReverseTry();
            }
        });
    }
}
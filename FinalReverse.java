package Lab31;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Reverse extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public Reverse() {
        setTitle("Number Sequence Reversal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 465, 320);
        getContentPane().setLayout(null);

        JTextField txtNumberReversal = new JTextField();
        txtNumberReversal.setBounds(0, 0, 453, 52);
        txtNumberReversal.setForeground(new Color(204, 204, 204));
        txtNumberReversal.setBackground(new Color(178, 34, 34));
        txtNumberReversal.setFont(new Font("Tahoma", Font.BOLD, 21));
        txtNumberReversal.setHorizontalAlignment(SwingConstants.CENTER);
        txtNumberReversal.setText("NUMBER REVERSAL");
        txtNumberReversal.setEnabled(false);
        getContentPane().add(txtNumberReversal);
        txtNumberReversal.setColumns(10);

        JLabel inputLabel = new JLabel("Enter numbers:");
        inputLabel.setBounds(10, 70, 106, 20);
        inputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        inputField = new JTextField();
        inputField.setBounds(116, 68, 218, 26);
        inputField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JButton reverseButton = new JButton("Reverse");
        reverseButton.setForeground(new Color(204, 204, 204));
        reverseButton.setBackground(new Color(178, 34, 34));
        reverseButton.setBounds(339, 68, 101, 25);
        reverseButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        outputArea = new JTextArea(5, 20);
        outputArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(30, 123, 391, 147);

        getContentPane().add(inputLabel);
        getContentPane().add(inputField);
        getContentPane().add(reverseButton);
        getContentPane().add(scrollPane);

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(Reverse.this, "No input provided!", "Error", JOptionPane.ERROR_MESSAGE);
                    inputField.setText(""); // Empty the text field
                } else if (isValidInput(input)) {
                    String[] numbers = input.split(" ");
                    List<String> reversedNumbers = new ArrayList<>();
                    for (int i = numbers.length - 1; i >= 0; i--) {
                        reversedNumbers.add(numbers[i]);
                    }
                    String reversedSequence = String.join(" ", reversedNumbers);
                    outputArea.setText(reversedSequence);
                } else {
                    JOptionPane.showMessageDialog(Reverse.this, "Invalid input! Only numbers and spaces are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    inputField.setText(""); // Empty the text field
                }
            }
        });
    }

    private boolean isValidInput(String input) {
        return input.matches("[0-9\\s]+");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Reverse app = new Reverse();
            app.setVisible(true);
        });
    }
}
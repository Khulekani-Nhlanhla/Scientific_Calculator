import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorFrame extends JFrame implements ActionListener {

    private JTextField display;
    private double num1 = 0, num2 = 0,result = 0;
    private char operator;

    private DecimalFormat df = new DecimalFormat("0.########");

    //DEFINING BUTTONS
    private final String[] buttonLabels = {
        "7", "8", "9", "/", "sin",
        "4", "5", "6", "*", "cos",
        "1", "2", "3", "-", "tan",
        "0", ".", "=", "+", "√",
        "log", "x^y", "π", "C"
    };

    private final JButton[] buttons = new JButton[buttonLabels.length];

    public CalculatorFrame() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6,4, 5, 5));

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 16));
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }





}

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C":
                    display.setText("");
                    num1 = num2 = result = 0;
                    break;

                case "+":
                case "-":
                case "*":
                case "/":
                case "x^y":
                    num1 = Double.parseDouble(display.getText());
                    operator = command.charAt(0);
                    display.setText("");
                    break;

                case "=":
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/': result = num1 / num2; break;
                        case 'x': result = Math.pow(num1,num2); break;
                    }
                    display.setText(df.format(result));
                    break;

                case "sin":
                    result = Math.sin(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText(df.format(result));
                    break;

                case "cos":
                    result = Math.cos(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText(df.format(result));
                    break;

                case "tan":
                    result = Math.tan(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText(df.format(result));
                    break;

                case "√":
                    result = Math.sqrt(Double.parseDouble(display.getText()));
                    display.setText(df.format(result));
                    break;

                case "log":
                    result = Math.log10(Math.toRadians(Double.parseDouble(display.getText())));
                    display.setText(df.format(result));
                    break;

                case "π":
                    display.setText(String.valueOf(Math.PI));
                    break;

                default:
                    display.setText(display.getText() + command);
                    break;
            }
        }catch (Exception ex){
            display.setText("Error");
        }
    }



}

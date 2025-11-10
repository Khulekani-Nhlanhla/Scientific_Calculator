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




}

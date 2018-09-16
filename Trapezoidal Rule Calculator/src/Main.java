import javax.swing.JFrame;
import javax.swing.SpringLayout;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Main {
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	static JTextField textField_4;
	static JTextField textField_5;

	public static void Window(){
		JFrame m = new JFrame("JFrame");
		m.setResizable(false);
		m.setTitle("Calculus Project");
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		m.getContentPane().setLayout(springLayout);
		
		JLabel lblEnterLowerLimit = new JLabel("Enter Function:");
		springLayout.putConstraint(SpringLayout.WEST, lblEnterLowerLimit, 10, SpringLayout.WEST, m.getContentPane());
		lblEnterLowerLimit.setFont(new Font("Arial Black", Font.PLAIN, 15));
		m.getContentPane().add(lblEnterLowerLimit);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -112, SpringLayout.SOUTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, m.getContentPane());
		m.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 71, SpringLayout.WEST, m.getContentPane());
		textField_1.setColumns(10);
		m.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField_1);
		textField_2.setColumns(10);
		m.getContentPane().add(textField_2);
		
		JButton btnCalculate = new JButton("Calculate!");
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, btnCalculate);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculate, 10, SpringLayout.WEST, m.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCalculate, -18, SpringLayout.SOUTH, m.getContentPane());
		m.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent i) {
                try {
                        Calculations.c(i);
                    }catch (NumberFormatException nfe) {
                    	JOptionPane.showMessageDialog(null,"One or more input boxes is/are empty or having a wrong input.");
                    } catch (Exception ex) {
                    	Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            });
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, -56, SpringLayout.SOUTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -10, SpringLayout.EAST, m.getContentPane());
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		m.getContentPane().add(textField_3);
		
		JButton btnReset = new JButton("Reset");
		springLayout.putConstraint(SpringLayout.WEST, btnReset, 122, SpringLayout.WEST, m.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCalculate, -6, SpringLayout.WEST, btnReset);
		springLayout.putConstraint(SpringLayout.NORTH, btnReset, 0, SpringLayout.NORTH, btnCalculate);
		springLayout.putConstraint(SpringLayout.SOUTH, btnReset, 0, SpringLayout.SOUTH, btnCalculate);
		springLayout.putConstraint(SpringLayout.EAST, btnReset, -263, SpringLayout.EAST, m.getContentPane());
		m.getContentPane().add(btnReset);
		btnReset.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        textField_4.setText("");
		        textField_5.setText("");
		    }
		});
		
		JLabel lblTrapezoidalRuleCalculator = new JLabel("Trapezoidal Rule Calculator");
		springLayout.putConstraint(SpringLayout.NORTH, lblTrapezoidalRuleCalculator, 10, SpringLayout.NORTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTrapezoidalRuleCalculator, -81, SpringLayout.EAST, m.getContentPane());
		lblTrapezoidalRuleCalculator.setFont(new Font("Arial Black", Font.PLAIN, 19));
		m.getContentPane().add(lblTrapezoidalRuleCalculator);
		
		JLabel label = new JLabel("\u222B");
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 86, SpringLayout.NORTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnterLowerLimit, -7, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -86, SpringLayout.SOUTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculate, 32, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, textField, 46, SpringLayout.EAST, label);
		label.setFont(new Font("Tahoma", Font.BOLD, 70));
		m.getContentPane().add(label);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 8, SpringLayout.SOUTH, lblTrapezoidalRuleCalculator);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, -23, SpringLayout.EAST, m.getContentPane());
		textField_4.setColumns(10);
		m.getContentPane().add(textField_4);
		
		JLabel lblFinalAnswer = new JLabel("Final Answer:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblFinalAnswer, -84, SpringLayout.SOUTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, lblFinalAnswer);
		springLayout.putConstraint(SpringLayout.WEST, lblFinalAnswer, 83, SpringLayout.EAST, textField_1);
		lblFinalAnswer.setFont(new Font("Arial Black", Font.PLAIN, 15));
		m.getContentPane().add(lblFinalAnswer);
		
		JLabel lblNumberOfTrapezoids = new JLabel("Number of Trapezoids:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumberOfTrapezoids, 6, SpringLayout.SOUTH, lblTrapezoidalRuleCalculator);
		springLayout.putConstraint(SpringLayout.EAST, lblNumberOfTrapezoids, -6, SpringLayout.WEST, textField_4);
		lblNumberOfTrapezoids.setFont(new Font("Arial Black", Font.PLAIN, 15));
		m.getContentPane().add(lblNumberOfTrapezoids);
		
		JLabel lblsampleInputX = new JLabel("(Sample Input: x ^ 2 + 4)");
		springLayout.putConstraint(SpringLayout.EAST, lblsampleInputX, -10, SpringLayout.EAST, m.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_4, -24, SpringLayout.NORTH, lblsampleInputX);
		springLayout.putConstraint(SpringLayout.SOUTH, lblsampleInputX, -152, SpringLayout.SOUTH, m.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblsampleInputX);
		m.getContentPane().add(lblsampleInputX);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, textField_5, -10, SpringLayout.EAST, m.getContentPane());
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		m.getContentPane().add(textField_5);
		
		JLabel lblDecimalForm = new JLabel("Decimal Form:");
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblDecimalForm);
		springLayout.putConstraint(SpringLayout.NORTH, lblDecimalForm, 10, SpringLayout.SOUTH, lblFinalAnswer);
		springLayout.putConstraint(SpringLayout.WEST, lblDecimalForm, 10, SpringLayout.WEST, lblFinalAnswer);
		m.getContentPane().add(lblDecimalForm);
		
		JLabel lblFractionForm = new JLabel("Fraction Form:");
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblFractionForm);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, lblFractionForm);
		springLayout.putConstraint(SpringLayout.NORTH, lblFractionForm, 22, SpringLayout.SOUTH, lblDecimalForm);
		springLayout.putConstraint(SpringLayout.EAST, lblFractionForm, 0, SpringLayout.EAST, lblDecimalForm);
		m.getContentPane().add(lblFractionForm);

		m.setSize(472, 286);
		m.setLocation(300,200);
		m.setVisible(true);
	}
	public static void main(String[] args) {
		Window();
	}
}

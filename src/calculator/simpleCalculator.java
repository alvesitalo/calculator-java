package calculator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.Math;

public class simpleCalculator {
	private JFrame frame;
	private JPanel mainVisor;
	private JPanel initialKeyboard;
	private JPanel numericKeyboard;
	private JPanel operationsKeyboard;
	
	private JTextField visor;
	private String strVisor = "";
	
	private void windowGUI() {
		frame = new JFrame("Calculator");
		frame.getContentPane().setLayout(null);
		mainVisor = new JPanel();
		mainVisor.setBounds(10, 0, 280, 62);
		initialKeyboard = new JPanel();
		initialKeyboard.setBounds(10, 68, 280, 62);
		numericKeyboard = new JPanel();
		numericKeyboard.setBounds(10, 136, 181, 174);
		operationsKeyboard = new JPanel();
		operationsKeyboard.setBounds(217, 136, 73, 174);
		
		// Main Visor
		visor = new JTextField();
		visor.setFont(new Font("Dialog", Font.PLAIN, 14));
		visor.setColumns(18);
		visor.setBounds(12, 12, 256, 38);
		
		mainVisor.add(visor);
		mainVisor.setLayout(null);	
		
		frame.getContentPane().add(mainVisor);
		
		// Initial Keyboard
		JButton btnclear = new JButton("clear");
		btnclear.setActionCommand(btnclear.getText());
		btnclear.addActionListener(new btnEvent());
		initialKeyboard.add(btnclear);
		
		JButton btndel = new JButton("del");
		btndel.setActionCommand(btndel.getText());
		btndel.addActionListener(new btnEvent());
		initialKeyboard.add(btndel);
		
		JButton btnS = new JButton("x\u00b2"); // x²

		btnS.setActionCommand(btnS.getText());
		btnS.addActionListener(new btnEvent());
		initialKeyboard.add(btnS);
		
		JButton btnR = new JButton("\u221a"); // √
		btnR.setActionCommand(btnR.getText());
		btnR.addActionListener(new btnEvent());
		initialKeyboard.add(btnR);
		
		frame.getContentPane().add(initialKeyboard);
		
		// Numeric Keyboard
		JButton btn1 = new JButton("1");
		btn1.setActionCommand(btn1.getText());
		btn1.addActionListener(new btnEvent());
		numericKeyboard.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setActionCommand(btn2.getText());
		btn2.addActionListener(new btnEvent());
		numericKeyboard.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setActionCommand(btn3.getText());
		btn3.addActionListener(new btnEvent());
		numericKeyboard.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setActionCommand(btn4.getText());
		btn4.addActionListener(new btnEvent());
		numericKeyboard.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setActionCommand(btn5.getText());
		btn5.addActionListener(new btnEvent());
		numericKeyboard.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setActionCommand(btn6.getText());
		btn6.addActionListener(new btnEvent());
		numericKeyboard.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setActionCommand(btn7.getText());
		btn7.addActionListener(new btnEvent());
		numericKeyboard.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setActionCommand(btn8.getText());
		btn8.addActionListener(new btnEvent());
		numericKeyboard.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setActionCommand(btn9.getText());
		btn9.addActionListener(new btnEvent());
		numericKeyboard.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setActionCommand(btn0.getText());
		btn0.addActionListener(new btnEvent());
		numericKeyboard.add(btn0);
		
		JButton btndot = new JButton(".");
		btndot.setActionCommand(btndot.getText());
		btndot.addActionListener(new btnEvent());
		numericKeyboard.add(btndot);
		
		numericKeyboard.setLayout(new GridLayout(4, 3, 5, 5));
		frame.getContentPane().add(numericKeyboard);
		
		// Operations Keyboard
		JButton btnP = new JButton("+");
		btnP.setActionCommand(btnP.getText());
		btnP.addActionListener(new btnEvent());
		operationsKeyboard.add(btnP);
		
		JButton btnM = new JButton("-");
		btnM.setActionCommand(btnM.getText());
		btnM.addActionListener(new btnEvent());
		operationsKeyboard.add(btnM);
		
		JButton btnX = new JButton("x");
		btnX.setActionCommand(btnX.getText());
		btnX.addActionListener(new btnEvent());
		operationsKeyboard.add(btnX);
		
		JButton btnD = new JButton("\u00f7"); // ÷
		btnD.setActionCommand(btnD.getText());
		btnD.addActionListener(new btnEvent());
		operationsKeyboard.add(btnD);
		
		JButton btnE = new JButton("=");
		btnE.setActionCommand(btnE.getText());
		btnE.addActionListener(new btnEvent());
		operationsKeyboard.add(btnE);
		
		operationsKeyboard.setLayout(new GridLayout(5, 1, 5, 5));	
		frame.getContentPane().add(operationsKeyboard);
	}
	
	private String doOperations(String operations) {
		String strTerm1;
		String strTerm2;
		String strResult = "0";
		
		char operator = '0';
		float term2 = 0.0f;
		float result = 0.0f;
		
		int i = 0;
		strTerm1 = "0";
		
		while (i < operations.length()) {
			if (operations.charAt(i) != '+' && operations.charAt(i) != '-' && operations.charAt(i) != 'x' && operations.charAt(i) != '\u00f7') {
				strTerm1 += operations.charAt(i);
			}
			else {
				break;
			}
			
			i++;
		}
		
		result = Float.parseFloat(strTerm1);
		
		while (i < operations.length()) {
			operator = operations.charAt(i);
			i++;
			
			strTerm2 = "0";
			
			while (i < operations.length()) {
				if (operations.charAt(i) != '+' && operations.charAt(i) != '-' && operations.charAt(i) != 'x' && operations.charAt(i) != '\u00f7') {
					strTerm2 += operations.charAt(i);
				}
				else {
					break;
				}
				
				i++;
			}
			
			term2 = Float.parseFloat(strTerm2);
			
			switch (operator) {
				case '+':
					result += term2;
				break;
				case '-':
					result -= term2;
				break;
				case 'x':
					result *= term2;
				break;
				case '\u00f7':
					result /= term2;
				break;
			}
		}
		
		strResult = Float.toString(result);
		return strResult;
	}
	
	private String doSquareRoot(String strNumber, String action) {	
		float result = 0.0f;
		result = Float.parseFloat(strNumber);
		String strResult = "";
		
		switch (action) {
			case "x\u00b2":
				result *= result;
			break;
			case "\u221a":
				result = (float) Math.sqrt(result);
			break;
		}
		
		strResult = Float.toString(result);
		return strResult;
	}
	
	private class btnEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			
			if (action.equals("clear")) {
				strVisor = "";
			}
			else if (action.equals("del")) {
				if (strVisor != null && strVisor.length() > 0) {
					strVisor = strVisor.substring(0, strVisor.length() - 1);
			    }
			}
			else if (action.equals("x\u00b2") || action.equals("\u221a")) {
				strVisor = doSquareRoot(doOperations(strVisor), action);
			}
			else if (action.equals("=")) {
				strVisor = doOperations(strVisor);
			}
			else {
				strVisor = strVisor + action;
			}
			
			visor.setText(strVisor);
		}
	}
	
	public simpleCalculator() {
		windowGUI();
		frame.setSize(300, 350);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new simpleCalculator();
	}
}

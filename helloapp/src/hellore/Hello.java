package hellore;
//import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.*;

import javax.swing.*;

public class Hello implements ActionListener{
	float a = 0;//count
	String c = "";//show what number are showing in the calculator
	JTextArea label;// Where the number will appear
	JFrame frame;
	JPanel panel;
	JPanel p;
	
	public Hello() {
		frame = new JFrame();
		label = new JTextArea("Enter"); 
		label.setEditable(false);//prevent the user to type in the box
		label.setBounds(100, 30, 30, 300);  
		JButton[] button = new JButton [10];
		//sign button
		JButton adds = new JButton("+");
		JButton takeaway = new JButton("-");
		JButton times = new JButton("*");
		JButton divide = new JButton("/");
		JButton equals = new JButton("=");
		JButton clear = new JButton("CLEAR");
		for(int i = 0; i<10;i++) {
			button[i] = new JButton(""+i);
			button[i].addActionListener(this);
			button[i].setFont(new Font("Arial", 34, 30));
			button[i].setBackground(Color.WHITE);
			
			
		}
		adds.addActionListener(this);
		takeaway.addActionListener(this);
		times.addActionListener(this);
		divide.addActionListener(this);
		equals.addActionListener(this);
		clear.addActionListener(this);
		//colour of buttom
		adds.setBackground(Color.WHITE);
		takeaway.setBackground(Color.WHITE);
		times.setBackground(Color.WHITE);
		divide.setBackground(Color.WHITE);
		equals.setBackground(Color.WHITE);
		clear.setBackground(Color.WHITE);
		//font for button
		adds.setFont(new Font("Arial", 34, 30));
		takeaway.setFont(new Font("Arial", 34, 30));
		times.setFont(new Font("Arial", 34, 30));
		divide.setFont(new Font("Arial", 34, 30));
		equals.setFont(new Font("Arial", 34, 30));
		clear.setFont(new Font("Arial", 34, 12));
		panel = new JPanel();
		
		p = new JPanel();
		//p.setSize(200,300);
		p.setLayout(new GridLayout(0, 4));
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		p.setBorder(BorderFactory.createEmptyBorder(10,40,20,40));
		label.setFont(new Font("Arial", 3, 20));
		
		
		
		panel.add(label);
		int b1 = button.length-1;
		//int a1 = 0;
		//JButton [] s1 = {adds,takeaway,times,divide}; 
		for(int i = 0; i<14;i++) {
			if(i == 0) {
				p.add(adds);
			}
			else if(i == 4) {
				p.add(takeaway);
			}
			else if(i == 8) {
				p.add(times);
			}
			else if(i == 12) {
				p.add(divide);
			}
			else {
				p.add(button[b1]);
				b1--;
				
				//System.out.println(i);
			}
			p.add(equals);
			p.add(clear);
		}
		
		
		
		
		frame.setResizable(false);
		//frame.setExtendedState(0);
		frame.setSize(390, 595);
		frame.setMaximumSize(new Dimension(390, 595));
		frame.add(panel, BorderLayout.NORTH);
		frame.add(p, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our Gui");
		//frame.pack();
		frame.setVisible(true);
	}
	public static void main(String [] args) {
		new Hello();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String b = e.getActionCommand();
		//String nuts = "";
	try {
		if(b.equals("=")){
			String [] nums = c.split("[^0-9]");
			String [] sign = new String[nums.length-1];
			int ou = 0;
			for(int i = 0; i<c.length();i++) {
				if(c.charAt(i)=='+') {
					sign[ou] = "+";
					ou++;
				}
				else if(c.charAt(i)=='-') {
					sign[ou] = "-";
					ou++;
				}
				else if(c.charAt(i)=='*') {
					sign[ou] = "*";
					ou++;
				}
				else if(c.charAt(i)=='/') {
					sign[ou] = "/";
					ou++;
				}
				
			}
			System.out.println(c);
			System.out.println(nums.length);
			System.out.println(sign[0]);
			a= Integer.parseInt(nums[0]);
			for(int i = 0;i<sign.length;i++) {
				if(sign[i].equals("+")) {
					a+=Integer.parseInt(nums[i+1]);
					System.out.println(a+" "+nums[i]+" "+i);
				}
				else if(sign[i].equals("-")) {
					a-=Integer.parseInt(nums[i+1]);
					System.out.println(a+" "+nums[i]+" "+i);
				}
				else if(sign[i].equals("*")) {
					a*=Integer.parseInt(nums[i+1]);
					System.out.println(a+" "+nums[i]+" "+i);
				}
				else if(sign[i].equals("/")) {
					a/=Integer.parseInt(nums[i+1]);
					System.out.println(a+" "+nums[i]+" "+i);
				}
				
			}
			c = ""+a;
			label.setText(c);
		
			
		}
		
		
		else if(b.equals("CLEAR")) {
			c="";
			a=0;
			label.setText("CLEAR");
		}
		
		
		else {
			c+=b;
			label.setText(c);
			
		}
		
	   }
	catch(Exception ed) {
		label.setText("ERROR");
		a = 0;
		c = "";
	}
		
		}
       
	
}
		
		
		
				
		
		
		

		
		
		 
//}
		
		
//}



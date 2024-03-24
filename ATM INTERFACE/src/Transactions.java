import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;

	Transactions(String pin) {
		this.pin = pin;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(0, 0, 960, 1080);
		add(l2);

		l1 = new JLabel("Please Select Your Transaction");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("System", Font.BOLD, 16));

		b1 = new JButton("DEPOSIT");
		b2 = new JButton("CASH WITHDRAWL");
		b3 = new JButton("BALANCE ENQUIRY");
		b4 = new JButton("EXIT");

		setLayout(null);

		l1.setBounds(235, 400, 700, 35);
		l2.add(l1);

		b1.setBounds(170, 499, 150, 35);
		l2.add(b1);

		b2.setBounds(390, 499, 150, 35);
		l2.add(b2);

		b3.setBounds(170, 543, 150, 35);
		l2.add(b3);

		b4.setBounds(390, 543, 150, 35);
		l2.add(b4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		setSize(960, 960);
		setLocation(500, 0);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		} else if (ae.getSource() == b2) {
			setVisible(false);
			new Withdrawl(pin).setVisible(true);

		} else if (ae.getSource() == b3) {
			this.setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		} else if (ae.getSource() == b4) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Transactions("").setVisible(true);
	}
}
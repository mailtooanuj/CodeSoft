
import java.awt.*;
import java.awt.event.*;

import javax.sound.midi.Track;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends Frame implements ActionListener {

	TextField t1, t2;
	Button b1, b2, b3;
	Label l1, l2, l3, l4;
	String pin;

	Withdrawl(String pin) {
		this.pin = pin;
       

		l1 = new Label("MAXIMUM WITHDRAWAL IS RS.10,000");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("System", Font.BOLD, 20));

		l2 = new Label("PLEASE ENTER YOUR AMOUNT");
		l2.setForeground(Color.RED);
		l2.setFont(new Font("System", Font.BOLD, 16));

		t1 = new TextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 25));

		b1 = new Button("WITHDRAW");
		b2 = new Button("BACK");

		setLayout(null);

		l1.setBounds(90, 150, 400, 20);
		add(l1);

		l2.setBounds(160, 200, 400, 20);
		add(l2);

		t1.setBounds(190, 280, 330, 30);
		add(t1);

		b1.setBounds(390, 370, 150, 35);
		add(b1);

		b2.setBounds(390, 400, 150, 35);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		setBackground(Color.BLUE);
		setSize(600, 600);
		setLocation(500, 100);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {
			String amount = t1.getText();
			Date date = new Date();
			if (t1.getText().equals("")) {
                   JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
			} else {
				try {
					Conn c1 = new Conn();

					ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");

					c1.s.executeUpdate(
							"insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "')");
                   JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawed Successfully");

					setVisible(false);
					new Transactions(pin).setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("error: " + e);
				}
			}
		}

		if (ae.getSource() == b2) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Withdrawl("").setVisible(true);
	}
}
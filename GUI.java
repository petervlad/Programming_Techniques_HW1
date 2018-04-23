 
//package com.javacodegeeks.desktopjava.swing.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void create() {
		JFrame frame = new JFrame("Polynomial");

		// exitin when closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		JLabel l1 = new JLabel("Primul polinom: ");
		JTextField t1 = new JTextField(50);
		JLabel l2 = new JLabel("Al doilea polinom: ");
		JTextField t2 = new JTextField(50);
		JTextField pr = new JTextField(50);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynomial p1 = new Polynomial(Polynomial.createPolynomial(t1.getText()));
				Polynomial p2 = new Polynomial(Polynomial.createPolynomial(t2.getText()));
				pr.setText(p1.add(p2).PolynomialToString());
			}
		});

		JButton subButton = new JButton("Sub");
		subButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynomial p1 = Polynomial.createPolynomial(t1.getText());
				Polynomial p2 = Polynomial.createPolynomial(t2.getText());
				Polynomial r = p1.sub(p2);
				pr.setText(r.PolynomialToString());
			}
		});
		
		JButton mulButton = new JButton("Multiply");
		mulButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynomial p1 = Polynomial.createPolynomial(t1.getText());
				Polynomial p2 = Polynomial.createPolynomial(t2.getText());
				Polynomial r = p1.mult(p2);
				pr.setText(r.PolynomialToString());
			}
		});

		JButton derButton = new JButton("Derivation");
		derButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynomial p1 = Polynomial.createPolynomial(t1.getText());
				pr.setText(p1.diff().PolynomialToString());
			}
		});

		JButton intButton = new JButton("Integration");
		intButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Polynomial p1 = Polynomial.createPolynomial(t1.getText());
				pr.setText(p1.integration().PolynomialToString());
			}
		});

		panel.add(l1);
		panel.add(t1);
		panel.add(l2);
		panel.add(t2);
		panel.add(addButton);
		panel.add(subButton);
		panel.add(mulButton);
		panel.add(derButton);
		panel.add(intButton);
		panel.add(pr);

		frame.setContentPane(panel);
		frame.setSize(600, 300);
		frame.setVisible(true);

	}

}

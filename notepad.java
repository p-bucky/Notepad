import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class notepad extends JFrame implements ActionListener {
	JPanel p1;
	JTextArea a1;
	JButton b1;
	File txtf;

	public notepad() {
		super("Notepad");

		try {
			txtf = new File("./Textfile.txt");
			txtf.createNewFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}

		a1 = new JTextArea();
		a1.setBounds(2, 2, 490, 440);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(true);
		add(a1);

		b1 = new JButton("Update");
		b1.setBounds(409, 444, 83, 24);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(500, 500);
		setLocation(400, 200);
		setResizable(false);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String text = a1.getText();

		if (ae.getSource() == b1) {

			try {
				FileWriter mywrite = new FileWriter("./Textfile.txt");
				mywrite.write(text);
				mywrite.close();
				JOptionPane.showMessageDialog(null, "File Updated Successfully");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new notepad().setVisible(true);
	}

}

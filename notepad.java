import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class notepad extends JFrame implements ActionListener {
	JPanel p1;
	JTextArea a1;
	JButton b1, b2, b3;
	File txtf;
	JScrollPane sp;
	JFrame frame;
	JTextPane tp;

	public notepad() {
		super("Notepad");
		p1 = new JPanel();

		sp = new JScrollPane();
		sp.setBounds(2, 2, 490, 440);
		add(sp);

		a1 = new JTextArea();
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(true);
		a1.setLineWrap(true);
		sp.setViewportView(a1);

		b1 = new JButton("Save as");
		b1.setBounds(409, 444, 83, 24);
		b1.setBackground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Create new");
		b2.setBounds(305, 444, 102, 24);
		b2.setBackground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);

		b3 = new JButton("Update");
		b3.setBounds(220, 444, 83, 24);
		b3.setBackground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);

		tp = new JTextPane();
		tp.setBounds(2, 444, 83, 24);
		tp.setEditable(false);
		add(tp);

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
		String path = null;

		if (ae.getSource() == b1) {
			// FileChooser window
			frame = new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save As");
			int userSelection = fileChooser.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				path = fileToSave.getAbsolutePath();
			}
			// FileChooser window

			try {
				FileWriter mywrite = new FileWriter(path);
				mywrite.write(text);
				mywrite.close();
				tp.setText("File Updated..");
			} catch (IOException e) {

				e.printStackTrace();
			}

		} else if (ae.getSource() == b2) {
			// FileChooser window
			frame = new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Create File");
			int userSelection = fileChooser.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				path = fileToSave.getAbsolutePath();
			}
			// FileChooser window

			// File Create
			try {
				txtf = new File(path);
				txtf.createNewFile();
				tp.setText("File Created..");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
				System.exit(0);
			}
		} else if (ae.getSource() == b3) {
			// FileChooser window
			frame = new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select File To Update");
			int userSelection = fileChooser.showSaveDialog(frame);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				path = fileToSave.getAbsolutePath();
			}
			// FileChooser window

			try {
				FileWriter mywrite = new FileWriter(path);
				mywrite.write(text);
				mywrite.close();
				tp.setText("Updated..");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new notepad().setVisible(true);
	}

}

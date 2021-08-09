import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
	JTextField textField;
	JButton button;
	JTextField textField2;

	public GUI() {
		JFrame frame = new JFrame();
		TextField textField = new TextField();
		textField.setBounds(50, 50, 150, 20);
		JTextField textField2 = new JTextField();
		textField2.setBounds(50, 100, 150, 20);
		button = new JButton();
		button.setBounds(50, 200, 50, 50);
		button.addActionListener(this);
		frame.add(textField);
		frame.add(textField2);
		frame.add(button);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s1 = textField.getText();
	}

}

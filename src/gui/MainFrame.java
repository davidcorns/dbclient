package gui;

import java.awt.*;
import javax.swing.*;


public class MainFrame extends JFrame {

	public MainFrame() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(650, 500);
		super.setVisible(true);
	}
	

	public static void main(String[] args) {
		final MainFrame frame = new MainFrame();
		final DefaultListModel model = new DefaultListModel();
		model.addElement("hhello world my anme is david \n good nmorning \n ok u winaslkfjalsdkfjalksdjflkasdjflkasdjfello world my anme is david \n good nmorning \n ok u winaslkfjalsdkfjalksdjflkasdjflkasdjf");
		model.addElement("world");

		frame.getContentPane().add(BorderLayout.CENTER, new JobUnit(model));
	}
}

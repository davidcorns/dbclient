package gui;

import java.awt.*;
import javax.swing.*;

import model.JobUnitModel;

public class MainFrame extends JFrame {

	public MainFrame() {
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(650, 500);
		super.setVisible(true);
	}
	

	public static void main(String[] args) {
		final MainFrame frame = new MainFrame();
		final String[] data = { "hello world", "good mirning", "ok u win" , " good software" };
		final JobUnitModel list = new JobUnitModel();
		for(String s : data) {
			list.add(s);
		}

		frame.getContentPane().add(BorderLayout.CENTER, new JobUnit(list));
		frame.revalidate();
		frame.repaint();
	}
}

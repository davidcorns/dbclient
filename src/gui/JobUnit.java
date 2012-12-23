package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.table.TableCellRenderer;

import java.util.List;

import model.JobUnitModel;
import core.Util;

 class JobUnit extends JPanel {

	private static Object[] colName = { "SQL Expression" };

	private JScrollPane pane;
	private JTable table;
	private JTextArea result;


	public JobUnit(JobUnitModel model) {
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//table
		this.table = new JTable(model);
		
		//pane
		this.pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//result areaa
		this.result = new JTextArea();
		result.setEditable(false);
		result.setLineWrap(true);

		super.add(this.pane);
		super.add(new JSeparator(SwingConstants.HORIZONTAL));
		super.add(result);
	}



	public void setResultText(String text) {
		this.result.setText(text);
	}	




}	//class JobUnit


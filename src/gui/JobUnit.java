package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

 class JobUnit extends JPanel implements ListSelectionListener {
	private static ListCellRenderer render = new MultiLineCellRenderer();

	private JScrollPane pane;
	private JList list;


	public JobUnit(AbstractListModel listModel) {
		super.setLayout(new GridLayout(0, 1));

		this.list = new JList(listModel);
		this.pane = new JScrollPane(list);

		list.setCellRenderer(render);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);

		super.add(this.pane);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		//TODO: do nothing
	}



	private static class MultiLineCellRenderer 
		implements ListCellRenderer {

		@Override
		public Component getListCellRendererComponent(
			JList list, Object value, 
			int index, boolean isSelected, boolean cellHasFocus
		) {
			JInput res = new JInput(value.toString());
			res.setLineWrap(true);
			

			if(cellHasFocus && isSelected) {
				res.setEditable(true);	
			}

			return res;
		}

	}	//class MultiLineCellRenderer


}	//class JobUnit


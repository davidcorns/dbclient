package model;

import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

final public class JobUnitModel extends DefaultTableModel {
	StringBuilder result = new StringBuilder();

	public JobUnitModel() {
		super.addColumn("SQL Statement");
	}

	public void setResult(String res) {
		result.trimToSize();
	}

	public void add(String sql) {
		super.addRow(new Object[]{sql});
	}

}	//class JobUnitModel


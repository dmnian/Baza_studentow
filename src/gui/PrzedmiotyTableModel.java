package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ListaPrzedmiotow;
import model.Przedmiot;

public class PrzedmiotyTableModel extends AbstractTableModel {
	private List<Przedmiot> listaPrzedmiotow;
	private String[] colNames = { "nazwa", "ocena" };
	
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setData(List<Przedmiot> listaPrzedmiotow) {
		this.listaPrzedmiotow = listaPrzedmiotow;
	}

	@Override
	public int getRowCount() {
		if(listaPrzedmiotow == null) return 0;
		return listaPrzedmiotow.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Przedmiot przedmiot = listaPrzedmiotow.get(row);
		
		switch(col){
			case 0:
				return przedmiot.getNazwa();
			case 1: 
				return przedmiot.getOcena();
			default:
				return null;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		if (listaPrzedmiotow == null)
			return;

		Przedmiot przedmiot = listaPrzedmiotow.get(row);

		switch (col) {
		case 0:
			przedmiot.setNazwa((String) value);
			break;
		case 1:
			przedmiot.setOcena((String) value);
			break;
			default:
				return;
		}
	}

	
}

package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Przedmiot;

public class PrzedmiotyTablePanel extends JPanel {
	private JTable tablePrzedmioty;
	private PrzedmiotyTableModel przedmiotyTableModel;

	public PrzedmiotyTablePanel() {
		przedmiotyTableModel = new PrzedmiotyTableModel();
		tablePrzedmioty = new JTable(przedmiotyTableModel);

		setLayout(new BorderLayout());

		add(new JScrollPane(tablePrzedmioty), BorderLayout.CENTER);
	}

	public void setListaPrzedmiotow(List<Przedmiot> listaPrzedmiotow) {
		przedmiotyTableModel.setData(listaPrzedmiotow);
	}

	public void refresh() {
		przedmiotyTableModel.fireTableDataChanged();
	}
}

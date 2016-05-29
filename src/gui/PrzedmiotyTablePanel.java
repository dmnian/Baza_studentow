package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Przedmiot;

public class PrzedmiotyTablePanel extends JPanel {
	private JTable tablePrzedmioty;
	private PrzedmiotyTableModel przedmiotyTableModel;
	private JPopupMenu popup;
	private PrzedmiotyDialog zewKlasa;

	public PrzedmiotyTablePanel() {
		przedmiotyTableModel = new PrzedmiotyTableModel();
		tablePrzedmioty = new JTable(przedmiotyTableModel);
		popup = new JPopupMenu();
		
		JMenuItem removeItem = new JMenuItem("usuń przedmiot");
		
		popup.add(removeItem);
		
		tablePrzedmioty.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = tablePrzedmioty.rowAtPoint(e.getPoint());
				tablePrzedmioty.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3 ){
					popup.show(tablePrzedmioty, e.getX(), e.getY());
				}
			}
			
		});
		
		removeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tablePrzedmioty.getSelectedRow();
				
				zewKlasa.przedmiotRemove(row);
				przedmiotyTableModel.fireTableDataChanged();
			}
		});
		
		setLayout(new BorderLayout());

		add(new JScrollPane(tablePrzedmioty), BorderLayout.CENTER);
	}

	public void setListaPrzedmiotow(List<Przedmiot> listaPrzedmiotow) {
		przedmiotyTableModel.setData(listaPrzedmiotow);
	}

	public void refresh() {
		przedmiotyTableModel.fireTableDataChanged();
	}
	
	public void setZewKlasa(PrzedmiotyDialog zewKlasa){
		this.zewKlasa = zewKlasa;
	}
}

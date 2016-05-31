package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Student;


/**
 * Klasa - panel ktora zawiera tabele ze studentami.
 *
 */
public class TablePanel extends JPanel {
	private JTable table;
	private StudentTableModel tableModel;
	private JPopupMenu popup;
	private StudentTableListener studentTableListener;

	// wyszukiwanie
	private TableRowSorter<TableModel> rowSorter;
	private JTextField filtr;

	public TablePanel() {
		tableModel = new StudentTableModel();
		table = new JTable(tableModel);
		// table.setAutoCreateRowSorter(true);
		popup = new JPopupMenu();

		JMenuItem removeItem = new JMenuItem("Usuń rekord");
		JMenuItem showPrzedmioty = new JMenuItem("Pokaż przedmioty");

		popup.add(showPrzedmioty);
		popup.add(removeItem);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}

		});

		removeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int index = (Integer) table.getValueAt(row, 0);

				if (studentTableListener != null) {
					studentTableListener.rowDeleted(index);
					tableModel.fireTableDataChanged();
				}
			}
		});

		// pokaz przedmioty

		showPrzedmioty.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int index = (Integer) table.getValueAt(row, 0);
				
				if(studentTableListener != null){
					studentTableListener.showPrzedmioty(index);
				}

			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);

		// wyszukiwanie wedlug podanego kryterium:
		rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);

		filtr = new JTextField();
		JPanel panel = new JPanel(new BorderLayout());
		JButton szukaj = new JButton("wyszukaj");
		panel.add(new JLabel("Podaj kryterium wyszukiwania: "), BorderLayout.WEST);
		panel.add(filtr, BorderLayout.CENTER);
		panel.add(szukaj, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		szukaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = filtr.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
		});
	}

	public void setStudentTableListener(StudentTableListener listener) {
		this.studentTableListener = listener;
	}

	public void setData(List<Student> bazaStudentow) {
		tableModel.setData(bazaStudentow);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}

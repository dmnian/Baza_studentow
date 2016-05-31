package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;


/**
 * Klasa - model w oparciu o który funkcjonuje tabela ze studentami.
 *
 */
public class StudentTableModel extends AbstractTableModel {
	private List<Student> bazaStudentow;

	private String[] colNames = { "ID", "Imię", "Nazwisko", "Kierunek", "Rok Studiów", "Numer Albumu" };

	public void setData(List<Student> bazaStudentow) {
		this.bazaStudentow = bazaStudentow;
	}

	@Override
	public boolean isCellEditable(int row, int col) {

		switch (col) {
		case 0:
			return false;
		default:
			return true;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		if (bazaStudentow == null)
			return;

		Student student = bazaStudentow.get(row);
		
		switch (col) {
		case 1:
			student.setImie((String)(value));
			break;
		case 2:
			student.setNazwisko((String)(value));
			break;
		case 3:
			student.setKierunek((String)value);
			break;
		case 4:
			student.setRokStudiow((String)value);
			break;
		case 5:
			try {
				student.setNrAlbumu(Integer.parseInt((String)value));
			} catch (NumberFormatException e) {
				student.setNrAlbumu(-1);
			}
			break;
		default:
			return;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		if(bazaStudentow == null) return 0;
		return bazaStudentow.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Student student = bazaStudentow.get(row);

		switch (col) {
		case 0:
			return student.getId();
		case 1:
			return student.getImie();
		case 2:
			return student.getNazwisko();
		case 3:
			return student.getKierunek();
		case 4:
			return student.getRokStudiow();
		case 5:
			return student.getNrAlbumu();
		}

		return null;
	}

}

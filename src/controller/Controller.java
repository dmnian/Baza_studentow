package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JOptionPane;

import gui.FormEvent;
import model.BazaStudentow;
import model.Kierunek;
import model.Przedmiot;
import model.RokStudiow;
import model.Student;

/**
 * Klasa odpowiedzialna za przyjmowanie danych wejściowych, odświeżanie widoków oraz aktualizacje modelu. 
 */
public class Controller {
	BazaStudentow bazaStudentow = new BazaStudentow();

	public List<Student> getStudenci() {
		return bazaStudentow.getStudenci();
	}

	
	public void addStudent(FormEvent ev) { 
		String imie = ev.getImie();
		String nazwisko = ev.getNazwisko();
		int kierunekId = ev.getKierunekId();
		Kierunek kierunek = null;

		switch (kierunekId) {
		case 0:
			kierunek = Kierunek.chemia;
			break;
		case 1:
			kierunek = Kierunek.informatyka;
			break;
		case 2:
			kierunek = Kierunek.matematyka;
			break;
		}
		int nrAlbumu = ev.getNrAlbumu();
		
		try {
			if(bazaStudentow.sprawdzCzyIstnieje(nrAlbumu)){
				throw new Exception("Student o określonym numerze Albumu już istnieje w bazie!");
			}
			
			RokStudiow rokStudiow = ev.getRokStudiow();

			Student student = new Student(imie, nazwisko, kierunek, nrAlbumu, rokStudiow);
			bazaStudentow.dodajStudenta(student);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void addPrzedmiot(int index, String nazwa, String ocena) {
		Przedmiot przedmiot = new Przedmiot(nazwa, ocena);
		Student student = this.getStudenci().get(index);
		student.dodajPrzedmiot(przedmiot);
	}

	public void removePrzedmiot(int idStudenta, int przedmiot) {
		Student student = this.getStudenci().get(idStudenta);
		student.removePrzedmiot(przedmiot);
	}

	public void zapiszDoPliku(File file) throws FileNotFoundException {
		bazaStudentow.zapiszDoPliku(file);
	}

	public void wczytajPlik(File file) throws FileNotFoundException {
		bazaStudentow.wczytajPlik(file);
	}

	public void removeStudent(int index) {
		bazaStudentow.usunStudenta(index);
	}

}

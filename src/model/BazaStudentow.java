package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Klasa zawierająca Baze Studentów oraz metody do wykonywania operacji na niej.
 * 
 */
public class BazaStudentow {
	private List<Student> studenci;

	public BazaStudentow() {
		studenci = new LinkedList<>();
	}

	public void dodajStudenta(Student student) {
		studenci.add(student);
	}

	public void usunStudenta(int index) {
		studenci.removeIf(s -> s.getId() == index);
	}

	public Student wyszukajStudenta(int id) {
		for (Student student : studenci) {
			if (student.isId(id)) {
				return student;
			}
		}
		return null;
	}
	
	

	public Student wyszukajStudentaPoNrAlbumu(int NrAlbumu) {
		for (Student student : studenci) {
			if (student.getNrAlbumu() == NrAlbumu) {
				return student;
			}
		}
		return null;
	}

	public List<Student> wyszukajStudenta(Kierunek kierunek) {
		List<Student> studentSpelniajacyKryteria = new ArrayList<>();
		for (Student student : studenci) {
			if (student.getKierunek() == kierunek) {
				studentSpelniajacyKryteria.add(student);
			}
		}
		return studentSpelniajacyKryteria;
	}

	public List<Student> wyszukajStudenta(RokStudiow rokStudiow) {
		List<Student> studentSpelniajacyKryteria = new ArrayList<>();
		for (Student student : studenci) {
			if (student.getRokStudiow() == rokStudiow) {
				studentSpelniajacyKryteria.add(student);
			}
		}
		return studentSpelniajacyKryteria;
	}

	public void zapiszDoPliku(File file) throws FileNotFoundException {

		PrintWriter zapisz = new PrintWriter(file);

		for (Student student : studenci) {
			zapisz.println(student);
		}

		zapisz.close();

	}

	public void wczytajPlik(File file) throws FileNotFoundException {
		Scanner wczytaj = new Scanner(file);
		String rekord;

		studenci.clear();
		while (wczytaj.hasNextLine()) {
			rekord = wczytaj.nextLine();
			Student student = Student.toStudent(rekord);
			studenci.add(student);
		}

		wczytaj.close();
	}

	public List<Student> getStudenci() {
		return studenci;
	}

}

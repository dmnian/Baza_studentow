package test;

import java.util.List;

import model.BazaStudentow;
import model.Kierunek;
import model.RokStudiow;
import model.Student;

public class App {
	public static void main(String[] args) {
		BazaStudentow bazaStudentow = new BazaStudentow();
		
		
		Student student = new Student("Jan", "Kowalski", Kierunek.informatyka, 001, RokStudiow.I);
		Student student3 = new Student("Jan", "Kowalczak", Kierunek.informatyka, 11, RokStudiow.I);
		student.dodajPrzedmiotDoListy("Algebra Liniowa");
		student.dodajPrzedmiotDoListy("Algebra Liniowa2");
		
		
		bazaStudentow.dodajStudenta(student);
		bazaStudentow.dodajStudenta(student3);
		

		List<Student> wynik = bazaStudentow.wyszukajStudenta(Kierunek.informatyka);
		
		for (Student student2 : wynik) {
			System.out.println(student2.getNazwisko());
		}
		
		System.out.println(Kierunek.chemia);
		
		student.ustalOcene("Algebra Liniowa", "4");
//		bazaStudentow.zapiszDoPliku();
	}
}

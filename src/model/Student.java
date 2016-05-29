package model;

import java.util.List;
import java.util.StringTokenizer;

public class Student extends Osoba {
	private static int licznik = 0;
	private int id;
	private Kierunek kierunek;
	private int nrAlbumu;
	private RokStudiow rokStudiow;
	private ListaPrzedmiotow przedmioty;

	public Student(String imie, String nazwisko, Kierunek kierunek, int nrAlbumu, RokStudiow rokStudiow) {
		super(imie, nazwisko);
		this.kierunek = kierunek;
		this.nrAlbumu = nrAlbumu;
		this.rokStudiow = rokStudiow;
		this.przedmioty = new ListaPrzedmiotow();
		this.id = licznik;
		licznik++;
	}

	public Student(int id, String imie, String nazwisko, Kierunek kierunek, int nrAlbumu, RokStudiow rokStudiow) {
		super(imie, nazwisko);
		this.kierunek = kierunek;
		this.nrAlbumu = nrAlbumu;
		this.rokStudiow = rokStudiow;
		this.przedmioty = new ListaPrzedmiotow();
		this.id = id;
		licznik = id+1;
	}

	public String toString() {
		String doPliku;
		doPliku = id + ";" + this.getImie() + ";" + this.getNazwisko() + ";" + kierunek + ";" + nrAlbumu + ";"
				+ rokStudiow + ";" + przedmioty.size() + ";" + przedmioty.toString();
		return doPliku;
	}

	public static Student toStudent(String rekord) {
		StringTokenizer st = new StringTokenizer(rekord, ";");

		int id = Integer.parseInt(st.nextToken());
		String imie = st.nextToken();
		String nazwisko = st.nextToken();
		String kierunekTekst = st.nextToken();
		int nrAlbumu = Integer.parseInt(st.nextToken());
		Kierunek kierunek = null;

		switch (kierunekTekst) {
		case "informatyka":
			kierunek = Kierunek.informatyka;
			break;
		case "chemia":
			kierunek = Kierunek.chemia;
			break;
		case "matematyka":
			kierunek = Kierunek.matematyka;
			break;
		}

		String rokStudiowTekst = st.nextToken();
		RokStudiow rokStudiow = null;

		switch (rokStudiowTekst) {
		case "I":
			rokStudiow = RokStudiow.I;
			break;
		case "II":
			rokStudiow = RokStudiow.II;
			break;
		case "III":
			rokStudiow = RokStudiow.III;
			break;
		case "IV":
			rokStudiow = RokStudiow.IV;
			break;
		case "V":
			rokStudiow = RokStudiow.V;
			break;
			default:
				rokStudiow = RokStudiow.inny;
		}

		int liczbaPrzedmiotow = Integer.parseInt(st.nextToken());

		Student student = new Student(id, imie, nazwisko, kierunek, nrAlbumu, rokStudiow);

		for (int i = 0; i < liczbaPrzedmiotow; i++) {
			String nazwa = st.nextToken();
			String ocena = st.nextToken();
			
			student.dodajPrzedmiot(new Przedmiot(nazwa, ocena));
		}

		return student;
	}

	public void dodajPrzedmiot(Przedmiot przedmiot) {
		przedmioty.dodajPrzedmiot(przedmiot);
	}

	public void dodajPrzedmiotDoListy(String nazwa) {
		przedmioty.dodajPrzedmiot(nazwa);
	}

	public void ustalOcene(String nazwa, String ocena) {
		przedmioty.ustalOcene(nazwa, ocena);
	}

	public boolean isId(int id) {
		return id == this.id;
	}

	public Kierunek getKierunek() {
		return kierunek;
	}

	public void setKierunek(Kierunek kierunek) {
		this.kierunek = kierunek;
	}

	public void setKierunek(String kierunekTekst) {
		Kierunek kierunek=null;
		
		switch (kierunekTekst) {
		case "informatyka":
			kierunek = Kierunek.informatyka;
			break;
		case "chemia":
			kierunek = Kierunek.chemia;
			break;
		case "matematyka":
			kierunek = Kierunek.matematyka;
			break;
			default:
				kierunek = Kierunek.inny;
		}
		
		this.kierunek = kierunek;
	}

	public int getNrAlbumu() {
		return nrAlbumu;
	}

	public void setNrAlbumu(int nrAlbumu) {
		this.nrAlbumu = nrAlbumu;
	}

	public RokStudiow getRokStudiow() {
		return rokStudiow;
	}

	public void setRokStudiow(RokStudiow rokStudiow) {
		this.rokStudiow = rokStudiow;
	}

	public void setRokStudiow(String rokStudiowTekst) {
		RokStudiow rokStudiow;
		
		switch (rokStudiowTekst) {
		case "I":
			rokStudiow = RokStudiow.I;
			break;
		case "II":
			rokStudiow = RokStudiow.II;
			break;
		case "III":
			rokStudiow = RokStudiow.III;
			break;
		case "IV":
			rokStudiow = RokStudiow.IV;
			break;
		case "V":
			rokStudiow = RokStudiow.V;
			break;
			default:
				rokStudiow = RokStudiow.inny;
		}
		
		this.rokStudiow = rokStudiow;
	}

	public List<Przedmiot> getPrzedmioty() {
		return przedmioty.getPrzedmioty();
	}

	public void setPrzedmioty(ListaPrzedmiotow przedmioty) {
		this.przedmioty = przedmioty;
	}

	public int getId() {
		return id;
	}

}

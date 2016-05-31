package model;

/**
 * Klasa określająca przedmiot na studiach. Zawiera pole dotyczące nazwy oraz oceny.
 *
 */
public class Przedmiot {
	private String nazwa;
	private Ocena ocena;

	public Przedmiot(String nazwa, Ocena ocena) {
		this.nazwa = nazwa;
		this.ocena = ocena;
	}

	public Przedmiot(String nazwa, String ocena) {
		this.nazwa = nazwa;
		this.ocena = Przedmiot.zamienOcene(ocena);
	}

	public String toString() {
		return nazwa + ";" + ocena + ";";
	}
	
//	public Przedmiot toPrzedmiot(String przedmiot){
//		
//		return null;
//	}

	public Przedmiot(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Ocena getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = Przedmiot.zamienOcene(ocena);
	}

	public boolean isPrzedmiot(String nazwa) {
		return nazwa.equals(this.nazwa);
	}

	public static Ocena zamienOcene(String ocenaS) {

		switch (ocenaS) {
		case "2":
			return Ocena.NDST;
		case "3":
			return Ocena.DST;
		case "3.5":
			return Ocena.DSTplus;
		case "4":
			return Ocena.DB;
		case "4.5":
			return Ocena.DBplus;
		case "5":
			return Ocena.BDB;
		case "NDST":
			return Ocena.NDST;
		case "DST":
			return Ocena.DST;
		case "DSTplus":
			return Ocena.DSTplus;
		case "DB":
			return Ocena.DB;
		case "DBplus":
			return Ocena.DBplus;
		case "BDB":
			return Ocena.BDB;
			default:
				return null;
		}
//		return null;
	}
}

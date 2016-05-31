package gui;
import java.util.EventObject;

import model.Kierunek;
import model.ListaPrzedmiotow;
import model.RokStudiow;


/**
 * Klasa przenosząca dane z formularza.
 *
 */
public class FormEvent extends EventObject {

	private String imie;
	private String nazwisko;
	private int kierunekId;
	private int nrAlbumu;
	private RokStudiow rokStudiow;
	private ListaPrzedmiotow przedmioty;
	

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String imie, String nazwisko, int kierunekId, int nrAlbumu,
			RokStudiow rokStudiow) {
		super(source);
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.kierunekId = kierunekId;
		this.nrAlbumu = nrAlbumu;
		this.rokStudiow = rokStudiow;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}



	public int getKierunekId() {
		return kierunekId;
	}

	public void setKierunekId(int kierunekId) {
		this.kierunekId = kierunekId;
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

	public ListaPrzedmiotow getPrzedmioty() {
		return przedmioty;
	}

	public void setPrzedmioty(ListaPrzedmiotow przedmioty) {
		this.przedmioty = przedmioty;
	}


}

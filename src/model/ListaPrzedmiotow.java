package model;

import java.util.ArrayList;

public class ListaPrzedmiotow {
	private ArrayList<Przedmiot> przedmioty;
	
	public ListaPrzedmiotow(){
		przedmioty = new ArrayList<>();
	}
	
	public String toString(){
		String tekst = "";
		for (Przedmiot przedmiot : przedmioty) {
			tekst += przedmiot.toString();
		}
		
		return tekst;
	}
	
	public void dodajPrzedmiot(Przedmiot przedmiot){
		przedmioty.add(przedmiot);
	}

	public void dodajPrzedmiot(String nazwa, Ocena ocena){
		Przedmiot przedmiot = new Przedmiot(nazwa, ocena);
		przedmioty.add(przedmiot);
	}

	public void dodajPrzedmiot(String nazwa){
		Przedmiot przedmiot = new Przedmiot(nazwa);
		przedmioty.add(przedmiot);
	}
	
	public void ustalOcene(String nazwa, String ocena){
		for (Przedmiot przedmiot : przedmioty) {
			if(przedmiot.isPrzedmiot(nazwa)){
				przedmiot.setOcena(ocena);
			}
		}
	}
	
	public int size(){
		return przedmioty.size();
	}
}

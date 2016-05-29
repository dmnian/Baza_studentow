package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListaPrzedmiotow {
	private List<Przedmiot> przedmioty;
	
	public ListaPrzedmiotow(){
		przedmioty = new LinkedList<>();
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
	
	public void removePrzedmiot(int index){
		przedmioty.remove(index);
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
	
	public List<Przedmiot> getPrzedmioty() {
		return Collections.unmodifiableList(przedmioty);
	}
}

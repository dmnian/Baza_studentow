package gui;

import java.util.EventListener;


/**
 * Interfejs - nasłuchuje zdarzeń ze strony akcji wykonanych na rzecz przedmiotów (dodanie, usunięcie, modyfikacja).
 *
 */
public interface PrzedmiotListener extends EventListener{
	public void przedmiotEventOccured(int index, String nazwa, String ocena);
	public void przedmiotRemove(int idStudenta, int przedmiot);
}

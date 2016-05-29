package gui;

import java.util.EventListener;

public interface PrzedmiotListener extends EventListener{
	public void przedmiotEventOccured(int index, String nazwa, String ocena);
}

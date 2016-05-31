package gui;
import java.util.EventListener;


/**
 * Interfejs odpowiedzialny za nasłuchiwanie zdarzeń ze strony formularza.
 */
public interface FormListener extends EventListener{
	public void formEventOccured(FormEvent e);
}

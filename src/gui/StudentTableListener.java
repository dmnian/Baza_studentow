package gui;


/**
 * Interfejs nasłuchujący zmian w tabeli studentów. 
 *
 */
public interface StudentTableListener {
	public void rowDeleted(int row);

	public void showPrzedmioty(int row);
}

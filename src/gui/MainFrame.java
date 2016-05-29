package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;
import model.Przedmiot;

public class MainFrame extends JFrame {

	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	private PrzedmiotyDialog przedmiotyDialog;

	public MainFrame() {
		super("Baza Danych Studentów");

		setLayout(new BorderLayout());

		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		przedmiotyDialog = new PrzedmiotyDialog(this);
		
		przedmiotyDialog.setPrzedmiotListener(new PrzedmiotListener() {
			
			@Override
			public void przedmiotEventOccured(int index, String nazwa, String ocena) {
				controller.addPrzedmiot(index, nazwa, ocena);
				przedmiotyDialog.refresh();
			}

			@Override
			public void przedmiotRemove(int idStudenta, int przedmiot) {
				controller.removePrzedmiot(idStudenta, przedmiot);
			}
			
			
		});
		
		controller = new Controller();
		
		tablePanel.setData(controller.getStudenci());
		
		
		tablePanel.setStudentTableListener(new StudentTableListener() {
			
			@Override
			public void rowDeleted(int row) {
				controller.removeStudent(row);
				System.out.println(row);
			}

			@Override
			public void showPrzedmioty(int index) {
				List<Przedmiot> listaPrzedmiotow = controller.getStudenci().get(index).getPrzedmioty(); 
				przedmiotyDialog.setListaPrzedmiotow(listaPrzedmiotow);
				przedmiotyDialog.setIdStudenta(index);
//				controller ?
				przedmiotyDialog.refresh();
				przedmiotyDialog.setVisible(true);
			}
			
			
		});
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new StudentFileFilter());

		setJMenuBar(createMenuBar());

		formPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent ev) {
				controller.addStudent(ev);
				tablePanel.refresh();
			}

		});

		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 500));
		setSize(600, 500);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("Plik");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Wyjdź");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Okno");
		JMenu showMenu = new JMenu("Wyświetl");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Formularz: Student");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				formPanel.setVisible(menuItem.isSelected());
			}
		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.wczytajPlik(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Błąd, nie udało sie wczytać pliku.", "Błąd!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});

		exportDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.zapiszDoPliku(fileChooser.getSelectedFile());
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Błąd, nie udało sie zaisac pliku.", "Błąd!", JOptionPane.ERROR_MESSAGE);
					}
//					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Czy napewno chcesz wyjść z aplikacji?", "Potwierdź wyjście", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		return menuBar;
	}
}

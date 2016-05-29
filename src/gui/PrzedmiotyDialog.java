package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Przedmiot;

public class PrzedmiotyDialog extends JDialog {

	private PrzedmiotyTablePanel przedmiotyTablePanel;
	private JPanel dodajPrzedmiotPanel;
	private JButton dodajPrzedmiotButton;
	private JTextField nazwaPrzedmiot;
	private JTextField ocenaPrzedmiot;
	private int idStudenta;
	private PrzedmiotListener przedmiotListener;

	public PrzedmiotyDialog(JFrame parent){
		super(parent, "Przedmioty", false);
		przedmiotyTablePanel = new PrzedmiotyTablePanel();
		dodajPrzedmiotPanel = new JPanel();
		
		dodajPrzedmiotButton = new JButton("dodaj przedmiot");
		nazwaPrzedmiot = new JTextField(10);
		ocenaPrzedmiot = new JTextField(10);
		
		dodajPrzedmiotPanel.setLayout(new FlowLayout());
		dodajPrzedmiotPanel.add(new JLabel("nazwa: "));
		dodajPrzedmiotPanel.add(nazwaPrzedmiot);
		dodajPrzedmiotPanel.add(new JLabel("ocena: "));
		dodajPrzedmiotPanel.add(ocenaPrzedmiot);
		dodajPrzedmiotPanel.add(dodajPrzedmiotButton);
		
		
		setSize(600, 400);
		
		setLayout(new BorderLayout());
		
		dodajPrzedmiotButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nazwa = nazwaPrzedmiot.getText();
				String ocena = ocenaPrzedmiot.getText();
				
				if(przedmiotListener != null){
					przedmiotListener.przedmiotEventOccured(idStudenta, nazwa, ocena);
				}
			}
		});
		
		
		add(przedmiotyTablePanel, BorderLayout.CENTER);
		add(dodajPrzedmiotPanel, BorderLayout.SOUTH);
	}

	public void setListaPrzedmiotow(List<Przedmiot> listaPrzedmiotow) {
		przedmiotyTablePanel.setListaPrzedmiotow(listaPrzedmiotow);
	}
	
	public void setIdStudenta(int idStudenta){
		this.idStudenta = idStudenta;
	}
	
	public int getIdStudenta(){
		return idStudenta;
	}
	
	public void setPrzedmiotListener(PrzedmiotListener przedmiotListener){
		this.przedmiotListener = przedmiotListener;
	}
	
	public void refresh(){
		przedmiotyTablePanel.refresh();
	}
}

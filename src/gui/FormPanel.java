package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.RokStudiow;

public class FormPanel extends JPanel {

	private JLabel imieLabel;
	private JLabel nazwiskoLabel;
	private JTextField imieField;
	private JTextField nazwiskoField;
	private JButton okBtn;
	private FormListener listener;
	private JList kierunekList;
	private JComboBox rokCombo;
	private JTextField nrAlbumuField;
	private JLabel nrAlbumuLabel;

	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		imieLabel = new JLabel("Imie: ");
		nazwiskoLabel = new JLabel("Nazwisko: ");
		imieField = new JTextField(10);
		nazwiskoField = new JTextField(10);
		kierunekList = new JList();

		// tu skonczylem
		rokCombo = new JComboBox();
		nrAlbumuField = new JTextField(10);
		nrAlbumuLabel = new JLabel("nr albumu: ");
		okBtn = new JButton("OK");

		// Set up mnemonics
		okBtn.setMnemonic(KeyEvent.VK_O);

		imieLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		imieLabel.setLabelFor(imieField);

		// Set up list
		DefaultListModel kierunekModel = new DefaultListModel();
		kierunekModel.addElement(new KierunekCategory(0, "chemia"));
		kierunekModel.addElement(new KierunekCategory(1, "informatyka"));
		kierunekModel.addElement(new KierunekCategory(2, "matematyka"));

		kierunekList.setModel(kierunekModel);

		kierunekList.setPreferredSize(new Dimension(114, 72));
		kierunekList.setBorder(BorderFactory.createEtchedBorder());
		kierunekList.setSelectedIndex(1);

		// Set up combo box
		DefaultComboBoxModel rokModel = new DefaultComboBoxModel();
		rokModel.addElement(RokStudiow.I);
		rokModel.addElement(RokStudiow.II);
		rokModel.addElement(RokStudiow.III);
		rokModel.addElement(RokStudiow.IV);
		rokModel.addElement(RokStudiow.V);

		rokCombo.setModel(rokModel);

		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String imie = imieField.getText();
				String nazwisko = nazwiskoField.getText();
				KierunekCategory kierunekCat = (KierunekCategory) kierunekList.getSelectedValue();
				RokStudiow rokCat = (RokStudiow) rokCombo.getSelectedItem();

				int nrAlbumu;
				try {
					nrAlbumu = Integer.parseInt(nrAlbumuField.getText());

					FormEvent ev = new FormEvent(this, imie, nazwisko, kierunekCat.getId(), nrAlbumu, rokCat);

					if (listener != null) {
						listener.formEventOccured(ev);
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Wprowadziłeś niepoprawne dane, lub pozostawiłeś pole z nr albumu puste!");
				}

			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Dodaj studenta");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();

	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		//////////////// First row////////////////
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(imieLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(imieField, gc);

		//////////////// Second row////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nazwiskoLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nazwiskoField, gc);

		//////////////// Next row////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Kierunek: "), gc);

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(kierunekList, gc);

		//////////////// Next row////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Rok studiów: "), gc);

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(rokCombo, gc);

		//////////////// Next row////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nrAlbumuLabel, gc);

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nrAlbumuField, gc);

		//////////////// Next row////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1.0;

		gc.gridx = 1;

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
	}

	public void setFormListener(FormListener listener) {
		this.listener = listener;
	}
}

class KierunekCategory {

	private int id;
	private String text;

	public KierunekCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String toString() {
		return text;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

}

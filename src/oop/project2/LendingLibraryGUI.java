package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LendingLibraryGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String[] authors;
	/**
	 * Create the frame.
	 */
	public LendingLibraryGUI() {
		authors = new String[]{"blah1", "blah2"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Scanned Event", null/*insert icon here*/, panel, null/*insert tooltip here*/);
		panel.setPreferredSize(new Dimension(300, 415));
		panel.setLayout(null);
		
		JTextPane txtpnNoItemsHave = new JTextPane();
		txtpnNoItemsHave.setText("No items have been checked yet!");
		txtpnNoItemsHave.setEditable(false);
		txtpnNoItemsHave.setSize(400, 200);
		panel.add(txtpnNoItemsHave);
		txtpnNoItemsHave.setPreferredSize(new Dimension(400, 200));
		txtpnNoItemsHave.setLocation(32, 33);
		
		JLabel lblNewLabel = new JLabel("Checked Item Description:");
		lblNewLabel.setBounds(32, 4, 158, 16);
		panel.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(32, 290, 400, 68);
		panel.add(textPane);
		
		JLabel lblEventStatus = new JLabel("Event Status:");
		lblEventStatus.setBounds(32, 261, 87, 16);
		panel.add(lblEventStatus);
		
		JTextPane inventoryTextPane = new JTextPane();
		inventoryTextPane.setContentType("text/html");
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Inventory", null, panel_1, null);
		panel_1.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane(inventoryTextPane);
		scrollPane_1.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane_1.setBounds(12, 81, 443, 316);
		panel_1.add(scrollPane_1);
		
		for(String author: authors){
			inventoryTextPane.add(new JLabel(author));
		}
		System.out.println(inventoryTextPane.getComponent(0)); //<-- use getComponent to add mouse listeners
		System.out.println(inventoryTextPane.getComponentCount());
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Books");
		comboBox.addItem("Movies");
		comboBox.addItem("Periodicals");
		comboBox.addItem("Audio");
		comboBox.addItem("Reference Materials");
		comboBox.setBounds(54, 14, 99, 22);
		panel_1.add(comboBox);
		
		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setBounds(12, 16, 56, 16);
		panel_1.add(lblFilter);
		
		textField = new JTextField();
		textField.setBounds(339, 14, 116, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(287, 17, 56, 16);
		panel_1.add(lblSearch);
		
		JLabel lblItemsAvailable = new JLabel("Items Available:");
		lblItemsAvailable.setBounds(12, 52, 99, 16);
		panel_1.add(lblItemsAvailable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Item Details", null, panel_2, null);
		panel_2.setPreferredSize(new Dimension(300, 415));
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 57, 216, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 60, 56, 16);
		panel_2.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(12, 115, 56, 16);
		panel_2.add(lblAuthor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 112, 216, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 172, 75, 16);
		panel_2.add(lblDescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(116, 169, 231, 86);
		panel_2.add(textArea_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Map", null, panel_3, null);
		panel_3.setPreferredSize(new Dimension(300, 415));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Policies", null, panel_4, null);
		panel_4.setPreferredSize(new Dimension(300, 415));	
	}
}

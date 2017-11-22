package gui;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class LendingLibraryGUI extends JFrame {

	/**
	 * Everyone, if you have any comments on UI design or where 
	 * things(listeners) should be included. Please text me
	 * or leave comments where things should be. Thanks
	 * 
	 * Jon
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String[] authors;
	/**
	 * Create the frame.
	 */
	public LendingLibraryGUI() {
		
		authors = new String[]{"1","2","3","4","5","6","7","8","9","10"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.requestFocus();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Scanned Event", null/*insert icon here*/, panel, null/*insert tooltip here*/);
		panel.setLayout(null);
		
		JTextPane txtpnNoItemsHave = new JTextPane();
		txtpnNoItemsHave.setText("No items have been checked yet!");
		txtpnNoItemsHave.setEditable(false);
		txtpnNoItemsHave.setSize(400, 200);
		panel.add(txtpnNoItemsHave);
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
		
		JLabel lblClickHereTo_1 = new JLabel("CLICK HERE TO EXIT SESSION");
		lblClickHereTo_1.addMouseListener(new MouseAdapter() { //All this does is reset to the default GUI
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblClickHereTo_1.setBounds(32, 382, 184, 16);
		panel.add(lblClickHereTo_1);
		
		JPanel inventoryTextPane = new JPanel(); //<-- change this to a JPanel instead to use BoxLayout
		inventoryTextPane.setLayout(new BoxLayout(inventoryTextPane, BoxLayout.PAGE_AXIS)); //this stacks the components
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Inventory", null, panel_1, null);
		panel_1.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane(inventoryTextPane);
		scrollPane_1.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane_1.setBounds(12, 81, 443, 316);
		panel_1.add(scrollPane_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Everything");
		comboBox.addItem("Books");
		comboBox.addItem("Movies");
		comboBox.addItem("Periodicals");
		comboBox.addItem("Audio");
		comboBox.addItem("Reference Materials");
		comboBox.setBounds(54, 14, 99, 22);
		panel_1.add(comboBox);
		
		/*
		 * This item listener should filter the components based on their category. Components(JLabels) should
		 * be created based on the items. The strategy might be to remove the JLabels from the panel, then readd the
		 * filtered JLabels based on the item's category. 
		 */
		comboBox.addItemListener(new ItemListener (){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == 1){ //this if statement is to get the selected item
					System.out.println(comboBox.getSelectedItem()); //<-- prints the selected item
				}
			}
		});
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
		//This loop creates and adds the labels to the inventory window pane
		//we will add all of the item labels in this loop
		for(String author: authors){
			JLabel tempLabel = new JLabel(author + "        ");
			tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
			inventoryTextPane.add(tempLabel);
		}
		//This loop adds a mouse listener to every label contained in the panel
		//Strategy: use switch case to fill in, or, send label text to item DB and retrieve its details
		//to fill in the item details tab
		for(Component lblInStock: inventoryTextPane.getComponents()){
			lblInStock.addMouseListener(new MouseAdapter() {
				@Override
				//This mousePressed event should display the item details of the label that was clicked
				public void mousePressed(MouseEvent arg0) {
					System.out.println(((JLabel)lblInStock).getText()); // <--can use this for a switch case to fill in details
					tabbedPane.setSelectedIndex(2);
				}
			});
		}
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Item Details", null, panel_2, null);
	//	panel_2.setPreferredSize(new Dimension(300, 415));
		panel_2.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 60, 56, 16);
		panel_2.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(12, 115, 56, 16);
		panel_2.add(lblAuthor);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 172, 75, 16);
		panel_2.add(lblDescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(116, 169, 231, 86);
		panel_2.add(textArea_1);
		
		JLabel lblInStock = new JLabel("In Stock:");
		lblInStock.setBounds(12, 295, 56, 16);
		panel_2.add(lblInStock);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(116, 57, 231, 22);
		panel_2.add(textArea);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(116, 112, 231, 22);
		panel_2.add(textArea_2);
		
		JTextArea stockTextArea = new JTextArea();
		stockTextArea.setEditable(false);
		stockTextArea.setBounds(116, 292, 56, 22);
		panel_2.add(stockTextArea);
		
		JLabel lblClickHereTo = new JLabel("CLICK HERE TO VIEW MAP LOCATION");
		//This listener will switch the tab to the map, and send the item name or id to the DB
		//once it retrieves its x,y coordinates, puts the gif on the map where that location is
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(3); //switches the tab to map
			}
		});
		lblClickHereTo.setBounds(12, 377, 221, 16);
		panel_2.add(lblClickHereTo);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Map", null, panel_3, null);
		try {
			DisplayImage(panel_3, "mapa.png");
			panel_3.add(new JLabel("                                                "));
			DisplayImage(panel_3, "mapb.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getCause());
		}
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Policies", null, panel_4, null);
		panel_4.setPreferredSize(new Dimension(300, 415));	
		
		contentPane.addKeyListener(new KeyAdapter(){ //trying to use this for scanner input
			@Override
			public void keyPressed(KeyEvent e){
				System.out.println("here");
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					tabbedPane.setSelectedIndex(0); //switches the tab to scanned event
					System.out.println("here");
				}
			}
		});
		
	}
	private void DisplayImage(JPanel jp, String url) throws IOException, Exception {
        try {
        	System.out.println(this.getClass().getResource(url));
            Image image=ImageIO.read(this.getClass().getResource(url));
            ImageIcon imageicon=new ImageIcon(image);
            JLabel label=new JLabel(imageicon);
            jp.add(label);
        } catch (IOException ex) {
            throw new IOException();
        } catch (Exception ex) {
            throw new Exception();
        }
    }
}

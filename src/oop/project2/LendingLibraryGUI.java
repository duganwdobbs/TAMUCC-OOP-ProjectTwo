package oop.project2;

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


public class LendingLibraryGUI extends JFrame{

	/**
	 * Everyone, if you have any comments on UI design or where 
	 * things(listeners) should be included. Please text me
	 * or leave comments where things should be. Thanks
	 * 
	 * Jon
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchBox;
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
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setResizable(false);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("Scanned Event", null/*insert icon here*/, tab1, null/*insert tooltip here*/);
		tab1.setLayout(null);
		
		JTextPane itemDescriptBox = new JTextPane();
		itemDescriptBox.setText("No items have been checked yet!");
		itemDescriptBox.setEditable(false);
		itemDescriptBox.setSize(400, 200);
		tab1.add(itemDescriptBox);
		itemDescriptBox.setLocation(32, 33);
		
		JLabel checkedItemlbl = new JLabel("Checked Item Description:");
		checkedItemlbl.setBounds(32, 4, 158, 16);
		tab1.add(checkedItemlbl);
		
		JTextPane eventStatusBox = new JTextPane();
		eventStatusBox.setEditable(false);
		eventStatusBox.setBounds(32, 290, 400, 68);
		tab1.add(eventStatusBox);
		
		JLabel lblEventStatus = new JLabel("Event Status:");
		lblEventStatus.setBounds(32, 261, 87, 16);
		tab1.add(lblEventStatus);
		
		JLabel exitSessionLabel = new JLabel("CLICK HERE TO EXIT SESSION");
		exitSessionLabel.addMouseListener(new MouseAdapter() { //All this does is reset to the default GUI
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		exitSessionLabel.setBounds(32, 382, 184, 16);
		tab1.add(exitSessionLabel);
		
		JPanel inventoryTextPane = new JPanel(); //<-- change this to a JPanel instead to use BoxLayout
		inventoryTextPane.setLayout(new BoxLayout(inventoryTextPane, BoxLayout.PAGE_AXIS)); //this stacks the components
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("Inventory", null, tab2, null);
		tab2.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane(inventoryTextPane);
		scrollPane_1.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane_1.setBounds(12, 81, 443, 316);
		tab2.add(scrollPane_1);
		
		JComboBox<String> filterBox = new JComboBox<String>();
		filterBox.addItem("Everything");
		filterBox.addItem("Books");
		filterBox.addItem("Movies");
		filterBox.addItem("Periodicals");
		filterBox.addItem("Audio");
		filterBox.addItem("Reference Materials");
		filterBox.setBounds(54, 14, 99, 22);
		tab2.add(filterBox);
		
		/*
		 * This item listener should filter the components based on their category. Components(JLabels) should
		 * be created based on the items. The strategy might be to remove the JLabels from the panel, then readd the
		 * filtered JLabels based on the item's category. 
		 */
		filterBox.addItemListener(new ItemListener (){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == 1){ //this if statement is to get the selected item
					System.out.println(filterBox.getSelectedItem()); //<-- prints the selected item to prove it works
				}
			}
		});
		JLabel lblFilter = new JLabel("Filter:");
		lblFilter.setBounds(12, 16, 56, 16);
		tab2.add(lblFilter);
		
		searchBox = new JTextField();
		//get the text as it is being typed so we can remove labels that do not contain the substring
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				System.out.println(searchBox.getText());
			}
		});
		searchBox.setBounds(339, 14, 116, 22);
		tab2.add(searchBox);
		searchBox.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(287, 17, 56, 16);
		tab2.add(lblSearch);
		
		JLabel lblItemsAvailable = new JLabel("Items Available:");
		lblItemsAvailable.setBounds(12, 52, 99, 16);
		tab2.add(lblItemsAvailable);
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
		
		JPanel tab3 = new JPanel();
		tabbedPane.addTab("Item Details", null, tab3, null);
		tab3.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 60, 56, 16);
		tab3.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(12, 115, 56, 16);
		tab3.add(lblAuthor);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 172, 75, 16);
		tab3.add(lblDescription);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(116, 169, 231, 86);
		tab3.add(textArea_1);
		
		JLabel lblInStock = new JLabel("In Stock:");
		lblInStock.setBounds(12, 295, 56, 16);
		tab3.add(lblInStock);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(116, 57, 231, 22);
		tab3.add(textArea);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(116, 112, 231, 22);
		tab3.add(textArea_2);
		
		JTextArea stockTextArea = new JTextArea();
		stockTextArea.setEditable(false);
		stockTextArea.setBounds(116, 292, 56, 22);
		tab3.add(stockTextArea);
		
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
		tab3.add(lblClickHereTo);
		
		JPanel tab4 = new JPanel();
		tabbedPane.addTab("Map", null, tab4, null);
		try {
			DisplayImage(tab4, "mapa.png");
			tab4.add(new JLabel("                                                "));
			DisplayImage(tab4, "mapb.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getCause());
		}
		JPanel tab5 = new JPanel();
		tabbedPane.addTab("Policies", null, tab5, null);	
		
		contentPane.addKeyListener(new KeyAdapter(){ //trying to use this for scanner input
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					tabbedPane.setSelectedIndex(0); //switches the tab to scanned event
				}
			}
		});
//		this.autoResizeComponents(panel);
//		this.autoResizeComponents(panel_1);
//		this.autoResizeComponents(panel_2);
//		this.autoResizeComponents(panel_3);
//		this.autoResizeComponents(panel_4);
	}
	private void autoResizeComponents(JPanel panel) { //need to figure out a clever way to do this
		for(Component components: panel.getComponents()){
			if(!(components instanceof JLabel) && !(components instanceof JComboBox)){
				components.setSize(components.getWidth() * 2, components.getHeight() * 2);
			}
		}
		
	}
	private void DisplayImage(JPanel jp, String url) throws IOException, Exception {
        try {
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

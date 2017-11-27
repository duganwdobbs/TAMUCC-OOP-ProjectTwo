package oop.project2;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.project2.DataObjects.Item;


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
	private JTextPane itemDescriptBox;
	private JTextPane eventStatusBox;
	private JLabel checkedItemLbl;
	private JComboBox<String> filterBox;
	private JLabel lblFilter;
	private JLabel lblSearch;
	private JLabel lblEventStatus;
	private JPanel inventoryTextPane;
	private JTabbedPane tabbedPane;
	private JLabel lblTitle;
	private JLabel lblItemsAvailable;
	private JLabel lblAuthor;
	private JLabel lblDescription;
	private JTextArea titleText;
    private JTextArea authorText;
    private JTextArea descriptionText;
    private JTextArea stockTextArea;
    private JLabel lblInStock;
    private JPanel tab1;
    private JPanel tab2;
    private JPanel tab3;
    private JPanel tab4;
    private JPanel tab5;
    private JScrollPane scrollPane_1;
    private JLabel mapA;
    private JLabel mapB;
        //Associative Objects
        private DBThread DBs; 
        private InputBuilder Inp;
        private EventBuilder Evt;
	/**
	 * Create the frame.
	 */
	public LendingLibraryGUI(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
            
        this.DBs = DBs;
        this.Inp = Inp;
        this.Evt = Evt;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setResizable(false);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		tab1 = new JPanel();
		tabbedPane.addTab("Scanned Event", null/*insert icon here*/, tab1, null/*insert tooltip here*/);
		tab1.setLayout(null);
	
		itemDescriptBox = new JTextPane();
		itemDescriptBox.setText("No items have been checked yet!");
		itemDescriptBox.setEditable(false);
		itemDescriptBox.setSize(400, 200);
		tab1.add(itemDescriptBox);
		itemDescriptBox.setLocation(32, 33);
		
		checkedItemLbl = new JLabel("Checked Item Description:");
		checkedItemLbl.setBounds(32, 4, 158, 16);
		tab1.add(checkedItemLbl);
		
		eventStatusBox = new JTextPane();
		eventStatusBox.setEditable(false);
		eventStatusBox.setBounds(32, 290, 400, 68);
		tab1.add(eventStatusBox);
		
		lblEventStatus = new JLabel("Event Status:");
		lblEventStatus.setBounds(32, 261, 87, 16);
		tab1.add(lblEventStatus);
		tab1.setFocusable(true);
		JLabel exitSessionLabel = new JLabel("CLICK HERE TO EXIT SESSION");
		exitSessionLabel.addMouseListener(new MouseAdapter() { //All this does is reset to the default GUI
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		exitSessionLabel.setBounds(32, 382, 184, 16);
		tab1.add(exitSessionLabel);
		
		inventoryTextPane = new JPanel(); //<-- change this to a JPanel instead to use BoxLayout
		inventoryTextPane.setLayout(new BoxLayout(inventoryTextPane, BoxLayout.PAGE_AXIS)); //this stacks the components
		tab2 = new JPanel();
		tabbedPane.addTab("Inventory", null, tab2, null);
		tab2.setLayout(null);
		scrollPane_1 = new JScrollPane(inventoryTextPane);
		scrollPane_1.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scrollPane_1.setBounds(12, 81, 443, 316);
		tab2.add(scrollPane_1);
		
		filterBox = new JComboBox<String>();
		filterBox.addItem("Everything");
		filterBox.addItem("Book");
		filterBox.addItem("Movie");
		filterBox.addItem("Periodical");
		filterBox.addItem("Audio");
		filterBox.addItem("Reference Material");
		filterBox.setBounds(54, 14, 99, 22);
		tab2.add(filterBox);
		
		lblFilter = new JLabel("Filter:");
		lblFilter.setBounds(12, 16, 56, 16);
		tab2.add(lblFilter);
		
		this.initializeInventory();
		searchBox = new JTextField();
		//get the text as it is being typed so we can remove labels that do not contain the substring
		searchBox.setBounds(339, 14, 116, 22);
		tab2.add(searchBox);
		searchBox.setColumns(10);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setBounds(287, 17, 56, 16);
		tab2.add(lblSearch);
		
		lblItemsAvailable = new JLabel("Items Available:");
		lblItemsAvailable.setBounds(12, 52, 99, 16);
		tab2.add(lblItemsAvailable);

		//This loop adds a mouse listener to every label contained in the panel
		//Strategy: use switch case to fill in, or, send label text to item DB and retrieve its details
		//to fill in the item details tab
		
		tab3 = new JPanel();
		tabbedPane.addTab("Item Details", null, tab3, null);
		tab3.setLayout(null);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 172, 75, 16);
		tab3.add(lblDescription);
		
		descriptionText = new JTextArea();
		descriptionText.setEditable(false);
		descriptionText.setBounds(116, 169, 350, 175);
		descriptionText.setLineWrap(true);
		tab3.add(descriptionText);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 60, 56, 16);
		tab3.add(lblTitle);
		
		titleText = new JTextArea();
		titleText.setEditable(false);
		titleText.setBounds(116, 57, 231, 22);
		tab3.add(titleText);
		
		lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(12, 115, 56, 16);
		tab3.add(lblAuthor);
		
		authorText = new JTextArea();
		authorText.setEditable(false);
		authorText.setBounds(116, 112, 231, 22);
		tab3.add(authorText);
		
		lblInStock = new JLabel("In Stock:");
		lblInStock.setBounds(12, 375, 56, 16);
		tab3.add(lblInStock);
		
		stockTextArea = new JTextArea();
		stockTextArea.setEditable(false);
		stockTextArea.setBounds(116, 372, 56, 22);
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
		lblClickHereTo.setBounds(12, 425, 221, 16);
		tab3.add(lblClickHereTo);
		
		tab4 = new JPanel();
		tabbedPane.addTab("Map", null, tab4, null);
		JPanel mapPanel = new JPanel();
		tab4.add(mapPanel);
		try {
			mapA = DisplayImage(mapPanel, "mapa.png");
			tab4.add(new JLabel("                                                                     "));
			mapB = DisplayImage(mapPanel, "mapb.png");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getCause());
		}
		mapA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(3); //switches the tab to map
				
				System.out.println(mapA.getX() + " , " + mapA.getY());
				System.out.println(mapB.getX() + " , " + mapB.getY());
			}
		});
		tab5 = new JPanel();
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
		/*
		 * This item listener should filter the components based on their category. Components(JLabels) should
		 * be created based on the items. The strategy might be to remove the JLabels from the panel, then readd the
		 * filtered JLabels based on the item's category. 
		 */
		filterBox.addItemListener(new ItemListener (){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == 1){ //this if statement is to get the selected item
					for(Component component: inventoryTextPane.getComponents()){
						inventoryTextPane.remove(component);
					}
					if(filterBox.getSelectedItem().toString().equals("Everything") && searchBox.getText().equals("")){
						initializeInventory();
					}
					else{
						for(Item item: search(filterBox.getSelectedItem().toString() + "," + searchBox.getText())){
							JLabel tempLabel = new JLabel(item.getName() + "        ");
							tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
							inventoryTextPane.add(tempLabel);
							addLabelListener(tempLabel, item);
						}
					}
					repaint();
				}
			}
		});
		
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				for(Component component: inventoryTextPane.getComponents()){
					inventoryTextPane.remove(component);
				}
				if(filterBox.getSelectedItem().toString().equals("Everything") && searchBox.getText().equals("")){
					initializeInventory();
				}
				else{
					for(Item item: search(filterBox.getSelectedItem().toString() + "," + searchBox.getText())) {
						JLabel tempLabel = new JLabel(item.getName() + "        ");
						tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
						inventoryTextPane.add(tempLabel);
						addLabelListener(tempLabel, item);
					}
				}
				repaint();
			}
		});
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            tabbedPane.requestFocus();
	        }
	    });
		tabbedPane.addKeyListener(new KeyAdapter() { //<--use this for input listener
			@Override
			public void keyReleased(KeyEvent arg0) {
				Inp.PutEvent(arg0.getKeyChar());
			}
		});
	}
	private void autoResizeComponents(JPanel panel) { //need to figure out a clever way to do this
		for(Component components: panel.getComponents()){
			if(!(components instanceof JLabel) && !(components instanceof JComboBox)){
				components.setSize(components.getWidth() * 2, components.getHeight() * 2);
			}
		}
		
	}
	private JLabel DisplayImage(JPanel jp, String url) throws IOException, Exception {
        try {
            Image image=ImageIO.read(this.getClass().getResource(url));
            ImageIcon imageicon=new ImageIcon(image);
            JLabel label=new JLabel(imageicon);
            jp.add(label);
            return label;
        } catch (IOException ex) {
            throw new IOException();
        } catch (Exception ex) {
            throw new Exception();
        }
    }
        
    private LinkedList<Item> search(String[] to_search){
        LinkedList<Item> found = new LinkedList<Item>();
        for(Item itm: DBs.getItems()){
            for(String to_s: to_search){
                if("".equals(to_s)){
                    break;
                }
                if(itm.toCSVFormat().trim().contains(to_s.trim())){
                    found.add(itm);
                    break;
                }
            }
        }
        return found;
    }
        
    private LinkedList<Item> search(String to_search){
        return search(to_search.split(","));
    }
    
    private void initializeInventory(){	
	    for(Item item: DBs.getItems()){
	    	if(item != null){
				JLabel tempLabel = new JLabel(item.getName() + "        ");
				tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
				inventoryTextPane.add(tempLabel);
				addLabelListener(tempLabel, item);
	    	}
		}
  
    }
    private void addLabelListener(JLabel itemLabel, Item item){
    	itemLabel.addMouseListener(new MouseAdapter() {
			@Override
			//This mousePressed event should display the item details of the label that was clicked
			public void mousePressed(MouseEvent arg0) {
			//	System.out.println(((JLabel)tempLabel).getText()); // <--can use this for a switch case to fill in details
				lblAuthor.setText(item.getMaker()[0] + ":");
				tabbedPane.setSelectedIndex(2);					
				titleText.setText(item.getName());
				authorText.setText(item.getMaker()[1]);
				descriptionText.setText(item.getDescription());
				stockTextArea.setText("" + item.getQuantity() + "");
			}
		});
    }
}

package oop.project2;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import oop.project2.DataObjects.Item;
import oop.project2.libevent.LibEvent;
/**
 * This is the GUI file that contains all of the front end code
 * and backend calls. The GUI is composed of 5 tabs, "Scanned Event",
 * which is responsible for handling scanner events such as checking in
 * or checking out a book, "Inventory", which is responsible for searching
 * and displaying items in the library's inventory, "Item Details", which is
 * responsible for displaying the selected item's details, "Map", which is responsible
 * for showing the location of the selected item, and the "Policy" tab which displays
 * the library's policy. 
 * @author jshaak
 *
 */

public class LendingLibraryGUI extends JFrame{

	/**
	 * declaring the attributes of the GUI
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchBox;
	private JTextArea itemDescriptBox;
	private JScrollPane itemDescriptPane;
	private JScrollPane eventScroll;
	private JTextArea eventStatusBox;
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
    private BufferedImage mapA;
    private BufferedImage mapB;

    private DBThread DBs; 
    private InputBuilder Inp;
    private EventBuilder Evt;
    private Item currentItem;
    private JPanel mapPanel;
    private Image dotImage;
    private BufferedImage canvas;
    private Graphics g;
    
    private Pallette palette;
    private String itemId;
    private JScrollPane policyScrollPane;
    private JTextArea policyTextArea;
	/**
	 * LendingLibraryGUI(DBThread DBs, InputBuilder Inp, EventBuilder Evt)
	 * 
	 * This constructor initializes the components of the UI. It also sets
	 * listeners on some of the components. 
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
		tabbedPane.requestFocus();
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		tab1 = new JPanel();
		tabbedPane.addTab("Scanned Event", null/*insert icon here*/, tab1, null/*insert tooltip here*/);
		tab1.setLayout(null);
	
		itemDescriptBox = new JTextArea();
		itemDescriptBox.setText("No items have been checked yet!");
		itemDescriptBox.setEditable(false);
		itemDescriptBox.setWrapStyleWord(true);
		itemDescriptPane = new JScrollPane(itemDescriptBox);
		itemDescriptPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		itemDescriptBox.setBounds(32, 45, 400, 200);
		itemDescriptBox.setLocation(this.getWidth()/2 - itemDescriptBox.getWidth()/2, this.getHeight()/7 - itemDescriptBox.getHeight()/2+10);
		itemDescriptPane.setBounds(itemDescriptBox.getBounds());
		tab1.add(itemDescriptPane);
		
		checkedItemLbl = new JLabel("Checked Item Description:");
		checkedItemLbl.setBounds(32, 4, itemDescriptBox.getWidth(), 16);
		checkedItemLbl.setLocation(this.getWidth()/2 - itemDescriptBox.getWidth()/2, this.getHeight()/8-itemDescriptBox.getHeight()/2-20);
		checkedItemLbl.setFont(new Font(checkedItemLbl.getName(), Font.BOLD, 14));
		tab1.add(checkedItemLbl);
		
		eventStatusBox = new JTextArea();
		eventStatusBox.setEditable(false);
		eventStatusBox.setBounds(32, 290, 400, 200);
		eventStatusBox.setLocation(this.getWidth()/2 - itemDescriptBox.getWidth()/2, this.getHeight()/2-eventStatusBox.getHeight()/2-30);
		eventScroll = new JScrollPane(eventStatusBox);
		eventScroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		eventScroll.setBounds(eventStatusBox.getBounds());
		tab1.add(eventScroll);
		
		lblEventStatus = new JLabel("Event Status:");
		lblEventStatus.setBounds(32, 261, eventStatusBox.getWidth(), 16);
		lblEventStatus.setLocation(this.getWidth()/2 - itemDescriptBox.getWidth()/2, this.getHeight()/3);
		lblEventStatus.setFont(new Font(lblEventStatus.getName(), Font.BOLD, 14));
		tab1.add(lblEventStatus);
		tab1.setFocusable(true);
		JLabel exitSessionLabel = new JLabel("CLICK HERE TO EXIT SESSION");
		exitSessionLabel.addMouseListener(new MouseAdapter() { //All this does is reset to the default GUI
			@Override
			public void mouseClicked(MouseEvent e) {
				itemDescriptBox.setText("No items have been checked yet!");
				eventStatusBox.setText("");
				filterBox.setSelectedIndex(0);
				initializeInventory();
				currentItem = null;
			}
		});
		exitSessionLabel.setBounds(this.getWidth()/2 - itemDescriptBox.getWidth()/2, this.getHeight()/2 + eventStatusBox.getHeight(), 
								eventStatusBox.getWidth(), 16);
		exitSessionLabel.setFont(new Font(exitSessionLabel.getName(), Font.BOLD, 14));
		tab1.add(exitSessionLabel);
		
		inventoryTextPane = new JPanel(); 
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
		//filterBox.addItem("Periodical");
		filterBox.addItem("Newspaper");
		filterBox.addItem("Magazine");
		filterBox.addItem("Audio");
		filterBox.addItem("Reference Material");
		filterBox.setBounds(54, 14, 99, 22);
		tab2.add(filterBox);
		
		lblFilter = new JLabel("Filter:");
		lblFilter.setBounds(12, 16, 56, 16);
		tab2.add(lblFilter);
		
		this.initializeInventory(); //initialize the labels in the inventoryTextPane
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
		lblDescription.setBounds(12, 172, 150, 16);
		lblDescription.setFont(new Font(lblDescription.getName(), Font.BOLD, 14));
		tab3.add(lblDescription);
		
		descriptionText = new JTextArea();
		descriptionText.setEditable(false);
		descriptionText.setBounds(220, 169, 400, 200);
		descriptionText.setWrapStyleWord(true);
		descriptionText.setLineWrap(true);
		tab3.add(descriptionText);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(12, 60, 56, 16);
		lblTitle.setFont(new Font(lblTitle.getName(), Font.BOLD, 14));
		tab3.add(lblTitle);
		
		titleText = new JTextArea();
		titleText.setEditable(false);
		titleText.setBounds(220, 57, descriptionText.getWidth(), 22);
		tab3.add(titleText);
		
		lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(12, 115, 150, 16);
		lblAuthor.setFont(new Font(lblAuthor.getName(), Font.BOLD, 14));
		tab3.add(lblAuthor);
		
		authorText = new JTextArea();
		authorText.setEditable(false);
		authorText.setBounds(220, 112, descriptionText.getWidth(), 22);
		tab3.add(authorText);
		
		lblInStock = new JLabel("In Stock:");
		lblInStock.setBounds(12, 400, 150, 16);
		lblInStock.setFont(new Font(lblInStock.getName(), Font.BOLD, 14));
		tab3.add(lblInStock);
		
		stockTextArea = new JTextArea();
		stockTextArea.setEditable(false);
		stockTextArea.setBounds(220, 400, 56, 22);
		tab3.add(stockTextArea);
		
		JLabel lblClickHereTo = new JLabel("CLICK HERE TO VIEW MAP LOCATION");
		//This listener will switch the tab to the map, and send the item name or id to the DB
		//once it retrieves its x,y coordinates, puts the gif on the map where that location is
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				palette.setPaintProperties(dotImage, currentItem, g); //palette now knows what and where to paint 
				palette.repaint(); //palette draws the image on the canvas
				tabbedPane.setSelectedIndex(3); //switches the tab to map
			}
		});
		lblClickHereTo.setBounds(12, 460, 221, 16);
		tab3.add(lblClickHereTo);
		
		tab4 = new JPanel();
		tabbedPane.addTab("Map", null, tab4, null);
		mapPanel = new JPanel();
		tab4.add(mapPanel);
		/**
		 * The code in this try block loads the images that will be
		 * placed in the "Map" tab. It also draws the maps on the canvas.
		 */
		try {
			mapA = readImage("mapa.png");
			mapB = readImage("mapb.png");
			dotImage = readImage("dot.gif");
			dotImage = resizeImage(dotImage, 30, 30);
			
			canvas = new BufferedImage(mapA.getWidth() + mapB.getWidth() + 100, mapA.getHeight() + mapB.getHeight(), BufferedImage.TYPE_INT_ARGB);
			g = canvas.getGraphics(); //uses the canvas graphic to paint on
			
			ImageIcon icon = new ImageIcon(canvas); //convert the canvas to something usable by a JLabel
			palette = new Pallette(icon); //creates the Pallette and it now knows what to paint on
			mapPanel.add(palette); //add the palette to the Panel so it can paint
			
			g.drawImage(mapA, 50, 50, null); //draws mapA on the canvas
			g.drawImage(mapB, mapA.getWidth() + 100, 50, null); //draws mapB on the canvas
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			System.out.println(e1.getCause());
		}
		//TODO: REMOVE AT THE END
		palette.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(3); //switches the tab to map
				
				System.out.println(arg0.getX() + " , " + arg0.getY());
				System.out.println(arg0.getX() + " , " + arg0.getY());
			}
		});
		tab5 = new JPanel(); //create the policy tab
		tab5.setLayout(null);
		tabbedPane.addTab("Policy", null, tab5, null);	
	
		//creating the textArea and scrollPane for the library policy
		policyTextArea = new JTextArea();
		policyTextArea.setText(this.getPolicy());
		policyTextArea.setEditable(false);
		policyTextArea.setLineWrap(true);
		policyTextArea.setWrapStyleWord(true);
		policyScrollPane = new JScrollPane(policyTextArea);
		policyScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		policyTextArea.setBounds(32, 45, this.getWidth()/2, this.getHeight()-200);
		policyTextArea.setLocation(this.getWidth()/2 - policyTextArea.getWidth()/2, 
									this.getHeight()/2 - policyTextArea.getHeight()/2); //centers the textBox
		policyScrollPane.setBounds(policyTextArea.getBounds());
		tab5.add(policyScrollPane);
		
		/**
		 * This item listener should filter the components based on their category. Components(JLabels) should
		 * be created based on the items. The strategy might be to remove the JLabels from the panel, then readd the
		 * filtered JLabels based on the item's category. 
		 */
		filterBox.addItemListener(new ItemListener (){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == 1){ //this if statement is to get the selected item
					for(Component component: inventoryTextPane.getComponents()){ //removes the current labels
						inventoryTextPane.remove(component);
					}
					if(filterBox.getSelectedItem().toString().equals("Everything") && searchBox.getText().equals("")){ //special case
						initializeInventory();
					}
					else{ //searches items based on search box input and filter box selection and turns them into JLabels
						for(Item item: search(filterBox.getSelectedItem().toString() + "," + searchBox.getText())){
							JLabel tempLabel = new JLabel(item.getName() + "        ");
							tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
							inventoryTextPane.add(tempLabel);
							addItemLabelListener(tempLabel, item);
						}
					}
					repaint(); //redraws the newly searched JLabels
				}
			}
		});
		/**
		 * This listener works the same as above. This event
		 * fires when the user types a character into the search box.
		 */
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
						addItemLabelListener(tempLabel, item);
					}
				}
				repaint();
			}
		});
		/**
		 * This listener ensures that when the tab is changed, the focus
		 * will focus on the newly opened tab. There is a special case that if
		 * the user clicks the item, and changes tabs instead of clicking
		 * the click here to view map location button. 
		 */
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            tabbedPane.requestFocus();
	            if(tabbedPane.getSelectedIndex() == 3){
	            	palette.setPaintProperties(dotImage, currentItem, g); //palette now knows what and where to paint 
					palette.repaint(); //palette draws the image on the canvas
	            }
	        }
	    });
		/**
		 * This listener is designed to fire when
		 * an item is scanned. When it fires, the
		 * item that was just scanned will be displayed
		 * starting a list of strings in the text area.
		 * It will also retrieve the event that occurred 
		 * from the scan letting the user know if the item
		 * was checked in or checked out.
		 */
		
		tabbedPane.addKeyListener(new KeyAdapter() { //<--use this for input listener
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(tabbedPane.isFocusOwner()){
					tabbedPane.setSelectedIndex(0);
					Inp.PutEvent(arg0.getKeyChar());
					itemId += arg0.getKeyChar();
				}
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					if(itemDescriptBox.getText().equals("No items have been checked yet!")){
						itemDescriptBox.setText("");
					}
					for(Item item: DBs.getItems()){ //searches each item in the database for their id
						if(item.getID().equals(itemId)){
							itemDescriptBox.setText(itemDescriptBox.getText() + item.getName() + "\n");
						}
					}                        
					for(LibEvent evt : Evt.getEvents()){
						eventStatusBox.setText(eventStatusBox.getText() + evt.toString() + "\n");
					}
					itemId = ""; //reset itemId to an empty string
				}
			}
		});
	}
	/**
	 * Image resizeImage(Image i, int width, int height)
	 * 
	 * This method is designed to return a scaled image based on the given width and height to scale with.
	 * @param i
	 * @param width
	 * @param height
	 * @return Image
	 */
	private Image resizeImage(Image i, int width, int height){
		return i.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	}
	/**
	 * BufferedImage readImage(String url)
	 * This method reads in and returns an image. It takes in the image path
	 * as a parameter. 
	 * 
	 * @param url
	 * @return BufferedImage 
	 * @throws IOException
	 * @throws Exception
	 */
	private BufferedImage readImage(String url) throws IOException, Exception {
		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource(url));
			return image;
		}catch(IOException e){
			
		}catch(Exception e){
			
		}
		return null; //if no image was read
	}
	/**
	 * LinkedList<Item> search(String[] to_search)
	 * 
	 * This method is designed to search through the database given a string array
	 * trims the string and searches the database with each string in the to_search array. This
	 * search also returns items with any string that contains the searched word.
	 * @param to_search
	 * @return LinkedList<Item> 
	 */
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
    /**
     * LinkedList<Item> search(String to_search)
     * 
     * This method parses a string into an array of strings and passes
     * that array to the overloaded search(Search[] to_search) method
     * 
     * @param String to_search
     * @return LinkedList<Item>
     */
    private LinkedList<Item> search(String to_search){
        return search(to_search.split(","));
    }
    
    /**
     * initializeInventory()
     * 
     * This method is designed to initialize
     * the inventoryTextPane with all items
     * in the database.
     */
    private void initializeInventory(){	
	    for(Item item: DBs.getItems()){
	    	if(item != null){
				JLabel tempLabel = new JLabel(item.getName() + "        ");
				tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
				inventoryTextPane.add(tempLabel);
				addItemLabelListener(tempLabel, item);
	    	}
		}
  
    }
    /**
     * addLabelListener(JLabel itemLabel, Item item)
     * 
     * This item adds a listener to the itemLabel passed into the method.
     * @param itemLabel
     * @param item
     */
    private void addItemLabelListener(JLabel itemLabel, Item item){
    	itemLabel.addMouseListener(new MouseAdapter(){ 
			/**
			 * This event fires when the itemLabel is clicked.
			 * It is designed to display the details of the item
			 * that was clicked. It sets the currentItem as well
			 * so that the Pallette knows whose item coordinates
			 * it needs to draw the dot. 
			 */
    		@Override
			public void mousePressed(MouseEvent arg0) {
				lblAuthor.setText(item.getMaker()[0] + ":");
				tabbedPane.setSelectedIndex(2);					
				titleText.setText(item.getName());
				authorText.setText(item.getMaker()[1]);
				descriptionText.setText(item.getDescription());
				stockTextArea.setText("" + item.getQuantity() + "");
				currentItem = item;
			}
		});
    }
   
    private String getPolicy(){
    	return "Popular Reading Policy The Mary and Jeff Bell Library Popular Reading Collection contains contemporary fiction, "
    			+ "popular non-fiction and best sellers. The Popular reading collections aim is to provide the TAMUCC campus community "
    			+ "with a leisure reading outlet that helps to supplement our academic collections.\n" 
    			+ "\nThe collection is available on the first floor of the Mary and Jeff Bell Library across from the circulation desk and adjacent to the New Books Collection."

    			+ "\n\nCirculation Policy:\n"
    			+ "Limit of two items per patron\n"
    			+ "Loan period = 2 weeks\n"
    			+ "One renewal"
    			+ "Books can only be checked out by TAMUCC faculty, staff, and students\n\n"
    	
    			+ "Group Study Rooms\n"
    			+ "The Mary and Jeff Bell Library provides 15 study rooms of various size for single student, small group, and "
    			+ "large group usage. Keys to these rooms may be checked out from the Circulation desk for a period of three hours.\n\n"

    			+ "Food and Drinks are not allowed in any study room with electronic equipment.\n\n" 

    			+ "Study room keys are library use only and may not be taken out of the Library for any time period.\n\n" 

    			+ "Checked out study room keys will not be held at any service desk.\n" 

    			+ "Anyone not actively using a checked out study room must return the key to the Circulation desk. \n" 

    			+ "If a key to a study room is lost any and all students who checked out the room will be required to pay for the rekeying of the "
    			+ "group study room, and will lose all study room privileges for the remainder of the semester.\n" 

    			+ "\nNo study rooms will be checked out after Midnight as this will not allow for the full three hour checkout period.\n" 

    			+ "\nRooms will be available for a maximum of three hours and are only renewable if no one is waiting to check out the room. \n"

    			+ "\nThe Mary and Jeff Bell Library provides six individual study rooms for check out by a single student with a valid Sanddollar ID card. "
    			+ "No food or drinks are allowed in the individual study rooms."
    			+ "Any damage to the room or electronic equipment provided in the room will be charged to the student who checked out the room."
    			+ "The Mary and Jeff Bell Library provides six study rooms intended for small groups of up to four students."
    			+ "At least 2 members of the group must be present at the service desk to checkout a key."
    			+ "Any damage to the room or electronic equipment provided in the room will be charged to both students who checked out the room."
    			+ "The Mary and Jeff Bell Library provides two study rooms intended for large groups of up to eight students."
    			+ "At least 3 members of the group must be present with valid Sanddollar ID’s at the Circulation desk to checkout a key."
    			+ "Accessories for the use of the Smartboards inside the large group study rooms are also available for checkout at the Circulation desk. The accessories will be treated as reserve items and are therefore subject to their own late fees."
    			+ "Keys and room accessories that are returned late are subject to a $3.00 per hour fine. All fines may be paid at the Library's main Circulation Desk on the first floor or at the Business office located in the Student Services Center. Students accruing $15.00 or more in library fines are unable to borrow additional materials until fines are paid."
    			+ "Study rooms may only be checked out and used by current TAMUCC students or by Faculty members holding study sessions with groups of students. These rooms are not meant to be used as faculty or staff conference rooms or offices."
    			+ "Study rooms are available on a walk-in basis. The Mary and Jeff Bell Library does not routinely allow advance room reservations"
    			+ "Study room users must vacate the room when the key is due."
    			+ "Study room users must maintain a moderate noise level - rooms are not soundproof, and loud talking disturbs other users in adjoining rooms and outside the rooms."
    			+ "Users of the study rooms must clean up after themselves, and leave the room in good condition for the next users, including erasing the white board."
    			+ "If a patron notices significant damage to the room upon entering the study room they are obligated to let the circulation staff know the condition of the room. Failure to do so may result in the patron being liable for any and all damages."
    			+ "Patrons groups exceeding the maximum capacity of each room will be required to cut down the number of individuals in the room until maximum capacity is met."
    			+ "In addition, users of the group study rooms, as with all Library resources, must comply with the rules of use and conduct listed in the Mary and Jeff Bell Library Building Use policies."
  
    			+ "\n\nNOTICE: failure to follow these policies, or other applicable library policies, may result in a temporary or permanent suspension of access to these group study rooms."

    			+ "The goal of the Mary and Jeff Bell Library staff is that these rooms will be a clean and pleasant place to study. If you find that a room was left in poor condition by the previous occupants, report this immediately to the service desk.\n"

    			+ "\nSpecial Status\n"
    			+ "Special Activities - Community members with a driver's license or state identification card may check out government documents with a Special Activities card. The loan period is 3 weeks with no renewals.\n" 
    			+ "Community Users may purchase a Community User's Card, valid for one year, for $20 dollars. Community Users may check out 3 items, for 3 weeks with no renewals. Community users do not receive computer lab, media, or Interlibrary Loan privileges.\n"
    			+ "TexShare Cards - Currently enrolled students and currently employed faculty and staff may obtain a TexShare card, valid for a semester. TexShare cards may be obtained from the Circulation Desk. You may take your TexShare card and a photo ID to another TexShare Library and receive borrowing privileges at that library. Patrons are responsible for returning items borrowed from other libraries.\n"

    			+ "\nLocation\n" 
    			+ "All circulating materials, other than media items, can be checked out at the Circulation Desk on the 1st floor near the entrance. The telephone number is (361) 825-2340, and the Circulation Supervisor is Robert Rios at Robert.Rios@tamucc.edu. The Media Center is located on the 2nd floor, and the Media contact is Abel Cantu at Abel.Cantu@tamucc.edu (361) 825-2348.\n"

    			+ "\nBooks and other materials located at the South Texas Institute for the Arts do not circulate, but patrons may use them at that location. A&M-CC patrons may borrow materials (except periodicals and reference items) from the library at the Driscoll Children's Hospital or may request them through InterLibrary Loan.";
    }
}

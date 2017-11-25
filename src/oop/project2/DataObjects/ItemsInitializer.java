package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author Jeremy
 * 
 * 5 of each category
 * 
 * Item (String category,
 * │     String name,
 * │     String description,
 * │     int quantity,
 * │     int id,
 * │     int x,
 * │     int y)
 * ├───LibraryBook (...String author, int rating)
 * ├───Movie (...String genre, int rating)
 * ├───Audio (...String narrator, int rating)
 * ├───Periodical (...String subject)
 * │   ├──Magazine (...int issue)
 * │   └──Newspaper (...String leaning)
 * └───Reference Material(...)
 */
public class ItemsInitializer {

    public static void main(String[] args){
        Item[] inventory = new Item[30];
        
        // LibraryBook s *****************************************************
        inventory[0] = new LibraryBook("Book",
                                "Surreal Numbers",
        						"Shows how a young couple turned on to pure mathematics and found total happiness. This title is intended for those who might enjoy an engaging dialogue on abstract mathematical ideas, and those who might wish to experience how new mathematics is created.",
        						2,
        						0000,
        						50,
                                50,
                                "Donald E. Knuth",
                                4);
        inventory[1] = new LibraryBook("Book",
                                "The Gulag Archipelago",
        						"Drawing on his own experiences before during and after his eleven years of incarceration and exile: on evidence provided by more than 200 fellow prisoners and on Soviet archives Solzhenitsyn reveals with torrential narrative and dramatic power the entire apparatus of Soviet repression, the state within the state that once ruled all-powerfully with its creation by Lenin in 1918.",
        						3,
        						0001,
        						25,
                                50,
                                "Aleksandr Solzhenitsyn",
                                5);
        inventory[2] = new LibraryBook("Book",
                                "Brave New World",
        						"Aldous Huxley's profoundly important classic of world literature: Brave New World is a searching vision of an unequal/ technologically-advanced future where humans are genetically bred; socially indoctrinated; and pharmaceutically anesthetized to passively uphold an authoritarian ruling order--all at the cost of our freedom full humanity and perhaps also our souls.",
        						9,
        						0002,
        						25,
                                25,
                                "Aldous Huxley",
                                4);
        
        // Audio s ***********************************************************
        
        inventory[5] = new Audio("Audio",
                                "Hitchhiker's Guide to the Galaxy",
        						"Don't leave earth without this story of the end of the world and the happy-go-lucky days that follow. Written by Douglas Adams.",
        						2,
        						0005,
        						50,
                                25,
                                "Stephen Fry",
                                5);

        // Movie s ***********************************************************
        
        inventory[10] = new Movie("Movie",
				                "Lincoln",
								"An inspiring drama that focuses on Abraham Lincoln's final four months",
								2,
								0010,
								10,
				                10,
				                "Drama",
				                4);
        
        // Newspaper s *******************************************************
        //https://www.allsides.com/unbiased-balanced-news
        
        inventory[15] = new Newspaper("Newspaper",
					                "The Wall Street Journal",
									"The Wall Street Journal is an American business-focused, English-language international daily newspaper based in New York City.",
									57,
									0015,
									12,
					                10,
					                "Business",
					                "Center");
        
        // Magazine s ********************************************************
        
        inventory[20] = new Magazine("Magazine",
					                "Scientific American",
									"American popular science magazine. Many famous scientists, including Albert Einstein, have contributed articles in the past 170 years. It is the oldest continuously published monthly magazine in the United States",
									1,
									0020,
									10,
					                12,
					                "Science",
					                783);
        
        // Reference s *******************************************************
        //Almanacs, Atlases, Bibliographies, Biographical Resources, Dictionaries, Encyclopedias - General and by Subject, Handbooks, Indexes, Statistics, and Citation Guides
        
        
        System.out.printf(inventory[0].toCSVFormat());
     

    }

}

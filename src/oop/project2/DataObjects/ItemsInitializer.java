package oop.project2.DataObjects;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @since 10/20/2017
 * @author Jeremy
 * Item (String category,
 *      String name,
 *      String description,
 *      int quantity,
 *      int id,
 *      int x,
 *      int y)
 *     LibraryBook (...String author, int rating)
 *     Movie (...String genre, String director, int rating)
 *     Audio (...String narrator, int rating)
 *     Periodical (...String subject)
 *         Magazine (...int issue)
 *         Newspaper (...String leaning)
 *     Reference Material(...)
 */
public class ItemsInitializer {
    public static Item[] inventory;

    public static void main(String[] args){
        inventory = new Item[30];

        // LibraryBook s *****************************************************
        inventory[0] = new LibraryBook("Book",
                                "Surreal Numbers",
                                "Shows how a young couple turned on to pure mathematics and found total happiness. This title is intended for those who might enjoy an engaging dialogue on abstract mathematical ideas, and those who might wish to experience how new mathematics is created.",
                                2,
                                "997145003993",
                                1152,
                                386,
                                "Donald E. Knuth",
                                4);
        inventory[1] = new LibraryBook("Book",
                                "The Gulag Archipelago",
                                "Drawing on his own experiences before during and after his eleven years of incarceration and exile: on evidence provided by more than 200 fellow prisoners and on Soviet archives Solzhenitsyn reveals with torrential narrative and dramatic power the entire apparatus of Soviet repression, the state within the state that once ruled all-powerfully with its creation by Lenin in 1918.",
                                3,
                                "437145003993",
                                260,
                                540,
                                "Aleksandr Solzhenitsyn",
                                5);
        inventory[2] = new LibraryBook("Book",
                                "Brave New World",
                                "Aldous Huxley's profoundly important classic of world literature: Brave New World is a searching vision of an unequal/ technologically-advanced future where humans are genetically bred; socially indoctrinated; and pharmaceutically anesthetized to passively uphold an authoritarian ruling order--all at the cost of our freedom full humanity and perhaps also our souls.",
                                9,
                                "337145003993",
                                1162,
                                257,
                                "Aldous Huxley",
                                4);
        inventory[8] = new LibraryBook("Book",
                                "The picture of Dorian Gray",
                                "Dorian Gray is the subject of a full-length portrait in oil by Basil Hallward, an artist who is impressed and infatuated by Dorian's beauty; he believes that Dorian's beauty is responsible for the new mode in his art as a painter. Through Basil, Dorian meets Lord Henry Wotton, and he soon is enthralled by the aristocrat's hedonistic worldview: that beauty and sensual fulfilment are the only things worth pursuing in life. Newly understanding that his beauty will fade, Dorian expresses the desire to sell his soul, to ensure that the picture, rather than he, will age and fade. The wish is granted, and Dorian pursues a libertine life of varied and amoral experiences, while staying young and beautiful; all the while his portrait ages and records every sin.",
                                9,
                                "037145003993",
                                796,
                                676,
                                "Aldous Huxley",
                                4);

        // Audio s ***********************************************************

        inventory[3] = new Audio("Audio",
                                "Hitchhiker's Guide to the Galaxy",
                                "Don't leave earth without this story of the end of the world and the happy-go-lucky days that follow. Written by Douglas Adams.",
                                2,
                                "137145003993",
                                796,
                                676,
                                "Stephen Fry",
                                5);

        inventory[10] = new Audio("Audio",
                                "How to Make Friends & Influence People",
                        				"For more than sixty years the rock-solid: time-tested advice by Dale Carnegie in this book has carried thousands of now famous people up the ladder of success in their business and personal lives.",
                        				5,
                        				"0000000000006",
                        				40,
                                35,
                                "Andrew MacMillan",
                                5);

        // Movie s ***********************************************************

        inventory[4] = new Movie("Movie",
                                "Lincoln",
                                "An inspiring drama that focuses on Abraham Lincoln's final four months",
                                2,
                                "337433003993",
                                518,
                                292,
                                "Drama",
                                "Steven Spielberg",
                                4);
        inventory[5] = new Movie("Movie",
                                "Citizen Toxie The Toxic Avenger IV",
                                "The Toxic Avenger must defend his friends from his own evil alternate universe doppelgänger, The Noxious Offender.",
                                2,
                                "790357905034",
                                769,
                                676,
                                "Drama",
                                "Lloyd Kauffman",
                                4);
        inventory[11] = new Movie("Movie",
                                "March of the Penguins",
                        				"A documentary about a colony of emperor penguins. Narrated by Morgan Freeman.",
                        				2,
                        				"0000000000011",
                        				55,
                                95,
                                "Documentary",
                                "Luc Jaquet",
                                4);

        // Newspaper s *******************************************************
        //https://www.allsides.com/unbiased-balanced-news

        inventory[6] = new Newspaper("Newspaper",
                                    "The Wall Street Journal",
                                    "The Wall Street Journal is an American business-focused, English-language international daily newspaper based in New York City.",
                                    57,
                                    "337124403993",
                                    518,
                                    292,
                                    "Business",
                                    "Center");

        inventory[12] = new Newspaper("Newspaper",
                                    "Los Angeles Times",
                            				"The Los Angeles Times is a daily newspaper published in Los Angeles California.",
                            				20,
                            				"0000000000016",
                            				12,
                                    15,
                                    "News",
                                    "Left");

        inventory[13] = new Newspaper("Newspaper",
                                    "Washington Times",
                            				"The Washington Times founded in 1982 with headquarters in Washington D.C. is a daily newspaper.",
                            				13,
                            				"0000000000017",
                            				12,
                                    18,
                                    "American Politics",
                                    "Right");

        // Magazine s ********************************************************

        inventory[7] = new Magazine("Magazine",
                                    "Scientific American",
                                    "American popular science magazine. Many famous scientists, including Albert Einstein, have contributed articles in the past 170 years. It is the oldest continuously published monthly magazine in the United States",
                                    1,
                                    "467145003993",
                                    518,
                                    292,
                                    "Science",
                                    783);

        inventory[14] = new Magazine("Magazine",
                                    "National Geographic",
                            				"It primarily contains articles about science geography history and world culture. The magazine is known for its thick square-bound glossy format with a yellow rectangular border and its extensive use of dramatic photographs.",
                            				1,
                            				"0000000000021",
                            				10,
                                    82,
                                    "Nature",
                                    783);

        // Reference s *******************************************************
        //Almanacs, Atlases, Bibliographies, Biographical Resources, Dictionaries, Encyclopedias - General and by Subject, Handbooks, Indexes, Statistics, and Citation Guides
        inventory[9] = new Reference("Reference",
                          				 "Encyclopedia Britannica",
                          				 "general knowledge English-language encyclopaedia",
                          				 2,
                          				 "0000000000025",
                          				 64,
                          				 70,
                          				 "Encyclopedia Britanica Inc.");

        System.out.printf(inventory[0].toCSVFormat());

        toFile();


    }

    public static void toFile(){
        try {
            int c_size = 15;
            FileWriter out = new FileWriter("./src/ItemDB.dat");
            out.write(Integer.toString(c_size));
            out.write("\n");
            for(int x=0;x<c_size;x++)
            {
                out.write(inventory[x].toCSVFormat());
                out.write("\n");
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("Item File Write Error");
        }
    }

}

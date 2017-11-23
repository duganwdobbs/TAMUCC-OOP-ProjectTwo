package oop.project2;

/**
 *
 * @author jeremy
 * constructor args: String category,
                     String name,
 		     String description,
                     int quantity,
                     int id,
                     int x,
                     int y,
                     String author,
                     int rating
 */
public class ItemTest {

    public static void main(String[] args){
        Item[] inventory = new Item[35];
        inventory[0] = new Book("Book",
                                "Surreal Numbers",
        						"Shows how a young couple turned on to pure mathematics and found total happiness. This title is intended for those who might enjoy an engaging dialogue on abstract mathematical ideas, and those who might wish to experience how new mathematics is created.",
        						2,
        						0000,
        						50,
                                50,
                                "Donald E. Knuth",
                                4);
        inventory[1] = new Book("Book",
                                "The Gulag Archipelago",
        						"Drawing on his own experiences before during and after his eleven years of incarceration and exile: on evidence provided by more than 200 fellow prisoners and on Soviet archives Solzhenitsyn reveals with torrential narrative and dramatic power the entire apparatus of Soviet repression, the state within the state that once ruled all-powerfully with its creation by Lenin in 1918.",
        						3,
        						0001,
        						25,
                                50,
                                "Aleksandr Solzhenitsyn",
                                5);
        inventory[2] = new Book("Book",
                                "Brave New World",
        						"Aldous Huxley's profoundly important classic of world literature: Brave New World is a searching vision of an unequal/ technologically-advanced future where humans are genetically bred; socially indoctrinated; and pharmaceutically anesthetized to passively uphold an authoritarian ruling order--all at the cost of our freedom full humanity and perhaps also our souls.",
        						9,
        						0002,
        						25,
                                25,
                                "Aldous Huxley",
                                4);
        inventory[3] = new Book("Audio",
                                "Hitchhiker's Guide to the Galaxy",
        						"Don't leave earth without this story of the end of the world and the happy-go-lucky days that follow. Written by Douglas Adams.",
        						2,
        						0003,
        						50,
                                25,
                                "Stephen Fry",
                                5);

        System.out.printf(inventory[0].toCSVFormat());

    }

}

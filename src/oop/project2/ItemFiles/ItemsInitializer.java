/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uberstock;

/**
 *
 * @author jeremy
 * constructor args: String name,
 					String description,
 					int quantity,
                	int id,
                	double price,
                	Category category
   public enum Category{
        FURNITURE, RUGS, DECOR, BED_AND_BATH,
        HOME_IMPROVEMENT, KITCHEN, OUTDOOR
    }
 */
public class ItemTest {

    public static void main(String[] args){
        Item[] inventory = new Item[35];
        inventory[0] = new Item("Corvus Madonna Mid-Century Accent Chair",
        						"Add sleek mid-century style to your home with this lovely Madonna accent chair from Corvus. This stylish accent chair features an unique profile with an artistically curved seat and back in a rich walnut finish black bonded leather upholstery adding comfort to the design. The supportive solid wood legs complete the sturdy and retro appeal of this accent chair.",
        						20,
        						0000,
        						102.14,
        						Item.Category.FURNITURE);
        inventory[1] = new Item("Linon Manhattanesque Backless Counter Stool with Black Vinyl Seat",
        						"Use this classic stool for extra seating in your living space or at a counter. Solidly constructed with a sturdy rubberwood frame; this stool is strong and durable. Black vinyl upholstery and nail head trim with accent stitching give it a stylish and elegant look.",
        						15,
        						0001,
        						42.99,
        						Item.Category.FURNITURE);
        inventory[2] = new Item("Rustic Reclaimed Wood Coffee Table",
        						"A fresh complement to your rustic home decor, this excellent coffee table is made from solid wood with a tapered metal frame that is just as supportive as it is stylish. A rich natural wood finish and spacious shelf underneath make this table the perfect statement piece in any industrial-chic space.",
        						6,
        						0002,
        						187.99,
        						Item.Category.FURNITURE);
        inventory[3] = new Item("Tufted Wingback Bed in Velvet Navy- Skyline Furniture",
        						"Update your home with this navy velvet wingback bed. This bed features a solid pattern and is made with 100-percent polyester. The velvet upholstery and handmade diamond tufts will add elegance and charm to any existing bedroom decor. The unique silhouette will make this bed the focal point of any bedroom.",
        						5,
        						0003,
        						570.99,
        						Item.Category.FURNITURE);
        inventory[4] = new Item("Benchwright Premium Tufted Rolled Back Parsons Chairs (Set of 2)",
        						"Highlight your dinner parties with the luxury and comfort of these gorgeous Benchwright premium upholstered Parsons chairs from iNSPIRE Q Artisan. The exquisite rolled back features rows of diamond-shaped button tufting; showcasing the inviting plush cushions. Offered in your choice of bonded leather or linen fabric upholstery; these elegant dining Parsons chairs are certain to lend sophistication to any dining space.",
        						18,
        						0004,
        						169.00,
        						Item.Category.FURNITURE);
        inventory[5] = new Item("Safavieh Handwoven Casual Thick Jute Area Rug (6' x 9')",
        						"Give your home a carefree coastal vibe with Safavieh's handwoven jute area rug. Promoting a tranquil and organic ambiance; the thick jute fibers have been secured in a sisal-style weave for a textured feel. This 0.25-inch thick; neutral-colored area rug will blend harmoniously with new or existing decor. ",
        						10,
        						0100,
        						169.99,
        						Item.Category.RUGS);
        inventory[6] = new Item("nuLOOM Hand-knotted Moroccan Trellis Natural Shag Wool Rug (5' x 8')",
        						"Made from 100-percent premium wool fibers; this gorgeous shag rug features a generously high pile that's just as cozy as it is long-lasting. The crisp ivory color features a stylish Moroccan trellis pattern in accenting grey; while chunky tassels on either end lend a classic touch of textured character to any space.",
        						12,
        						0101,
        						185.42,
        						Item.Category.RUGS);
        inventory[7] = new Item("Safavieh Adirondack Vintage Ombre Ivory / Silver Rug (8' x 10')",
        						"Safavieh's Adirondack collection is inspired by timeless vintage designs crafted with the softest polypropylene available. This rug is crafted using a power-loomed construction with a polypropylene pile and features main accent color of ivory.Inspired by global travel and the bold colorful motifs adorning fashionable ski chalets; Safavieh translates rustic lodge style into the supremely chic and easy-care Adirondack collection. Crafted of enhanced polypropylene yarns; Adirondack rugs explore stylish over-dye and antiqued looks making striking fashion statements in any room.",
        						11,
        						0102,
        						164.89,
        						Item.Category.RUGS);
        inventory[8] = new Item("Safavieh Monaco Vintage Bohemian Multicolored Distressed Runner (2' 2 x 8')",
        						"Free-spirited and boldly colored. This 2'2 x 8' rug from Safavieh's Monaco Collection brings Bohemian-chic flair to contemporary and transitional home decor. Featuring neutral hues of cream beige and black and more vibrant hues of pink orange and blue this rug is truly a work of art. Made of power-loomed polypropylene this rug is virtually non-shedding and is able to withstand high-traffic areas. Its medium cut pile height of 0.5 inches allows for seamless placement under furniture and in entryways. Display this visually charming rug as a focal conversation piece for family and friends to love for years to come.",
        						8,
        						0103,
        						57.34,
        						Item.Category.RUGS);
        inventory[9] = new Item("Carolina Weavers Indoor/Outdoor Santa Barbara Collection Bangkok Multi Area Rug (5'2 x 7'6)",
        						"The Bongkok Multi area rug is a gorgeous and totally fun design that will make any decor pop. This rug uses the amazing red blue green orange yellow ivory and brown to create a dazzling pattern that will always leave your home vibrant. It is a lovely blend of colors stain resistant and machine woven with polypropylene so the color and intensity will last for years to come.",
        						5,
        						0104,
        						111.98,
        						Item.Category.RUGS);
        inventory[10] = new Item("60-inch Golden Bronze Floor Lamp",
        						"With accents of marble and a golden bronze finish this gorgeous floor lamp effortlessly offers chic elegance and sophistication. The faux silk shade is tan to match the bronze finish of the lamp and offer a homey and warm feeling.",
        						10,
        						0200,
        						37.49,
        						Item.Category.DECOR);
        inventory[11] = new Item("Vineyard Distressed Mahogany and Bronze 4-light Orb Chandelier",
        						"Create a sophisticated ambiance for your dining table or entryway with the gorgeous Vinyard orb chandelier. Four distressed mahogany wood slices are cradled around an oil-rubbed bronze rod for a rich vintage appeal. Designed for maximum visual impact this 24-inch orb chandelier will lend a romantic contemporary feel to a variety of home decors.",
        						4,
        						0201,
        						233.74,
        						Item.Category.DECOR);
        inventory[12] = new Item("Eddie Bauer Bear Felt 3 Colors Decorative Pillows",
        						"Decorate your living space with these fun pillows from Eddie Bauer. Available in three colors, these felt pillows are plush and soft to the touch, making them perfect for snuggling with while relaxing.",
        					  20,
        						0202,
        						21.63,
        						Item.Category.DECOR);
        inventory[13] = new Item("Montclair William Laminate 'Live, Love, Laugh' Inspirational Wall Shelves (Set of 3)",
        						"Bring encouraging charm to your living space with the Montclair William Laminate 'Live, Love, Laugh' Inspirational Wall Shelves. These shelves feature a laminate construction with black painted words that you will love.",
        						6,
        						0203,
        						29.73,
        						Item.Category.DECOR);
        inventory[14] = new Item("Lavish Home 3 Piece LED Flameless Candle Set with Remote",
        						"Designed to look like real candles, the 3 piece lEd flameless candle Set with Remote by lavish home is a great addition to any home. Get the classic, comforting look of a soft glowing candle without any drips, smoke, flame or safety hazards. Never worry about blowing out the candles before bed, simply use the remote to set the timer and forget about them. Featuring two brightness settings. Create the perfect ambiance for your home, wedding, dinner parties and more. Enjoy the subtle scent of vanilla while relaxing by our candles.",
        						30,
        						0204,
        						16.46,
        						Item.Category.DECOR);
        inventory[15] = new Item("LINENSPA Premium Hypoallergenic 100-percent Waterproof Mattress Protector",
        						"This practical fitted sheet style mattress protector is both hypoallergenic and waterproof. Constructed of cotton and polyurethane, this piece is also conveniently machine washable and dryer safe on low heat.",
        						23,
        						0300,
        						18.29,
        						Item.Category.BED_AND_BATH);
        inventory[16] = new Item("Grand Hotel Woven Cotton Throw Blanket",
        						"Crafted from soft cotton for a luxurious feel, this Grand Hotel throw is perfect for snuggling up on a cold night. The throw is crafted from 100-percent cotton with a pleasant basket weave, creating a piece that is both warm and cozy. The blanket is available in a variety of lush and trendy colors to blend beautifully with your decor.",
        						20,
        						0301,
        						17.77,
        						Item.Category.BED_AND_BATH);
        inventory[17] = new Item("Casa Platino Soft and Luxurious Cotton 600 GSM 20-Piece Towel Set",
        						"The finely crafted Egyptian cotton towel set, from Casa Platino, includes bath towels, hand towels, and wash cloths for a complete bathroom set. The feel gets better with every wash, with a wonderfully deep pile that is incredibly soft against your skin. The pieces are machine washable for easy care.",
        						18,
        						0302,
        						61.87,
        						Item.Category.BED_AND_BATH);
        inventory[18] = new Item("Avondale Manor Ella Pinch Pleat Reversible 7-piece Comforter Set",
        						"Refresh your bedroom with this chic seven-piece comforter set by Avondale Manor. Available in a wide array of colors, this bedding set features a diamond pintuck pattern that adds a touch of elegance to your sleeping space while the reverse chevron pattern adds a fun, modern alternative. Crafted with brushed microfiber and polyester materials, this set is machine washable for your convenience.",
        						23,
        						0303,
        						71.76,
        						Item.Category.BED_AND_BATH);
        inventory[19] = new Item("SwissLux Decorator 28-inch Euro Square Pillows (Set of 2)",
        						"Update the look of your bedroom with the SwissLux decorator 28-inch euro square pillows. These pillows feature a soft 100-percent cotton construction with a plush polyester fill that provides hypoallergenic comfort.",
        						25,
        						0304,
        						29.96,
        						Item.Category.BED_AND_BATH);
        inventory[20] = new Item("Studio 707 50-pair Shoe Rack",
        						"Reduce clutter and free up space in your closet with this 50-pair shoe rack. Made from plastic and metal in a few stylish color options, this organizer shoe rack offers 10 rows to display and store shoes.",
        						7,
        						0400,
        						36.99,
        						Item.Category.HOME_IMPROVEMENT);
        inventory[21] = new Item("The Art of Storage 'Donatello' Leaning Bike Rack",
        						"Keep your bikes accessible but out of the way with this Donatello leaning bike rack from The Art of Storage. Designed to hold two bikes vertically stacked, this convenient rack provides secure storage for your bikes while taking up minimal floor space. The leaning design requires no installation, so you have the flexibility to move the rack wherever it fits best.",
        						4,
        						0401,
        						38.99,
        						Item.Category.HOME_IMPROVEMENT);
        inventory[22] = new Item("Seville Classics UltraZinc Expandable Closet Organizer",
        						"Ensure every item in your wardrobe has its place with the Seville Classics UltraZinc Expandable Closet Organizer. Useful inside a closet or as a standalone piece this organizer is constructed from steel-wire and supports up to 100 pounds per shelf.",
        						6,
        						0402,
        						128.99,
        						Item.Category.HOME_IMPROVEMENT);
        inventory[23] = new Item("Honeywell WiFi Smart Thermostat",
        						"Update the heating and cooling systems in your home with this wi-fi compatible smart thermostat from Honeywell. For your convenience the thermostat can be controlled from a computer smartphone or tablet.",
        						20,
        						0403,
        						176.99,
        						Item.Category.HOME_IMPROVEMENT);
        inventory[24] = new Item("Trades Pro 1400W/1600W Gas Generator - 838016",
        						"Product Details: MAX WATTAGE: 1600 MAX WATTAGE RUNNNING: 1400 ENGINE: 98CC OHV 4 Stroke 2.8hp FUEL TANK: 1.85 Gal (7 liter) DUPLEX OUTLETS: 1 x 120V (11A)Cigarette lighter style) Outlet: 1 x 12V (8.3A) WARRANTY: 1 Year Limited Purchase Includes: Portable Generator PLEASE NOTE: This unit is 49 state carb approved. Since this item is not carb approved by the state of California it cannot be used or purchased in California.",
        						2,
        						0404,
        						254.95,
        						Item.Category.HOME_IMPROVEMENT);
        inventory[25] = new Item("Steel Bookshelf-style Kitchen Rack",
        						"Update and organize your kitchen with this bookshelf-style kitchen rack. Crafted from heavy gauge steel with a durable lacquered finish in your choice of colors the rack is simple but elegant. The gird-style shelf mounts to the wall using sturdy brackets and the twelve included hooks make it easy to hang your pots and pans for easy access.",
        						4,
        						0500,
        						65.49,
        						Item.Category.KITCHEN);
        inventory[26] = new Item("Gotham Steel Non-stick Ti Cerama 10 Piece Cookware Set",
        						"The ultimate collection for all your food preparation needs. the Gotham Ti Cerama cookware set is made from premium steel with a rich titanium ceramic non-stick coating. This incredible ten-piece assortment includes two frying pans three sauce pans with lids and an aluminum steamer insert. This set is dishwasher safe and easy to maintain and keep clean.",
        						9,
        						0501,
        						105.99,
        						Item.Category.KITCHEN);
        inventory[27] = new Item("Keurig K130 DeskPro Coffee Maker",
        						"Be energized on the go with this is the coffee maker that brews an 8-ounce cup in under three minutes. Simply add water into the single-use reservoir choose your favorite K-Cup brew and enjoy. For the person who wants a quality cup of coffee brewed to your pecifications at work without the hassle of large cumbersome coffee makers; the sleek Keurig B130 DeskPro coffee maker is a dream come true. Individual servings mean you and anyone you share with no longer need to finish off the stale diluted office pot before getting a fresh cup. With the B130 nothing goes to waste.",
        						30,
        						0502,
        						76.99,
        						Item.Category.KITCHEN);
        inventory[28] = new Item("Cuisinart C77SS-17P Artiste Collection 17-piece Stainless Steel Knife Block Set",
        						"Slice with style and functionality with this 17-piece stainless steel knife block set. Featuring precision-stamped high-carbon stainless steel blades these knives can cut through anything for your culinary creations. The ergonomic stainless steel handles provide comfortable stability and control. The bright stainless steel design adds an attractive flair to any kitchen's decor.",
        						6,
        						0503,
        						64.99,
        						Item.Category.KITCHEN);
        inventory[29] = new Item("KitchenAid Black 17-piece Kitchen Tool and Gadget Set",
        						"Make easy work of everyday kitchen tasks with the KitchenAid Black 17-piece Kitchen Tool and Gadget Set. This set features a durable nylon construction that ensures years of lasting use. Dishwasher safe and heat resistant up to 450 degrees Fahrenheit. This set is a must-have for your kitchen.",
        						5,
        						0504,
        						49.49,
        						Item.Category.KITCHEN);
        inventory[30] = new Item("Outsunny Outdoor Metal Garden Storage Shed",
        						"Easily add storage space and value to your property with an outdoor garden shed from Outsunny. An Outsunny metal shed has distinct advantages over traditional wooden models that make it a much more attractive choice for purchase. It all comes down to affordability and durability. A metal shed is more affordable and being pre-fabricated significantly cuts down on expenses relating to materials and labor.",
        						2,
        						0600,
        						291.99,
        						Item.Category.OUTDOOR);
        inventory[31] = new Item("Blue Max 20-inch 51.5cc Gas Chainsaw",
        						"The Bluemax 51.5cc 20-inch Gasoline Chain saw has adjustable Auto Chain Oiler and easy chain adjustment, it offers a quick stop chain brake system with anti-kick back chain and an effective anti-vibration design. This Blue Max 20-inch chainsaw's Eco Boost engine gives lower emissions and increased power and reduced fuel consumption plus has a modern and professional design.",
        						10,
        						0601,
        						168.99,
        						Item.Category.OUTDOOR);
        inventory[32] = new Item("Super Jumper 14-foot Trampoline Combo With Safety Net",
        						"Encourage adventure in a safe setting with this trampoline combo complete with a safety net. Stay in shape while showing off your flips and balance with this trampoline designed for ages 10 and up.",
        						5,
        						0602,
        						230.77,
        						Item.Category.OUTDOOR);
        inventory[33] = new Item("Goplus Portable Inflatable Bubble Massage Spa Hot Tub 4 Person Relaxing Outdoor",
        						"The Goplus Bubble Massage Spa provides simple maintenance with an easy-to-replace filter cartridges for lasting enjoyment for up to four people. An inflation hose is included for easy inflation. The Bubble Massage Spa allows you to pamper yourself in relaxing heated water surrounded by soothing bubble jets. The easy-to-use control panel on this garden hot tub activates the 130 high-powered bubble jets surrounding the interior of the spa for a refreshing massage. The built-in hard water treatment system makes water gentler on skin for a soothing experience.",
        						1,
        						0603,
        						395.99,
        						Item.Category.OUTDOOR);
        inventory[34] = new Item("Backyard Discovery Prairie Ridge Playset",
        						"Bringing a landscape of rolling hills and green pastures the Prairie Ridge swing set offers both peaceful and energizing activities for your playful backyard brood. They'll have hours of healthy climbing fun ascending to the covered upper deck on either the standard ladder or propelling on the monkey bars. Enjoy plenty of playhouse valley views out of both the upper observation window and snack window below.",
        						3,
        						0604,
        						697.99,
        						Item.Category.OUTDOOR);


        System.out.printf(inventory[0].toCSVFormat());

    }

}

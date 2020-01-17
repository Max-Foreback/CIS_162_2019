
/**
 * Tests class Concert
 *
 * @author Max Foreback
 * @version 10-15-19
 */
public class ConcertTest
{
    public static void main(String args[]){
        System.out.println("Testing starts");
        int errors = 0;

        // instantiating a concert 
        Concert c1 = new Concert(10,19,2019, 
                "Keith Urban & Kelsea Ballerini",
                "Van Andel Arena");

        // buy 10 tickets in the floor section
        c1.buyTickets ('F', 10, 1800.00);
        if(c1.getTotalSales() != 1800.00){
            errors++;
            System.out.println("ERROR: Total Sales should be 1800.00");
        }

        // the floor tickets available should be 390 
        if(c1.getAvailableFloorTickets() != 390){
            errors++;
            System.out.println("ERROR: available floor tickets should be 390");
        }

        // buy 1 ticket in the floor section
        // testing errors in input parameters
        c1.buyTickets ('F', -1, 180.0);
        if(c1.getTotalSales() != 1800.0){
            errors++;
            System.out.println("ERROR: Total Sales should be 1800.0");
        }

        // invoking the method to simulate a company buying 50
        // individual tickets in random sections
        c1.simulateCompanyBuyingTickets(50);

        // invoking the report method
        c1.printReport();

        //Begin second concert
        Concert c2 = new Concert(4,17,2013, 
                "Taylor Swift",
                "My Backyard");

        // buy 3 tickets in the upper section
        c2.buyTickets ('U', 3, 89.70);
        if(c2.getTotalSales() != 89.69999999999999){
            errors++;
            System.out.println("ERROR: Total Sales should be 89.70");
            System.out.println(c2.getTotalSales());
        }

        // the floor tickets available should be 297 
        if(c2.getAvailableUpperTickets() != 297){
            errors++;
            System.out.println("ERROR: available floor tickets should be 297");
        }

        // buy 1 ticket in the floor section
        // testing errors in input parameters
        c2.buyTickets ('F', -1, 180.0);
        if(c2.getTotalSales() != 89.69999999999999){
            errors++;
            System.out.println("ERROR: Total Sales should be 89.70");
        }

        // invoking the method to simulate a company buying 126
        // individual tickets in random sections
        c2.simulateCompanyBuyingTickets(126);

        // invoking the report method
        c2.printReport();

        //Third concert

        // instantiating a concert 
        Concert c3 = new Concert(2,22,1998, 
                "Babe Ruth",
                "McDonald's");

        // buy 20 tickets in the lower section
        c3.buyTickets ('L', 20, 1980.00);
        if(c3.getTotalSales() != 1980.00){
            errors++;
            System.out.println("ERROR: Total Sales should be 1980.00");
            System.out.println(c3.getTotalSales());
        }

        // the lower tickets available should be 280 
        if(c3.getAvailableLowerTickets() != 280){
            errors++;
            System.out.println("ERROR: available lower tickets should be 280");
        }

        // buy 1 ticket in the upper section
        // testing errors in input parameters
        c3.buyTickets ('U', -1, 180.0);
        if(c3.getTotalSales() != 1980.0){
            errors++;
            System.out.println("ERROR: Total Sales should be 1980.0");
        }

        if(c3.getAvailableUpperTickets() != 300){
            errors++;
            System.out.println("ERROR: available upper tickets should be 300");
        }
        if(c3.getAvailableFloorTickets() != 400){
            errors++;
            System.out.println("ERROR: available floor tickets should be 400");
        }
        // invoking the method to simulate a company buying 400
        // individual tickets in random sections
        c3.simulateCompanyBuyingTickets(400);

        // invoking the report method
        c3.printReport();

        if (c3.getVenue() != "McDonald's"){
            System.out.println("Venue should be McDonald's");
            errors ++;
        }
        if (c3.getArtist() != "Babe Ruth"){
            System.out.println("Artist should be Babe Ruth");
            errors ++;
        }

        System.out.println("Date formatted: " + c3.formatDate(1));
        System.out.println("");
        System.out.println("Date formatted differently: " + c3.formatDate(3));
        System.out.println("");
        System.out.println("Testing Complete. Number of errors: " + errors);
        if (errors == 0){
            System.out.print("If you're seeing this, all behind the scenes");
            System.out.println(" test statements have passed. No errors!");
        }
    }

}

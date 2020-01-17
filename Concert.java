import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
/**
 * Performs various operations about a concert
 *
 * @author (Max Foreback)
 * @version (10-9-19)
 */
public class Concert
{
    private int day;
    private int month;
    private int year;
    private String artistName;
    private String venue;
    private int availableUpperTickets;
    private int availableLowerTickets;
    private int availableFloorTickets;
    private double totalSales;

    /** ticket prices for the different sections */
    private static final double PRICE_UPPER_TICKET = 29.90;
    private static final double PRICE_LOWER_TICKET = 99.0;
    private static final double PRICE_FLOOR_TICKET = 180.0;

    /** total number of tickets per section */
    private static final int TOTAL_NUMBER_UPPER_TICKETS= 300;
    private static final int TOTAL_NUMBER_LOWER_TICKETS= 300;
    private static final int TOTAL_NUMBER_FLOOR_TICKETS= 400;

    public Concert() { 
        month = 9;
        day = 8;
        year = 2019;
        artistName = "Jonas Brothers";
        venue = "Van Andel Arena";
        totalSales = 0.0;
        availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;
        availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
    }

    public Concert (int m, int d, int y, String a, String v) {
        if (isDateValid(m, d, y) == true){
            month = m;
            day = d;
            year = y;
        } else System.out.print("Please enter a valid date.");
        artistName = a;
        venue = v;
        totalSales = 0.0;
        availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;
        availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
        //sets all the other instance variables 
        //the same way it was done on the default constructor.
    }

    public String getArtist(){
        return artistName;
    }

    public String getVenue(){
        return venue;
    }

    public double getTicketPrice(char ticketType){
        if (ticketType == 'U')
            return PRICE_UPPER_TICKET;
        else if (ticketType == 'L')
            return PRICE_LOWER_TICKET;
        else if (ticketType == 'F')
            return PRICE_FLOOR_TICKET;
        else return 0.0;
    }

    public int getAvailableUpperTickets(){
        return availableUpperTickets;
    }

    public int getAvailableLowerTickets(){
        return availableLowerTickets;
    }

    public int getAvailableFloorTickets(){
        return availableFloorTickets;
    }

    public double getTotalSales(){
        return totalSales;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public void setArtist(String n) {
        artistName = n;
    }

    public void setVenue(String n) {
        venue = n;
    }

    public void setDate(int m, int d, int years) {
        if (isDateValid(m, d, years) == true) {
            day = d;
            month = m;
            year = years;
        } else System.out.println("Date invalid.");
    }

    public void parseDate(String date) {
        int firstSlash = date.indexOf("/");
        month = Integer.parseInt (date.substring(0, firstSlash));
        int secondSlash = date.indexOf ("/", date.indexOf("/") + 1);
        day = Integer.parseInt (date.substring (firstSlash + 1, secondSlash));
        year = Integer.parseInt (date.substring (secondSlash + 1));
        if (isDateValid(month, day, year) == false) {
            System.out.print("Invalid Date");
            month = 0;
            day = 0;
            year = 0000;
        }
    }

    public Concert (String date, String a, String v) {
        artistName = a;
        venue = v;
        parseDate (date);
        totalSales = 0.0;
        availableUpperTickets = TOTAL_NUMBER_UPPER_TICKETS;
        availableLowerTickets = TOTAL_NUMBER_LOWER_TICKETS;
        availableFloorTickets = TOTAL_NUMBER_FLOOR_TICKETS;
    }

    public void buyTickets(char ticketType, int numTickets, double pmt) {
        double due = 0.0;
        if (ticketType == 'U'){
            due = numTickets * PRICE_UPPER_TICKET;
            if (numTickets <= availableUpperTickets && pmt >= due && numTickets >= 0) {
                availableUpperTickets = availableUpperTickets - numTickets;
                totalSales = totalSales + due;
            }
            else if (numTickets >= availableUpperTickets) {
                System.out.println("Not enough tickets left in the Upper section for this purchase.");
            }
            else if (due >= pmt) {
                System.out.println("Insufficient funds for this purchase.");
            }
        }
        if (ticketType == 'L'){
            due = numTickets * PRICE_LOWER_TICKET;
            if (numTickets <= availableLowerTickets && pmt >= due && numTickets >= 0) {
                availableLowerTickets = availableLowerTickets - numTickets;
                totalSales = totalSales + due;
            }
            else if (numTickets >= availableLowerTickets) {
                System.out.println("Not enough tickets left in the Lower section for this purchase.");
            }
            else if (due >= pmt) {
                System.out.println("Insufficient funds for this purchase.");
            }
        }
        if (ticketType == 'F'){
            due = numTickets * PRICE_FLOOR_TICKET;
            if (numTickets <= availableFloorTickets && pmt >= due && numTickets >= 0) {
                availableFloorTickets = availableFloorTickets - numTickets;
                totalSales = totalSales + due;
            }
            else if (numTickets >= availableFloorTickets) {
                System.out.println("Not enough tickets left in the Floor section for this purchase.");
            }
            else if (due >= pmt) {
                System.out.println("Insufficient funds for this purchase.");
            }
        }
        
    }

    public void printReport() {
        int upperSold = TOTAL_NUMBER_UPPER_TICKETS - availableUpperTickets;
        int lowerSold = TOTAL_NUMBER_LOWER_TICKETS - availableLowerTickets;
        int floorSold = TOTAL_NUMBER_FLOOR_TICKETS - availableFloorTickets;
        DecimalFormat dft = new DecimalFormat();

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Concert Report");
        System.out.println("====================");
        System.out.println("Artist:       " + artistName);
        System.out.println("Venue:        " + venue);
        System.out.println("Date:         " + formatDate(3));
        System.out.println("");
        System.out.println("Tickets sold");
        System.out.println("====================");
        System.out.print("Upper: " + upperSold);
        System.out.println("      "+ currency.format(upperSold * PRICE_UPPER_TICKET));
        System.out.print("Lower: " + lowerSold);
        System.out.println("      "+ currency.format(lowerSold * PRICE_LOWER_TICKET));
        System.out.print("Floor: " + floorSold);
        System.out.println("      "+ currency.format(floorSold * PRICE_FLOOR_TICKET));
        System.out.println("====================");
        System.out.println("Total sales: $" + dft.format(totalSales));

    }

    private boolean isLeapYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            return true;
        } else  return false;
    }

    private boolean isDateValid (int m, int d, int y) {
        if (m < 1 || m > 12)
            return false;
        if (y < 0)
            return false;

        switch (m) {
            case 1:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 2:
            if (isLeapYear(y) == true) {
                if (d >= 1 && d <= 29)
                    return true;
                else return false;
            }
            else {
                if (d >= 1 && d <= 28)
                    return true;
                else return false;
            }
            case 3:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 4:
            if (d >= 1 && d <= 30)
                return true;
            else return false;
            case 5:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 6:
            if (d >= 1 && d <= 30)
                return true;
            else return false;
            case 7:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 8:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 9:
            if (d >= 1 && d <= 30)
                return true;
            else return false;
            case 10:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            case 11:
            if (d >= 1 && d <= 30)
                return true;
            else return false;
            case 12:
            if (d >= 1 && d <= 31)
                return true;
            else return false;
            default : return false;
        }
    }

    public void simulateCompanyBuyingTickets(int numberTickets) {
        Random rand = new Random();

        char ticketType = 'E';
        double pmt = 0.0;
        for(int i = 1; i <= numberTickets; i++){
            int ticketSect = rand.nextInt(3);
            if (ticketSect == 0){
                ticketType = 'U';
                pmt = PRICE_UPPER_TICKET;
            }
            if (ticketSect == 1){
                ticketType = 'L';
                pmt = PRICE_LOWER_TICKET;
            }
            if (ticketSect == 2){
                ticketType = 'F';
                pmt = PRICE_FLOOR_TICKET;
            }
            buyTickets(ticketType, 1, pmt);
        }
    }

    public String formatDate(int format) {
        String form = "fixme";
        String fullmon = "helpme";
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        String lol = "" + day + "/" + month + "/" + year;
        if (format == 1)
            form = "" + day + "/" + month + "/" + year;
        if (format == 2)
            form = simpleDate.format(lol);
        if (format == 3) {
            String months = "JanFebMarAprMayJunJulAugSepOctNovDec";
            form = months.substring(month * 3 - 3,month * 3) + "/" + day + "/" + year;
        }
        if (format == 4) {
            switch(month) {
                case 1:
                fullmon = "January";
                break;
                case 2:
                fullmon = "February";
                break;
                case 3:
                fullmon = "March";
                break;
                case 4:
                fullmon = "April";
                break;
                case 5:
                fullmon = "May";
                break;
                case 6:
                fullmon = "June";
                break;
                case 7:
                fullmon = "July";
                break;
                case 8:
                fullmon = "August";
                break;
                case 9:
                fullmon = "September";
                break;
                case 10:
                fullmon = "October";
                break;
                case 11:
                fullmon = "November";
                break;
                case 12:
                fullmon = "December";
                break;
                default: fullmon = "-1";
                form = fullmon + " " + day + "," + year;
                break;
            }
        }
        return form;
    }

}


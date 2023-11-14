/** 
 * A class representing a cafe with methods to sell coffee and restock 
 * the supplies needed for basic coffee preperation.
 * */
public class Cafe extends Building {
    /** The number of ounces of coffee remaining in inventory */
    private int nCoffeeOunces;
    /** The number of sugar packets remaining in inventory */
    private int nSugarPackets;
    /** The number of "splashes" of cream remaining in inventory */
    private int nCreams;
    /** The number of cups remaining in inventory */
    private int nCups;

    /** Default Cafe constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Overloaded constructor to create a single-story cafe, the most common iteration
     */
    public Cafe(String name, String address) {
        this(name, address, 1);
    }

    /**
     * Creates a new Cafe object
     * @param name The name of the Cafe
     * @param address The address of the Cafe
     * @param nFloors The number of floors in the Cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 80;
        this.nCreams = 60;
        this.nCups = 50;
        System.out.println("You have built a cafe: " + this.name);
    }

    /**
     * Sells a cup of coffee and reduces the contents of the Cafe's inventory according to 
     * the specifications of the coffee sold and restocks inventory with a specific item 
     * when there is not enough for the specified coffee
     * @param size Number of ounces in the coffee to be sold
     * @param nSugarPackets Number of sugars in the specified coffee
     * @param nCreams Number of "splashes" of cream in the specified coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces >= size) {
            this.nCoffeeOunces -= size;
        } else {
            restock(200, 0, 0, 0);
            this.nCoffeeOunces -= size;
        }
        if (this.nSugarPackets >= nSugarPackets) {
            this.nSugarPackets -= nSugarPackets;
        } else {
            restock(0, 80, 0, 0);
            this.nSugarPackets -= nSugarPackets;
        }
        if (this.nCreams >= nCreams) {
            this.nCreams -= nCreams;
        } else {
            restock(0, 0, 60, 0);
            this.nCreams -= nCreams;
        }
        if (this.nCups > 0) {
            this.nCups -= 1;
        } else {
            restock(0, 0, 0, 50);
            this.nCups -= 1;
        }
    }

    /**
     * Overloaded sellCoffee() for easier ordering of a black coffee (with no sugar or cream)
     * @param size Number of ounces in the coffee to be sold
     */
    public void sellCoffee(int size) {
        this.sellCoffee(size, 0, 0);
    }

    /**
     * Restocks the Cafe's inventory
     * @param nCoffeeOunces Ounces of coffee to add to inventory
     * @param nSugarPackets Number of sugar packets to add to inventory
     * @param nCreams Number of "splashes" of cream to add to inventory
     * @param nCups Number of cups to add to inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Overridden goToFloor() method to account for the lack of a cafe elevator
     * @param floorNum Number of floor to go to
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException(this.name + " does not have an elevator.");
    }

    /** showOptions() method for Cafe objects */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(size, sugars, creams)");
    }

    /**
     * toString for a Cafe object
     */
    public String toString() {
        return ("The cafe '" + this.name + "' has " + this.nCoffeeOunces + " ounces of coffee, " 
            + this.nSugarPackets + " sugar packets, " + this.nCreams + " splashes of cream, and " 
            + nCups + " cups" );
    }

    /**
     * for testing
     * @param args
     */
    public static void main(String[] args) {
        Cafe ccCafe = new Cafe("CC Cafe", "1 Chapin Way", 1);
        System.out.println(ccCafe);
        ccCafe.sellCoffee(12, 2, 61);
        System.out.println(ccCafe);
        ccCafe.showOptions();
    }
    
}

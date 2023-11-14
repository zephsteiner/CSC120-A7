import java.util.ArrayList;
import java.util.Scanner;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Washburn House", "2 Seelye Drive Northampton MA 01063", 4, false, 45, false));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 5));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new House("Tyler House", "123 Green Street, Northampton, MA 01060", 5, true, 69, false));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Parking Garage", "54 West Street Northampton, MA 01060", 5));
        myMap.addBuilding(new Building("Lyman Plant House", "16 College Lane Northampton, MA 01063"));
        myMap.addBuilding(new Library("Josten Library", new Building("Mendenhall", "122 Green Street Northampton, MA 01063", 3)));
        myMap.addBuilding(new House("Dawes House", "8 Bedford Terrace Northampton, MA 01063"));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063"));
        System.out.println(myMap);

        // here's my vague attempt at the loop to explore buildings! 
        // it works successfully only for things created as buildings
        // and only if you don't do anything that would throw an exception
        // i'm sure i could get it to work better if i poked at it way longer though
        boolean go = true;
        Scanner input = new Scanner(System.in);
        while (go) {
            System.out.println("Welcome to campus! Type a building to explore:");
            for (Building b : myMap.buildings) {
                if (b.getName().equals(input.nextLine())) {
                    b.showOptions();
                    if (input.nextLine().equals("enter()")) {
                        b.enter();
                    }
                    if (input.nextLine().equals("exit()")) {
                        b.exit();
                        System.out.println("Keep going? y or n");
                        if (input.nextLine().equals("y")) {
                            System.out.println("Pick a new building to explore.");
                        }
                        else {
                            go = false;
                            System.out.println("Thanks for playing!");
                            // input.close();
                            break;
                        }
                    }
                    if (input.nextLine().equals("goUp()")) {
                        b.goUp();
                    }
                    if (input.nextLine().equals("goDown()")) {
                        b.goDown();
                    }
                    if (input.nextLine().contains("goToFloor")) {
                        System.out.println("What floor?");
                        b.goToFloor(input.nextInt());
                    }
                    // if (input.nextLine().contains("moveIn") && b instanceof House) {
                    //     System.out.println("Who?");
                    //     b.moveIn(input.nextLine());
                    // }
                }
            }
        }
        input.close();
    }
    
}

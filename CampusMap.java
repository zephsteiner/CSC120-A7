import java.util.ArrayList;

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
        myMap.addBuilding(new Library("Josten Library", "122 Green Street Northampton, MA 01063"));
        myMap.addBuilding(new House("Dawes House", "8 Bedford Terrace Northampton, MA 01063"));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063"));
        System.out.println(myMap);
    }
    
}

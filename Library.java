import java.util.Enumeration;
import java.util.Hashtable;

/** 
 * A class to represent a library with methods to modify  the collection 
 * and check books in and out as well as check the status of items.
 */
public class Library extends Building {

  /** The collection of items in the Library */
  private Hashtable<String, Boolean> collection;

  /**
   * Creates a new Library object
   * @param name The name of the Library
   * @param address The address of the Library
   * @param nFloors The number of floors in the Library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds an item to the collection if the specified title is not yet in the collection
   * @param title The title and author or creator of the item
   */
  public void addTitle(String title) {
    if (this.containsTitle(title)) {
      throw new RuntimeException(title + " is already in the collection");
    }
    this.collection.put(title,true);
  }

  /**
   * Removes an item from the Library's collection if found
   * @param title The item to remove
   * @return Message detailing what title was removed
   */
  public String removeTitle(String title) {
    if (!this.containsTitle(title)) {
      throw new RuntimeException(title + " not found");
    }
    this.collection.remove(title);
    return title + " removed from collection";
  }

  /**
   * Modifies an item's status to be checked out if it is not already
   * @param title The item to check out of the collection
   */
  public void checkOut(String title) {
    if (!this.containsTitle(title)) {
      throw new RuntimeException(title + " not found");
    }    
    if (!this.isAvailable(title)) {
      throw new RuntimeException(title + " is already checked out. Sorry!");
    }
    this.collection.replace(title, false);
  }

  /**
   * Modifies an item's status to be checked in if it is not already
   * @param title The item to return to the collection
   */
  public void returnBook(String title) {
    if (!this.containsTitle(title)) {
      throw new RuntimeException(title + " not found");
    }
    if (this.isAvailable(title)) {
      throw new RuntimeException(title + " is already checked in");
    }
    this.collection.replace(title, true);
  }

  /**
   * Checks if the Library's collection contains an item
   * @param title The item to check for
   * @return True if the title appears as a key in the Libary's collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Checks if an item in the Library's collection is available
   * @param title The item to check the status of
   * @return True if the title is currently available, false otherwise
   */
  public boolean isAvailable(String title) {
    if (!this.containsTitle(title)) {
      throw new RuntimeException(title + " not found");
    }    
    return this.collection.get(title);
  } 

  /**
   * Prints out the Library's entire collection in an easy-to-read way (including checkout status)
   */
  public void printCollection() {
    Enumeration<String> titles = this.collection.keys();
    while (titles.hasMoreElements()) {
      String title = titles.nextElement();
      if (this.collection.get(title) == true) {
        System.out.println(title + " is checked in.");
      } 
      if (this.collection.get(title) == false) {
        System.out.println(title + " is checked out.");
      }
    }

  }
  
  /**
   * for testing
   * @param args
   */
  public static void main(String[] args) {
    Library l = new Library("Neilson", "1 Neilson Dr", 4);
    l.addTitle("Eugene Onegin by Alexander Pushkin");
    l.printCollection();
    l.checkOut("Eugene Onegin by Alexander Pushkin");
    l.printCollection();
    l.returnBook("Eugene Onegin by Alexander Pushkin");
    l.printCollection();
    l.removeTitle("Eugene Onegin by Alexander Pushkin");
    l.addTitle("Ancillary Justice by Ann Leckie");
    l.printCollection();
    try {
      l.checkOut("Eugene Onegin by Alexander Pushkin");
    } catch (Exception e) {
      System.out.println("not there :(");
    }
    l.printCollection();
  }
  
}
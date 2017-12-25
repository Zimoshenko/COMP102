import ecs100.*;    import java.util.*;

/**
 * Write a description of class ToDoList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToDo{
    // instance variables - replace the example below with your own
    private ArrayList<String> allItems = new ArrayList<String>();
    public ToDo(){
       UI.initialise();
       UI.addButton("New", this::newList);
       UI.addTextField("Add", this::addItem);
       UI.addButton("List", this::displayList);
       UI.addTextField("Contains", this::doContains);
       UI.addTextField("Remove", this::doRemove);
       UI.addButton("Quit", UI::quit);

      /**
       * Constructor for objects of class ToDoList
       */
    }
    public void newList(){
        this.allItems = new ArrayList<String>();
        // or:   this.allItems.clear();
        this.displayList();
      }
      public void addItem(String item){
        this.allItems.add(item);
        this.displayList();
    }
    
    public void displayList(){
        UI.clearText();
        UI.printf("List has %d items:\n", this.allItems.size());
        for (String item : allItems){
           UI.println(item);
        }	    
      }
    public void doContains(String item){
        if (this.allItems.contains(item)){
            UI.println(item+"  is in the list");
        }
        else {
            UI.println(item+" is not in the list");
        }
    }
    public void doRemove(String item){
        if (this.allItems.remove(item)) {
            UI.println(item+" was removed");
        }
        else {
            UI.println(item+" was not present");
        }
    }

  
   }
      /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */





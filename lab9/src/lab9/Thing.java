package lab9;

import java.util.ArrayList;

/**
 * A Thing represents something that could either be a birthday present,
 * or it could be a box containing more Thing objects.
 */
public class Thing
{
  /**
   * Contents of this thing, if it's a box.
   */
  private ArrayList<Thing> contents;
  
  /**
   * True if this thing is a present, false if it's a box.
   */
  private boolean isPresent;
  
  /**
   * String description of this thing, if it's a present.
   */
  private String description;
  
  /**
   * Constructs a thing that is a present with the given description.
   * @param givenDescription
   */
  public Thing(String givenDescription)
  {
    description = givenDescription;
    isPresent = true;
    contents = null;
  }
  
  /**
   * Constructs a thing that is an empty box.
   */
  public Thing()
  {
    description = "box!";
    isPresent = false;
    contents = new ArrayList<Thing>();
  }
  
  /**
   * Adds a thing to this thing's contents.  This thing must
   * be a box for this to work.
   * @param t
   */
  public void addThing(Thing t)
  {
    contents.add(t);
  }
  
  /**
   * Returns true if this thing is a present, false if it's a box.
   * @return
   */
  public boolean isPresent()
  {
    return isPresent;
  }
  
  /**
   * Returns a list of the contents of this thing, or null if
   * it's not a box.
   * @return
   */
  public ArrayList<Thing> getContents()
  {
    return contents;
  }
  
  /**
   * Returns the description of this thing.
   * @return
   */
  public String getDescription()
  {
    return description;
  }
  
  /**
 * @param thing
 */
public static void listAllPresents(Thing thing)
  {
    if(thing.isPresent()){
    	System.out.println(thing.getDescription());
    }else{
    	ArrayList<Thing> subthing = new ArrayList<Thing>();
    	subthing = thing.getContents();
    	for(int i=0; i < subthing.size(); i ++){
    		if(subthing.get(i).isPresent()){
    			System.out.println(subthing.get(i).getDescription());
    		}else{
    			listAllPresents(subthing.get(i));
    		}
    	}   	
    }
  }

public static void main(String[] args){
	Thing gift = new Thing();
	Thing gift1 = new Thing();
	Thing gift2 = new Thing();
	Thing gift3 = new Thing();
	Thing gift4 = new Thing("Banana");
	Thing gift5 = new Thing("Coal");
	Thing gift6 = new Thing("Tofu");
	Thing gift7 = new Thing("XboxOne");
	gift.addThing(gift1);
	gift1.addThing(gift4);
	gift1.addThing(gift5);
	gift.addThing(gift2);
	gift2.addThing(gift6);
	gift.addThing(gift3);
	gift3.addThing(gift7);
	listAllPresents(gift);
}
}
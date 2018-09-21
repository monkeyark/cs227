package lab9;
import java.io.File;
import java.util.ArrayList;

/**
 * Nonrecursive version of the file lister example.
 */
public class FileListerNonRecursive
{
  
  public static void main(String[] args)
  {
    // Choose the directory you want to list.
    // If running in Eclipse, "." will just be the current project directory.
    // Use ".." to list the whole workspace directory, or enter a path to
    // some other directory.
    File rootDirectory = new File(".");
    
    listAllFiles(rootDirectory);
  }
  
  /**
   * Nonrecursive version of the file lister example.  Instead of using
   * recursion, we put directories that are not fully processed onto a
   * "things to do" list to keep track of what still needs to be done.
   * @param f
   */
  public static void listAllFiles(File f)
  {
    // The to-do list.  Each "thing to do" is a File object along
    // with an integer index to keep track of which items in the 
    // directory have been explored.
    ArrayList<ThingToDo> list = new ArrayList<>();

    // initialization puts the root directory on the list
    if (!f.isDirectory())
    {
      String theName = f.getName();
      System.out.println(theName);
    }
    else
    {
      // the -1 indicates we haven't started processing the array of children yet
      list.add(new ThingToDo(f, -1));
      System.out.println("--> " + f.getName());
    }
    
    // last element on list is the task to do next
    while(!list.isEmpty())
    {
      // task to do now
      ThingToDo current = list.get(list.size() - 1);
      int index = current.getIndex();
      File[] arr = current.getFile().listFiles();
      
      // if we reached the end of the File's array of children, then remove
      // this task from the list
      if (index == arr.length - 1)
      {
        list.remove(list.size() - 1);
      }
      else
      {
        // otherwise, go on to next item
        index += 1;
        current.setIndex(index);
        
        File g = arr[index];       
        if (!g.isDirectory())
        {
          System.out.println(g.getName());
        }
        else
        {
          // it's a directory, add it to the list of things to do
          list.add(new ThingToDo(g, -1));
          System.out.println("--> " + g.getName());
        }
      }
    }
  }
  
}

/**
 * Simple data container for storing a File object along with an index.
 */
class ThingToDo
{
  private File savedFile;
  private int savedIndex;
  
  public ThingToDo(File file, int index)
  {
    savedFile = file;
    savedIndex = index;
  }
  
  public File getFile()
  {
    return savedFile;
  }
  
  public int getIndex()
  {
    return savedIndex;
  }
  
  public void setIndex(int index)
  {
    savedIndex = index;
  }
}

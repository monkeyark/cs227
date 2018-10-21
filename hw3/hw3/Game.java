package hw3;
import java.util.ArrayList;
import api.GridPosition;
import api.Jewel;

/**
 * 
 * Implementation of a simple version of the game Bejeweled.
 * 
 */
public class Game
{
	private Jewel[][] myGrid;
	private JewelFactory generator;
	private int score;
	
	/**
	 * Constructs a game with the given number of columns and rows that will use
	 * the given JewelFactory instance to create new jewels. The grid is initialized
	 * according to the factory's createGrid method.
	 * @param width
	 * 		number of columns
	 * @param height
	 * 		number of rows
	 * @param generator
	 * 		generator for new jewels
	 */
	public Game(int width, int height, JewelFactory generator)
	{
		myGrid = generator.createGrid(width,height);
		this.generator = generator;
		score = 0;
	}
	
	/**
	 * Constructs a game whose size and initial configuration are determined by
	 * the given string array and that will use the given JewelFactory instance
	 * to create new jewels. Each string in the given array consists of whitespace-separated
	 * integers corresponding to the initial jewel type for each cell.
	 * @param descriptor
	 * 		array of strings
	 * @param generator
	 * 		generator for new jewels
	 */
	public Game(java.lang.String[] descriptor, JewelFactory generator)
	{
		myGrid = Util.createFromStringArray(descriptor);
		this.generator = generator;
		score = 0;
	}
	
	/**
	 * Returns the Jewel at the given row and column.
	 * @param row
	 * 		given row in the grid
	 * @param col
	 * 		given column in the grid
	 * @return
	 * 		Jewel at the given row and column
	 */
	public Jewel getJewel(int row, int col)
	{
		return myGrid[row][col];
	}
	
	/**
	 * Sets the Jewel at the given row and column.
	 * @param row
	 * 		given row in the grid
	 * @param col
	 * 		given column in the grid
	 * @param jewel
	 * 		value to be set
	 */
	public void setJewel(int row, int col, Jewel jewel)
	{
		myGrid[row][col] = jewel;
	}
	
	/**
	 * Returns the height of the grid for this game (number of rows).
	 * @return
	 * 		number of rows in the grid for this game
	 */
	public int getWidth()
	{
		return myGrid[0].length;
	}
	
	/**
	 * Returns the height of the grid for this game (number of rows).
	 * @return
	 * 		number of rows in the grid for this game
	 */
	public int getHeight()
	{
		return myGrid.length;
	}
	
	/**
	 * Returns the current score for this game.
	 * @return
	 * 		current score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Returns a copy of the given row of the grid.
	 * @param row
	 * 		given row
	 * @return
	 * 		a new array containing the Jewels from the given row
	 */
	public Jewel[] getRow(int row)
	{
//		//deep copy
//		Jewel[] rows = new Jewel[myGrid[0].length];
//		for (int i=0; i<myGrid[0].length; i++)
//		{
//			rows[i] = myGrid[row][i];
//		}
//		return rows;
		return myGrid[row];
	}
	
	/**
	 * Copies the given array values into the specified row of the grid.
	 * @param row
	 * 		given row
	 * @param arr
	 * 		array of Jewel containing the values for the row
	 */
	public void setRow(int row, Jewel[] arr)
	{
//		for (int i=0; i<arr.length; i++)
//		{
//			myGrid[row][i] = arr[i];
//		}
		myGrid[row] = arr;
	}
	
	/**
	 * Returns a copy of the given column of the grid.
	 * @param col
	 * 		given col
	 * @return
	 * 		a new array containing the Jewels from the given col
	 */
	public Jewel[] getCol(int col)
	{
		Jewel[] cols = new Jewel[myGrid.length];
		for (int i=0; i<myGrid.length; i++)
		{
			cols[i] = myGrid[i][col];
		}
		return cols;
	}
	
	/**
	 * Copies the given array values into the specified column of the grid. given array.
	 * @param col
	 * 		given col
	 * @param arr
	 * 		array of Jewel containing the values for the column
	 */
	public void setCol(int col, Jewel[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			myGrid[i][col] = arr[i];
		}
	}
	
	/**
	 * Exchanges the Jewels described by the given GridPositions, if possible.
	 * The caller is responsible for ensuring that the given positions are
	 * horizontally or vertically adjacent. The exchange is allowed only if one of
	 * the affected cells forms part of a run after the jewels are swapped.
	 * If so, the jewels for the two cells are exchanged and the method returns true;
	 * otherwise, the method returns false. No other aspects of the game state are modified.
	 * (Note that only the row and column of the given GridPositions are used; the Jewel attribute is ignored.)
	 * @param c0
	 * 		grid position
	 * @param c1
	 * 		grid position adjacent to c0
	 * @return
	 * 		true if the two given cells are exchanged, false otherwise
	 */
	public boolean select(GridPosition c0, GridPosition c1)
	{
		Jewel tempGrid = myGrid[c0.row()][c0.col()];
		myGrid[c0.row()][c0.col()] = myGrid[c1.row()][c1.col()];
		myGrid[c1.row()][c1.col()] = tempGrid;
		if (findHorizontalRuns(c0.row()).isEmpty()
				&& findVerticalRuns(c0.col()).isEmpty()
				&& findHorizontalRuns(c1.row()).isEmpty()
				&& findVerticalRuns(c1.col()).isEmpty())
		{
			//change the c0 and c1 back to original
			tempGrid = myGrid[c0.row()][c0.col()];
			myGrid[c0.row()][c0.col()] = myGrid[c1.row()][c1.col()];
			myGrid[c1.row()][c1.col()] = tempGrid;
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Finds runs in the given row of the grid using the method Util.findRuns
	 * The return value is a list containing a GridPosition object for each cell
	 * that is part of a run, in left-to-right order.
	 * This method does not modify the grid or update the score.
	 * @param row
	 * 		the row in which to find runs
	 * @return
	 * 		list of GridPosition objects for cells that are part of a run
	 */
	public java.util.ArrayList<GridPosition> findHorizontalRuns(int row)
	{
		ArrayList<GridPosition> horizontalRuns = new ArrayList<GridPosition>();
		for(int i=0; i<Util.findRuns(getRow(row)).size(); i++)
		{
			horizontalRuns.add(new GridPosition(row, Util.findRuns(getRow(row)).get(i), getRow(row)[Util.findRuns(getRow(row)).get(i)]));
		}
		return horizontalRuns;
	}
	
	/**
	 * Finds runs in the given column of the grid using the method Util.findRuns
	 * The return value is a list containing a GridPosition object for each cell
	 * that is part of a run, in top-to-bottom order.
	 * This method does not modify the grid or update the score.
	 * @param col
	 * 		the column in which to find runs
	 * @return
	 * 		list of GridPosition objects for cells that are part of a run
	 */
	public java.util.ArrayList<GridPosition> findVerticalRuns(int col)
	{
		ArrayList<GridPosition> verticalRuns = new ArrayList<GridPosition>();
		for(int i=0; i<Util.findRuns(getCol(col)).size(); i++)
		{
			verticalRuns.add(new GridPosition(Util.findRuns(getCol(col)).get(i), col, getCol(col)[Util.findRuns(getCol(col)).get(i)]));
		}
		return verticalRuns;
	}
	
	/**
	 * Finds all horizontal and vertical runs, and returns a list containing a GridPosition object
	 * for all cells that are part of a run. The list is in no particular order and may contain duplicates.
	 * All grid positions that are part of a run are set to null in the grid, and the score is updated.
	 * @return
	 * 		list of GridPosition objects for all cells that are part of a run
	 */
	public java.util.ArrayList<GridPosition> findAndMarkAllRuns()
	{
		ArrayList<GridPosition> findMarkRuns = new ArrayList<GridPosition>();
		for (int i=0; i<getHeight(); i++)
		{
			findMarkRuns.addAll(findHorizontalRuns(i));
		}
		for (int i=0; i<getWidth(); i++)
		{
			findMarkRuns.addAll(findVerticalRuns(i));
		}
		score+=findMarkRuns.size();//update score
		for (int i=0; i<findMarkRuns.size(); i++)
		{
			myGrid[findMarkRuns.get(i).row()][findMarkRuns.get(i).col()] = null;
		}
		return findMarkRuns;
	}
	
	/**
	 * Shifts the Jewels in a given column downward using the method Util.shiftNonNullElements.
	 * After executing this method the null cells, if any, are at the top of the column.
	 * The order of the Jewels is not changed. The return value is a list containing a GridPosition object
	 * for each Jewel that was moved by this operation.
	 * The GridPosition's row and column should be the position of the moved Jewel when the operation completes.
	 * @param col
	 * 		the given column
	 * @return
	 * 		list of GridPosition objects for elements that are moved
	 */
	public java.util.ArrayList<GridPosition> shiftColumnDown(int col)
	{
		Jewel[] column = getCol(col);
		ArrayList<GridPosition> shiftedColumn = new ArrayList<GridPosition>();
		ArrayList<Integer> shifted = Util.shiftNonNullElements(column);
		setCol(col, column);//mutate col to array with shifted null
		for (int i=0; i<shifted.size(); i++)
		{
			shiftedColumn.add(new GridPosition(shifted.get(i), col, getJewel(shifted.get(i), col)));
		}
		return shiftedColumn;
	}
	
	/**
	 * Replaces each null cell in the grid with a new Jewel created by a call to this Game's JewelFactory.
	 * The return value is a list containing a GridPosition object for each newly assigned cell.
	 * @return
	 * 		list of GridPosition objects for the filled cells
	 */
	public java.util.ArrayList<GridPosition> fillAll()
	{
		ArrayList<GridPosition> fill = new ArrayList<GridPosition>();

		for (int row=0; row<getHeight(); row++)
		{
			for (int col=0; col<getWidth(); col++)
			{
				if (myGrid[row][col] == null)
				{
					myGrid[row][col] = generator.generate();
					fill.add(new GridPosition(row, col, myGrid[row][col]));
				}
			}
		}
		return fill;
	}
	
	/**
	 * Returns a String representation of the grid for this game, with rows delimited by newlines.
	 */
	public java.lang.String toString()
	{
		return Util.convertToString(myGrid);
	}
}
package examFinal;

import java.util.ArrayList;
import java.util.Random;

abstract class AbstractPlayer implements Q1_IPlayer
{
	private ArrayList<Integer> history = new ArrayList<Integer>();
	private Random rand = new Random();
	public int getPreviousMove(int movesAgo)
	{
		return history.get(history.size() - movesAgo);
	}
	public int play()
	{
		int move = getMove(); // randomly chooses 0, 1, or 2
		history.add(move);
		return move;
	}
	public int getRand(int r)
	{
		return rand.nextInt(r);
	}
	public abstract int getMove();
}

class RandomPlayer extends AbstractPlayer
{
	//private Random rand = new Random();
	public int getMove()
	{
		//return rand.nextInt(3);
		return super.getRand(3);
	}
}

class AlternatingPlayer extends AbstractPlayer
{
	//private Random rand = new Random();
	private int state = 0;
	public int getMove()
	{
		// usually returns 0, but every third move randomly chooses 1 or 2
		int move = 0;
		if (state % 3 == 2)
		{
			//move = rand.nextInt(2) + 1;
			move = super.getRand(2) + 1;
		}
		++state;
		return move;
	}
}

interface Q1_IPlayer
{
	int play(); // Returns the player's move, which is always 0, 1, or 2
	int getPreviousMove(int movesAgo); // Returns a previous move
}
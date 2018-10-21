package examFinal;

import java.util.ArrayList;

public class Q2_Picture
{
	private ArrayList<Shape> alist = new ArrayList<Shape>();
	
	public Q2_Picture()
	{
	}
	// adds a Shape to this Picture
	public void add(Shape s)
	{
		alist.add(s);
	}
	// finds the total area of all shapes in this Picture (zero if empty)
	public double findTotalArea()
	{
		double total = 0.0;
		for(Shape s : alist)
			total += s.getArea();
		return total;	
	}
}


interface Shape
{
	double getArea();
	void draw();
}
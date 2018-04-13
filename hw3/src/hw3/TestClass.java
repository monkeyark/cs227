package hw3;

import java.util.ArrayList;

import api.GridPosition;

public class TestClass {

	public static void main(String[] args) {
		
//		String[] desc=
//			{
//			"2 0 1 3",
//				"1 0 1 3",
//				"2 1 2 1"
//			};
//		JewelFactory generator=new JewelFactory(4);
//		System.out.println(generator.generate());
//		Jewel[][] a=generator.createGrid(4, 5);
//		Game g=new Game(desc, generator);
	//	System.out.println(g.toString());
		
		//test of getJewel
//		System.out.println(g.getJewel(2, 1));
//		g.setJewel(2, 1,new Jewel(3));
//		System.out.println(g.getJewel(2, 1));
//		g.setJewel(2, 1, null);
//		System.out.println(g.toString());
		
		//test of getRow and getCol
//		Jewel[] arr=g.getCol(0);
//		System.out.println(Arrays.toString(arr));
		
		//test of setRow
//		Jewel[] j=Util.createFromString("5 6 ");
//		g.setCol(1, j);
//		System.out.println(g);
		
//		Jewel[] test=Util.createFromString("4 2 2 2 2 2 2 1 3 3 2");
//		System.out.println(Arrays.toString(test));
//		ArrayList<Integer> result=Util.findRuns(test);
//		System.out.println(Arrays.toString(test));
//		System.out.println(result);
		
//		Jewel[] test1 = Util.createFromString("4 2 2 2 4 4 3 3 3 3 2");
//		ArrayList<Integer> result1 = Util.findRuns(test1);
//		System.out.println(result1); // expected [1, 2, 3, 6, 7, 8, 9]
//		System.out.println("------------------------");
		
//		String[] desc2= 
//			{
//			"1 2 3 2 4 4 3 4 3 3 2",
//			"1 2 3 4 5 1 2 3 4 5 1",
//			"1 2 3 4 5 1 2 3 4 5 1",
//			
//		};
//		
//		JewelFactory generator2=new JewelFactory(6);
//		Game g2=new Game(desc2, generator2);
//		ArrayList<GridPosition> result2=g2.findVerticalRuns(0);
//		System.out.println(result2);
//
//		String[] desc3= 
//				{
//				"3 3 3 1 0",
//				"3 0 1 0 1",
//				"2 2 3 2 0",
//				"0 2 1 2 1"
//			};
//		JewelFactory generator3=new JewelFactory(6);
//		Game g3=new Game(desc3, generator3);
//		ArrayList<GridPosition> result3=g3.findHorizontalRuns(0);
//		System.out.println(result3);
//		
//		//Test select
//		String[] desc4 =
//			{
//			"3 3 2 1 0",
//			"3 3 0 0 1",
//			"2 2 3 2 1",
//			"0 2 3 1 0"
//			};
//			JewelFactory generator4 = new JewelFactory(6);
//			Game g4 = new Game(desc4, generator4);
//			//ok to use null here since the jewel will be ignored
//			GridPosition c0 = new GridPosition(1, 1, null);
//			GridPosition c1 = new GridPosition(1, 2, null);
//			boolean ret = g4.select(c0, c1);
//			System.out.println(ret);
//			System.out.println(g4);
//		
//			
//			//Test findAndMarkAllRuns
//			String[] desc5= 
//				{
//				"1 2 3 2 4 4 3 4 3 3 2",
//				"1 2 3 4 5 1 2 3 4 5 1",
//				"1 2 3 4 5 1 2 3 4 5 1",
//				"1 3 4 4 5 1 2 3 4 5 1",
//				"1 3 4 3 5 1 2 3 4 5 1",
//				
//			};
//			
//			JewelFactory generator5=new JewelFactory(6);
//			Game g5=new Game(desc5, generator5);
//			ArrayList<GridPosition> result5=g5.findAndMarkAllRuns();
//			System.out.println(result5);	
//			
//			
//		String[] desc6= 
//		{
//		"2 4 1 3",
//		"1 4 1 3",
//		"2 1 2 1"
//	    };
//		JewelFactory generator6=new JewelFactory(5);
//		Game g6=new Game(desc6, generator6);
//		g6.setJewel(0, 1, null);
//		g6.setJewel(1, 1, null);
//		g6.setJewel(0, 3, null);
//		g6.setJewel(2, 0, null);
//		System.out.println(g6);
//		ArrayList<GridPosition> result6=g6.fillAll();
//		System.out.println(g6);
//		System.out.println(result6);
//		
//		Jewel[] test=Util.createFromString("0 1 2 3 4 5 6 7");
//		test[2]=null;
//		test[5]=null;
//		test[7]=null;
//		test[0]=null;
//		test[2]=null;
//		test[6]=null;
//		System.out.println(Arrays.toString(test));
//		ArrayList<Integer> result=Util.shiftNonNullElements(test); 
//		System.out.println(Arrays.toString(test));
//		System.out.println(result);
//		
		String[] desc=
			{
					"0 0 0 ",
					"0 1 0 ",
					"0 2 0 ",
					"0 3 0 ",
					"0 4 0 ",
					"0 5 0 ",
					"0 6 0 ",
					"0 7 0 "
			};
		
		Game g=new Game(desc, new JewelFactory(8));
		g.setJewel(3, 1, null);
		g.setJewel(5, 1, null);
		System.out.println(g);
		ArrayList<GridPosition> result=g.shiftColumnDown(1);
		System.out.println(g);
		System.out.println(result);
					
			}


	}



package lab5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import balloon.Balloon;
//import balloon1.Balloon; //no max limit for blow & blow isn't disable after pop
//import balloon2.Balloon; //blow isn't disable after pop
//import balloon3.Balloon; //no radius increment in multiple blow
//import balloon4.Balloon; //deflate pop the balloon

public class BalloonTests
{
	private Balloon bb;

    @Before    
    public void setup()  // runs before every test case
    {
      bb = new Balloon(5);
    }
    
    @Test
    public void testInitial()
    {
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testInitialRadius()
    {
    	assertEquals(0, bb.getRadius());
    }
    
    @Test
    public void testBlow0()
    {
    	bb.blow(0);
    	assertEquals(0, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testBlow1()
    {
    	bb.blow(1);
    	assertEquals(1, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testBlow2()
    {
    	bb.blow(1);
    	assertEquals(1, bb.getRadius());
    	bb.blow(2);
    	assertEquals(3, bb.getRadius());
    	bb.blow(1);
    	assertEquals(4, bb.getRadius());
    	bb.blow(0);
    	assertEquals(4, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testBlow3()
    {
    	bb.blow(2);
    	bb.blow(2);
    	assertEquals(4, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testBlow4()
    {
    	bb.blow(6);
    	assertEquals(0, bb.getRadius());
    	assertEquals(true, bb.isPopped());
    }

    @Test
    public void testDeflate0()
    {
    	bb.blow(1);
    	bb.blow(3);
    	bb.deflate();
    	assertEquals(0, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testDeflate1()
    {
    	bb.blow(5);
    	bb.deflate();
    	assertEquals(0, bb.getRadius());
    	assertEquals(false, bb.isPopped());
    }

    @Test
    public void testRadiusAfterPop()
    {
    	bb.pop();
    	assertEquals(0, bb.getRadius());
    	assertEquals(true, bb.isPopped());
    }
    
    @Test
    public void testBlowAfterPop0()
    {
    	bb.pop();
    	bb.blow(3);
    	assertEquals(0, bb.getRadius());
    	assertEquals(true, bb.isPopped());
    }
    
    @Test
    public void testBlowAfterPop1()
    {
    	bb.pop();
    	bb.blow(3);
    	bb.blow(1);
    	assertEquals(0, bb.getRadius());
    	assertEquals(true, bb.isPopped());
    }

}

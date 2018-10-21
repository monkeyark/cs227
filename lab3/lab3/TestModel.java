package lab3;

public class TestModel
{
	  public static void main(String[] args)
	  {
		System.out.println("Model");
		RabbitModel0 model0 = new RabbitModel0();
		// Check that the initial population is 2
	    System.out.println(model0.getPopulation());
	    System.out.println("Expected 2");
	    // A year goes by...
	    model0.simulateYear();
	    System.out.println(model0.getPopulation());
	    System.out.println("Expected 3");	    
	    // Start over
	    model0.reset();
	    System.out.println(model0.getPopulation());
	    System.out.println("Expected 2");
	    System.out.println("---------------------");
	    
	    
	    System.out.println("Model1");
	    RabbitModel1 model1 = new RabbitModel1();
	    // Check that the initial population is 0
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 0");
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 1");	    
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 2");
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 3");
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 4");
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 0");
	    // A year goes by...
	    model1.simulateYear();
	    System.out.println(model1.getPopulation());
	    System.out.println("Expected 1");
	    System.out.println("---------------------");
	    
		System.out.println("Model2");
	    RabbitModel2 model2 = new RabbitModel2();
	    // Check that the initial population is 500
	    System.out.println(model2.getPopulation());
	    System.out.println("Expected 500");
	    // A year goes by...
	    model2.simulateYear();
	    System.out.println(model2.getPopulation());
	    System.out.println("Expected 250");
	    // A year goes by...
	    model2.simulateYear();
	    System.out.println(model2.getPopulation());
	    System.out.println("Expected 125");
	    // A year goes by...
	    model2.simulateYear();
	    System.out.println(model2.getPopulation());
	    System.out.println("Expected 62");
	    System.out.println("---------------------");
	    
		System.out.println("Model3");
	    RabbitModel3 model3 = new RabbitModel3();
	    // Check that the initial population is 0
	    System.out.println(model3.getPopulation());
	    System.out.println("Expected from 0 to 10");
	    // A year goes by...
	    model3.simulateYear();
	    System.out.println(model3.getPopulation());
	    System.out.println("Expected from 0 to 10");
	    // A year goes by...
	    model3.simulateYear();
	    System.out.println(model3.getPopulation());
	    System.out.println("Expected from 0 to 10");
	    // A year goes by...
	    model3.simulateYear();
	    System.out.println(model3.getPopulation());
	    System.out.println("Expected from 0 to 10");
	    System.out.println("---------------------");
	    
		System.out.println("Model4");
	    RabbitModel4 model4 = new RabbitModel4();
	    // Check that the initial population is 0
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 1");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 1");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 2");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 3");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 5");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 8");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 13");
	    // A year goes by...
	    model4.simulateYear();
	    System.out.println(model4.getPopulation());
	    System.out.println("Expected 21");
	    System.out.println("---------------------");
	    	    
	  }

}

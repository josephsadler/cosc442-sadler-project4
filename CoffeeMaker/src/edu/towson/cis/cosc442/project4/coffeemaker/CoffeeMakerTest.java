package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testAddInventory1() {
		assertTrue(cm.addInventory(5, 5, 5, 5));
	}
	
	public void testCheckInventory() {
		assertNotNull(cm.checkInventory());
	}
	
	public void testPurchaseBeverage1() { //Test successful purchase
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1,50));
	}
	
	public void testPurchaseBeverage2() { //Test not enough money inserted
		cm.addRecipe(r1);
		assertEquals(49, cm.makeCoffee(r1,49));
	}
	
	public void testPurchaseBeverage3() { //Test not enough inventory
		Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setPrice(50);
		r2.setAmtCoffee(600);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		cm.addRecipe(r2);
		assertEquals(50, cm.makeCoffee(r2,50));
	}
	
	public void testGetRecipeForName() {
		cm.addRecipe(r1);
		assertEquals(r1, cm.getRecipeForName(r1.getName()));
	}
	
	public void testEnoughIngredients() {
		Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setPrice(50);
		r2.setAmtCoffee(600);
		r2.setAmtMilk(100);
		r2.setAmtSugar(100);
		r2.setAmtChocolate(100);
		cm.checkInventory().enoughIngredients(r2);
	}
	
	public void testInventorySetters() {
		Inventory inv = cm.checkInventory();
		
		inv.setCoffee(-1);
		inv.setMilk(-1);
		inv.setSugar(-1);
		inv.setChocolate(-1);
		
		assertEquals(0, inv.getCoffee());
		assertEquals(0, inv.getMilk());
		assertEquals(0, inv.getSugar());
		assertEquals(0, inv.getChocolate());
	}
	
	public void testInventoryToString() {
		assertNotNull(cm.checkInventory().toString());
	}
	
	public void testRecipeSetters() {
		Recipe r2 = new Recipe();
		r2.setAmtCoffee(-1);
		r2.setAmtMilk(-1);
		r2.setAmtSugar(-1);
		r2.setAmtChocolate(-1);
		r2.setPrice(-1);
		
		assertEquals(0, r2.getAmtCoffee());
		assertEquals(0, r2.getAmtMilk());
		assertEquals(0, r2.getAmtSugar());
		assertEquals(0, r2.getAmtChocolate());
		assertEquals(0, r2.getPrice());
	}

}
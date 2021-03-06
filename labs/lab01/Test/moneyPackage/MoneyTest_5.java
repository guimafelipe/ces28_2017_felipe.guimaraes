package moneyPackage;

import static org.junit.Assert.*;

import org.junit.*;

/*Testes referentes �s funcionalidades b�sicas da classe Money Bag*/

public class MoneyTest_5 {
	
	private static MoneyBag mb1;
	
	@BeforeClass
	public static void initialsetup () {
		mb1 = new MoneyBag();
	}
	
	@Test
	public void WhenCreatingMoneyBagShouldBeEmpty() {
		assertEquals(mb1.size(), 0);
	}
	
	@Test
	public void AddingSameOcurrenciesMoney() {
		mb1.add(new Money(3,"USD"));
		
		assertEquals(1, mb1.size());
		assertEquals(new Money(3, "USD"), mb1.get(0));
		
		mb1.add(new Money(6,"USD"));
		
		assertEquals(1, mb1.size());
		assertEquals(new Money(9, "USD"), mb1.get(0));
	}
	
	@Test
	public void AddingDifferentOcurrencyMoney() {
		mb1.add(new Money(4, "BRL"));
		
		assertEquals(2, mb1.size());
		assertEquals(mb1.get(1), new Money(4, "BRL"));
	}
}

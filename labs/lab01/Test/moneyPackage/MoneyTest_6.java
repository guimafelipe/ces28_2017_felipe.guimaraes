package moneyPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest_6 {
	Money m1;
	Money m2;
	Money m3;
	@Before
	public void setup() {
		m1 = new Money(19, "EUR");
		m2 = new Money(21, "EUR");
		m3 = new Money(23, "BRL");
	}
	
	@Test
	public void whenAddSameTypeReturnsMoney() {
		assertEquals(new Money(40, "EUR"),m1.add(m2));
	}
	
	@Test
	public void whenAddDiffCurrencyReturnsMoneyBag() {
		MoneyBag mb = new MoneyBag();
		mb.add(m1);
		mb.add(m3);
		assertEquals(mb, m1.add(m3));
		
	}
}

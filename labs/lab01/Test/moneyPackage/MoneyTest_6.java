package moneyPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest_6 {
	Money m1;
	Money m2;
	Money m3;
	MoneyBag mb;
	@Before
	public void setup() {
		mb = new MoneyBag();
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
		
		mb.add(m1);
		mb.add(m3);
		assertEquals(mb, m1.add(m3));
		
	}
	
	@Test
	public void testingConversionMap() {
		assertEquals(3, mb.checarConversion(new Currency("USD")));
		
	}
	
	@Test
	public void returningTotalMoneyInBRL() {
		mb.add(m3);
		mb.add(new Money (17, "BRL"));
		assertEquals(40, mb.valorEmReais());
		
		mb.add(new Money(5, "USD"));
		assertEquals(55, mb.valorEmReais());
		
		mb.add(new Money(5, "CHF"));
		assertEquals(65, mb.valorEmReais());
	}
	
}

package moneyPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*Teste referente ao passo 2 do processo do roteiro*/
public class MoneyTest_1 {

	private Money _36USDm = new Money();
	private Money _52USDm = new Money();
	private Money addResult = new Money();
	
	
	@Before
	public void setup () {
		this._36USDm.setAmount(36);
		this._36USDm.setCurrency("USD");
		this._52USDm.setAmount(52);
		this._52USDm.setCurrency("USD");
		this.addResult = _36USDm.add(this._52USDm);
	}
	
	@Test
	public void WhenAddingSameCurrencyMoneysRetunsAMoneyWithSummedAmoutsAndCurrency() {
	
		assertTrue(addResult.getAmount() == 88);
		assertTrue(addResult.getCurrency() == "USD");	
	}
}


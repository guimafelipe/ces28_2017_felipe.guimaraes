package moneyPackage;

public class Money implements MoneyInterface{
	public	Money(int amount, String currency)	{
		this._currency = new Currency(currency);
		//assert currency.length() == 3 : "Currency needs to have length of 3.";
		this.setAmount(amount);
	}

	public MoneyInterface add(Money m) { 
		
		if(m.getCurrency().equals(this.getCurrency())) {
			Money money = new Money(0,"");
	
			money.setAmount(this.getAmount() + m.getAmount()); 	
			money.getCurrency().setCurrencyStr(this._currency.getCurrencyStr());
			
			return	money;
		} else {
			MoneyBag mb = new MoneyBag();
			mb.add(this);
			mb.add(m);
			return mb;
		}
	}

	public int getAmount() {
		return _amount;
	}
	 
	public void setAmount(int amount) {
		this._amount = amount;
	}
	
	public Currency getCurrency() {
		return _currency;
	}
	
	@Override
	public boolean equals(Object money) {
		if(!((Money) money).getCurrency().getCurrencyStr().equals(this.getCurrency().getCurrencyStr()))
			return false;
		if(((Money) money).getAmount()!=this.getAmount())
			return false;
		return true;
	}
	
	private int _amount;
	private Currency _currency;

}
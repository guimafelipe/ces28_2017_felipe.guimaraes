package moneyPackage;

public class Currency {
	
	public	Currency(String currency)	{
		this.setCurrencyStr(currency);
	}
	
	public String getCurrencyStr() { 
		return _currency;
	}

	public void setCurrencyStr(String currency) {
		this._currency = currency;
	}
	
	public boolean equals(Currency currency) {
		if(this.getCurrencyStr().equals(currency.getCurrencyStr()))
			return true;
		return false;
	}
	
	private String _currency;
}

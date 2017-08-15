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
	
	@Override
	public boolean equals(Object currency) {
		if(this.getCurrencyStr().equals(((Currency) currency).getCurrencyStr()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return _currency.hashCode();
	}
	
	private String _currency;
}

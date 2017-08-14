package moneyPackage;

import java.util.ArrayList;

public class MoneyBag {
	
	private ArrayList<Money> _bag;
	
	public MoneyBag(){
		_bag = new ArrayList<Money>();		
	}
	
	public String toString() {
		String result = "";
		
		for (Money money : _bag) {
			result = result + money.getAmount();
			result = result + " " + money.getCurrency().getCurrencyStr() + ", ";
		}
		return result;
	}
	
	public int numberOfDifferentCurrencies() {
		return _bag.size();
	}
	
	public Money get(int i) {
		return _bag.get(i);
	}
	
	public void add(Money money) {
		boolean moneyTypeFound = false;
		for(int i = 0; i < _bag.size(); i++) {
			if(money.getCurrency().equals(_bag.get(i).getCurrency())) {
				moneyTypeFound = true;
				_bag.set(i, _bag.get(i).add(money));
				break;
			}
		}
		if(!moneyTypeFound) {
			_bag.add(money);
		}
	}
}

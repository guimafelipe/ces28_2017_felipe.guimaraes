package moneyPackage;

import java.util.ArrayList;

public class MoneyBag implements MoneyInterface{
	
	private ArrayList<Money> _bag;
	
	public MoneyBag(){
		_bag = new ArrayList<Money>();		
	}
	
	//Item 9 do roteiro
	public String toString() {
		String result = "";
		
		for (Money money : _bag) {
			result = result + money.getAmount();
			result = result + " " + money.getCurrency().getCurrencyStr() + ", ";
		}
		return result;
	}
	
	public int size() {
		return _bag.size();
	}
	
	public Money get(int i) {
		return _bag.get(i);
	}
	
	public MoneyInterface add(Money money) {
		boolean moneyTypeFound = false;
		for(int i = 0; i < _bag.size(); i++) {
			if(money.getCurrency().equals(_bag.get(i).getCurrency())) {
				moneyTypeFound = true;
				_bag.set(i,  (Money) _bag.get(i).add(money));
				break;
			}
		}
		if(!moneyTypeFound) {
			_bag.add(money);
		}
		return this;
	}
	
	@Override
	public boolean equals(Object mb) {
		boolean resp = true;
		if(((MoneyBag) mb).size() != this.size())
			return false;
		for(int i = 0; i < _bag.size(); i++) {
			if(!((MoneyBag) mb).get(i).equals(_bag.get(i))) {
				resp = false;
			}
		}
		return resp;
	}
}

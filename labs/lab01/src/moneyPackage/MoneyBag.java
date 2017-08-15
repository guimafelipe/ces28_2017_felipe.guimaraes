package moneyPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoneyBag implements MoneyInterface{
	
	private ArrayList<Money> _bag;
	private Map<Currency, Integer> _conversion;
	
	public MoneyBag(){
		_bag = new ArrayList<Money>();
		_conversion = new HashMap<Currency, Integer>();
		_conversion.put(new Currency("USD"), new Integer(3));
		_conversion.put(new Currency("CHF"), new Integer(2));
		_conversion.put(new Currency("BRL"), new Integer(1));
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
	
	public int checarConversion(Currency currency) {
		
		if(_conversion.containsKey(currency)) {
			return _conversion.get(currency).intValue();
		}
		
		return -1;
	}
	
	public int valorEmReais() {
		int result = 0;
		
		for(int i = 0; i < _bag.size(); i++) {
			if(_conversion.containsKey(_bag.get(i).getCurrency()))
				result += _conversion.get(_bag.get(i).getCurrency()).intValue()*_bag.get(i).getAmount();
		}
		return result;
	}
	
}

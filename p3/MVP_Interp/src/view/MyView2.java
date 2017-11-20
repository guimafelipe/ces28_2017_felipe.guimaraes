package view;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import presenter.MyInterpolationApp;

public class MyView2 implements Observer{
	
	double _value;
	File _file;
	
	public File getDataFile() {
		return _file;
	}
	
	private DecimalFormat formatResult = new DecimalFormat("####.######");
	Observable _presenter;
	private void bind(Observable presenter) {
		_presenter = presenter;
		_presenter.addObserver(this);
	}
	
	public MyView2(Observable presenter) {
		bind(presenter);
	}
	
	private void printResult(double result) {
    	System.out.println("Olá pessoal, eu sou a VIEW2!!!!");
    	System.out.println("Eu nem chamei o cálculo, mas estou sendo atualizada ao mesmo tempo!!!\nTemos o resultado = " + formatResult.format(result));
	}

	@Override
	public void update(Observable o, Object arg) {
		printResult((double) arg);
	}
	
	public void getMethod(String method) {
		MyInterpolationApp pres;
		pres =  (MyInterpolationApp) _presenter;
		pres.getMethod(method);
	}
	
	public void calculateResult(float value, File file) {
		MyInterpolationApp pres = (MyInterpolationApp) _presenter;
		_value = value;
		_file = file;
		pres.calculateResult(value, file);
	}
}

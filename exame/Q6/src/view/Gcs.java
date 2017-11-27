package view;

import java.util.Observable;
import java.util.Observer;

public class Gcs implements Observer { //View
	
	private int id;
	
	public Gcs(int _id){
		id = _id;
	}
	
	public void receiveMessage(String msg){
		System.out.println("GCS " + id + " recebeu mensagem:\n"
				 + msg);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		receiveMessage((String) arg1);
	}
	
}

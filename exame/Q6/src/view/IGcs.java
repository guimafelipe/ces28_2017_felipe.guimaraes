package view;

import java.util.Observer;

public interface IGcs extends Observer{
	public void receiveMessage(String msg);
	
}

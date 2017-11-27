package model;

public class Drone1 extends DroneBase{ //Model
	
	public Drone1(int _id, int _x, int _y){
		id = _id;
		x = _x;
		y = _y;
	}
	
	public void goTo(int _x, int _y){
		x = _x;
		y = _y;
	}
		
}

package model;

public class Drone1 implements DroneBase{ //Model
	int id, x, y;
	
	public Drone1(int _id, int _x, int _y){
		id = _id;
		x = _x;
		y = _y;
	}
	
	public void goTo(int _x, int _y){
		x = _x;
		y = _y;
	}

	@Override
	public String selfStatus() {
		return "Drone " + id + ", pos: (" + x + ", " + y + ")";
	}
		
}

package model;

public abstract class DroneBase {
	protected int id, x, y;
	
	public String selfStatus(){
		return "Drone " + id + ", pos: (" + x + ", " + y + ")";
	}
}

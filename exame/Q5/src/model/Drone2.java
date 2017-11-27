package model;

public class Drone2 extends DroneBase{
	public Drone2(int _id, int _x, int _y){
		id = _id;
		x = _x;
		y = _y;
	}
	
	public void goFoward(int dist){
		x += dist;
	}
}

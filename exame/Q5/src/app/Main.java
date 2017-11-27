package app;

import presenter.Utmctr;
import view.Gcs;
import model.Drone1;
import model.Drone2;

public class Main {
	public static void main(String [ ] args){
		Gcs gcs1, gcs2, gcs3;
		gcs1 = new Gcs(1);
		gcs2 = new Gcs(2);
		gcs3 = new Gcs(3);
		Utmctr utm;
		utm = Utmctr.getInstance();
		utm.addObserver(gcs1);
		utm.addObserver(gcs2);
		utm.addObserver(gcs3);
		utm.getAllInfo();
		Drone1 drn1, drn2;
		Drone2 drn3;
		drn1 = new Drone1(1, 17, 18);
		drn2 = new Drone1(2, 18, 19);
		drn3 = new Drone2(3, 19, 20);
		utm.addDrone(drn1);
		utm.addDrone(drn2);
		utm.addDrone(drn3);
		utm.getAllInfo();
		drn2.goTo(20, 21);
		drn3.goFoward(5);
		utm.getAllInfo();
	}
}

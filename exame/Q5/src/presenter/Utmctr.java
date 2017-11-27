package presenter;

import java.util.ArrayList;
import java.util.Observable;

import model.DroneBase;

public class Utmctr extends Observable { //Presenter
	static private Utmctr instance = null;
	
	ArrayList<DroneBase> drones;
	
	public static Utmctr getInstance(){ //Singleton implementado
		if(instance == null){
			instance = new Utmctr();
		}
		return instance;
	}
	
	public static void clearInstance(){
		instance = null;
	}
	
	private Utmctr(){
	}
	
	public void addDrone(DroneBase drone){
		if(drones == null){
			drones = new ArrayList<DroneBase>();
		}
		drones.add(drone);
	}
	
	public int numberOfDrones(){
		if(drones == null){
			return 0;
		}
		return drones.size();
	}
	
	public String getAllInfo(){
		String resp = "";
		if(drones == null){
			resp = "Nao ha drones.\n";
		} else {
			for(DroneBase drone : drones){
				resp += drone.selfStatus() + "\n";
			}
		}
		System.out.println("UTM leu status dos drones:\n" + resp);
		setChanged();
		notifyObservers(resp);
		return resp;
	}
	
}

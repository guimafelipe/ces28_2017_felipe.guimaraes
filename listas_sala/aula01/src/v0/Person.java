package v0;

public class Person {
	static int nextId=0;
	Person(){
		id_ = nextId++;
	}
		   
	public int getId() {
	  return id_;
	}
	
	private int id_;

}

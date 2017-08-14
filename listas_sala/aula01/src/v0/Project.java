package v0;

import java.util.*;
class Project {
 
  private Vector <Person>participants_ = new Vector<Person>();
 
  public void addParticipant(Person P){ participants_.addElement(P); }
  public void removeParticipant(Person P) { participants_.removeElement(P); }
   
  public void printParticipants() {
	  for (Person person_ : participants_)
		  System.out.println("project has person "+ person_.getId());
  }

	boolean isParticipant(Person p) {
		return participants_.contains(p);
		
	}

}


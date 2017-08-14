package v0;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class VerificacaoDeAdicaoEPertencimentoNoProjeto {
	private Project pj;
	private Vector <Person>ps ;
	@Before
	public void init() {
		pj = new Project();
		ps = new Vector <Person> ();
		
		for (int i=0; i < 3; i++) {
			ps.addElement(new Person());
			pj.addParticipant(ps.get(i));
		}
	}
	@Test
	public void test() {		
		Person x = new Person();
		assertFalse(pj.isParticipant(x));
		assertEquals(Person.nextId - 1, x.getId() );
		
		Person p = ps.get(1);		
		assertTrue(pj.isParticipant(p));
		
		pj.removeParticipant(p);
		assertFalse(pj.isParticipant(p));
	}

}

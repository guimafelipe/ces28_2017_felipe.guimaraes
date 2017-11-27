package utm_v1;

import static org.junit.Assert.*;

import java.util.Observable;

import model.Drone1;
import model.DroneBase;

import org.junit.Test;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import org.junit.*;

import presenter.Utmctr;
import view.IGcs;



public class Testes {
	Utmctr utm;
	
	@Test
	public void testandoInstanciaUnicaDoPresenter(){ //testa se o singleton esta 
		assertNull(utm);                             //funcionando perfeitamente
		utm = Utmctr.getInstance();                  //ou seja, soh ha uma instancia
		assertEquals(Utmctr.getInstance(), utm);     // de utmctr
	}
	
	@Test
	public void testandoDrone(){ //testa se uma instancia de drone responde corretamente
		Drone1 drone1 = new Drone1(1, 1, 1);
		assertEquals("Drone 1, pos: (1, 1)", drone1.selfStatus());
		drone1.goTo(19,19);
		assertEquals("Drone 1, pos: (19, 19)", drone1.selfStatus());
	}
	
	@Test
	public void testandoAdicionarDrone(){            //Testa se um drone esta sendo
		DroneBase dronemock;                         //adicionado corretamente na 
		dronemock = Mockito.mock(DroneBase.class);   //lista de models (drones) 
		utm = Utmctr.getInstance();                  //de utmctr
		utm.addDrone(dronemock);
		assertEquals(1, utm.numberOfDrones());
	}
	
	@Test
	public void testandoView(){                      //Testa se a view consegue enxergar
		IGcs gcsmock;                                //corretamente as mudanças no presenter
		gcsmock = Mockito.mock(IGcs.class);          // (Quando ele notifica as views)
		Utmctr.clearInstance();
		utm = Utmctr.getInstance();
		utm.addObserver(gcsmock);
		utm.getAllInfo();                            //Chama o método em que o presenter pega todas as informações dos models
		Mockito.verify(gcsmock).update(utm,"Nao ha drones.\n"); // e verifica se a view recebeu a mensagem correta
	}
	
	@Test
	public void testandoPresenterComDroneEGCSMockados(){ //testa o presenter em um sistema completo 
		IGcs gcsmock;                                    //Com model e views mockados
		DroneBase dronemock;
		gcsmock = Mockito.mock(IGcs.class);
		dronemock = Mockito.mock(DroneBase.class);
		Mockito.when(dronemock.selfStatus()).thenReturn("Drone 1, pos: (19, 19)");
		assertNotNull(dronemock);
		Utmctr.clearInstance();
		utm = Utmctr.getInstance();
		utm.addDrone(dronemock); //adiciona drone mockado nos models
		utm.addObserver(gcsmock);//adiciona view mockada como observer
		utm.getAllInfo();        //Chama a função do presenter de verificar models e mandar mensagem pra views
		Mockito.verify(gcsmock).update(utm, "Drone 1, pos: (19, 19)\n"); // Checa se tudo ocorreu perfeitamente.
	}
}

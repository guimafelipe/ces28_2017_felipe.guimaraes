package Q4.ptc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.any;


public class Teste {
	
	ControladorPTC controlador;
	
	
	//item a da questao 4
	@Test
	public void testarInicializaçãoDoControlador(){
		Sensor sensordummy = mock(Sensor.class);
		Datacenter datacenterdummy = mock(Datacenter.class);
		PainelCondutor paineldummy = mock(PainelCondutor.class);
		
		controlador = new ControladorPTC(sensordummy, datacenterdummy, paineldummy);
	}
	
	//item b da questao 4
	@Test
	public void testaTremForadoCruzamento(){
		Sensor sensordummy = mock(Sensor.class);
		Datacenter datacenterdummy = mock(Datacenter.class);
		PainelCondutor paineldummy = mock(PainelCondutor.class);
		
		controlador = new ControladorPTC(sensordummy, datacenterdummy, paineldummy);
		
		when(sensordummy.getVelocidade()).thenReturn(50.0);
		when(sensordummy.isCruzamento()).thenReturn(false);
		
		controlador.run();
		
		verify(datacenterdummy).gerarRelatorio((String) any());
		verify(paineldummy).imprimirAviso((String) any(), isA(int.class));
	}
	
	//item c da questao 4
	@Test
	public void testaTrema100kmNoCruzamento(){
		Sensor sensordummy = mock(Sensor.class);
		Datacenter datacenterdummy = mock(Datacenter.class);
		PainelCondutor paineldummy = mock(PainelCondutor.class);
		
		controlador = new ControladorPTC(sensordummy, datacenterdummy, paineldummy);
		ControladorPTC contrlspy = Mockito.spy(controlador);
		
		when(sensordummy.getVelocidade()).thenReturn(101.0);
		when(sensordummy.isCruzamento()).thenReturn(true);
		when(paineldummy.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		
		contrlspy.run();
		
		verify(paineldummy).imprimirAviso("Velocidade alta", 1);
		verify(contrlspy).enviaMsgPrioritariaPainel((String) any(), (PainelCondutor)any());
	}
	
	//item d da questao 4
	@Test
	public void testaTrema20kmNoCruzamento(){
		Sensor sensordummy = mock(Sensor.class);
		Datacenter datacenterdummy = mock(Datacenter.class);
		PainelCondutor paineldummy = mock(PainelCondutor.class);
		
		controlador = new ControladorPTC(sensordummy, datacenterdummy, paineldummy);
		
		ControladorPTC contrlspy = Mockito.spy(controlador);
		
		when(sensordummy.getVelocidade()).thenReturn(19.0);
		when(sensordummy.isCruzamento()).thenReturn(true);
		when(paineldummy.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		
		contrlspy.run();
		
		verify(paineldummy).aceleraVelocidadeTrem(20.0);
		verify(contrlspy).aumentaVelocidade(20.0);
		
	}
	
}

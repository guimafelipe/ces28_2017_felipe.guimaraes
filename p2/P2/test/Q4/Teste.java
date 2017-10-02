package Q4;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.any;

public class Teste {
	
	RelatorioDespesas relatorio;
	
	@Test
	public void TestingRelatorioDespesas(){
		Despesa despesa1 = mock(Despesa.class);
		Despesa despesa2 = mock(Despesa.class);
		when(despesa1.getDespesa()).thenReturn(19f);
		when(despesa2.getDespesa()).thenReturn(45f);
		Calculadora calculadora = mock(Calculadora.class);
		Calculadora calculadoraspy = Mockito.spy(calculadora);
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		despesas.add(despesa1);
		despesas.add(despesa2);
		relatorio = new RelatorioDespesas(calculadoraspy);
		relatorio.ImprimirRelatorio(despesas.iterator());
		verify(calculadoraspy).imprime(64f);	
	}
	
	
}

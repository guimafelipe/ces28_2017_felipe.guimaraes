package Q4;

import java.util.ArrayList;
import java.util.Iterator;

public class RelatorioDespesas {
	
	Calculadora calculadora;
	
	public RelatorioDespesas(Calculadora calculadora){
		this.calculadora = calculadora;
	}
	
	public RelatorioDespesas(){
		this.calculadora = new Calculadora();
	}
	
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
		}
		
		calculadora.imprime(totalDespesa);
	}
}
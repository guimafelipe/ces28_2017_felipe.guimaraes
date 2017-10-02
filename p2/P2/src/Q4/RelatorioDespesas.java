package Q4;

import java.util.ArrayList;
import java.util.Iterator;

public class RelatorioDespesas {
	 private final int LASER = 1;
	 private final int INKJAT = 2;
	 private final int OLDONE = 3;
	   
	Calculadora calculadora;
	int tipoImpressora = LASER;
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
		
		calculadora.imprime(totalDespesa, tipoImpressora);
	}
}
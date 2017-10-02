package Q4;

import net.bytebuddy.asm.Advice.Return;

public class SistemaOperacional {
	public IImpressora getDriverImpressao(int tipo) {
		switch (tipo){
		case 1: 
			return new ImpressoraLaser();
		case 2:
			return new ImpressoraJato();
		case 3:
			return new Impressora();
		default:
			return new Impressora();
		}
		
		
	}
	
	public void Imprimir(String conteudo, int tipo){
		getDriverImpressao(tipo).Imprimir(conteudo);
	}
}

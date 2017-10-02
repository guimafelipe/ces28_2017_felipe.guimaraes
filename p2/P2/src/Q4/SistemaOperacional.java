package Q4;

public class SistemaOperacional {
	public Impressora getDriverImpressao() {
		return new Impressora();
	}
	
	public void Imprimir(String conteudo){
		getDriverImpressao().Imprimir(conteudo);
	}
}

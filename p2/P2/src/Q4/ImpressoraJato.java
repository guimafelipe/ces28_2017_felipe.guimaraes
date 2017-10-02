package Q4;

public class ImpressoraJato implements IImpressora {
	public void Imprimir(String conteudo)  {
		if (conteudo==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else 
			System.out.println(conteudo);
	}
}

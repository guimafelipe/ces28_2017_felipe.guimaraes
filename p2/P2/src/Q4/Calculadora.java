package Q4;

public class Calculadora {
	public void imprime(float totalDespesa, int tipo) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);

		SistemaOperacional so = new SistemaOperacional();
		so.Imprimir(conteudo, tipo);
	}
}

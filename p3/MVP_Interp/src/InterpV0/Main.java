package InterpV0;

import java.io.File;

import model.AlgoritmoZero;
import presenter.MyInterpolationApp;
import view.MyView;
import view.MyView2;

public class Main {
	public static void main(String[] args) {
			// RESPONSABILITY: CREATE APP
			MyInterpolationApp myInterp = new MyInterpolationApp();
			MyView view1 = new MyView(myInterp);
			MyView2 view2 = new MyView2(myInterp);
			// ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
			// RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		   	view1.getMethod("Lagrange");
			// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
			// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
			// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		   	view1.calculateResult(10.3f, new File("./data.dat"));
		   	myInterp.addMethod("zero", new AlgoritmoZero()); //algoritmo novo que retorna zero sempre
		   	view1.getMethod("zero");
		   	view1.calculateResult(10.3f, new File("./data.dat"));
	    }
}

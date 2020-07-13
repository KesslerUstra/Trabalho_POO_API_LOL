package principal;

import card.layouts.subMenu;
import interfacee.JFramee;
import interfacee.PainelEscolha;

public class CodigoPrincipal {
	//Criamos duas constantes para representar o tamanho que queremos para nosso programa
	private static final int larguraTela = 600;
	private static final int alturaTela = 560;
	//Instanciamos  um objeto do tipo JFramee
	JFramee janela;
	PainelEscolha menuPrincipal;

	public static void main(String[] args) {
		//Criamos um objeto do tipo JFramee
		JFramee janela = new JFramee(larguraTela,alturaTela);
		
		
		subMenu painelPrincipal = new subMenu(larguraTela,alturaTela,janela);
		painelPrincipal.iniciar();
		//Definimos como visivel
		janela.setVisible(true);

	}

}

package card.layouts;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import principal.subMenuPainel;

public class subMenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int larguraTela;
	int alturaTela;
	JFrame janela;
	CardLayout cardLayout2;
	public subMenu(int larguraTela,int alturaTela,JFrame janela) {
		this.alturaTela = alturaTela;
		this.larguraTela = larguraTela;
		this.janela = janela;
				
	}
	public void iniciar() {
		
		//Criamos um objeto do tipo cardLayout
		cardLayout2 = new CardLayout();
		//Definimo o layout do JPanel como cardLayout
		this.setLayout(cardLayout2);
		
		
		//Criamos nosso JPanel para ser o menu principal e definimos o tamanho e cor
			//PainelEscolha menuPrincipal = new PainelEscolha(0,0,larguraTela,alturaTela,"#ECE9E9",this);
		JPainelCardLayout jogo = new JPainelCardLayout(larguraTela,alturaTela,this);
		subMenuPainel menu = new subMenuPainel(0,0,larguraTela,alturaTela,"#ECE9E9",this);
		JPainelCardLayoutInvocador invocador = new JPainelCardLayoutInvocador(larguraTela,alturaTela,this);
		
		//Adicionamos nosso menu principal ao JPainel do cardLayout
		this.add(jogo,"JOGO");
		this.add(menu,"MENU");
		this.add(invocador,"INVOCADOR");
		//Definimos o tamanho do nosso JPainel do cardLayout
		this.setBounds(0, 0, larguraTela, alturaTela);
		
		//Escolhemos qual card queremos mostrar
		cardLayout2.show(this, "MENU");
		//Adicionamos nosso JPanel no nosso JFrame
		janela.add(this,"MENU");
	}
}
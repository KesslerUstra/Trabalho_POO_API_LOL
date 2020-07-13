package card.layouts;

import java.awt.CardLayout;

import javax.swing.JPanel;

import interfacee.JPainelCampeoes;
import interfacee.JPainelVersao;
import interfacee.PainelEscolha;

public class JPainelCardLayout extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int larguraTela;
	int alturaTela;
	JPanel janela;
	CardLayout cardLayout;
	public JPainelCardLayout(int larguraTela,int alturaTela,JPanel janela) {
		this.alturaTela = alturaTela;
		this.larguraTela = larguraTela;
		this.janela = janela;
		iniciar();
				
	}
	public void iniciar() {
		
		//Criamos um objeto do tipo cardLayout
		cardLayout = new CardLayout();
		//Definimo o layout do JPanel como cardLayout
		this.setLayout(cardLayout);
		
		
		//Criamos nosso JPanel para ser o menu principal e definimos o tamanho e cor
		PainelEscolha menuPrincipal = new PainelEscolha(0,0,larguraTela,alturaTela,"#ECE9E9",this,janela);
		JPainelCampeoes plano1 = new JPainelCampeoes(0,0,larguraTela,alturaTela,"#ECE9E9",this);
		JPainelVersao plano2 = new JPainelVersao(0,0,larguraTela,alturaTela,"#ECE9E9",this);
		
		//Adicionamos nosso menu principal ao JPainel do cardLayout
		this.add(menuPrincipal,"Principal");
		this.add(plano1,"champs");
		this.add(plano2,"Versao");
		//Definimos o tamanho do nosso JPainel do cardLayout
		this.setBounds(0, 0, larguraTela, alturaTela);
		
		//Escolhemos qual card queremos mostrar
		cardLayout.show(this, "Principal");
		//Adicionamos nosso JPanel no nosso JFrame
		janela.add(this,"Principal");
	}
}

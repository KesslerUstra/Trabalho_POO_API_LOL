package card.layouts;

import java.awt.CardLayout;

import javax.swing.JPanel;

import interfacee.JPainelInformacoesInvocador;
import interfacee.PainelEscolhaInvocador;


public class JPainelCardLayoutInvocador extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int larguraTela;
	int alturaTela;
	JPanel janela;
	CardLayout cardLayout3;
	public JPainelCardLayoutInvocador(int larguraTela,int alturaTela,JPanel janela) {
		this.alturaTela = alturaTela;
		this.larguraTela = larguraTela;
		this.janela = janela;
		iniciar();
				
	}
	public void iniciar() {
		
		//Criamos um objeto do tipo cardLayout
		cardLayout3 = new CardLayout();
		//Definimo o layout do JPanel como cardLayout
		this.setLayout(cardLayout3);
		//Criamos nosso JPanel para ser o menu principal e definimos o tamanho e cor
		PainelEscolhaInvocador painelEscolhas = new PainelEscolhaInvocador(0,0,larguraTela,alturaTela,"#ECE9E9",this,janela);
		JPainelInformacoesInvocador painelInfoInvocador = new JPainelInformacoesInvocador(0,0,larguraTela,alturaTela,"#ECE9E9",this);
		//Adicionamos nosso menu principal ao JPainel do cardLayout
		this.add(painelEscolhas,"Principal");
		this.add(painelInfoInvocador,"INFO");
		//Definimos o tamanho do nosso JPainel do cardLayout
		this.setBounds(0, 0, larguraTela, alturaTela);
		
		//Escolhemos qual card queremos mostrar
		cardLayout3.show(this, "Principal");
		//Adicionamos nosso JPanel no nosso JFrame
		janela.add(this,"Principal");
	}
}

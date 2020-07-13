package principal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eventos.click.EventoClick;
import eventos.click.EventoClickSair;
import interfacee.PainelBasicos;

public class subMenuPainel extends PainelBasicos{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel cards;
	public subMenuPainel(int x, int y, int widght, int height, String color,JPanel cards) {
		super(x, y, widght, height, color);
		this.cards = cards;
		inicializar();
		
	}
	//metodo responsavel pelas coisas  que terá no nosso JPanel
		public void inicializar() {
			//Criamos um JLabel com o conteudo de Menu Principal
			JLabel MenuPrincipal = criarLabels(190,10,250,30,30,"Menu Principal");
			//Adicionamos ele no nosso JPainel
			this.add(MenuPrincipal);
			//Criamos um JLabel com o conteudo de >>>>>>> JOGO <<<<<<<
			JLabel escolha1 = criarLabels(165,180,400,30,20,">>>>>>> JOGO <<<<<<<");
			this.add(escolha1);
			JLabel escolha3 = criarLabels(169,320,400,30,20,">>>>>>> SAIR <<<<<<<");
			this.add(escolha3);
			//Adicionei um evento na label escolha1 para ir para outro card do nosso CardLyout
			escolha1.addMouseListener(new EventoClick(cards,"JOGO"));
			//Versao do codigo
			escolha3.addMouseListener(new EventoClickSair());
			JLabel versao = criarLabels(0,540,80,20,10,"1.0.0");
			this.add(versao);
			
			
		}
		//Metodo responsavel por criar JLabels pra gente :)
		public JLabel criarLabels(int x,int y,int widght,int height,int tamanhoLetra,String conteudo) {
			//Criamos um objeto do tipo JLabel
			JLabel Label = new JLabel(conteudo);
			//Definimos a fonte do conteudo do JLabel
			Label.setFont(new Font("Gotham",Font.BOLD,tamanhoLetra));
			//Definimos a cor que tera o conteudo do nosso JLabel
			Label.setForeground(Color.BLACK);
			//Definimos aonde ficara e o tamanho do nosso JLabel
			Label.setBounds(x,y,widght,height);
			return Label;
		}

}

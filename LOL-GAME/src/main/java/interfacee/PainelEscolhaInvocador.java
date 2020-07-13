package interfacee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eventos.click.EventoClick;

public class PainelEscolhaInvocador extends PainelBasicos{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel menu;
	private JPanel cards;

	public PainelEscolhaInvocador(int x, int y, int widght, int height, String color,JPanel cards,JPanel menu) {
		super(x, y, widght, height, color);
		this.menu = menu;
		this.cards = cards;
		//Chamamos o método inicializar 
		iniciar();
	}
	
	private void iniciar() {
		//Criamos um JLabel com o conteudo de Menu Principal
		JLabel MenuPrincipal = criarLabels(190,10,250,30,30,"Menu Principal");
		//Adicionamos ele no nosso JPainel
		this.add(MenuPrincipal);
		//Criamos um JLabel com o conteudo de Invocador
		JLabel Invocador = criarLabels(213,50,250,35,30,"Invocador");
		this.add(Invocador);
		//Criamos um JLabel com o conteudo de >>>>>>> Informações Invocador <<<<<<<
		JLabel escolha1 = criarLabels(82,180,500,30,20," >>>>>>> Informações Invocador <<<<<<<");
		this.add(escolha1);
		//Criamos um JLabel com o conteudo de >>>>>>> Rank Invocador LOL <<<<<<<
		JLabel escolha2 = criarLabels(105,250,400,30,20," >>>>>>> Rank Invocador LOL <<<<<<<");
		this.add(escolha2);
		//Criamos um JLabel com o conteudo de >>>>>>> Rank Invocador LOR <<<<<<<
		JLabel escolha3 = criarLabels(105,320,400,30,20," >>>>>>> Rank Invocador TFT <<<<<<<");
		this.add(escolha3);
		//Criamos um JLabel com o conteudo de >>>>>>> Voltar <<<<<<<
		JLabel escolha4 = criarLabels(167,400,400,30,20,">>>>>>> Voltar <<<<<<<");
		this.add(escolha4);
		
		escolha1.addMouseListener(new EventoClick(cards,"INFO"));
		escolha2.addMouseListener(new EventoClick(cards,"LOL"));
		escolha3.addMouseListener(new EventoClick(cards, "TFT"));
		escolha4.addMouseListener(new EventoClick(menu,"MENU"));
		//Versao do codigo
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

package interfacee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eventos.click.EventoClick;
//Extendemos da classe Painelbasicos
public class PainelEscolha extends PainelBasicos{
	//Atributo para podermos mudar a tela do nosso CardLayout
	private JPanel cards;
	private JPanel menu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Pegamos o metodo construtor da classe Extendida
	public PainelEscolha(int x, int y, int widght, int height, String color,JPanel cards,JPanel menu) {
		super(x, y, widght, height, color);
		this.cards = cards;
		this.menu = menu;
		//Chamamos o método inicializar 
		inicializar();
	}
	//metodo responsavel pelas coisas  que terá no nosso JPanel
	private void inicializar() {
		//Criamos um JLabel com o conteudo de Menu Principal
		JLabel MenuPrincipal = criarLabels(190,10,250,30,30,"Menu Principal");
		//Adicionamos ele no nosso JPainel
		this.add(MenuPrincipal);
		//Criamos um JLabel com o conteudo de Jogo
		JLabel Jogo = criarLabels(260,50,250,35,30,"Jogo");
		this.add(Jogo);
		//Criamos um JLabel com o conteudo de >>>>>>> Campeões <<<<<<<
		JLabel escolha1 = criarLabels(150,180,400,30,20," >>>>>>> Campeões <<<<<<<");
		this.add(escolha1);
		//Criamos um JLabel com o conteudo de >>>>>>> Versao Atual <<<<<<<
		JLabel escolha2 = criarLabels(135,250,400,30,20," >>>>>>> Versao Atual <<<<<<<");
		this.add(escolha2);
		//Criamos um JLabel com o conteudo de >>>>>>> Voltar <<<<<<<
		JLabel escolha3 = criarLabels(173,320,400,30,20,">>>>>>> Voltar <<<<<<<");
		this.add(escolha3);
		//Adicionei um evento na label escolha1 para ir para outro card do nosso CardLyout
		escolha1.addMouseListener(new EventoClick(cards,"champs"));
		//Adicionei um evento na label escolha2 para ir para outro card do nosso CardLyout
		escolha2.addMouseListener(new EventoClick(cards,"Versao"));
		//Adicionei um evento na label escolhapara que feche o programa
		escolha3.addMouseListener(new EventoClick(menu,"MENU"));
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

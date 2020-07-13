package interfacee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import eventos.click.EventoClick;

public class JPainelVersao extends PainelBasicos{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel cards;

	//Metodo construtor da classe PainelBasicos
	public JPainelVersao(int x, int y, int widght, int height, String color,JPanel cards) {
		super(x, y, widght, height, color);
		this.cards = cards;
		inicializar();
	}
	//metodo responsavel pelas coisas  que terá no nosso JPanel
	public void inicializar() {
		//Iremos criar um jLabel para podermo voltar para a pagina inicial
		JLabel voltar = criarLabels(0,0,80,15,10,"Voltar");
		//Adicionamos um evento de mouse na JLabel
		voltar.addMouseListener(new EventoClick(cards,"Principal"));
		//Adicionamos essa label na nossa classe
		this.add(voltar);
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

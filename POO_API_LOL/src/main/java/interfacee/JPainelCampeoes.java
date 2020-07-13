package interfacee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eventos.click.EventoClick;
import eventos.click.EventoClickChampButton;
import jtextfield.focus.EventoFocus;

public class JPainelCampeoes extends PainelBasicos{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel cards;

	//Metodo construtor da classe PainelBasicos
	public JPainelCampeoes(int x, int y, int widght, int height, String color,JPanel cards) {
		super(x, y, widght, height, color);
		this.cards = cards;
		inicializar();
	}
	//metodo responsavel pelas coisas  que terá no nosso JPanel
	private void inicializar() {
		//Criamos uma JLabel para mostar a frase nome
		JLabel nome = criarLabels(50,10,200,30,20,"Nome Campeão");
		//Adicionamos ela na nossa classe
		this.add(nome);
		//Criamos um JTextField para podermos pegar o nosso do player
		JTextField nomeCampeao = criarTextField(45, 40, 150, 30,"Digite o nome");
		//Adicionamos um FocusListener no nosso JTextField
		nomeCampeao.addFocusListener(new EventoFocus(nomeCampeao,"Digite o nome"));
		//Adicionamos ele na nossa classe
		this.add(nomeCampeao);
		
		
		//Criaremos um JLabel para mostrar o nome do campeao;
		JLabel nomeChamp = criarLabels(10,200,200,30,16,"");
		//Adicionaremos na nossa classe
		this.add(nomeChamp);
		JLabel titleChamp = criarLabels(10,230,200,30,14,"");
		this.add(titleChamp);
		JLabel fotoChamp = criarLabels(292,0,308,560,10,"");
		this.add(fotoChamp);
		
		//Criaremos um JButton para pegar o nome do champ e podermos iniciar a pesquisa
		JButton botao = criarButton(70,80,100,25,"Clique Aqui");
		//Adicionamos um evento para podermos pegar o texto que esta no JtextField e colocar no nosso JLabel 
		botao.addActionListener(new EventoClickChampButton(nomeCampeao,nomeChamp,titleChamp,fotoChamp));
		//Adicionamos esse botao a classe
		this.add(botao);
		//Criamos un Jlabel para podermos avisar algo
		JLabel obs = criarLabels(10, 110, 100, 80, 10, ("<html>"+
		"Obs: digite o nome do"+"<br/>"+" campeão com a primeira"+"<br/>"+" letra sendo maiuscula"+"<html>"));
		//Adicionamos o Aviso na nossa classe
		this.add(obs);
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
	
	//Metodo responsavel por criar JTextField pra gente :)
	public JTextField criarTextField(int x,int y, int widght,int height,String conteudo) {
		//Criamos um objeto do tipo JTexField
		JTextField TextField = new JTextField(conteudo);
		//Definfimos o tamanho do nosso JtextField
		TextField.setBounds(x, y, widght, height);
		//Definimos a cor de fundo do nosso JtextField
		TextField.setBackground(Color.decode("#DFDDDD"));
		//Definimos a cor das letras do nosso JTexField
		TextField.setForeground(Color.BLACK);
		//Definimos os limites de bordas de nosso JTexField
		TextField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
				BorderFactory.createEmptyBorder(0, 20, 0, 0)));
		//retornamos nosso JTextField
		return TextField;
	}
	//Metodo responsavel por criar JButton pra gente :)
	public JButton criarButton(int x, int y,int widght,int height,String conteudo) {
		//Criamos um objeto do tipo JBotton
		JButton botao = new JButton(conteudo);
		//Definimos o tamanho do nosso JButton
		botao.setBounds(x, y, widght, height);
		//Retornamos nosso JButton
		return botao;
	}

}

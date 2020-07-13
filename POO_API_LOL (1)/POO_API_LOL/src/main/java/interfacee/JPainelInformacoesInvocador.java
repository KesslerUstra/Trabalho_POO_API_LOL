package interfacee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import eventos.click.EventoClick;
import eventos.click.EventoClickInvocadorInfo;
import jtextfield.focus.EventoFocus;

public class JPainelInformacoesInvocador extends PainelBasicos{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private JPanel cards;
	//Metodo Construtor
	public JPainelInformacoesInvocador(int x, int y, int widght, int height, String color,JPanel cards) {
		super(x, y, widght, height, color);
		this.cards = cards;
		iniciar();
	}
	private void iniciar() {
		//Criamos uma JLabel para mostar a frase nome
		JLabel nome = criarLabels(50,10,200,30,20,"Info Invocador");
		//Adicionamos ela na nossa classe
		this.add(nome);
		//Criamos um JTextField para podermos pegar o nosso do player
		JTextField nomeCampeao = criarTextField(45, 40, 150, 30,"Digite o nome");
		//Adicionamos um FocusListener no nosso JTextField
		nomeCampeao.addFocusListener(new EventoFocus(nomeCampeao,"Digite o nome"));
		//Adicionamos ele na nossa classe
		this.add(nomeCampeao);
		
		//Criamos um JTextField para podermos pegar a senha da API
		JTextField senhaAPI = criarTextField(45, 75, 150, 30,"Digite o token da API");
		//Adicionamos um FocusListener no nosso JTextField
		senhaAPI.addFocusListener(new EventoFocus(senhaAPI,"Digite o token da API"));
		//Adicionamos ele na nossa classe
		this.add(senhaAPI);
				
				
		JLabel nomeInvocador = criarLabels(0,240,400,30,14,"");
		this.add(nomeInvocador);
		JLabel levelInvocador = criarLabels(0,270,220,30,14,"");
		this.add(levelInvocador);
		JLabel iconeInvocador = criarLabels(240,0,400,520,14,"");
		this.add(iconeInvocador);
		
				
		//Criaremos um JButton para pegar o nome do champ e podermos iniciar a pesquisa
		JButton botao = criarButton(70,120,100,25,"Clique Aqui");
		//Adicionamos um evento para pegarmos as informacoes da API
		botao.addActionListener(new EventoClickInvocadorInfo(senhaAPI, nomeCampeao, nomeInvocador, levelInvocador,
				iconeInvocador));
		//Adicionamos esse botao a classe
		this.add(botao);
		//Criamos un Jlabel para podermos avisar algo
		JLabel obs = criarLabels(10, 160, 100, 80, 10, ("<html>"+
		"Obs: Para pegar a"+"<br/>"+" sua senha pesquise"+"<br/>"+" sobre 'LOL API' "+"<html>"));
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

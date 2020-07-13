package interfacee;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
//Extendemos da classe4 JFrame
public class JFramee extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Criamos dois atributos para o tamanho do nosso JFrame
	private int x,y;
	
	//Metodo Construtor
	public JFramee(int x,int y) {
		this.x = x;
		this.y = y;
		//Chamamos o método construtor
		inicializar();
	}
	
	//Metodo Responsavel por definir as coisas básicas do nosso JFrame
	public void inicializar(){
		//Definimos o layout do nosso JFrame como null
		this.setLayout(null);
		//Definimos o tasmanho do nosso JFrame
		this.setBounds(0,0,x,y);
		//Colocamos para que o nosso JFrame fique centralizado no monitor
		this.setLocationRelativeTo(null);
		//Definimos para que o nosso programa pare de executar quando fechar o JFrame
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//Definindo para não ser redimensionada
		this.setResizable(false);
		//Coloca nosso JFrame sem cabeçalho
		this.setUndecorated(true);
	}
}

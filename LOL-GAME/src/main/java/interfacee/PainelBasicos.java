package interfacee;

import java.awt.Color;

import javax.swing.JPanel;

public class PainelBasicos extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos da classe 
	int x,y,widght,height;
	String color;
	
	//Metodo Construtor
	
	public PainelBasicos(int x,int y,int widght,int height,String color) {
		this.x = x;
		this.y = y;
		this.widght = widght;
		this.height = height;
		this.color = color;
		//Definimos a cor de fundo do JPanel
		this.setBackground(Color.decode(this.color));
		this.setBounds(x,y,widght,height);
		//Definimo o lyout do JPanel como null para podermos colocar do jeito que quisermos
		this.setLayout(null);
	}
	
}

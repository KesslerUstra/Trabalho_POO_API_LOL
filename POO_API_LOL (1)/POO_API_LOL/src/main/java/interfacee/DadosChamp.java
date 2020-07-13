package interfacee;

import javax.swing.JLabel;

//Metodo por mostrar os detalhes do campeao
public class DadosChamp extends PainelBasicos{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String champ;
	
	public DadosChamp(int x, int y, int widght, int height, String color,String champ) {
		super(x, y, widght, height, color);
		this.champ = champ;
		inicializar();
	}
	public void inicializar() {
		JLabel nomeChamp = new JLabel(champ);
		nomeChamp.setBounds(100,100,100,30);
		this.add(nomeChamp);
	}
	
}

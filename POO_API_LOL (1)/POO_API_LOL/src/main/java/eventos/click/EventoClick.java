package eventos.click;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class EventoClick implements MouseListener{
	JPanel painel;
	String card;
	
	
	public EventoClick(JPanel painel,String card) {
		this.painel = painel;
		this.card = card;
	}

	public void mouseClicked(MouseEvent arg0) {
		CardLayout layout = (CardLayout)painel.getLayout();
		layout.show(painel, card);
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

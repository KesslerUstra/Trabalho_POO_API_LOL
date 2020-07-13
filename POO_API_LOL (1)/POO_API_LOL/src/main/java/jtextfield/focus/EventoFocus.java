package jtextfield.focus;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

//Classe utilizada para implementar o evento do foco no nosso JtexField
public class EventoFocus implements FocusListener{
	JTextField campo;
	String inicial;
	
	public EventoFocus(JTextField campo,String inicial) {
		this.campo = campo;
		this.inicial = inicial;
	}

	public void focusGained(FocusEvent arg0) {
		if((campo.getText()).equals(inicial)) {
			campo.setText("");
		}
		
	}

	public void focusLost(FocusEvent arg0) {
		if(campo.getText().isEmpty()) {
			campo.setText(inicial);
		}
		
	}
	
}

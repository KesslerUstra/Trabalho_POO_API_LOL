package eventos.click;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.JSONObject;

import api.executar.BuscadoInformacoesInvocador;

public class EventoClickInvocadorInfo implements ActionListener{
	//Atributos da classe
	private JTextField senhaAPI;
	private JTextField campo; 
	private JLabel nomeInvocador;
	private JLabel levelInvocador;
	private JLabel iconeInvocador;

	//metodo Construtor
	public EventoClickInvocadorInfo(JTextField senhaAPI,JTextField campo,JLabel nomeInvocador,JLabel levelInvocador,JLabel iconeInvocador) {
		this.senhaAPI = senhaAPI;
		this.campo = campo;
		this.nomeInvocador = nomeInvocador;
		this.levelInvocador = levelInvocador;
		this.iconeInvocador = iconeInvocador;
	}
	//metodo do click
	public void actionPerformed(ActionEvent arg0) {
		BuscadoInformacoesInvocador ApiExecutor =  new BuscadoInformacoesInvocador();
		try {
			JSONObject info = ApiExecutor.DadosAPI(campo.getText(), senhaAPI.getText());
			
			//Pegando o nome do Invocador
			String nomeInvocador2 = info.getString("name");
			//Deixando vizualmente melhor
			nomeInvocador2 = String.format("<html>"+"Nome Invocador : %s"+"<html>", nomeInvocador2);
			//Adicionando na nossa JLabel
			nomeInvocador.setText(nomeInvocador2);
			
			//Pegando o level do Invocador
			int  levelInvocador2 = info.getInt("summonerLevel");
			//Deixando vizualmente melhor
			String resultado = String.format("<html>"+"Level : %d"+"<html>", levelInvocador2);
			//Adicionando na nossa JLabel
			levelInvocador.setText(resultado);
			
			//Pegando o icone do Invocador
			int  idIconeInvocador = info.getInt("profileIconId");
			String endereco = String.format("http://ddragon.leagueoflegends.com/cdn/10.14.1/img/profileicon/%d.png",idIconeInvocador);
			URL url = new URL(endereco);
			Image imagem = ImageIO.read(url);
			iconeInvocador.setIcon(new ImageIcon(imagem));
			
		} catch (IOException e) {
			nomeInvocador.setText("Erro nome Inválido");
			e.printStackTrace();
		}
		
	}

}

package eventos.click;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import api.executar.*;
//Evento que quando apertamos iremos chamar a API
public class EventoClickInvocadorRankLOL implements ActionListener{
	//Atributos da classe
	private JTextField senhaAPI;
	private JTextField campo; 
	private JLabel nomeInvocador;
	private JLabel tierInvocador;
	private JLabel rankInvocador;
	private JLabel winInvocador;
	private JLabel lossesInvocador;
	private JLabel pdlInvocador;
	private String id;
	
	//Metodo Construtor
	public EventoClickInvocadorRankLOL(JTextField senhaAPI,JTextField campo,JLabel nomeInvocador,JLabel tierInvocador,JLabel rankInvocador
			,JLabel winInvocador,JLabel lossesInvocador,JLabel pdlInvocador) {
		this.senhaAPI = senhaAPI;
		this.campo = campo;
		this.nomeInvocador = nomeInvocador;
		this.tierInvocador = tierInvocador;
		this.rankInvocador = rankInvocador;
		this.winInvocador = winInvocador;
		this.lossesInvocador = lossesInvocador;
		this.pdlInvocador = pdlInvocador;
	}
	//metodo do click
	public void actionPerformed(ActionEvent arg0) {
		BuscadoInformacoesInvocador ApiExecutor =  new BuscadoInformacoesInvocador();
		BuscandoInformacoesRankLOL ApiExecutor2 = new BuscandoInformacoesRankLOL();
		try {
			JSONObject informacoesInvocador = ApiExecutor.DadosAPI(campo.getText(), senhaAPI.getText());
			//Pegando o nome do Invocador
			String nomeInvocador2 = informacoesInvocador.getString("name");
			//Deixando vizualmente melhor
			nomeInvocador2 = String.format("<html>"+"Nome Invocador : %s"+"<html>", nomeInvocador2);
			//Adicionando na nossa JLabel
			nomeInvocador.setText(nomeInvocador2);
			
			id = informacoesInvocador.getString("id");
			JSONArray informacoesRank = ApiExecutor2.DadosAPI(id, senhaAPI.getText());
			if(informacoesRank.isEmpty()) {
				nomeInvocador.setText("Voçe não jogou nenhum jogo Ranked .-.");
				return;
			}
			JSONObject informacoesRank2 = informacoesRank.getJSONObject(0);
			//Pegando tier Invocador
			String tierInvocador2 = informacoesRank2.getString("tier");
			tierInvocador2 = String.format("Tier : %s", tierInvocador2);
			tierInvocador.setText(tierInvocador2);
			
			//Pegando rank Invocador
			String rankInvocador2 = informacoesRank2.getString("rank");
			rankInvocador2 = String.format("Rank : %s", rankInvocador2);
			rankInvocador.setText(rankInvocador2);
			
			//Pegando wins Invocador
			int winsInvocador2 = informacoesRank2.getInt("wins");
			String resposta = String.format("Wins : %d", winsInvocador2);
			winInvocador.setText(resposta);
			
			//Pegando losses Invocador
			int lossesInvocador2 = informacoesRank2.getInt("losses");
			resposta = String.format("Losses : %d", lossesInvocador2);
			lossesInvocador.setText(resposta);
			
			//pegando os pdl :)
			int pdlInvocador2 = informacoesRank2.getInt("leaguePoints");
			resposta = String.format("PDL : %d", pdlInvocador2);
			pdlInvocador.setText(resposta);
			
		} catch (IOException e) {
			nomeInvocador.setText("Erro!!!!!  Nome ou Senha API  Inválido");
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}

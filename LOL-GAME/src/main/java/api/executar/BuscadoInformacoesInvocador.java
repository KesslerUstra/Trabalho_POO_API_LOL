package api.executar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import api.Api;
import api.JsonParser;

public class BuscadoInformacoesInvocador {
	//Metodo Construtor
	public BuscadoInformacoesInvocador() {
		
	}
	
	public JSONObject DadosAPI(String nomeInvocador,String tokenAPI) throws IOException {
		String url = String.format("https://br1.api.riotgames.com/lol/summoner/v4/summoners/by-name/%s",nomeInvocador);
		Api api = new Api(url);
		Map<String,String> cabecalhos = new HashMap<String,String>();
		cabecalhos.put("X-Riot-Token", tokenAPI);
		JSONObject json = JsonParser.parseToObject(api.executar(cabecalhos));
		return json;
	}
}

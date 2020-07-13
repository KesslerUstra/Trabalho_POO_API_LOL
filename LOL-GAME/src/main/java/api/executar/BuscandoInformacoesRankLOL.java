package api.executar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import api.Api;
import api.JsonParser;

public class BuscandoInformacoesRankLOL {
	//Metodo Construtor
	public BuscandoInformacoesRankLOL() {
		
	}
	
	public JSONArray DadosAPI(String idInvocador,String tokenAPI) throws IOException {
		String url = String.format("https://br1.api.riotgames.com/lol/league/v4/entries/by-summoner/%s",idInvocador);
		Api api = new Api(url);
		Map<String,String> cabecalhos = new HashMap<String,String>();
		cabecalhos.put("X-Riot-Token", tokenAPI);
		JSONArray json = JsonParser.parseToArray(api.executar(cabecalhos));
		return json;
	}
}

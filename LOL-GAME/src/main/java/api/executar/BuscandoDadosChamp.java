package api.executar;

import java.io.IOException;

import org.json.JSONObject;

import api.Api;
import api.JsonParser;

public class BuscandoDadosChamp {

	
	public BuscandoDadosChamp() {

	}
	
	public JSONObject DadosAPI(String nomeChamp) throws IOException {
		String url = String.format("http://ddragon.leagueoflegends.com/cdn/10.14.1/data/pt_BR/champion/%s",nomeChamp);
		url = url+".json";
		Api api = new Api(url);
		JSONObject json = JsonParser.parseToObject(api.executar());
		return json;
	}
	
	
	
	
}

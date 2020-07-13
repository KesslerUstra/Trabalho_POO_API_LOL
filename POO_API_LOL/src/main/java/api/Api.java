package api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class Api {
	//Sempre ter�
    private  HttpTransport TRANSPORT;
    private  HttpRequestFactory REQ_FACTORY;
    
    private GenericUrl url;
    
    //Metodo construtor
    public Api(String url) {
    	this.url = new GenericUrl(url);
    }
    //Metodo Construtor sobrecarga
    public Api(GenericUrl genericUrl) {
    	this.url = genericUrl;
    }
    
    //Sem nenhum cabecalho
    /**
     * Executa a requisi��o com a URL informada
     * @return Retorna uma resposta HTTP
     * @throws IOException
     */
    public HttpResponse executar() throws IOException {
    	return executar(new HashMap<String,String>());
    }
    
    
    
    //Esse metodo retorna tudo que veio de saida do API
    /**
     * Executa a requisi��o com a URL informada sendo necess�rio informar os parametros do cabe�alho
     * @param cabecalhos Lista mapeada contendo os parametros do cabe�alho
     * @return Resposta da requisi��o em HTTP
     * @throws IOException
     */
    public HttpResponse executar(Map<String,String> cabecalhos) throws IOException {
    	//Faz a requisi��o
    	HttpRequest requisicao = reqFactory().buildGetRequest(url);
    	
    	//Criamos um Headers para podermos passar nossa senha para podermos acessar a API
    	HttpHeaders cabecalho = new HttpHeaders();
    		//Map<String,String> cabecalhos = new HashMap<String,String>();
    	//Adicionamos nossa senha no cabecalho
    		//cabecalhos.put("X-Riot-Token", "RGAPI-5ae6fda8-1e99-494f-b454-1f9ac89ed07c");
    	for(String chave : cabecalhos.keySet()) {
    			//System.out.printf("Adicionando a chave %s com o valor %s\n",chave,cabecalhos.get(chave));
    		cabecalho.set(chave, cabecalhos.get(chave));
    	}
    	//Setamos a senha
    		//cabecalho.set("X-Riot-Token", "RGAPI-5ae6fda8-1e99-494f-b454-1f9ac89ed07c");
    	//E adicionamos o nosso cabecalho a nossa requisi��o
    	requisicao.setHeaders(cabecalho);
		//Executa a requisi��o
		HttpResponse resposta = requisicao.execute();
		return resposta;
    }
    
    
    
    
    
    //Metodos obrigatorios para fazer a requisi��o com a API
    
    //Metodo que sempre ter�
    private  HttpTransport transport() {
        if (null == TRANSPORT) {
            TRANSPORT = new NetHttpTransport();
        }
        return TRANSPORT;
    }
    
    //Meotodo que sempre ter�
    private  HttpRequestFactory reqFactory() {
        if (null == REQ_FACTORY) {
            REQ_FACTORY = transport().createRequestFactory();
        }
        return REQ_FACTORY;
    }
}

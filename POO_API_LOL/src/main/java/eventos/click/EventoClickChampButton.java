package eventos.click;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.json.JSONObject;

import api.executar.BuscandoDadosChamp;
//Evento que quando apertamos iremos chamar a API
public class EventoClickChampButton implements ActionListener{
	//Atributos da classe
	private JTextField campo; 
	private JLabel champ;
	private JLabel title;
	private JLabel foto;
	//Metodo Construtor
	public EventoClickChampButton(JTextField campo,JLabel champ,JLabel title,JLabel foto) {
		this.campo = campo;
		this.champ = champ;
		this.title = title;
		this.foto = foto;
	}
	//metodo do click
	public void actionPerformed(ActionEvent arg0) {
		BuscandoDadosChamp ApiExecutor = new BuscandoDadosChamp();
		try {
			//Pegando as informações do campeao
			JSONObject campeaoTotal = ApiExecutor.DadosAPI(campo.getText());
			JSONObject data = campeaoTotal.getJSONObject("data");
			JSONObject campeaoInfo = data.getJSONObject(campo.getText());
			
			//Pegando o nome do campeão
			String nomeChamp = campeaoInfo.getString("id");
			//Deixando vizualmente melhor
			nomeChamp = String.format("Nome : %s", nomeChamp);
			//Adicionando na nossa JLabel
			champ.setText(nomeChamp);
			
			//Pegando o titulo do campeao
			String titulo = campeaoInfo.getString("title");
			//Transforma nossa string para UTF-8
			byte array[] = titulo.getBytes("ISO-8859-1");
			titulo = new String(array, "UTF-8");
			titulo = String.format("<html>"+"Título : %s"+"<html>", titulo);
			//Adicionando na nossa JLabel
			title.setText(titulo);
			
			//Definindo foto lateral
			String endereco = String.format("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/%s_0.jpg", campo.getText());
			URL url = new URL(endereco);
			Image imagem = ImageIO.read(url);
			foto.setIcon(new ImageIcon(imagem));
			
		} catch (IOException e) {
			champ.setText("Erro Nome Inválido");
			e.printStackTrace();
		}
	}
	public static ByteBuffer toByteBuffer(String content, String encode) {
	    Charset charset = Charset.forName(encode);
	    ByteBuffer bb = charset.encode(content);
	    return bb;
	}

}

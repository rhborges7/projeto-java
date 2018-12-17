package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurador {

	private String idioma;
	private String regiao;
	private String arquivoAjuda;
	private String url;
	private String driver;
	private String login;
	private String senha;
	
	

	public String getIdioma() {
		return idioma;
	}

	public String getRegiao() {
		return regiao;
	}

	public String getArquivoAjuda() {
		return arquivoAjuda;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	public Configurador() {
		
		// TRATAMENTO DE ERRO PARA CASO OS ARQUIVOS CITADOS NAO POSSAM SER LIDOS
		try {

		// ABRE O ARQUIVO DE PROPRIEDADES
		FileInputStream arq = new FileInputStream("config.ini");
		// CRIA UM OBJETO PARA ARMAZENAR AS PROPRIEDADES
		Properties prop = new Properties();
		// CARREGA O CONTEUDO DO ARQUIVO DE PROPRIEDADES
		prop.load(arq);

		// FECHA O ARQUIVO DE PROPRIEDADES
		arq.close();

		// CARREGA AS RESPECTIVAS PROPRIEDADES E CADA ATRIBUTO
		idioma = prop.getProperty("idioma");
		regiao = prop.getProperty("regiao");
		arquivoAjuda = prop.getProperty("ajuda"); 
		url = prop.getProperty("url");
		driver = prop.getProperty("driver");
		login = prop.getProperty("login");
		senha = prop.getProperty("senha");
		} catch(IOException ioe) {
			System.out.println("Arquivo não Encontrado");
			
		}
		

	}
	
	

}

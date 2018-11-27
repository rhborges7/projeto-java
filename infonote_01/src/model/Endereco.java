package model;

public class Endereco {

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String logradouro;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	// METODO MOSTRAR PARAR DAR SAIDA NOS VALORES INDICADOS
	public void mostrar() {
		System.out.println("Logradouro : " + logradouro);
		System.out.println("Numero : " + numero);
		System.out.println("Complemento : " + complemento);
		System.out.println("Bairro : " + bairro);
		System.out.println("Cidade : " + cidade);
		System.out.println("Estado : " + estado);
		System.out.println("CEP : " + cep);
	}

	/**
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param estado
	 * @param cep
	 */
	public Endereco(String logradouro, String numero, String complemento, String bairro, String cidade, String estado,
			String cep) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Endereco \n logradouro =" + logradouro + "\n numero =" + numero + "\n complemento =" + complemento
				+ "\n bairro =" + bairro + "\n cidade =" + cidade + "\n estado =" + estado + "\n cep=" + cep ;
	}

	

}

package model;

public class ItemDePedido {
	
	private int qtde;
	private double subtotal;
	/**
	 * @return the qtde
	 */
	public int getQtde() {
		return qtde;
	}
	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	// METODO MOSTRAR PARAR DAR SAIDA NOS VALORES INDICADOS
	public void mostrar() {
		System.out.println("Logradouro : " + qtde);
		System.out.println("Numero : " + subtotal);
		
	}

}

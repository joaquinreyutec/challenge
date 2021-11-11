package clases;

public class Carril {
	private int numero;
	private Pista pista;

	public Carril() {
		super();
	}

	public Carril(int numero, Pista pista) {
		super();
		this.numero = numero;
		this.pista = pista;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

}

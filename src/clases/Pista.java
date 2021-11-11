package clases;

import java.util.ArrayList;

public class Pista {
	private String nombrePista;
	private int limite_distancia; // kilometros
	private ArrayList<Carril> carriles;

	public Pista() {
		super();
	}

	public Pista(String nombrePista, int limite) {
		super();
		this.nombrePista = nombrePista;
		this.limite_distancia = limite;
		this.carriles = new ArrayList<Carril>();
	}

	public String getNombrePista() {
		return nombrePista;
	}

	public void setNombrePista(String nombrePista) {
		this.nombrePista = nombrePista;
	}

	public int getLimite_distancia() {
		return limite_distancia;
	}

	public void setLimite_distancia(int limite_distancia) {
		limite_distancia = limite_distancia;
	}

	public ArrayList<Carril> getCarriles() {
		return carriles;
	}

	public void setCarriles(ArrayList<Carril> carriles) {
		this.carriles = carriles;
	}

}

package clases;

import java.util.ArrayList;

public final class Podio {
	private ArrayList<Carro> ganadores;
	private static Podio instancia;

	public ArrayList<Carro> getGanadores() {

		ArrayList<Carro> top = new ArrayList<Carro>();
		if (ganadores.size() >= 3) {

			for (int i = 0; i < 3; i++) {
				top.add(ganadores.get(i));
			}
			return top;
		}
		return null;
	}

	public void agregarGanador(Carro ganador) {
		this.ganadores.add(ganador);
	}

	private Podio() {
		super();
		this.ganadores = new ArrayList<Carro>();
	}

	public static Podio getInstance() {
		if (instancia == null) {
			instancia = new Podio();
		}
		return instancia;
	}
	
	public boolean gano(int numeroCarro) {
		
		for (Carro carro : ganadores) {
			if(carro.getNro_carro()==numeroCarro) {
				return true;
			}
		}
		return false;
	}

}

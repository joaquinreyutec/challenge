package clases;

public class Carro {
	private int nro_carro;
	private int distancia = 0;
	private Carril carril_avance;
	private Conductor conductor;

	public Carro() {
		super();
	}

	public Carro(int nro_carro, int distancia, Carril carril_avance, Conductor conductor) {
		super();
		this.nro_carro = nro_carro;
		this.distancia = distancia;
		this.carril_avance = carril_avance;
		this.conductor = conductor;
	}

	public int getNro_carro() {
		return nro_carro;
	}

	public void setNro_carro(int nro_carro) {
		this.nro_carro = nro_carro;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public Carril getCarril_avance() {
		return carril_avance;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public void setCarril_avance(Carril carril_avance) {
		this.carril_avance = carril_avance;
	}

	@Override
	public String toString() {
		return "Carro [nro_carro=" + nro_carro + ", distancia=" + distancia + ", carril_avance="
				+ carril_avance.getNumero() + ", conductor=" + conductor + "]";
	}

	public void avanceAleatorio() {

		Podio podio = Podio.getInstance();
		if (podio.gano(this.nro_carro)) {
			return;
		}

		int avance = ((int) (Math.random() * 6) + 1) * 100;
		if (carril_avance.getPista().getLimite_distancia() * 1000 > (this.distancia + avance)) {
			distancia = distancia + avance;
		} else {
			System.out.println("Gano");
			distancia = carril_avance.getPista().getLimite_distancia() * 1000;
			podio.agregarGanador(this);

		}

	}

}

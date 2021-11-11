package clases;

public class Jugador {
	private String nombre;
	private Conductor conductor;

	public Jugador() {
		super();
	}

	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + "]";
	}

}

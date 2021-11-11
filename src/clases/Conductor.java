package clases;

public class Conductor {
	private int id;
	private String nombre;
	private Carro carro_conducido;

	public Conductor() {
		super();
	}

	public Conductor(int id, String nombre, Carro carro_conducido) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carro getCarro_conducido() {
		return carro_conducido;
	}

	public void setCarro_conducido(Carro carro_conducido) {
		this.carro_conducido = carro_conducido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Conductor [id=" + id + ", nombre=" + nombre + ", carro_conducido=" + carro_conducido.getNro_carro()
				+ "]";
	}

}

package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class Juego {
	private int limitePista;
	private ArrayList<Jugador> listJugadores;
	private static Juego instancia = null;
	Connection connection = null;

	private Juego(int limite) {
		this.listJugadores = new ArrayList<Jugador>();
		this.limitePista = limite;
	}

	public static Juego getInstance(int limite) {
		if (instancia == null) {
			instancia = new Juego(limite);
		}
		return instancia;

	}

	public ArrayList<Jugador> getListJugadores() {
		return listJugadores;
	}

	public void setListJugadores(ArrayList<Jugador> listJugadores) {
		this.listJugadores = listJugadores;
	}

	public void configurarJuego() { // ConfigurarJuego

		Pista p1 = new Pista("Dubai", limitePista);
		Pista p2 = new Pista("Monaco", limitePista);
		Pista p3 = new Pista("Rio de Janeiro", limitePista);

		// Pista 1 con multiple carriles
		Carril carril1 = new Carril(1, p1);
		Carril carril2 = new Carril(2, p1);
		Carril carril3 = new Carril(3, p1);
		Carril carril4 = new Carril(4, p1);

		// Pista 2 con multiple carriles
		Carril carril5 = new Carril(5, p2);
		Carril carril6 = new Carril(6, p2);
		Carril carril7 = new Carril(7, p2);
		Carril carril8 = new Carril(8, p2);

		Carro c1 = new Carro(1, 0, carril1, null); // c1,p1
		Carro c2 = new Carro(2, 0, carril2, null); // c2, p2
		Carro c3 = new Carro(3, 0, carril3, null);

		Conductor con1 = new Conductor(1, "Conductor 1", c1);
		Conductor con2 = new Conductor(2, "Conductor 2", c2);
		Conductor con3 = new Conductor(3, "Conductor 3", c3);
		c1.setConductor(con1);
		c2.setConductor(con2);
		c3.setConductor(con3);

		Jugador j1 = new Jugador("jugador 1");
		Jugador j2 = new Jugador("jugador 2");
		Jugador j3 = new Jugador("jugador 3");

		j1.setConductor(con1);
		j2.setConductor(con2);
		j3.setConductor(con3);

		con1.setCarro_conducido(c1);
		con2.setCarro_conducido(c2);
		con3.setCarro_conducido(c3);

		c1.setCarril_avance(carril1);
		c2.setCarril_avance(carril2);
		c3.setCarril_avance(carril3);

		carril1.setPista(p1);
		carril2.setPista(p1);
		carril3.setPista(p1);

		listJugadores.add(j1);
		listJugadores.add(j2);
		listJugadores.add(j3);

	}

	public void inicilizarJuego() {

		for (Jugador jugador : listJugadores) {
			System.out.println(jugador.toString());
			Conductor conductor = jugador.getConductor();
			System.out.println(conductor.toString());
			Carro carro = conductor.getCarro_conducido();
			System.out.println(carro.toString());
			carro.avanceAleatorio();
			System.out.println();
			System.out.println(carro.toString());

		}

	}

	public void asignarPodio() {
		Podio podio = Podio.getInstance();

		ArrayList<Carro> listaPodio = podio.getGanadores();
		if (listaPodio == null) {
			System.out.println("Todavia no se armo el podio");
			return;
		}
		for (Carro carro : listaPodio) {
			System.out.println(carro.toString());
		}
	}

	public void guardarDatos() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontro el Driver para Oracle DB - la libreria necesaria esta referenciada");

			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // conexion
						"DESAFIO", // usuario
						"DESAFIO"); // clave
				System.out.println("Conexion creada con exito, es posible acceder a la base de datos!");

				int posicion = 0;
				for (Carro carro : Podio.getInstance().getGanadores()) {
					int id = carro.getConductor().getId();
					String nombre = carro.getConductor().getNombre();
					posicion++;
					int cant = 1;
					String insert_podio = "INSERT INTO PODIO" + "(ID,NOMBRE,POSICION,CANTIDAD) values(?,?,?,?) "; // Falta consultar a la BD si este jugador ya habia
																											// ganado para incrementar la cantidad de podios obtenidos.

					PreparedStatement statement = connection.prepareStatement(insert_podio);
					statement.setInt(1, id);
					statement.setString(2, nombre);
					statement.setInt(3, posicion);
					statement.setInt(4, cant);
					statement.executeUpdate();
					System.out.println("Datos cargados en la base de datos!");
				}
				try {
					connection.close();
					System.out.println("Conexion cerrada con exito, ya no es posible acceder a la base de datos");

				} catch (SQLException e) {
					System.out.println("Error al cerrar la conexion");
					e.printStackTrace();
					return;
				}
			} catch (SQLException e) {

				System.out.println("No logramos instanciar una conexion!");
				e.printStackTrace();
				return;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-path!");
			e.printStackTrace();
			return;
		}

	}
}

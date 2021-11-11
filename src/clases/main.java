package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println();
		System.out.println(" #############   JUEGO DE CARROS POR CONSOLA   #############");
		boolean salir = false;
		int opcion;
		Scanner sn = new Scanner(System.in);
		boolean var = true;
		while (!salir) {
			System.out.println("1 - Crear carro");
			System.out.println("2 - Inicializar juego e incrementar");
			System.out.println("3 - Asignar podio");
			System.out.println("4 - Guardar en Base de datos");
			System.out.println("5 - Salir");
			System.out.println("Eliga una opcion por el numero asociado anteriormente:");
			opcion = sn.nextInt();

			switch (opcion) {
			case 1: {
				System.out.println();
				System.out.println("Ingresar numero del carro: ");
				int numeroCarro = 0;
				Scanner scan = new Scanner(System.in);
				numeroCarro = scan.nextInt();
				Carro c = new Carro();
				c.setNro_carro(numeroCarro);
				System.out.println();
				break;
			}
			case 2: {
				Juego j1 = Juego.getInstance(1);
				if (var) {
					j1.configurarJuego();
					var = false;
				}
				j1.inicilizarJuego();
				break;
			}
			case 3:{
				Juego j1 = Juego.getInstance(1);
				j1.asignarPodio();
				break;
			}

			case 4: {
				Juego j1 = Juego.getInstance(1);
				j1.guardarDatos();
				break;
			}
			case 5:{
				salir=true;
			}
			
			}

		}

	}

}

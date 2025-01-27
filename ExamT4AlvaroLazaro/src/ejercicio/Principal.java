package ejercicio;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		int tam = 5, posicion = 0, eleccion, eleccion2, zona, fila, asiento, numPersonas;
		double porcentaje = 10, extraFamoso = 20, iva;
		String nombreFamoso;
		Scanner sc = new Scanner(System.in);
		Normales lista[] = new Normales[tam];
		Taquilla taquilla = new Taquilla(lista);

		System.out.println("Bienvenido a la taquilla del Circo del Sol.");

		do {
			System.out.println("""
					¿Qué deseas hacer?
					0. Salir
					1. Agregar entrada
					2. Calcular Precio de una entrada
					3. Calcular recaudación entradas de grupo
					4. Calcular recaudación entradas zona 2
					5. Ver ticket de botellas de famoso
					6. Calcular Iva de todas las entradas""");
			eleccion = sc.nextInt();
			switch (eleccion) {
				case 0:
					System.out.println("Saliendo...");
					break;
				case 1:
					do {
						System.out.println("""
								¿Qué entrada quieres?
								1. Normal
								2. Grupo
								3. Famoso""");
						eleccion2 = sc.nextInt();
						switch (eleccion2) {
							case 1:
								do {
									System.out.println("En que zona quieres estar en la 1 o en la 2.");
									do {
										zona = sc.nextInt();
										if (zona > 2 || zona < 1) {
											System.out.println("No existen dichas zonas.");
										}
									} while (zona > 2 || zona < 1);
									System.out.println("En que fila quieres estar.");
									fila = sc.nextInt();
									System.out.println("En que asiento quieres estar.");
									asiento = sc.nextInt();
									if (taquilla.estarOcupado(zona, fila, asiento)) {
										System.out.println("Lo siento pero está zona esta ocupada.\n" + "Dígame otro lugar.");
									}
								} while (taquilla.estarOcupado(zona, fila, asiento));
								lista[posicion] = new Normales(zona, fila, asiento);
								taquilla.agregarEntrada(lista[posicion], posicion);
								posicion++;
								break;
							case 2:
								do {
									System.out.println("En que zona quieres estar en la 1 o en la 2.");
									do {
										zona = sc.nextInt();
										if (zona > 2 || zona < 1) {
											System.out.println("No existen dichas zonas.");
										}
									} while (zona > 2 || zona < 1);
									System.out.println("En que fila quieres estar.");
									fila = sc.nextInt();
									System.out.println("En que asiento quieres estar.");
									asiento = sc.nextInt();
									if (taquilla.estarOcupado(zona, fila, asiento)) {
										System.out.println("Lo siento pero está zona esta ocupada.\n" + "Dígame otro lugar.");
									}
								} while (taquilla.estarOcupado(zona, fila, asiento));
								System.out.println("Cuántas personas le acompañan.");
								numPersonas = sc.nextInt();
								lista[posicion] = new Grupos(zona, fila, asiento, numPersonas);
								taquilla.agregarEntrada(lista[posicion], posicion);
								posicion++;
								break;
							case 3:
								do {
									System.out.println("En que zona quieres estar en la 1 o en la 2.");
									do {
										zona = sc.nextInt();
										if (zona > 2 || zona < 1) {
											System.out.println("No existen dichas zonas.");
										}
									} while (zona > 2 || zona < 1);
									System.out.println("En que fila quieres estar.");
									fila = sc.nextInt();
									System.out.println("En que asiento quieres estar.");
									asiento = sc.nextInt();
									if (taquilla.estarOcupado(zona, fila, asiento)) {
										System.out.println("Lo siento pero está zona esta ocupada.\n" + "Dígame otro lugar.");
									}
								} while (taquilla.estarOcupado(zona, fila, asiento));
								System.out.println("Cuál es su nombre Famoso.");
								nombreFamoso = sc.next();
								lista[posicion] = new Famoso(zona, fila, asiento, nombreFamoso);
								taquilla.agregarEntrada(lista[posicion], posicion);
								posicion++;
								break;
							default:
								System.out.println("Elige una opción correcta.");
								break;
						}
					} while (eleccion2 > 3 || eleccion < 1);
					break;
				case 2:
					System.out.println("En que zona se encuentra.");
					zona = sc.nextInt();
					System.out.println("En que fila se encuentra.");
					fila = sc.nextInt();
					System.out.println("En que asiento se encuentra.");
					asiento = sc.nextInt();
					System.out.printf("El precio de la entrada es de: %.2f€.\n",
							taquilla.calcularPrecioUnaEntrada(zona, fila, asiento, porcentaje, extraFamoso));
					break;
				case 3:
					System.out.printf("La recaudación total de las entradas de grupo es de: %.2f€.\n",
							taquilla.calcularEntradasGrupo(porcentaje, extraFamoso));
					break;
				case 4:
					System.out.printf("La recaudación total de las entradas de la zona 2 es de: %.2f€.\n",
							taquilla.calcularEntradasZona2(porcentaje, extraFamoso));
					break;
				case 5:
					taquilla.imprimirTicketFamoso();
					break;
				case 6:
					System.out.println("A cuanto está el iva ahora mismo.");
					iva = sc.nextDouble();
					System.out.printf("El total recudado en iva es de: %.2f€.\n",
							taquilla.calcularIvaEntradas(iva, porcentaje, extraFamoso));
					break;
				default:
					System.out.println("Elige una opción correcta.");
					break;
			}
		} while (eleccion != 0);
		System.out.println("Gracias por usar este programa.");
		sc.close();

	}

}

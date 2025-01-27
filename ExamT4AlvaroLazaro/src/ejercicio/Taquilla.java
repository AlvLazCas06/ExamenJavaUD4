package ejercicio;

import java.util.Arrays;

public class Taquilla {

	private Normales lista[];

	public Taquilla(Normales[] lista) {
		this.lista = lista;
	}

	public Normales[] getLista() {
		return lista;
	}

	public void setLista(Normales[] lista) {
		this.lista = lista;
	}

	public String toString() {
		return "Taquilla [lista=" + Arrays.toString(lista) + "]";
	}
	
	public void agregarEntrada(Normales entrada, int posicion) {
		lista[posicion] = entrada;
	}
	
	public double calcularPrecioUnaEntrada(int zona, int fila, int asiento, double porcentaje, double extraFamoso) {
		double total = 0;
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			if (lista[i].getZona() == zona && lista[i].getNumFila() == fila && lista[i].getNumAsiento() == asiento) {
				total = lista[i].calcularPrecioEntrada(porcentaje, extraFamoso);
			}
		}
		return total;
	}
	
	public double calcularEntradasGrupo(double porcentaje, double extraFamoso) {
		double total = 0;
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			if (lista[i] instanceof Grupos) {
				total = lista[i].calcularPrecioEntrada(porcentaje, extraFamoso);
			}
		}
		return total;
	}
	
	public double calcularEntradasZona2(double porcentaje, double extraFamoso) {
		double total = 0;
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			if (lista[i].getZona() == 2) {
				total = lista[i].calcularPrecioEntrada(porcentaje, extraFamoso);
			}
		}
		return total;
	}
	
	public void imprimirTicketFamoso() {
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			if (lista[i] instanceof Famoso) {
				((Famoso)lista[i]).mostrarMensajeFamoso();
			}
		}
	}

	public double calcularIvaEntradas(double porcentajeIva, double porcentaje, double extraFamoso) {
		double total = 0;
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			total = lista[i].calcularIVA(porcentajeIva, porcentaje, extraFamoso);
		}
		return total;
	}
	
	public boolean estarOcupado(int zona, int fila, int asiento) {
		boolean ocupado = false;
		for (int i = 0; i < lista.length && lista[i] != null; i++) {
			if (lista[i].getZona() == zona && lista[i].getNumFila() == fila && lista[i].getNumAsiento() == asiento) {
				ocupado = true;
			}
		}
		return ocupado;
	}
	
}

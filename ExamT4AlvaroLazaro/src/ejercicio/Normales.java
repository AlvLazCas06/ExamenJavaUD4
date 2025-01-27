package ejercicio;

public class Normales implements IDesglosable {

	private int zona;
	private int numFila;
	private int numAsiento;

	public Normales(int zona, int numFila, int numAsiento) {
		this.zona = zona;
		this.numFila = numFila;
		this.numAsiento = numAsiento;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getNumFila() {
		return numFila;
	}

	public void setNumFila(int numFila) {
		this.numFila = numFila;
	}

	public int getNumAsiento() {
		return numAsiento;
	}

	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}

	public String toString() {
		return "Normales [zona=" + zona + ", numFila=" + numFila + ", numAsiento=" + numAsiento + "]";
	}

	public double calcularPrecioEntrada(double porcentaje, double extraFamoso) {
		double precioEntrada = 0;
		if (zona == 1) {
			precioEntrada = 40;
		}
		if (zona == 2) {
			precioEntrada = 70;
		}

		return precioEntrada;

	}
	
	public double calcularIVA(double porcentajeIva, double porcentaje, double extraFamoso) {
		double cien = 100;
		return calcularPrecioEntrada(porcentaje, extraFamoso) * (porcentajeIva / cien);
	}

}

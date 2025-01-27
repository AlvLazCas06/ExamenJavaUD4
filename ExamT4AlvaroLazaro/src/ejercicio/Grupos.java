package ejercicio;

public class Grupos extends Normales {

	private int numPersonas;

	public Grupos(int zona, int numFila, int numAsiento, int numPersonas) {
		super(zona, numFila, numAsiento);
		this.numPersonas = numPersonas;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String toString() {
		return "Grupos [numPersonas=" + numPersonas + "]";
	}
	
	public double calcularPrecioEntrada(double porcentaje, double extraFamoso) {
		double precioEntrada = super.calcularPrecioEntrada(porcentaje, extraFamoso), cien = 100;
		
		if (numPersonas > 10) {
			precioEntrada -= (precioEntrada * (porcentaje / cien));
		}
		
		return precioEntrada;

	}
	
	public double calcularIVA(double porcentajeIva, double porcentaje, double extraFamoso) {
		double cien = 100;
		return calcularPrecioEntrada(porcentaje, extraFamoso) * (porcentajeIva / cien);
	}
	
}

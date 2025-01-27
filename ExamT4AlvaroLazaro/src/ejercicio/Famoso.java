package ejercicio;

public class Famoso extends Normales {

	private String famoso;

	public Famoso(int zona, int numFila, int numAsiento, String famoso) {
		super(zona, numFila, numAsiento);
		this.famoso = famoso;
	}

	public String getFamoso() {
		return famoso;
	}

	public void setFamoso(String famoso) {
		this.famoso = famoso;
	}

	public String toString() {
		return "Famoso [famoso=" + famoso + "]";
	}

	public double calcularPrecioEntrada(double porcentaje, double extraFamoso) {
		double precioEntrada = super.calcularPrecioEntrada(porcentaje, extraFamoso);

		precioEntrada += extraFamoso;

		return precioEntrada;

	}
	
	public double calcularIVA(double porcentajeIva, double porcentaje, double extraFamoso) {
		double cien = 100;
		return calcularPrecioEntrada(porcentaje, extraFamoso) * (porcentajeIva / cien);
	}
	
	public void mostrarMensajeFamoso() {
		System.out.println("Botella gratis para " + famoso);
	}

}

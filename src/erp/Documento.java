// Clase abstracta Documento
package erp;

public abstract class Documento implements Calculable {
    protected String numero;
    protected String solicitante;

    public Documento(String numero, String solicitante) {
        this.numero = numero;
        this.solicitante = solicitante;
    }

    public abstract double calcularCostoTotal();
}

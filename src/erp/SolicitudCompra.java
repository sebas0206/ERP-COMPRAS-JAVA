// Clase SolicitudCompra
package erp;

import java.util.*;

public class SolicitudCompra extends Documento {
    private List<Item> items = new ArrayList<>();
    private EstadoSolicitud estado;

    public SolicitudCompra(String numero, String departamento) {
        super(numero, departamento);
        this.estado = EstadoSolicitud.SOLICITADA;
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public double calcularCostoTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.calcularCostoTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Solicitud #%s [Departamento=%s, Estado=%s, Total=%.2f, Items=%s]",
                numero, solicitante, estado, calcularCostoTotal(), items.toString());
    }
}

// Clase Producto
package erp;

public class Producto implements Calculable {
    private String nombre;
    private double precioUnitario;
    private int cantidadDisponible;
    private Proveedor proveedor;

    public Producto(String nombre, double precioUnitario, int cantidadDisponible, Proveedor proveedor) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public double calcularCostoTotal() {
        return precioUnitario * cantidadDisponible;
    }

    @Override
    public String toString() {
        return String.format("Producto [Nombre=%s, Precio=%.2f, Cantidad=%d, Proveedor=%s]",
                nombre, precioUnitario, cantidadDisponible, proveedor.getNombre());
    }
}

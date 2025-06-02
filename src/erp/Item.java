// Clase Item
package erp;

public class Item implements Calculable {
    private Producto producto;
    private int cantidad;

    public Item(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public double calcularCostoTotal() {
        return producto.getPrecioUnitario() * cantidad;
    }

    @Override
    public String toString() {
        return String.format("Item [Producto=%s, Cantidad=%d, Subtotal=%.2f]",
                producto.getNombre(), cantidad, calcularCostoTotal());
    }
}

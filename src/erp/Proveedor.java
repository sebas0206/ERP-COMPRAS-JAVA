// Clase Proveedor
package erp;

public class Proveedor extends Entidad {
    private String id;

    public Proveedor(String nombre, String id) {
        super(nombre);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Proveedor [ID=" + id + ", Nombre=" + nombre + "]";
    }
}

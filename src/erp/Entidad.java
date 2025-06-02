// Clase base Entidad
package erp;

public abstract class Entidad {
    protected String nombre;

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String toString();
}
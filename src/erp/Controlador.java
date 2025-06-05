// Aquí va la clase Controlador con el menú
package erp;

import java.util.*;

public class Controlador {
    private Scanner scanner = new Scanner(System.in);
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<SolicitudCompra> solicitudes = new ArrayList<>();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> registrarProveedor();
                case 2 -> registrarProducto();
                case 3 -> registrarSolicitudCompra();
                case 4 -> listarProveedores();
                case 5 -> listarProductos();
                case 6 -> listarSolicitudes();
                case 7 -> buscarProveedorPorID();
                case 8 -> buscarProveedorPorNombre();
                case 9 -> buscarProductoPorNombre();
                case 10 -> buscarSolicitudPorNumero();
                case 11 -> aprobarORechazarSolicitud();
                case 12 -> calcularTotalSolicitud();
                case 13 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 15);
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
        System.out.println("1.  Registrar proveedor");
        System.out.println("2.  Registrar producto");
        System.out.println("3.  Registrar solicitud de compra");
        System.out.println("4.  Listar proveedores");
        System.out.println("5.  Listar productos");
        System.out.println("6.  Listar solicitudes de compra");
        System.out.println("7.  Buscar proveedor por ID");
        System.out.println("8.  Buscar proveedor por Nombre");
        System.out.println("9.  Buscar producto por nombre");
        System.out.println("10. Buscar solicitud por número");
        System.out.println("11. Aprobar / Rechazar solicitud de compra");
        System.out.println("12. Calcular total de una solicitud");
        System.out.println("13. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // private void registrarProveedor() {
    //     System.out.print("Nombre del proveedor: ");
    //     String nombre = scanner.nextLine();
    //     System.out.print("ID del proveedor: ");
    //     String id = scanner.nextLine();
    //     proveedores.add(new Proveedor(nombre, id));
    //     System.out.println("Proveedor registrado con éxito.");
    // }

    private void registrarProveedor() {
    System.out.print("Nombre del proveedor: ");
    String nombre = scanner.nextLine();
    System.out.print("ID del proveedor: ");
    String id = scanner.nextLine();

    // Verificar si ya existe un proveedor con el mismo ID o nombre
    for (Proveedor p : proveedores) {
        if (p.getId().equalsIgnoreCase(id)) {
            System.out.println("Ya existe un proveedor con ese ID.");
            return;
        }
        if (p.getNombre().equalsIgnoreCase(nombre)) {
            System.out.println("Ya existe un proveedor con ese nombre.");
            return;
        }
    }

    // Si pasa las validaciones, agregar el proveedor
    proveedores.add(new Proveedor(nombre, id));
    System.out.println("Proveedor registrado con éxito.");
    }


    private void registrarProducto() {
        if (proveedores.isEmpty()) {
            System.out.println("Debe registrar al menos un proveedor primero.");
            return;
        }

        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Cantidad disponible: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        listarProveedores();
        System.out.print("Ingrese el ID del proveedor: ");
        String idProveedor = scanner.nextLine();
        Proveedor proveedor = proveedores.stream()
                .filter(p -> p.getId().equals(idProveedor))
                .findFirst()
                .orElse(null);

        if (proveedor == null) {
            System.out.println("Proveedor no encontrado.");
            return;
        }

        productos.add(new Producto(nombre, precio, cantidad, proveedor));
        System.out.println("Producto registrado con éxito.");
    }

    private void registrarSolicitudCompra() {
        if (productos.isEmpty()) {
            System.out.println("Debe registrar al menos un producto primero.");
            return;
        }

        System.out.print("Número de solicitud: ");
        String numero = scanner.nextLine();
        System.out.print("Departamento solicitante: ");
        String depto = scanner.nextLine();

        SolicitudCompra solicitud = new SolicitudCompra(numero, depto);

        boolean agregarMas = false;
        do {
            listarProductos();
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            Producto prod = productos.stream()
                    .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                    .findFirst()
                    .orElse(null);

            if (prod == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad solicitada: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            solicitud.agregarItem(new Item(prod, cantidad));

            System.out.print("¿Agregar otro producto? (s/n): ");
            agregarMas = scanner.nextLine().equalsIgnoreCase("s");

        } while (agregarMas);

        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada con éxito.");
    }

    private void listarProveedores() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            proveedores.forEach(System.out::println);
        }
    }

    private void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            productos.forEach(System.out::println);
        }
    }

    private void listarSolicitudes() {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
        } else {
            solicitudes.forEach(System.out::println);
        }
    }

    private void buscarProveedorPorID() {
        System.out.print("Ingrese el ID del proveedor: ");
        String id = scanner.nextLine();
        proveedores.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Proveedor no encontrado.")
                );
    }

    private void buscarProveedorPorNombre() {
    System.out.print("Ingrese el nombre del proveedor: ");
    String nombre = scanner.nextLine().trim();

    proveedores.stream()
            .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Proveedor no encontrado.")
            );
}

    

    private void buscarProductoPorNombre() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Producto no encontrado.")
                );
    }

    private void buscarSolicitudPorNumero() {
        System.out.print("Número de solicitud: ");
        String numero = scanner.nextLine();
        solicitudes.stream()
                .filter(s -> s.getNumero().equals(numero))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Solicitud no encontrada.")
                );
    }

    private void aprobarORechazarSolicitud() {
        System.out.print("Número de solicitud: ");
        String numero = scanner.nextLine();
        Optional<SolicitudCompra> opt = solicitudes.stream()
                .filter(s -> s.getNumero().equals(numero))
                .findFirst();

        if (opt.isEmpty()) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        SolicitudCompra s = opt.get();
        System.out.print("¿Desea aprobar (a) o rechazar (r) la solicitud?: ");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("a")) {
            s.setEstado(EstadoSolicitud.APROBADA);
        } else if (opcion.equalsIgnoreCase("r")) {
            s.setEstado(EstadoSolicitud.RECHAZADA);
        } else {
            System.out.println("Opción inválida.");
            return;
        }
        System.out.println("Solicitud actualizada: " + s.getEstado());
    }

    private void calcularTotalSolicitud() {
        System.out.print("Número de solicitud: ");
        String numero = scanner.nextLine();
        solicitudes.stream()
                .filter(s -> s.getNumero().equals(numero))
                .findFirst()
                .ifPresentOrElse(
                        s -> System.out.printf("Total de la solicitud #%s: %.2f\n", s.getNumero(), s.calcularCostoTotal()),
                        () -> System.out.println("Solicitud no encontrada.")
                );
    }
}

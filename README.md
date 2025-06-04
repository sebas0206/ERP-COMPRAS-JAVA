# Autor:

-*Nombre:* Mateo Sebastian Tacuri Chuchuca

-*Universidad:* UPS

-*CI:* 0150552073

-*Carrera:* Electronica y Automatizacion.

# Sistema de Gestión de Compras ERP

Este proyecto es un módulo de compras desarrollado como parte de un sistema ERP en Java. Permite automatizar tareas relacionadas con la gestión
de proveedores, productos y solicitudes de compra, usando principios de Programación Orientada a Objetos (POO).

## Características

- Registro y listado de proveedores y productos.
- Creación de solicitudes de compra por departamento.
- Control de estados de solicitudes: SOLICITADA, EN_REVISIÓN, APROBADA, RECHAZADA.
- Cálculo de costos totales usando una interfaz `Calculable`.
- Menú interactivo en consola.

## Conceptos Basicos del Proyecto

- *Lenguaje:* Java
- *Paradigma:* Programación Orientada a Objetos (POO)
- *Estructura modular y reutilizable* con varios principios como Herencias, Clases Abstractas, Interfaces, etc.
- *GitHub* para control de versiones y usar el repositorio

# Principios de la POO utilizados en el proyecto

| Concepto        | Implementación                                      |
|-----------------|-----------------------------------------------------|
| Herencia        | `Proveedor` hereda de la clase abstracta `Entidad` |
| Clases abstractas | `Entidad`, `Documento`                           |
| Interfaces      | `Calculable` implementada por `Producto`, `Item`, `SolicitudCompra` |
| Enums           | `EstadoSolicitud`                                   |
| Polimorfismo    | Procesamiento dinámico de objetos `Calculable`      |

## Diagrama de Clases del Proyecto

![image](https://github.com/user-attachments/assets/71b711f4-b6d4-4d74-881b-2422873a3ea0)

## Cómo ejecutar el proyecto

Dentro de la linea de comandos, desde nuestra terminal, vamos a ejecutar el siguienre codigo:

    1. Abre el proyecto en VS Code
    2. Compila con: `javac -d bin src/erp/*.java`
    3. Ejecuta con: `java -cp bin erp.Main`
   
Es muy impoprtante compilar primero todos losa archivos .java, para que el codigo pueda ser revisado por la maquina y luego debemos ejecutarla para
que no exista ninguna confucion o error no deseado en nuestro codigo.

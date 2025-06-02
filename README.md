# Autor:

*Nombre:* Mateo Sebastian Tacuri Chuchuca
*Universidad:* UPS
*CI:* 0150552073
*Carrera:* Electronica y Automatizacion.

# Sistema de Gestión de Compras ERP

Este proyecto es un módulo de compras desarrollado como parte de un sistema ERP en Java. Permite automatizar tareas relacionadas con la gestión
de proveedores, productos y solicitudes de compra, usando principios de Programación Orientada a Objetos (POO).

## Funcionalidades

- Registro de *proveedores* y *productos* asociados.
- Creación de *solicitudes de compra* por parte de distintos departamentos.
- Estados de solicitud: `SOLICITADA`, `EN_REVISION`, `APROBADA`, `RECHAZADA`.
- Cálculo automático del *total* de cada solicitud.
- Interfaz de *menú en consola* para registrar, listar, buscar y aprobar solicitudes.

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

## ▶Cómo ejecutar el proyecto

Dentro de la linea de comandos, desde nuestra terminal, vamos a ejecutar el siguienre codigo:

    1. Abre el proyecto en VS Code
    2. Compila con: `javac -d bin src/erp/*.java`
    3. Ejecuta con: `java -cp bin erp.Main`
   
Es muy impoprtante compilar primero todos losa archivos .java, para que el codigo pueda ser revisado por la maquina y luego debemos ejecutarla para
que no exista ninguna confucion o error no deseado en nuestro codigo.

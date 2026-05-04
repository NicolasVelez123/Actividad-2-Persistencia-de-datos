package com.escuela.main;

import com.escuela.controllers.*;
import com.escuela.entities.*; // Esto importa las entidades REALES (Motocicleta, ServicioTecnico, etc.)
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Cambia "unidad_persistencia_motos" por el nombre exacto que tengas en tu persistence.xml
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad_persistencia_motos");
    
    private static MotocicletaJpaController motoController = new MotocicletaJpaController(emf);
    private static TipoMotocicletaJpaController tipoController = new TipoMotocicletaJpaController(emf);
    private static ProveedorJpaController provController = new ProveedorJpaController(emf);
    private static ServicioTecnicoJpaController servicioController = new ServicioTecnicoJpaController(emf);
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n********** SISTEMA DE GESTIÓN MOTOCICLETAS **********");
            System.out.println("1. Registrar Proveedor (Nombre y Contacto)");
            System.out.println("2. Registrar Motocicleta (Marca, Modelo, Tipo y Proveedor)");
            System.out.println("3. Registrar Servicio Técnico (Detalle y Precio)");
            System.out.println("4. Listar Inventario de Motos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: crearProveedor(); break;
                case 2: crearMotocicleta(); break;
                case 3: crearServicioTecnico(); break;
                case 4: listarMotos(); break;
                case 0: System.out.println("Cerrando sistema..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        
        emf.close();
    }

    private static void crearProveedor() {
        System.out.println("\n--- NUEVO PROVEEDOR ---");
        System.out.print("Ingrese Nombre del Proveedor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Contacto (Telf/Email): ");
        String contacto = scanner.nextLine();

        Proveedor p = new Proveedor();
        p.setNombreProv(nombre);
        p.setContactoProv(contacto);

        provController.create(p);
        System.out.println("✔ Proveedor guardado correctamente.");
    }

    private static void crearMotocicleta() {
        System.out.println("\n--- NUEVA MOTOCICLETA ---");
        System.out.print("Marca: "); String marca = scanner.nextLine();
        System.out.print("Modelo: "); String modelo = scanner.nextLine();
        System.out.print("Año: "); int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio de Venta: "); double precio = Double.parseDouble(scanner.nextLine());

        System.out.println("Seleccione el ID del Tipo de Moto:");
        tipoController.findTipoMotocicletaEntities().forEach(t -> 
            System.out.println(t.getIdTipo() + ". " + t.getDescripcionTipo()));
        int idT = Integer.parseInt(scanner.nextLine());
        TipoMotocicleta tipo = tipoController.findTipoMotocicleta(idT);

        System.out.println("Seleccione el ID del Proveedor:");
        provController.findProveedorEntities().forEach(p -> 
            System.out.println(p.getIdProv() + ". " + p.getNombreProv()));
        int idP = Integer.parseInt(scanner.nextLine());
        Proveedor prov = provController.findProveedor(idP);

        Motocicleta moto = new Motocicleta();
        moto.setMarcaMoto(marca);
        moto.setModeloMoto(modelo);
        moto.setAnioMoto(anio);
        moto.setPrecioMoto(precio);
        moto.setIdTipo(tipo);
        moto.setIdProv(prov);

        motoController.create(moto);
        System.out.println("✔ Motocicleta registrada con éxito.");
    }

    private static void crearServicioTecnico() {
        System.out.println("\n--- REGISTRO DE SERVICIO TÉCNICO ---");
        
        List<Motocicleta> motos = motoController.findMotocicletaEntities();
        if (motos.isEmpty()) {
            System.out.println("No hay motos registradas para asignar servicios.");
            return;
        }

        System.out.println("Seleccione el ID de la Moto:");
        motos.forEach(m -> System.out.println(m.getIdMoto() + ". " + m.getMarcaMoto() + " " + m.getModeloMoto()));
        int idM = Integer.parseInt(scanner.nextLine());
        Motocicleta motoSeleccionada = motoController.findMotocicleta(idM);

        System.out.print("Detalle del Servicio: ");
        String detalle = scanner.nextLine();
        System.out.print("Precio/Costo del Servicio: ");
        double costo = Double.parseDouble(scanner.nextLine());

        // Aquí usamos la entidad REAL ServicioTecnico del paquete entities
        ServicioTecnico st = new ServicioTecnico();
        st.setDetalleServicio(detalle);
        st.setCostoSer(costo);
        st.setFechaServicio(new Date()); 
        st.setIdMoto(motoSeleccionada);

        servicioController.create(st);
        System.out.println("✔ Servicio técnico guardado.");
    }

    private static void listarMotos() {
        System.out.println("\n--- INVENTARIO ACTUAL ---");
        List<Motocicleta> motos = motoController.findMotocicletaEntities();
        
        if (motos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.printf("%-5s | %-15s | %-15s | %-20s%n", "ID", "MARCA", "MODELO", "PROVEEDOR");
            System.out.println("----------------------------------------------------------------------");
            for (Motocicleta m : motos) {
                String nombreProv = (m.getIdProv() != null) ? m.getIdProv().getNombreProv() : "Sin Proveedor";
                System.out.printf("%-5d | %-15s | %-15s | %-20s%n", 
                    m.getIdMoto(), m.getMarcaMoto(), m.getModeloMoto(), nombreProv);
            }
        }
    }
}
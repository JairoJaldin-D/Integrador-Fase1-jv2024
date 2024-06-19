package org.com;


import org.com.almacen.model.Drone;
import org.com.almacen.service.DroneService;
import org.com.almacen.service.DroneServiceImpl;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        DroneService droneService = new DroneServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 6){
            System.out.println("1. Agregar nuevo drone");
            System.out.println("2. Incrementar stock de drones");
            System.out.println("3. Decrementar stock de drones");
            System.out.println("4. Actualizar precio de drones");
            System.out.println("5. Listar todos los drones");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){

                case 1:
                    System.out.println("Ingrese codigo:");
                    String codigo = scanner.nextLine();
                    System.out.println("Ingrese descripcion:");
                    String descripcion = scanner.nextLine();
                    System.out.println("Ingrese tipo de drone (recreacion, fotografia , carreras, militar, agricultura, Entrega):");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese precio de Venta:");
                    double precio = scanner.nextDouble();
                    System.out.println("Ingrese stock:");
                    int stock = scanner.nextInt();
                    droneService.agregarDrone(new Drone(codigo, descripcion, tipo, precio, stock));
                    break;
                case 2:
                    System.out.println("Ingrese codigo:");
                    codigo = scanner.nextLine();
                    System.out.println("Ingrese cantidad a incrementar:");
                    int cantidadInc = scanner.nextInt();
                    droneService.incrementarStock(codigo, cantidadInc);
                    break;
                case 3:
                    System.out.println("Ingrese codigo:");
                    codigo = scanner.nextLine();
                    System.out.println("Ingrese cantidad a decrementar:");
                    int cantidadDec = scanner.nextInt();
                    droneService.decrementarStock(codigo,cantidadDec);
                    break;
                case 4:
                    System.out.println("Ingrese codigo:");
                    codigo = scanner.nextLine();
                    System.out.println("Ingrese nuevo precio:");
                    precio = scanner.nextDouble();
                    droneService.actualizarPrecio(codigo,precio);
                    break;
                case 5:
                    System.out.println("\nIngrese tipo de drone a listar (o 'Todos' para listar todos):");
                    String tipoFiltro = scanner.nextLine();
                    List<Drone> drones = droneService.listarDrones();
                    for (Drone drone : drones) {
                        if (tipoFiltro.equalsIgnoreCase("Todos") || drone.getTipo().equalsIgnoreCase(tipoFiltro)) {
                            System.out.println(drone);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");

            }
        }
        scanner.close();
    }
}
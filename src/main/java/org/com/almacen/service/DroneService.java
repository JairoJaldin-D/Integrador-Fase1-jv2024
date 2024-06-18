package org.com.almacen.service;

import org.com.almacen.model.Drone;

import java.util.List;

public interface DroneService {

    void agregarDrone(Drone drone);
    void incrementarStock(String codigo, int cantidad);
    void decrementarStock(String codigo, int cantidad);
    void actualizarPrecio(String codigo, double nuevoPrecio);
    List<Drone> listarDrones();

}

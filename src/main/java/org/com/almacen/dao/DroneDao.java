package org.com.almacen.dao;

import org.com.almacen.model.Drone;
import java.util.List;

public interface DroneDao {

    void agregarDrone(Drone drone);
    void actualizarDrone(Drone drone);
    void eliminarDrone(String codigo);
    Drone obtenerDrone(String codigo);
    List<Drone> listarDrones();
    
}

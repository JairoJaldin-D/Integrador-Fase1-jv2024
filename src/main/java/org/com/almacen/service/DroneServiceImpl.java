package org.com.almacen.service;

import org.com.almacen.dao.DroneDAO;
import org.com.almacen.dao.DroneDAOImpl;
import org.com.almacen.model.Drone;

import java.util.List;

public class DroneServiceImpl implements DroneService {

    private DroneDAO droneDAO;

    public DroneServiceImpl(){
        this.droneDAO = new DroneDAOImpl();
    }

    @Override
    public void agregarDrone(Drone drone) {
        droneDAO.agregarDrone(drone);
    }

    @Override
    public void incrementarStock(String codigo, int cantidad) {
        Drone drone = droneDAO.obtenerDrone(codigo);
        if(drone != null){
            drone.setStock(drone.getStock() + cantidad);
            droneDAO.actualizarDrone(drone);
        }
    }

    @Override
    public void decrementarStock(String codigo, int cantidad) {
        Drone drone = droneDAO.obtenerDrone(codigo);
        if(drone != null && drone.getStock() >= cantidad){
            drone.setStock(drone.getStock() - cantidad);
            droneDAO.actualizarDrone(drone);
        }
    }

    @Override
    public void actualizarPrecio(String codigo, double nuevoPrecio) {
        Drone drone = droneDAO.obtenerDrone(codigo);
        if(drone != null){
            drone.setPrecioVenta(nuevoPrecio);
            droneDAO.actualizarDrone(drone);
        }
    }

    @Override
    public List<Drone> listarDrones() {
        return droneDAO.listarDrones();
    }

}

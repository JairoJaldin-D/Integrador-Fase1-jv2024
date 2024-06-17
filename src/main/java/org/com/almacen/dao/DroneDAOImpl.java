package org.com.almacen.dao;

import org.com.almacen.model.Drone;
import org.com.almacen.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DroneDAOImpl implements DroneDAO {

    private Connection conn;

    public DroneDAOImpl(){
        conn = DBConnection.getConnection();
    }


    @Override
    public void agregarDrone(Drone drone) {
        try {
            String query = "INSERT INTO drones (codigo, descripcion, precioVenta, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, drone.getCodigo());
            ps.setString(2, drone.getDescripcion());
            ps.setDouble(3, drone.getPrecioVenta());
            ps.setInt(4, drone.getStock());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actualizarDrone(Drone drone) {

        try{
            String query = "UPDATE drones SET descripcion = ?, precioVenta = ?, stock = ? WHERE codigo = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, drone.getDescripcion());
            ps.setDouble(2, drone.getPrecioVenta());
            ps.setInt(3, drone.getStock());
            ps.setString(4, drone.getCodigo());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarDrone(String codigo) {

        try{
            String query = "DELETE FROM drones WHERE codigo = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, codigo);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Drone obtenerDrone(String codigo) {
        Drone drone = null;
        try {
            String query = "SELECT * FROM drones WHERE codigo = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                drone = new Drone(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getDouble("precioVenta"),
                        rs.getInt("stock")
                );
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return drone;
    }

    @Override
    public List<Drone> listarDrones() {
        List<Drone> drones = new ArrayList<>();
        try{
            String query = "SELECT * FROM drones" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Drone drone = new Drone(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getDouble("precioVenta"),
                        rs.getInt("stock")
                );
                drones.add(drone);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return drones;
    }

}

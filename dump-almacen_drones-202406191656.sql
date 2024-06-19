-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: almacen_drones
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

CREATE TABLE `drones` (
  `codigo` varchar(10) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `precioVenta` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


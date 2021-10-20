-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: tecno_tienda
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `cedula_c` bigint NOT NULL,
  `direccion_c` varchar(150) NOT NULL,
  `email_c` varchar(45) NOT NULL,
  `nombre_c` varchar(120) NOT NULL,
  `telefono_c` varchar(45) NOT NULL,
  PRIMARY KEY (`cedula_c`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'1','123','1','1'),(10,'AvViva 123','cliente2@','Lucho rodriguez','2589647581'),(75,'Av.siempre viva','cliente1@','Pepito MArtinez','3125986530');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `codigo_detalle_venta` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_producto` int NOT NULL,
  `codigo_producto` bigint NOT NULL,
  `codigo_venta` bigint NOT NULL,
  `valor_total` double NOT NULL,
  `valor_venta` double NOT NULL,
  `valoriva` double NOT NULL,
  PRIMARY KEY (`codigo_detalle_venta`),
  KEY `codigo_producto_idx` (`codigo_producto`),
  KEY `codigo_venta_idx` (`codigo_venta`),
  CONSTRAINT `codigo_producto` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo_producto`),
  CONSTRAINT `codigo_venta` FOREIGN KEY (`codigo_venta`) REFERENCES `ventas` (`codigo_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `codigo_producto` bigint NOT NULL,
  `nombre_producto` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nit` bigint NOT NULL,
  `precio_compra` double NOT NULL,
  `iva_compra` double NOT NULL,
  `precio_venta` double NOT NULL,
  PRIMARY KEY (`codigo_producto`),
  KEY `nit_idx` (`nit`),
  CONSTRAINT `nit` FOREIGN KEY (`nit`) REFERENCES `proveedores` (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Mouse_Gamer1',15,54000,8640,62640),(2,'Mouse_Gamer2',15,54000,8640,62640),(3,'Mouse_Gamer3',15,54000,8640,62640),(4,'Mouse_Gamer4',15,54000,8640,62640),(5,'Mouse_Gamer5',15,54000,8640,62640),(6,'Mouse_Gamer6',15,54000,8640,62640),(7,'Mouse_Gamer7',15,54000,8640,62640),(8,'Mouse_Gamer8',15,54000,8640,62640);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `nit` bigint NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (15,'Medellin','Lote456789','Asus New','3150000069'),(15000005,'Medellin','Lote456','Asus','3150000069'),(85000007,'Bogota','edificio 4','MSI','3650000089');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `cedula_usuario` bigint NOT NULL,
  `email_usuario` varchar(45) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cedula_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'nosefue@selargo.com','Maria Alejandra','123','maria',NULL),(3,'pepito@selargo.com','Pepito','123','pepito',NULL),(15265567,'udcarkangel@gmail.com','Mauricio','123','admin',NULL),(15265600,'test@tecnotienda.com','Test','123','test',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `codigo_venta` bigint NOT NULL AUTO_INCREMENT,
  `cedula_c` bigint NOT NULL,
  `cedula_usuario` bigint NOT NULL,
  `ivaventa` double NOT NULL,
  `valor_venta` double NOT NULL,
  `total_venta` double NOT NULL,
  PRIMARY KEY (`codigo_venta`),
  KEY `cedula_c_idx` (`cedula_c`),
  KEY `cedula_usuario_idx` (`cedula_usuario`),
  CONSTRAINT `cedula_c` FOREIGN KEY (`cedula_c`) REFERENCES `clientes` (`cedula_c`),
  CONSTRAINT `cedula_usuario` FOREIGN KEY (`cedula_usuario`) REFERENCES `usuarios` (`cedula_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-15 23:40:09

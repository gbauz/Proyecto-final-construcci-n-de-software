-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2023 a las 23:40:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_arbitros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modificaractas`
--

CREATE TABLE `modificaractas` (
  `id` int(11) NOT NULL,
  `fecha` varchar(100) NOT NULL,
  `horaInicio` varchar(100) NOT NULL,
  `horaFin` varchar(100) NOT NULL,
  `partido` varchar(100) NOT NULL,
  `duracion` varchar(100) NOT NULL,
  `golesLocal` varchar(100) NOT NULL,
  `golesRival` varchar(100) NOT NULL,
  `ganador` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modificaractas`
--

INSERT INTO `modificaractas` (`id`, `fecha`, `horaInicio`, `horaFin`, `partido`, `duracion`, `golesLocal`, `golesRival`, `ganador`) VALUES
(2, '25/08/2023', '9:00 A.M', '11:00 A.M', 'Delfin VS Liga de Loja', '2 horas', '1', '0', 'Delfin'),
(3, '25 de agosto, 2023', '9:00 A.M', '11:00 A.M', 'Emelec VS Independiente', '2:00:00', '2', '3', 'Independiente'),
(4, '30 de agosto, 2023', '8:30 A.M', '10:30 A.M', 'Barcelona VS Aucas', '2 horas', '1', '3', 'Aucas'),
(5, '20 de agosto, 2023', '8:00 A.M', '10:30 A.M', 'Delfin VS Liga de Loja', '2:30:00', '0', '4', 'Liga de Loja');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `modificaractas`
--
ALTER TABLE `modificaractas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `modificaractas`
--
ALTER TABLE `modificaractas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

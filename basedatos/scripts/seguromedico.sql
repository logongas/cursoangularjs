CREATE DATABASE IF NOT EXISTS `seguromedico`;
USE `seguromedico`;


CREATE TABLE IF NOT EXISTS `seguromedico` (
  `idSeguroMedico` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(10) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `ape1` varchar(50) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `casado` tinyint(4) DEFAULT NULL,
  `numhijos` int(11) DEFAULT NULL,
  `embarazada` tinyint(4) DEFAULT NULL,
  `coberturaoftalmologica` tinyint(4) DEFAULT NULL,
  `coberturadental` tinyint(4) DEFAULT NULL,
  `coberturafecundacioninvitro` tinyint(4) DEFAULT NULL,
  `enfermedadcorazon` tinyint(4) DEFAULT NULL,
  `enfermedadestomacal` tinyint(4) DEFAULT NULL,
  `enfermedadrinyones` tinyint(4) DEFAULT NULL,
  `enfermedadalergia` tinyint(4) DEFAULT NULL,
  `nombrealergia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSeguroMedico`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


INSERT INTO `seguromedico` (`idSeguroMedico`, `nif`, `nombre`, `ape1`, `edad`, `sexo`, `casado`, `numhijos`, `embarazada`, `coberturaoftalmologica`, `coberturadental`, `coberturafecundacioninvitro`, `enfermedadcorazon`, `enfermedadestomacal`, `enfermedadrinyones`, `enfermedadalergia`, `nombrealergia`) VALUES
    (1, '12345678Z', 'Carlos', 'Cano', 41, 'H', 1, 3, 0, 1, 0, 0, 1, 0, 0, 1, 'Acaros'),
	(2, '34783627Z', 'Catalina', 'López', 33, 'M', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, ''),
	(3, '29069345J', 'Jose', 'Aguado', 56, 'H', 1, 2, 0, 1, 1, 0, 1, 1, 1, 0, ''),
	(4, '34828938S', 'Angel', 'Navarro', 21, 'H', 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 'Graminias'),
	(5, '23236773B', 'Teresa', 'Rubio', 36, 'M', 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, ''),
	(6, '27469252F', 'Alfredo', 'Padilla', 45, 'H', 1, 2, 0, 1, 1, 0, 1, 0, 0, 0, ''),
	(7, '34804406R', 'Rosa', 'Muñoz', 45, 'M', 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, ''),
	(8, '23244114S', 'Alejandro', 'Valeno', 19, 'H', 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 'Leche');



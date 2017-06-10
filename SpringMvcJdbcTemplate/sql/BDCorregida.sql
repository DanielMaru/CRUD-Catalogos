CREATE TABLE `perfiles_usuarios` (
  `idPERFIL` INT NOT NULL AUTO_INCREMENT,
  `nomPERFIL` varchar(45) NOT NULL,
  `descripPERFIL` varchar(45) NULL,
  `estadoPERFIL` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (idPERFIL)
);

CREATE TABLE `categorias` (
  `idCATEGORIAS` int(11) NOT NULL AUTO_INCREMENT,
  `nomCATEGORIAS` varchar(45) DEFAULT NULL,
  `descripCATEGORIAS` varchar(45) DEFAULT NULL,
  `estadoCATEGORIA` tinyint(4) DEFAULT '0',
  PRIMARY KEY (idCATEGORIAS)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ciudad` (
  `IdCiudad` int(45) NOT NULL AUTO_INCREMENT,
  `NombreCiudad` varchar(45) NOT NULL,
  `NombreDepartamento` varchar(45) NOT NULL,
  `estado_ciudad` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IdCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `departamento` (
  `id_depart` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_depart` varchar(45) NOT NULL,
  `descrip_depart` varchar(45) NOT NULL,
  `status_depart` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id_depart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `producto` (
  `producto_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_productos` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `estdo` bit(45) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`producto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `login`  varchar(45) NOT NULL unique,
  `pass` varchar(45) NOT NULL,
  `estado` tinyint(4) DEFAULT '0',
   PRIMARY KEY (id)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

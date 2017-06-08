CREATE TABLE `perfiles_usuarios` (
  `idPERFIL` INT NOT NULL AUTO_INCREMENT,
  `nomPERFIL` varchar(45) NOT NULL,
  `descripPERFIL` varchar(45) NULL,
  `estadoPERFIL` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPERFIL`)
)
INSERT INTO `Department` (`name`,`web_site`,`description`) VALUES ('Canelones','https://www.imcanelones.gub.uy/es','División Turismo de la Intendencia'),('Maldonado','https://www.maldonado.gub.uy/','División Turismo de la Intendencia'),('Rocha','www.turismorocha.gub.uy','La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público ? privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo.'),('Treinta y Tres','https://treintaytres.gub.uy/','División Turismo de la Intendencia'),('Cerro Largo','https://www.gub.uy/intendenciacerro-largo/','División Turismo de la Intendencia'),('Rivera','www.rivera.gub.uy/social/turismo/','Promociona e implementa proyectos e iniciativas sostenibles de interés turístico con la participación institucional pública ? privada en bien del desarrollo socioeconómico de la comunidad.'),('Artigas','http://www.artigas.gub.uy','División Turismo de la Intendencia'),('Salto','https://www.salto.gub.uy','División Turismo de la Intendencia'),('Paysandú','ttps://www.paysandu.gub.uy','División Turismo de la Intendencia'),('Rió Negro','https://www.rionegro.gub.uy','División Turismo de la Intendencia'),('Soriano','https://www.soriano.gub.uy','División Turismo de la Intendencia'),('Colonia','https://colonia.gub.uy/turismo/','La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta.'),('San José','https://sanjose.gub.uy','División Turismo de la Intendencia'),('Flores','https://flores.gub.uy','División Turismo de la Intendencia'),('Florida','http://www.florida.gub.uy','División Turismo de la Intendencia'),('Lavalleja','http://www.lavalleja.gub.uy','División Turismo de la Intendencia'),('Durazno','https://durazno.uy','División Turismo de la Intendencia'),('Tacuarembó','https://tacuarembo.gub.uy','División Turismo de la Intendencia'),('Montevideo','https://montevideo.gub.uy/areastematicas/turismo','División Turismo de la Intendencia');

INSERT INTO `User` (`birth_date`,`nationality`,`name`,`nickname`,`DTYPE`,`email`,`last_name`,`web_site`,`description`, `password`) VALUES ('1927-02-23','argentina','Rosa María','lachiqui','Tourist','mirtha.legrand.ok@hotmail.com.ar','Martínez',null,null,'awdrg543'),('1926-04-21','inglesa','Elizabeth','isabelita','Tourist','isabelita@thecrown.co.uk','Windsor',null,null,'r5t6y7u8'),('1937-12-31','lituana','Aníbal','anibal','Tourist','anibal@fing.edu.uy','Lecter',null,null,'edrft543'),('1990-04-15','inglesa','Emma','waston','Tourist','e.waston@gmail.com','Waston',null,null,'poiuy987'),('1971-07-30','estadounidense','Elvis','elelvis','Tourist','suavemente@hotmail.com','Lacio',null,null,'45idgaf67'),('2004-02-19','española','Eleven','eleven11','Tourist','eleven11@gmail.com','Once',null,null, 'xdrgb657'),('1999-05-01','japonesa','Bob','bobesponja','Tourist','bobesponja@nickelodeon.com','Esponja',null,null, 'sbsplol1'),('1976-04-11','uruguaya','Antonio','tony','Tourist','eltony@manya.org.uy','Pacheco',null,null, 'okmnji98'),('1976-03-17','uruguaya','Alvaro','chino','Tourist','chino@trico.org.uy','Recoba',null,null, 'qsxcdw43'),('1922-02-07','austríaca','Johann Sebastian','mastropiero','Tourist','johann.sebastian@gmail.com','Mastropiero',null,null, 'qpwoei586'),('1970-09-14',null,'Washington','washington','Provider','washingtong@turismorocha.gub.uy','Rocha ','http://turismorocha.gub.uy/','Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay',  'asdfg654'),('1965-06-27',null,'Pablo','eldiez','Provider','eldiez@socfomturriv.org.uy','Bengoechea ','http://wwww.socfomturriv.org.uy','Pablo es el presidente de la Sociedad de Fomento Turíıstico de Rivera (conocida como Socfomturriv)', 'ytrewq10'),('1990-12-31',null,'Mercedes','meche','Provider','meche@colonia.gub.uy','Venn ','https://colonia.gub.uy/turismo/','Departamento de Turismo del Departamento de Colonia', 'mnjkiu89');

INSERT INTO `Touristic_Activity` (`cost_per_tourist`,`duration`,`upload_date`,`department`,`provider`,`city`,`name`,`description`) VALUES (800,3,'2022-07-20',3,11,'Rocha','Degusta','Festival gastronómico de productos locales en Rocha'),(500,3,'2022-07-21',3,11,'Rocha','Teatro con Sabores','En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.'),(400,2,'2022-08-01',12,13,'Colonia del Sacramento','Tour por Colonia del Sacramento','Con guía especializado y en varios idiomas. Varios circuitos posibles.'),(800,2,'2022-08-01',12,13,'Colonia del Sacramento','Almuerzo en el Real de San Carlos','Restaurante en la renovada Plaza de Toros con menú internacional'),(300,2,'2022-08-01',6,12,'Tranqueras','Almuerzo en Valle del Lunarejo','Almuerzo en la Posada con ticket fijo. Men´u que incluye bebida y postre casero.'),(150,2,'2022-08-01',6,12,'Tranqueras','Cabalgata en Valle del Lunarejo','Cabalgata por el ´area protegida. Varios recorridos para elegir.');

INSERT INTO `Touristic_Departure` (`max_tourist`,`upload_date`,`departure_date_time`,`touristic_activity`,`name`,`place`) VALUES (20,'2022-07-21','2022-08-20 17:00:00.000000',1,'Degusta Agosto','Sociedad Agropecuaria de Rocha'),(20,'2022-07-22','2022-09-03 17:00:00.000000',1,'Degusta Setiembre','Sociedad Agropecuaria de Rocha'),(30,'2022-07-23','2022-09-04 18:00:00.000000',2,'Teatro con Sabores 1','Club Deportivo Union'),(30,'2022-07-23','2022-09-11 18:00:00.000000',2,'Teatro con Sabores 2','Club Deportivo Union'),(5,'2022-08-05','2022-09-11 10:00:00.000000',3,'Tour Colonia de Sacramento 11-09','Encuentro en la base del faro'),(5,'2022-08-05','2022-09-18 10:00:00.000000',3,'Tour Colonia de Sacramento 18-09','Encuentro en la base del faro'),(5,'2022-08-04','2022-09-18 12:00:00.000000',4,'Almuerzo 1','Restaurante de la Plaza de Toros '),(5,'2022-08-04','2022-09-25 12:00:00.000000',4,'Almuerzo 2','Restaurante de la Plaza de Toros'),(4,'2022-08-15','2022-09-10 12:00:00.000000',5,'Almuerzo 3','Posada del Lunarejo'),(4,'2022-08-15','2022-09-11 12:00:00.000000',5,'Almuerzo 4','Posada del Lunarejo'),(4,'2022-08-15','2022-09-10 16:00:00.000000',6,'Cabalgata 1','Posada del Lunarejo'),(4,'2022-08-15','2022-09-11 16:00:00.000000',6,'Cabalgata 2','Posada del Lunarejo');

INSERT INTO `Inscription` (`inscription_date`,`total_cost`,`tourist_amount`,`tourist`,`touristic_departure`) VALUES ('2022-08-15',2400,3,1,1),('2022-08-16',4000,5,5,1),('2022-08-18',1200,3,1,6),('2022-08-19',400,1,2,6),('2022-08-19',1600,2,10,8),('2022-08-19',500,1,9,3),('2022-08-20',5000,10,9,4),('2022-08-20',1000,2,7,4),('2022-08-21',500,1,3,4),('2022-08-21',8800,11,8,2);

INSERT INTO `Touristic_Bundle` (`discount`,`upload_date`,`validityPeriod`,`name`,`description`) VALUES (20,'2022-08-10',60,'Disfrutar Rocha','Actividades para hacer en familia y disfrutar arte y gastronomia'),(15,'2022-08-01',45,'Un dia en Colonia','Paseos por el casco hist ́orico y se puede terminar con Almuerzo en la Plaza de Toros');

INSERT INTO `Activities_In_Bundles` (`bundle`,`activity`) VALUES (1,1),(1,2),(2,3),(2,4);
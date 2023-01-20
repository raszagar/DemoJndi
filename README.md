## DemoJndi

Ejemplo de Spring boot con jndi  
Se usa autoconfiguración con [application.properties](https://github.com/raszagar/DemoJndi/blob/master/src/main/resources/application.properties)

Los datos del jndi del tomcat embebido estan en [DemoJndiApplication.java](https://github.com/raszagar/DemoJndi/blob/master/src/main/java/es/jose/DemoJndiApplication.java)

~~~
-- bdlocal.asistentes definition
CREATE TABLE `asistentes` (
  `id` bigint NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE bdlocal.asistentes MODIFY COLUMN id bigint auto_increment NOT NULL;
~~~


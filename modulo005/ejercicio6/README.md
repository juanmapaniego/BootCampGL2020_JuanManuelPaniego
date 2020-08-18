# Introduccion a Spring Actuator

1. Agregar la siguiente dependencia en el pom del proyecto armado en el ejercicio 5.2:
	´´´xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
	´´´

  - Una vez configurado, inicializar la aplicacion y validar que este exponiendo el recurso **/manage/heath**
  - Validar que tenemos expuesto el endpoint **/manage** y devuelve algo similar al ejemplo.
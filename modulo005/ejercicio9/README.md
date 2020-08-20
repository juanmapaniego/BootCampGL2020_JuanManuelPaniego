# Code coverage y sonarqube

1. Importar el projecto del ejercicio **Ejercicio 9.1.zip**
  - Una vez abierto e importado al STS, modificar la siguiente línea del archivo POM:
    <name>spring.coverage-example-yourname</name>
  reemplazar “yourname” por su nombre y apellido. Por ejemplo: spring.coverage-example-diegoaredes
  - Nota: Esto lo realizamos para que al utilizar el sonarqube compartido podamos diferenciar las ejecuciones nuestras con la de los demás cursantes.
  - Abrir un consola para ejecutar desde línea de comandos lo siguiente:
  ´´´bash
  mvn clean compile test jacoco:report sonar:sonar -Dsonar.host.url=http://54.232.39.137:9000
  ´´´
  donde mediante el comando de mvn se llama al Sonar remoto desplegado.
  - Acceder al sonar mediante la URL http://54.232.39.137:9000
  - Realizar las modificaciones necesarias en el proyecto para obtener una buena salida en el Sonar.
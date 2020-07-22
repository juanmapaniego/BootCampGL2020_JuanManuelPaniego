1. Crear un proyecto Maven con el comando **mvn archetype:generate** (En modo no interactivo)
```bash
mvn archetype:generate -DgroupId="com.globallogic.myapp" -DartifactId="bootcampgl" -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion="1.0" -DinteractiveMode=false
```
  - Agregar las dependencias para Log4j (Log4j es una biblioteca para el manejo y registros de logs)
  - Descargar las dependencias por medio del comando **mvn dependency:resolve** 

2. Crear un proyecto Maven con los siguientes parámetros:
  - **Paquete**: com.globallogic.app **Proyecto**: bootcampgl2020 Version: 1.1
  - Agregar la siguiente dependencias:
    - groupId: org.junit.jupiter artifactId: junit-jupiter-engine version: 5.1.0 scope: test
    - groupId: org.junit.platform artifactId: junit-platform-surefire-provider version: 1.0.0
    - groupId: org.slf4j artifactId: slf4j-simple version: 1.7.30
  - Descargar dependencias.
  - Importarlo y compilarlo
  
3. Modificar el archivo pom.xml creado en el punto 2
  - Agregar la siguiente dependencia: 
    - **groupId**: io.micrometer **artifactId**: micrometer-core **version**: 1.5.2
  - En la anterior depencencia agregar la siguiente exlusion:
    - **groupId**: org.apache.tomcat.embed **artifactId**: tomcat-embed-core
  - Descargar dependecias

# MODULO 006

- Session 1
  - ¿Que es un servicio?
  - ¿Que es un microservicio?
  - Spring Cloud
  - Spring Cloud Feign
  - Spring Cloud Feign vs RestTemplate

- Session 2
  - Balanceo de carga y Spring Ribbon
  - Service discovery y Eureka
  - Circuit Breaker y Hystrix
  - Api Gateway y Spring Zuul

- Session 3
  - Spring Cloud Config Server
  - Spring Cloud Sleuth Y Zipkin
  - Secret Managment y Spring Vault

# 006 - Introduccion a microservicios

1. Introduccion a microservicios
  1. Crear las distintas aplicaciones que expongan los servicios REST en los respectivos puertos implementando los CRUD con H2 para cada una de las siguientes entidades y sus estructuras descriptas. 
  ´´´ 
  Puerto: 8170
  Entidad: Libro
    - isbn
    - titulo
    - id de Autor
    - id de Género

  Puerto: 8180
  Entidad: Autor
    - nombre
    - nacionalidad

  Puerto: 8190
  Entidad: Género
    - nombre
  ´´´

  2. Crear las distintas aplicaciones que expongan los servicios REST en los respectivos puertos implementando los CRUD con H2 para cada una de las siguientes entidades y sus estructuras descriptas. 
  ´´´
  Puerto: 8280
  Entidad: Orden
    - listado de productos y cantidades
    - id de sucursal

  Puerto: 8270
  Entidad: Sucursal
    - nombre
    - ubicación
    - listado de productos y cantidades disponibles

  Puerto: 8290
  Entidad: Producto
    - Nombre
  ´´´´
  - Considerar agregar un método patch para la sucursal para poder ajustar en forma relativa el stock y evitar que este sea negativo.


2. Integracion con RestTemplate y Feign
  1. Crear un Microservicio de Búsqueda, consumiendo los servicios externos del punto 1.2, exponiendo como
un servicio rest las siguientes consultas:
    - Sucursales por nombre de producto.
    - Órdenes por id de la sucursal
    - Productos por nombre

  2. Crear un Microservicio de Ordenes que exponga la capacidad de poder armar órdenes para una sucursal,
haciendo que esta verifique que el stock esté disponible y lo descuente de ella al crear la orden. Este servicio deberá recibir
los siguientes datos:
    - Listado de nombre de productos y cantidades
    - Id de Sucursal

3. Client Side Load Balancer
  1. Usando servicio del punto 2.1.
    - Incluir dependencias de Ribbon.
    - Utilizar la anotación @EnableDiscoveryClient.

4. Discovery Service.
  1. Creamos otro microservicio (DISCOVERY SERVICE) en el puerto 8176 para el Server Eureka. Para ello
necesitaremos:
    - Incluir dependencias del server de Eureka
    - Indicar en los properties el nombre de server de Eureka.
    - Utilizar la anotación @EnableEurekaServer.
  2. Registramos los microservicios del punto 1.2 , 2.1 y 2.2 en Eureka.
    - Incluir dependencias del cliente de Eureka en los servicios.
    - Indicar en las properties donde está Eureka, de los servicio mencionados.
    - Verificar en las properties que cada servicio tenga un nombre para que nos descubra server eureka.
    - Utilizar la anotación @EnableDiscoveryClient, en los servicio mencionados.
    - Cambiar el @FeignClient(name:””,path:””) -> @FeignClient(APPLICATION-NAME) (punto 2.1 y 2.2).
  3. Probar load balancer y discovery service.
    - Levantar servicio del 1.2 (sucursales) en 2 puerto distintos y el discovery service.
    - Levantar servicio del punto 2.1 y realizar una petición a “sucursales por nombre de producto”. Verificar que
    que realice el pedido a las 2 instancias del servicio 1.2. **Tener en cuenta la URL de Base de Datos. Se recomienda: url: jdbc:h2:mem:{nombre-BD}**

5. Circuit Breaker
  1. Implementar circuit breaker en todos los proyectos (Punto 1.2 , 2.1 y 2.2 )
    - Incluir dependencia de Hystrix en los servicios.
    - Utilizar la anotación @EnableCircuitBreaker, en los servicio mencionados para indicar a Spring Cloud que
    - el microservicio utiliza circuit breaker y habilitar la monitorización, apertura y cierre del circuito.
    - Implementar la anotación @HystrixCommand y especificar el **fallbackMethod** en todos los métodos del
    **Controller**
    - **fallbackMethod** será un método nuevo.
  2. Probar desde el proyecto 2.1
    - levantar el servicio 2.1 y eureka server, realizar una petición de algún recurso del 1.2.
    - verificar que el resultado es el espero, definido en el **fallbackMethod**
  3. Habilitar Dashboard de hystrix. Implementar circuit breaker en el proyectos (Punto 2.1).
    - Incluir dependencia de Hystrix Dashboard.
    - Utilizar la anotación @EnableHystrixDashboard, para habilitar el dashboard de hystrix.
    - Probar **http://localhost:[PORT]/hystrix**

6. Service Gateway
  1. Creamos otro microservicio en el puerto 9090 para el Service Gateway. Para ello necesitaremos:
    - Incluir dependencia de ZUUL.
    - Utilizar la anotación @EnableZuulProxy, para habilitar el uso de Zuul como proxy.
    - Configuración de properties: En el application.yml es necesario agregar la configuración necesaria que indique
    el ruteo a ejecutar para las entradas recibidas por el api gateway

  2. Configurar Zuul para integrar con Eureka.
    - Incluir dependencias del cliente de Eureka.
    - Utilizar la anotación @EnableEurekaClient.
    - Modificar properties.yml, usar le ServiceId como ruteo. (ServiceId es el nombre del servicio con el que registra
en eureka)

7. Config Server
  1. Creamos otro microservicio en el puerto 9091 para el Config Server. Para ello necesitaremos:
    - Crearse un archivo .yml en una carpeta CONFIG en su git con las configuraciones de:
      - defaultZone: http://localhost:8761/eureka/
      - username y password de git.
    - Incluir dependencia de Config Server.
    - Utilizar la anotación @EnableConfigServer, para habilitar su propio servidor. 
    - Configuración de properties: En el application.yml es necesario agregar la configuración necesaria de la uri del
repositorio git.
  2. Configuración de properties: En el application.yml es necesario agregar la configuración necesaria de la uri del
repositorio git.
  3. Verificar los valores en **http://localhost:9091/{nombre_aplicacion_cliente}/default**
  4. Consumir Config Server desde el servicio del punto 1.2, 2.1, 6.1 y 7.1, solo necesitamos estos pasos:
    - Incluir dependencia de **Config Client**, **Spring Boot Actuator**, **Spring Web**.
    - Configuración de properties: En el application.yml es necesario agregar la configuración necesaria para url de
    config server(localhost:9091).
    - Habilitar todas las operaciones de actuator.
  5. Configuración de properties de los servicio 1.2, 2.1. 6.1 y 7.1:
    - Modificar el application.yml:
      - defaultZone: ${defaultZone}
  6. Configuración de properties de los servicio 7.1:
    - Modificar el application.yml:
      - username: ${username}
      - password: ${password}
      - uri:${url-git}

8. Distributed Trace
  1. Construir y comenzar una instancia de Zipkin
  2. Verificar el acceso al servidor de Zipkin inicializado en el punto 8.1 en **http://localhost:9411/zipkin/**
  3. Integración de Zipkin y Spring Sleuth en todos los servicios del 1.2, 2.1, 2.2 y 6.1.
    - Incluir la dependencias de Zipkin en los servicios ya mencionados.
    - Configuración de las properties: En los application.yml es necesario agregar la configuración necesaria para
poder conectarnos con nuestro servidor Zipkin(http://localhost:9411/)
  4. Agregar Logger en:
    - Entrada y salida feign
    - Inicio y fin de los métodos de controller
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
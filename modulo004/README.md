# 004 - Bases de datos
1. Modelo relacional y SQL
  1. Setup ambiente mysql con usuario para el ejercicios de lectura de base.
  2. Generar la consulta para obtener animales ordenados por su id de forma descendente.
  3.  Generar la consulta para obtener animales ordenados por su id de forma ascendente y que pesen más de 30 Kg.
  4. Generar la consulta para obtener animales ordenados por su id de forma ascendente y cuyo nombre comience con L.
  5. Generar la consulta para obtener animales ordenados por su id de forma descendente y agrupados por su especie.
  6. Generar la consulta para obtener los animales cuyo máximo peso sea mayor a 100 ordenados por su id de forma ascendente y agrupados por su especie.

2. Hibernate
  1. A partir del proyecto en el archivo: **hibernate.example.zip**, agregar la entidad **Alumno** y su conexión a la base de datos **H2** con sus operaciones CRUD. Para ello, agregar las siguientes dependencias:
    - groupId: org.hibernate, artifactId: hibernate-core, version: 5.4.18.Final
    - groupId: com.h2database, artifactId: h2, version: 1.4.200

    - Agregar la entidad (clase)Alumno, con sus getters, setter, toString y sus constructores por default y con todos atributos en base a la siguiente estructura:
      - Alumno:
        - Id
        - Nombre
        - Apellido

  2. Crear un CRUD utilizando H2 para la entidad Menu, donde se muestra con el siguiente ejemplo. Crear las pruebas de JUnit necesarias para mostrar su funcionamiento completo:

  3. Crear un CRUD utilizando H2 para la entidad Carrera, donde se muestra con el siguiente ejemplo. Crear las pruebas de JUnit necesarias para mostrar su funcionamiento completo:


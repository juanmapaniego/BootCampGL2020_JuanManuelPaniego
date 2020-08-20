# Introducción a OpenAPI y Swagger
- Contexto y Herramientas de Trabajo
  Ingresar a [swagger](http://editor.swagger.io/)

1. Crear API Cliente
  - Definir una especificación de API mediante la cual se permita realizar operaciones CRUD (Create, Read, Update, Delete) sobre clientes. Estos se componen por los siguientes atributos: 
    - DNI
    - Nombre
    - Apellido
    - Teléfono
    - Correo electrónico

  - Consideraciones a tener en cuenta:
    - Las operaciones CRUD deben estar asociadas correctamente a los métodos HTTP estandarizados
    - Respetar una nomenclatura estándar en toda la especificación (Ejemplo uso de idioma, descripciones, etc).
    - Enriquecer la especificación del Swagger lo más posible (uso de info, recursos, especificación de tipos de datos)

2. Enriquecer API Clientes: nuevos recursos
  - Sobre el Swagger definido en el punto 10.1 agregar métodos de consulta por criterios (a elección) los cuales permitan devolver una lista de clientes.

3. Enriquecer API Clientes: HATEOAS
  - Sobre las estructuras que venimos trabajando, agregar HATEOAS a todos los recursos y navegación al recurso del punto 10.2

4. Enriquecer API Clientes: Direcciones
  - A la entidad ya definida en el punto 11.1 de clientes, agregarle direcciones (no es necesario exponer recursos sobre la misma) de tal manera que puedan asociarse al cliente como una lista.

5. Implementación
  - Implementar mediante SpringBoot la API clientes con todas las funcionalidades previamente trabajadas.

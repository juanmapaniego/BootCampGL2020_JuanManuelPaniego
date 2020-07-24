1. Creamos una interface 
  - Crear una interfaz InterfaceAnimal.
  - Definir dentro de la interfaz dos métodos: dormir y sonidoAnimal.
  - Crear una clase Perro que implemente la clase Animal.
  - Implementar los métodos creados en la interfaz Animal.
  - En cada método mostrar un mensaje de salida.
  - Crear una clase MainAnimal que posea un método main().
  - En el main crear una variable dog de tipo Perro e inicializarla.
  - Invocar los métodos creados anteriormente, primero a dormir y luego a sonidoAnimal.

2. Metodo default y static 
  - A la interface creada en el ejercicio anterior le vamos a agregar 2 nuevos métodos.
  - Un método default llamado Come, que tiene como parámetro un string, en este método vamos a mostrar un mensaje que sea System.out.println("El " + s + " se alimenta");
  - Un método static llamado camina, que tiene como parámetro un string, en este método vamos a mostrar un mensaje que sea System.out.println("El " + s + " camina");
  - En el main se agrega la invocación a estos métodos, pasandole a ambos el “perro” como parámetro.

3. Metodo default y múltiples interfaces 
  - Crear una interfaz Persona.
  - Crear dos métodos hablar, dormir y un método por default come.
  - Crear una clase Hombre que implemente la clase Animal y Persona.
  - Implementar los métodos creados en ambas interfaces.
  - En cada método mostrar un mensaje de salida.
  - En la misma clase agregar un método main().
  - Crear un objeto de tipo Hombre e invocar a los métodos implementados anteriormente.
  - Validar la salida.



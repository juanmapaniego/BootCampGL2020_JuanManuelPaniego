# Introduccion a JUnit 5 y assertions

1. Agregar assertions a un proyecto.
  - Importar el proyecto **junitTestPtoject**
  - Crear el testCase de la clase **App.java**
  - Crear en el path **src/test/java/com/globallogic/bootcampgl/junitTest** la clase **AppTest** conteniendo
  ```java
  package com.globallogic.bootcampgl.junitTest;

  class AppTest {

  }
  ```
  - Agregar una assertion para validar que 2 Strings sean iguales
  ```java
  @Test
  void test(){
    assertEquals("Test","Test");
  }
  ```
  - Ejecutar la prueba con el comando **mvn test**.

2. Crear un Test donde se evalúe, dado tres variables String, dos sean iguales y la tercera sea distinta.

3. Crear un Test con las siguientes assertions:
  - 25 > 12 sea verdadero
  - 25 > 17 sea falso

4. Crear un Test donde se evalúe que una variable Long inicializada en  null. Luego asignarle el valor 1  volver a verificar, pero que esta vez no sea null

5. Modificar los ejercicios anteriores (1.2, 1.3, 1.4) para que todas las verificaciones resulten en error.

6. Crear un método que sume dos parámetros del Type int. Crear un test que utilice este método enviando dos valores y que verifique:
  - Que la suma sea correcta
  - Que la suma sea incorrecta con el mensaje "El resultado está mal: "

7. Crear un método con las siguientes condiciones
  - Debe retornar un boolean
  - Realizar un For, con valor inicial 0 y donde el valor máximo de iteración será recibido por parámetro.
  - Se debe colocar un corte en la iteración cuando este llegue a 3 retornando true, en caso contrario retornar false

  - A continuacion
    - Crear un Test que utilice este método y donde se realice las assertions en lo siguientes casos
      - Enviar un valor máximo y que sea true con el mensaje "Esta variable no es true:"  
      - Enviar un valor máximo y que sea false con el mensaje "Esta variable no es false:" 

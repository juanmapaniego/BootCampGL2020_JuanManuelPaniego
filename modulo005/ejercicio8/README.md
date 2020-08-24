# Mocking Rest Services

1. Usar servicio del ejercicio 5.1.
	- Usando la clase **VehículoServiceImpl.java** que depende de un repositorio. Hacer estos test:
    - Crear una clase **VehículoServiceImplTest**.
    - Agregar **@Mock** para el VehículoRepository.
    - Agregar **@InjectMocks** para el VehículoServiceImpl.
    - Realizar un test por cada método y verificar que no sea nulo.

2. Usar servicio del ejercicio 5.1
  - Usando la clase **VehículoServiceImplTest**:
    - Crear un método que debe ejecutarse antes de cada método de los test, instanciando entities o dtos y setear los valores. 
    - Agregar a los métodos de test para definir el valor de retorno cuando se llama a un método  de la clase VehiculoRepository.
    - Verificar con:
      - AssertTrue
      - AssertEquals
      - AssertNotNull

3. Usar servicio del ejercicio 5.1
  - Usando la clase **VehículoServiceController.java**. Hacer estos test:
    - Crear una clase **VehículoServiceControllerTes**.  
    - Agregar @Mock para el **VehículoServiceImpl**.  
    - Agregar @InjectMocks para el **VehículoServiceController**.
    - Realizar un test por cada método y verificar que no sea nulo.

4. Usar servicio del ejercicio 5.1
  - Usando la clase **VehículoServiceControllerTest** :
    - Crear un método que debe ejecutarse antes de cada método de los test, instanciando entities o dtos y setear los valores. 
    - Agregar a los métodos de test para definir el valor de retorno cuando se llama a un método  de la clase **VehículoServiceImpl**.
    - Por cada método de test agregar un **DisplayName** el nombre será acorde a la función que cumple dicho método.
    - Verificar con:
      - AssertTrue
      - AssertEquals
      - AssertNotNull

5. Usar servicio del ejercicio 5.2
  - Usando la clase **CarreraServiceImpl.java** que depende de un repositorio. Hacer estos test:
  - Crear una clase **CarreraServiceImplTest**.
  - Agregar @Mock para el **CarreraRepository** usado.
  - Agregar @InjectMocks para el **CarreraServiceImpl**.
  - Realizar un test  por cada método y verificar que no sea nulo.

6. Usar servicio del ejercicio 5.2  
  - Usando la clase **CarreraServiceImplTest**:
  - Crear un método que debe ejecutarse antes de cada método de los test, instanciando entities o dtos y setear los valores. 
  - Agregar a los métodos de test,  para definir el valor de retorno cuando se llama a un método  de la clase **CarreraRepository*.
  - Verificar con:
    - AssertTrue
    - AssertEquals
    - AssertNotNull

7. Usar servicio del ejercicio 5.2 
  - Usando la clase **CarreraServiceController.java**. Hacer estos test:
  - Crear una clase **CarreraServiceControllerTest**.
  - Agregar @Mock para el **CarreraServiceImpl**.
  - Agregar @InjectMocks para el **CarreraServiceController**.
  - Realizar un test por cada método y verificar que no sea nulo.

8. Usar servicio del ejercicio 5.2 
  - Usando la clase **CarreraServiceControllerTest**:
  - Crear un método que debe ejecutarse antes de cada método de los test, instanciando entities o dtos y setear los valores. 
  - Agregar a los métodos de test para definir el valor de retorno cuando se llama a un método  de la clase **CarreraServiceImpl**.
  - Por cada método de test agregar un **DisplayName** el nombre será acorde a la función que cumple dicho método.
  - Verificar con:
    - AssertTrue
    - AssertEquals
    - AssertNotNull

9. Test Parametrizados, usar servicio del ejercicio 5.1
  - Agregar un nuevo método de test  en la  Clase VehículoServiceImplTest que se ejecutará 3 veces cambiando cada vez la cadena de busqueda y el resultado esperado.  
  - Verificar con:
    - AssertTrue
    - AssertEquals
    - AssertNotNull

10. Test Parametrizados, Usar servicio del ejercicio 5.2
  - Agregar un nuevo método de test  en la  Clase CarreraServiceImplTest que se ejecutará 3 veces cambiando cada vez la cadena de búsqueda y el resultado esperado.  
  - Verificar con:
    - AssertTrue
    - AssertEquals
    - AssertNotNull

11. Excepciones - En función a los ejercicios finalizados tomar la clase **VehículoServiceControllerTest.java**:
  - Agregar Test por cada método qué método que contengan una excepción en la clase **VehículoServiceController**.
  - Para validar la excepción esperada  use **assertThatThrownBy**.
  - A los test agregado implementar los respectivos **DisplayName**.

12. Excepciones - En función a los ejercicios finalizados tomar la clase **CarreraServiceControllerTest.java**:
  - Agregar Test por cada método qué método que contengan una excepción en la clase Carrera **ServiceController**.
  - Para validar la excepción esperada  use **assertThatThrownBy**.
  - A los test agregado implementar los respectivos **DisplayName**.
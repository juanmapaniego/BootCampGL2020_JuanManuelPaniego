# Manejo de Excepciones 

1. En base al proyecto **serviceProducts** creado en el ejercicio 3, crear un manejador global de excepciones por medio de **ControllerAdvice**, la cual capture la excepción en el caso de NO enviar un request en la petición. Seguir los siguientes pasos:
	- Crear la clase **ProductServiceErrorHandler** en el paquete **com.globallogic.serviceProducts.error**
  - Colocar la anotación **@ControllerAdvice**
  - Crear un método para la excepción **HttpMessageNotReadableException**
  - Retornar el mensaje “ERROR” con un http status BAD REQUEST
  - Realizar un prueba para /products (POST) sin enviar un Request
  - Salida esperada: ERROR MENSAJE MAL FORMADO

2. En base al ejercicio 7.1, por medio de anotaciones configurar que id y name no puedan venir vacíos en la estructura JSON Request. Capturar la excepción generada al enviar alguno de esos elementos sin valor alguno.
  - Salida Esperada: “ERROR EN DATOS ESPERADOS” con un http status “BAD REQUEST”

3. En base al ejercicio 7.2, definir una clase con las propiedades json (ver “Json properties”) correspondientes para retornar los siguientes tres atributos simples: mensaje, estado y  url, en  los campos message, status_code y uri correspondientes para cada una de las excepciones capturadas en los ejercicios 7.1 y 7.2.

# Introduccion a docker y virtualizacion

## Bandit game
- Paso 1:
<img src="screenshots/Paso1.PNG">
- Paso 2:
<img src="screenshots/Paso2.PNG">
- Paso 3:
<img src="screenshots/Paso3.PNG">
- Paso 4:
<img src="screenshots/Paso4.PNG">
- Paso 5:
<img src="screenshots/Paso5.PNG">
- Paso 6:
<img src="screenshots/Paso6.PNG">
- Paso 7:
<img src="screenshots/Paso7.PNG">
- Paso 8:
<img src="screenshots/Paso8.PNG">
- Paso 9:
<img src="screenshots/Paso9.PNG">
- Paso 10:
<img src="screenshots/Paso10.PNG">
- Paso 11:
<img src="screenshots/Paso11.PNG">
- Paso 12:
<img src="screenshots/Paso12.PNG">
- Paso 13:
<img src="screenshots/Paso13.PNG">

## Ejercicios
1. Comandos
  - Verificar la version de docker
    <img src="screenshots/docker_version.PNG">
  - Ver las imagenes del repositorio local
    <img src="screenshots/docker_images.PNG">
  - Ver los contenedores corriendo y los que estan detenidos
    <img src="screenshots/docker_ps.PNG">

2. Imagenes
  - Descargar la imagen hello-world en su repositorio
    <img src="screenshots/docker_pull.PNG">
  - Ver las imagenes del repositorio local
    <img src="screenshots/docker_images_HW.PNG">
  - Ver los contenedores corriendo y los que estan detenidos
    <img src="screenshots/docker_ps.PNG">

3. Contenedores
  - Crear un contenedor a partir de la imagen bajada (hello-world)
    <img src="screenshots/docker_create_container.PNG">
  - Ver las imagenes del repositorio local}
    <img src="screenshots/docker_images_HW.PNG">
  - Ver los contenedores corriendo y los que estan detenidos
    <img src="screenshots/docker_container_ps.PNG">

4. Dockerfile
  - Crear una imagen con un SO Ubuntu y le vamos a instalar el servidor web Apache, para ello contamos con un Dockerfile que vamos a crear en la siguiente ruta C:\GLBootCamp\repo\docker\apache: 
  <img src="screenshots/dockerfile.PNG">

  - Ejercicio: Construir imagen. Indicar a docker que construya una imagen con el nombre apache a partir del DockerFile que se encuentra en la misma ruta donde ejecutamos el comando(C:\GLBootCamp\repo\docker\apache)
  ´´´
  docker build . -t apache
  ´´´
  <img src="screenshots/docker_file_create.PNG">
  - Crear un contenedor, que llamaremos apache1, mapeando el puerto 80 del contenedor con el 90 de nuestra máquina, a partir de la imagen apache. Para comprobar que todo ha ido bien abrimos un navegador con la url http://localhost:90/
  <img src="screenshots/docker_apache.PNG">
  <img src="screenshots/docker_start.PNG">
  <img src="screenshots/apache_running.PNG">

5. Service Registry
  - Implementar un servidor de registro.
    - Utilice un comando como el siguiente para iniciar el contenedor de registro:
    ´´´bash
    $ docker run -d -p 5000: 5000 --restart = always --name registro de registro: 2
    ´´´
    <img src="screenshots/docker_run_registry.PNG">
  - Extraiga la imagen ubuntu: 16.04 de Docker Hub.
    <img src="screenshots/ubuntu_1604.PNG">
  - Etiqueta docker ubuntu: 16.04 localhost: 5000 / my-ubuntu hacer PUSH en la imagen en el registro local que se ejecuta en localhost: 5000.
    <img src="screenshots/my_ubuntu.PNG">
    <img src="screenshots/push_local.PNG">
  - Elimine las imágenes: ubuntu:16.04 y localhost:5000/my-ubuntu almacenadas en caché local, para que pueda probar la extracción de la imagen de su registro.
    <img src="screenshots/removed.PNG">
    <img src="screenshots/pull_local.PNG">

6. Volúmenes
  1. Implementar volúmenes.
    - Crear un directorio que contendrá la página web.
    - Crear un fichero index.html con una simple página HTML y ubicarla en directorio creado.
    - Crear imagen a partir de dockerfile (bitnami/apache) y crear el contenedor usando volumen.
      - La opción --mount permite crear el enlace entre el directorio de la máquina virtual y el contenedor.
      - La opción tiene tres argumentos separados por comas pero sin espacios:
        - type=bind,source=ORIGEN-EN-MÁQUINA-VIRTUAL,target=DESTINO-EN-CONTENEDOR.
        <img src="screenshots/dockere6.PNG">

        <img src="screenshots/bitnami_apache.PNG">
  2. Implementar volúmenes.
    - Ingrese al navegador y compruebe que se muestra la página recién creada.
    <img src="screenshots/localhost_bitnami_apache.PNG">

7. Service Registry(Github)
  1. Generar token en github.
  2. Copiar token en un fichero. **(TOKEN.txt -> C:\GLBootCamp\repo\docker)**
  3. Autenticacion con token. 
    <img src="screenshots/docker_cmd_e7.PNG">
    - Utiliza este ejemplo de comando de ingreso, reemplace USERNAME con tu nombre de usuario de GitHub y ~/TOKEN.txt con la ruta de archivo a tu token de acceso personal para GitHub
  4. Publicar un paquete de imagen.
    - Determina el nombre y la ID de la imagen Docker APACHE.
    - Etiquetas la imagen APACHE .
      <img src="screenshots/docker_cmd_e7_4.PNG">
    - Publicar la imagen para Github Packages.
    - Respuesta esperada:
      <img src="screenshots/docker_RE.PNG">
<h1 align="center"> Camping los alerces </h1>
<hr>

<p align="center">
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge" #vitrinedev/>
</p>

### Temas 

- [Descripción del proyecto](#descripción-del-proyecto)

- [Funcionalidades](#funcionalidades)

- [aplicación](#aplicación)

- [Herramientas utilizadas](#herramientas-utilizadas)

- [Acesso al proyecto](#acesso-al-proyecto)

- [Abrir y rodar el proyecto](#abrir-y-rodar-el-proyecto)


## Descripción del proyecto Evaluación universitaria de Servicios Web

<p align="justify">
  ¡Desarrollando una solución tecnológica para mejorar la gestión de un camping!

El proyecto "Los Alerces" es un sistema de registro de agrupaciones que se hospedan en un camping atendido por la familia González. Se busca utilizar una solución tecnológica como herramienta de apoyo 
para facilitar el registro y manipulación de datos de los usuarios, representantes, alojamientos, tipos de vehículos y tipos de alojamiento en el camping. El sistema se implementará como un servicio 
web REST que permite agregar, modificar, eliminar y consultar entidades.

</p>

## Funcionalidades

:heavy_check_mark: `Funcionalidad 1:` Agregar usuario: Permite agregar un nuevo usuario. Se comprueba si el usuario ya existe. Si el usuario ya existe, se devuelve un mensaje de error, de lo contrario, se agrega correctamente.

:heavy_check_mark: `Funcionalidad 2:` Modificar usuario: Permite modificar la información de un usuario existente. Se comprueba si el usuario existe en la lista predefinida antes de realizar la modificación

:heavy_check_mark: `Funcionalidad 3:` Eliminar usuario: Permite eliminar un usuario existente. Se comprueba si el usuario existe en la lista predefinida antes de realizar la eliminación.

:heavy_check_mark: `Funcionalidad 4:` Listar usuarios: Permite obtener la lista de todos los usuarios registrados en el sistema.

:heavy_check_mark: `Funcionalidad 5:` Agregar alojamiento: Permite agregar un nuevo alojamiento al sistema. Se comprueba si existen el rut del usuario, el tipo de vehículo y el tipo de alojamiento asociados. Si alguno de ellos no existe, se devuelve un mensaje de error, de lo contrario, se agrega el alojamiento correctamente.

:heavy_check_mark: `Funcionalidad 6:` Eliminar alojamiento: Permite eliminar un alojamiento existente en el sistema.

:heavy_check_mark: `Funcionalidad 7:` Listar alojamientos: Permite obtener la lista de todos los alojamientos registrados en el sistema.
## Aplicación




###

## Herramientas utilizadas

<a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>

###
## Acesso al proyecto

Puedes [acceder al código fuente del proyecto](https://github.com/Yistler/camping).

## Abrir y rodar el proyecto

Clonar el repositorio desde GitHub: https://github.com/Yistler/camping
Abrir un proyecto existente (o alguna opcion similar) desde netbeans.
Busque la ubicación donde esta el proyecto y seleccionalo.
Finalmente aga click en aceptar.
Debes tener conectado Apache tomcat con Xampp el cual es un servidor web local multiplataforma que permite la creación y prueba de páginas web u otros elementos de programación.
Verificar que en la obcion Service pestaña servers este el nombre de proyecto corriendo no en sttoped.
Corre el proyecto (Run project "icono verde").
Prueba los servicios accediendo a las urls correspondiente de cada metodo
Ejemplo: http://localhost:8080/losAlerces/rest/usuarios
Realizar pruebas y verificar el correcto funcionamiento del servicio web REST utilizando herramientas como Postman o SoapUI 🏆 

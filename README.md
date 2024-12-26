# Gestion de Empleados

## Descripción

**La aplicación Gestión de Empleados permite registrar, actualizar, eliminar y buscar empleados en una base de datos. Proporciona una interfaz amigable en consola para interactuar con las funcionalidades.**

## Requisitos

Java Development Kit (JDK) 8 o superior

Maven 3.6 o superior

Base de datos MySQL o PostgreSQL

IDE compatible con Java (IntelliJ IDEA, Eclipse, NetBeans, etc.)

## Configuracion

- 1.clonar repositorio-
 git clone https://github.com/usuario/repo-gestion-empleados.git
- 2.mportar el proyecto en el IDE:
- Abrir el IDE.

- Seleccionar "Importar proyecto".

- Elegir el archivo pom.xml para cargar las dependencias de Maven. 

## Configuar la base datos
- Actualizar el archivo persistence.xml con la configuracion adecuada
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/empleados"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value="password"/>

## Ejecucion del proyecto
**mvn clean install**
**java -jar target/gestion-empleados.jar**

**Al iniciar la aplicacion muestra un menu con opciones**
=======================================
  ʕ•́ᴥ•̀ʔ   GESTION DE EMPLEADOS  ʕ•́ᴥ•̀ʔ
=======================================
Seleccione una opcion :)
1. Agregar un nuevo empleado
2. Mostrar empleados
3. Actualizar empleados
4. Eliminar empleados
5. Buscar empleado por cargo
6. Salir


## Supuestos

**Integridad de Datos**

- Se supone que el ID ingresado existe en la base de datos para operaciones como actualizar y eliminar.

- Se valida que los campos no estén vacíos.

- Base de Datos Inicializada:

- La base de datos debe estar previamente creada y configurada.

-Formato de Fecha:

-El formato de fecha esperado es YYYY-MM-DD.

-Valores Numéricos Positivos:

-Los salarios deben ser mayores a 0.
 

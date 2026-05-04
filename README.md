Sistema de Gestión de Inventario y Servicios para Motocicletas
    Este proyecto es una aplicación de escritorio desarrollada en Java que permite administrar el inventario de una comercializadora de vehículos y el historial de sus mantenimientos técnicos. Utiliza una arquitectura de persistencia basada en JPA para garantizar la integridad de los datos.

Descripción General
El sistema centraliza la información de motocicletas, proveedores y servicios técnicos. Permite realizar operaciones de registro, consulta, actualización y eliminación de datos (CRUD), asegurando que cada servicio técnico esté correctamente vinculado a una unidad de inventario y cada unidad a un proveedor específico.

Tecnologías Utilizadas
      
      Lenguaje de Programación: Java (JDK 17 o superior).

      Gestión de Persistencia: Jakarta Persistence API (JPA) con EclipseLink.

      Base de Datos: PostgreSQL.

      Gestión de Proyectos y Dependencias: Maven.

      Entorno de Desarrollo: NetBeans IDE.

Estructura del Proyecto
      
      src/main/java: Contiene el código fuente organizado en paquetes de entidades y controladores JPA.

      src/main/resources/META-INF/persistence.xml: Archivo de configuración para la conexión a la base de datos.

      database/: Carpeta que contiene el script SQL para recrear la base de datos localmente.

      pom.xml: Configuración de Maven y dependencias del proyecto.

Requisitos Previos
      
      Tener instalado el JDK 17 o versión superior.

      Contar con un servidor de PostgreSQL activo.
    
      Disponer de una herramienta para ejecutar el proyecto (NetBeans, IntelliJ o Maven por línea de comandos).

Configuración e Instalación
  Base de Datos:

      Cree una base de datos llamada "bd_motocicleta" en PostgreSQL.

      Ejecute el script ubicado en la carpeta "database/respaldo_bd.sql" para crear las tablas y relaciones.

      Configuración de Persistencia:

      Abra el archivo "src/main/resources/META-INF/persistence.xml".

      Asegúrese de que el usuario y la contraseña coincidan con sus credenciales locales de PostgreSQL.

Ejecución:

      Abra el proyecto en su IDE.

      Limpie y construya el proyecto (Clean and Build).

      Ejecute la clase principal (Main.java).

Modelo de Datos
      El sistema se basa en tres entidades principales:

      Proveedor: Información de contacto y origen.

      Motocicleta: Datos técnicos y comerciales del vehículo.

      Servicio Técnico: Detalle de mantenimientos y costos asociados.

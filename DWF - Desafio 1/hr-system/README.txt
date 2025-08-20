HR System - Proyecto Maven listo para IntelliJ IDEA 2022.1.4
Generado: 2025-08-12T03:56:04.048500 UTC

Instrucciones rápidas
1. Importar proyecto
   - File > Open... > seleccionar la carpeta 'HRSystem_Project' (contiene pom.xml).
   - IntelliJ detectará proyecto Maven; deja que descargue dependencias.

2. Configurar Payara (o GlassFish)
   - Instala Payara 5.x y añádelo en File > Settings > Application Servers.
   - En Run/Debug Configurations crea un nuevo 'Local' Payara/GlassFish: selecciona artefacto 'hr-system:war' y puerto 8080.
   - Build -> Build Artifacts... asegúrate que el WAR se construya 'on make'.

3. Base de datos MySQL
   - Ejecuta el script SQL en 'resources/db/init.sql' en tu MySQL Workbench.
   - Conexión por defecto usada en el proyecto: user=root, sin contraseña, host=localhost, puerto=3306.
   - Nombre de la BD: RecursosHumanos

4. Ajustes en el proyecto (si tu MySQL tiene contraseña)
   - Edita el archivo src/main/java/com/udb/hr/util/DBUtil.java
   - Cambia USER y PASS según necesites.

5. Ejecutar
   - Levanta Payara desde IntelliJ y accede a: http://localhost:8080/hr-system/empleados?action=list
   - Páginas para cada módulo: /empleados, /departamentos, /cargos, /tipos, /contrataciones

Contenido importante en el ZIP:
 - src/main/java (codigo Java)
 - src/main/webapp/jsp (vistas JSP)
 - resources/db/init.sql (script creación y datos de prueba)
 - pom.xml
 - web/WEB-INF/web.xml

Notas:
 - Proyecto minimal pero funcional: CRUD básicos implementados.
 - Para producción: usa DataSource JNDI, manejo de contraseñas, validaciones más estrictas y cifrado.

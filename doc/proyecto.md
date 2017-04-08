# Proyecto: MVC2, bases de datos y diseño de la lógica de negocio

Objetivos de la práctica
1. Diseño de la lógica de negocio
2. Diseño de la base de datos
3. Gestión de perfiles de usuario


El objetivo de esta práctica consiste en extender las funcionalidades de la tienda virtual
introduciendo un nuevo tipo de usuario, el administrador, y aportando nuevas
funcionalidades al usuario-cliente de la tienda.

## Requisitos de la aplicación web

### Funcionalidades
Indicamos aquí las funcionalidades del sistema en función del perfil del usuario:

*Cliente de la tienda*

F1. Registrar a los nuevos usuarios
F2. Validar nombre/contraseña del usuario
F3. Presentar el catálogo de CDs abaliable en la tienda en ese momento. Hay
que indicar aquí el título, autor, precio y el código del CD correspondiente.
F4. Realizar búsquedas de CDs disponibles indicando precio máximo, título,
autor y/o año. La búsqueda puede incluir todos los criterios o combinaciones de
los mismos.
F5. Permitir la selección de CDs al usuario
F6. Mostrar el contenido del carro de la compra al usuario
F7. Permitir la confirmación de la compra y el consiguiente pedido de los CDs
F8. Guardar el pedido incluyendo los productos de la selección y los datos del
usuario. Actualizar el perfil del usuario para poder aplicar el programa de
descuentos.
F9. Confirmar el pedido enviando un correo electrónico al usuario.
F10. Actualizar el stock de pedidos
F11. Mostrar al usuario el precio final de los items seleccionados. Considerar
que en función de los items previamente consumidos por el usuario, su cuenta
puede catalogarse como “VIP”, “básico”, lo que le permitirá acceder a los
descuentos de la tienda online. Estos son los criterios del programa de
descuentos:

-  Básico. Pertenecen aquellos usuarios que tengan menos de 100 euros
en compras realizadas. No hay descuento.
- VIP. Pertenecen aquellos usuarios con más de 100 euros en compras
realizadas. Descuentos del 20%.
F12. Permitir al usuario la introducción de comentarios y valoraciones para cada
item que haya consumido. (Opcional)
F13. Mostrar a los usuarios los comentarios y valoraciones de cada item.
(Opcional)

Administrador de la tienda
F14. Validar nombre/contraseña del usuario
F15. Permitir la introducción de nuevos CDs y cantidades correspondientes
F16. Visualizar el catálogo de CDs que oferta la tienda
F17. Almacenar el nuevo CD en la base de datos
F18. Administrar los usuarios registrados: visualización de cuentas,
modificación de contraseñas y borrado de usuarios.

*No nominales*
NN1. Mostrar una página de error en la validación de los usuarios
NN2. Mostrar una página si se introduce un CD que ya está introducido en la
BD
NN3. Mostrar página de error si el usuario no introduce sus datos completos en
el registro
1.3 De calidad del servicio
CS1. Escalabilidad respecto al tipo de usuarios que podemos definir en la
aplicación.
CS2. Escalabilidad respecto al número de tablas de la BD
CS3. Extensibilidad respecto a nuevas funcionalidades (por ejemplo,
personalización de la interfaz de usuario, subida de ficheros imagen que
acompañen al CD, gestión de usuarios por parte del administrador, etc.)
CS4. Interoperabilidad con aplicaciones web de proveedores de CDs
CS5. Robustez de la Base de Datos ante transacciones concurrentes.

*Diseño de la aplicación*

El único requisito es utilizar el patrón de diseño MVC2 en la capa web.


*Implementación de la solución*
La implementación de esta práctica debe realizarse con JDBC y MySQL como gestor de
base de datos.

### Material de apoyo para realizar la práctica

El objetivo de la práctica consiste en realizar un buen diseño de la aplicación. Para
ello se aconseja revisar la metodología explicada en clase en el tema 3.
Desde el punto de vista tecnológico sólo es necesario saber utilizar el middleware
de Java (librerias JAF y JavaMail) para enviar correo. En
proyecto1_fichero_javamail.java encontrareis código ejemplo para utilizar este
middleware.


### Notas para la realización de la práctica

Se recomienda especial atención al diseño de la práctica, ya que un buen diseño
garantiza la escalabilidad y la extensibilidad de vuestra aplicación. Estos aspectos
repercutirán enormemente en la reutilización del código de la aplicación.
En concreto, se recomienda incluir los patrones VO y DAO en el diseño de la lógica de
negocio.
4

### Presentación de la práctica


- Generar un fichero proyecto_nombre_apellidos.war, que contenga los siguientes
ficheros en el árbol de directorios requerido para una aplicación web:
 - Fichero(s) .html
 - Imágenes utilizadas
 - Fichero(s) .jsp
 - Fichero(s).java
 - Fichero(s).class (Fichero(s).java compilados)
 - Fichero .txt con las instrucciones SQL para generar la base de datos y
crear las tablas correspondientes.

- El fichero .war debe estar preparado para su despliegue automático en
TOMCAT. Esto significa que la aplicación debe estar abaliable en
http://localhost:8080/ proyecto_nombre_apellidos/, una vez copiado el fichero
.war en <TOMCAT>/webapps, y activado el contenedor web.

- Presentar un esquema de la arquitectura software del sistema indicando los
componentes, los conectores y su topología.

- Presentar un diagrama de secuencia para los casos de uso “Seleccionar y pagar
un CD” para el usuario-cliente, y para “Introducir nuevo CD y ver catálogo”
para el usuario-administrador

- Enviar el fichero proyecto_nombre_apellidos.war y los diagramas de diseño a
la dirección de correo del profesor: eduardouscdocencia@gmail.com. Indicar
en el correo los 3 integrantes (excepcionalmente, 4 integrantes) del grupo
que trabajó en el proyecto, con el asunto “[DAWA]
proyecto_nombre_aprellidos”.

- Fecha tope: Lunes, 18 de Abril – 23:59 horas.

### Evaluación de la práctica

- El proyecto representa el 30%, o 3 puntos, de la nota final de la asignatura.
Adicionalmente, se pueden obtener 0.4 puntos por la implementación de
funcionalidades optativas.

- La nota se reparte en función de los siguientes aspectos:
 - Diseño del sistema (1.5 puntos)
 - Implementación de las funcionalidades obligatorias (1.5 puntos)
 - Implementación de las funcionalidades optativas (0.4 puntos)
  - *Nota para cada apartado del diseño:*
   - Arquitectura software (0,5 punto)
   - Diagramas de secuencia (0,5 punto)
   - Satisfacción de requisitos de calidad de servicio:
CS1. Escalabilidad respecto al tipo de usuarios que podemos definir en la
aplicación. (0.1 puntos)
CS2. Escalabilidad respecto al número de tablas de la BD (0.1 puntos)
CS3. Extensibilidad respecto a nuevas funcionalidades (por ejemplo,
personalización de la interfaz de usuario, subida de ficheros imagen que
acompañen al CD, gestión de usuarios por parte del administrador, etc.)
(0.1 puntos)
CS4. Interoperabilidad con aplicaciones web de proveedores de CDs (0.1
puntos)
CS5. Robustez de la Base de Datos ante transacciones concurrentes. (0.1
puntos)

   - *Nota para las funcionalidades cliente:*
F1. Registrar a los nuevos usuarios (0.05 puntos)
F2. Validar nombre/contraseña del usuario (0.05 puntos)
F3. Presentar el catálogo de CDs abaliable en la tienda en ese momento. Hay
que indicar aquí el título, autor, precio y el código del CD correspondiente. (0.1
puntos)
F4. Realizar búsquedas de CDs disponibles indicando precio máximo, título,
autor y/o año. La búsqueda puede incluir todos los criterios o combinaciones de
los mismos. (0.2 puntos)
F5. Permitir la selección de CDs al usuario (0.05 puntos)
F6. Mostrar el contenido del carro de la compra al usuario (0.05 puntos)
F7. Permitir la confirmación de la compra y el consiguiente pedido de los CDs
(0.05 puntos)
F8. Guardar el pedido incluyendo los productos de la selección y los datos del
usuario. Actualizar el perfil del usuario para poder aplicar el programa de
descuentos. (0.1 puntos)
F9. Confirmar el pedido enviando un correo electrónico al usuario. (0.1 puntos)
F10. Actualizar el stock de pedidos (0.05 puntos).
F11. Mostrar al usuario el precio final de los items seleccionados. Considerar
que en función de los items previamente consumidos por el usuario, su cuenta
puede catalogarse como “VIP”, “básico”, lo que le permitirá acceder a los
descuentos de la tienda online. Estos son los criterios del programa de
descuentos (0.2 puntos):
• Básico. Pertenecen aquellos usuarios que tengan menos de 100 euros
en compras realizadas. No hay descuento.
• VIP. Pertenecen aquellos usuarios con más de 100 euros en compras
realizadas. Descuentos del 20%.
F12. Permitir al usuario la introducción de comentarios y valoraciones para cada
item que haya consumido. (Opcional, 0,3 puntos)
F13. Mostrar a los usuarios los comentarios y valoraciones de cada item.
(Opcional, 0,1 puntos)

Nota para las funcionalidades Administrador:
F14. Validar nombre/contraseña del usuario (0.1 puntos)
F15. Permitir la introducción de nuevos CDs y cantidades correspondientes (0.1
puntos)
F16. Visualizar el catálogo de CDs que oferta la tienda (0.1 puntos)
F17. Almacenar el nuevo CD en la base de datos (0.1 puntos)
F18. Administrar los usuarios registrados: visualización de cuentas,
modificación de contraseñas y borrado de usuarios. (0.1 puntos)
-

Si la práctica se presenta con posterioridad a la fecha tope, se descontarán 0,5
puntos por cada día de retraso.



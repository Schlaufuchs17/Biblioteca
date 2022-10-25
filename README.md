# <h1> Biblioteca </h1>

Ejercicio de Hilos-Sockets para PSP de 2º DAM

<h2> Requerimiento 1 </h2>
<br>
Se pide hacer dos programas cliente-servidor con sockets e hilos. La aplicación servidora programa consistirá en crear una aplicación que gestione una serie de libros de una biblioteca virtual, la aplicación cliente consumirá dicha aplicación servidora.

Los libros tendrán un ISBN, un título, un autor y un precio. Se encontrarán alojados en el servidor. Dicho servidor cuando arranque tendrá 5 libros preestablecidos con todos los datos rellenos. Los libros se guardarán en memoria en cualquier tipo de estructura de datos (como puede ser un lista). El servidor deberá estar preparado para que interactúen con él varios clientes (se deberá abrir un hilo por cada cliente).

La aplicación cliente mostrará un menú como el que sigue:

    Consultar libro por ISBN
    Consultar libro por titulo
    Salir de la aplicación

La aplicación se ejecutará hasta que el cliente decida pulsar la opción de “salir de la aplicación”.

El cliente deberá de recoger todos los datos del usuario necesarios y mandarlos al servidor en un solo envio.

<h2> Requerimiento 2 </h2>

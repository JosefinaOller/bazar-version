## Proyecto: TP Integrador Final - Spring Boot

### Objetivo
El objetivo de este proyecto es validar los conocimientos prácticos y técnicos referidos al desarrollo de APIs en Java mediante Spring Boot. Este proyecto forma parte del curso "Desarrollo de APIs en Java con Spring Boot" de la TodoCode Academy.

### Escenario
El bazar ha experimentado un incremento significativo en sus ventas, lo que hace inviable la gestión manual de las mismas y del control de stock. Por lo tanto, se desarrolló una API que permite registrar ventas y manejar el stock de productos de manera automatizada. Esta API servirá tanto a una aplicación web como a una futura aplicación móvil.

### Tecnologías Utilizadas
- **Java 17**
- **Spring Boot** (framework principal)
- **Hibernate** y **JPA** (para la persistencia de datos)
- **DTOs** (para transferencia de datos)
- **Arquitectura de multicapas**
- **Postman** (para pruebas de endpoints)

### Modelado de Datos
Se han definido las siguientes clases y sus atributos:

**Producto**
- `Long codigo_producto`
- `String nombre`
- `String marca`
- `Double costo`
- `Double cantidad_disponible`

**Venta**
- `Long codigo_venta`
- `LocalDate fecha_venta`
- `Double total`
- `List<Producto> listaProductos`
- `Cliente unCliente`

**Cliente**
- `Long id_cliente`
- `String nombre`
- `String apellido`
- `String dni`

### Requerimientos
La API permite realizar operaciones CRUD completas para productos, clientes y ventas, además de otras funcionalidades adicionales.

#### 1. CRUD de Productos
**Métodos HTTP**: GET, POST, DELETE, PUT

**Endpoints**:
- **Creación**: `POST /productos/crear`
- **Lista completa de productos**: `GET /productos`
- **Traer un producto en particular**: `GET /productos/{codigo_producto}`
- **Eliminación**: `DELETE /productos/eliminar/{codigo_producto}`
- **Edición**: `PUT /productos/editar`

#### 2. CRUD de Clientes
**Métodos HTTP**: GET, POST, DELETE, PUT

**Endpoints**:
- **Creación**: `POST /clientes/crear`
- **Lista completa de clientes**: `GET /clientes`
- **Traer un cliente en particular**: `GET /clientes/{id_cliente}`
- **Eliminación**: `DELETE /clientes/eliminar/{id_cliente}`
- **Edición**: `PUT /clientes/editar`

#### 3. CRUD de Ventas
**Métodos HTTP**: GET, POST, DELETE, PUT

**Endpoints**:
- **Creación**: `POST /ventas/crear`
- **Lista completa de ventas**: `GET /ventas`
- **Traer una venta en particular**: `GET /ventas/{codigo_venta}`
- **Eliminación**: `DELETE /ventas/eliminar/{codigo_venta}`
- **Edición**: `PUT /ventas/editar`

### Funcionalidades Adicionales
- **Verificación de Stock**: Al crear una venta, se verifica que haya suficiente stock de los productos solicitados. Si el stock es suficiente, se actualiza la cantidad disponible de cada producto.
- **Cálculo Automático del Total de la Venta**: El total de la venta se calcula automáticamente en base a los productos y sus cantidades.
- **Manejo de Errores**: La API incluye manejo de errores para garantizar que se brinden respuestas claras cuando las operaciones no se pueden realizar, como cuando no hay suficiente stock.
- **Actualización de Stock**: Después de realizar una venta, el stock de cada producto involucrado se actualiza automáticamente para reflejar la nueva cantidad disponible.

### Requerimientos Adicionales

#### Obtener todos los productos cuya cantidad_disponible sea menor a 5
**Métodos HTTP**: GET

**Endpoint**: `GET /productos/falta_stock`

#### Obtener la lista de productos de una determinada venta
**Métodos HTTP**: GET

**Endpoint**: `GET /ventas/productos/{codigo_venta}`

#### Obtener la sumatoria del monto y también la cantidad total de ventas de un determinado día
**Métodos HTTP**: GET

**Endpoint**: `GET /ventas/{fecha_venta}`

#### Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas
**Métodos HTTP**: GET

**Endpoint**: `GET /ventas/mayor_venta`

### Pruebas con Postman
Las pruebas de los endpoints se realizaron con **Postman**. Puedes importar la colección de Postman incluida en el repositorio para realizar pruebas de manera rápida y efectiva.



# Manual Técnico

---
#### Datos del Estudiante
- **Nombre:** Juan Jacobo Diaz Naola
- **Carnet:** 202408106
- **Curso:** Laboratorio de Introducción a la Programación y Computación I
- **Sección:** B
- **Universidad de San Carlos de Guatemala**

---

### Requerimientos de la Aplicación
- Java JDK 11 o superior
- NetBeans IDE (recomendado)
- Sistema Operativo: Windows, Linux o macOS
- Memoria RAM mínima: 2 GB
- Espacio en disco: 50 MB

---

### Descripción General
Sistema de gestión de inventario para una tienda de ropa desarrollado en Java con interfaz gráfica Swing. Permite gestionar productos, registrar ventas y generar reportes en formato HTML.

---

### Estructura del Proyecto
```
Proyecto1/
├── src/
│   ├── Producto.java
│   ├── Venta.java
│   ├── Inventario.java
│   ├── MainFrame.java
│   └── Main.java
└── dist/
    └── InventarioRopa.jar
```

---

### Descripción de Clases y Métodos

#### Clase `Producto.java`
Representa un producto del inventario.

| Método | Descripción |
|--------|-------------|
| `Producto(codigo, nombre, categoria, precio, stock)` | Constructor que inicializa todos los atributos del producto |
| `getCodigo()` | Retorna el código único del producto |
| `getNombre()` | Retorna el nombre del producto |
| `getCategoria()` | Retorna la categoría del producto |
| `getPrecio()` | Retorna el precio del producto |
| `getStock()` | Retorna la cantidad en stock |
| `setPrecio(precio)` | Modifica el precio del producto |
| `setStock(stock)` | Modifica la cantidad en stock |
| `toString()` | Retorna una cadena con la información completa del producto |

---

#### Clase `Venta.java`
Representa una transacción de venta.

| Método | Descripción |
|--------|-------------|
| `Venta(codigoProducto, nombreProducto, cantidad, precioUnitario)` | Constructor que inicializa la venta y calcula el total automáticamente |
| `getCodigoProducto()` | Retorna el código del producto vendido |
| `getNombreProducto()` | Retorna el nombre del producto vendido |
| `getCantidad()` | Retorna la cantidad vendida |
| `getTotalVenta()` | Retorna el total de la venta |
| `getFechaHora()` | Retorna la fecha y hora de la transacción |
| `toString()` | Retorna una cadena con la información completa de la venta |

---

#### Clase `Inventario.java`
Clase principal que gestiona toda la lógica del sistema mediante vectores.

| Método | Descripción |
|--------|-------------|
| `Inventario()` | Constructor que inicializa los vectores con capacidad máxima de 100 |
| `codigoExiste(codigo)` | Verifica si un código de producto ya existe en el inventario |
| `agregarProducto(codigo, nombre, categoria, precio, stock)` | Agrega un nuevo producto validando código único y valores positivos |
| `buscarProducto(criterio)` | Busca productos por nombre, código o categoría |
| `eliminarProducto(codigo)` | Elimina un producto del inventario reorganizando el vector |
| `getProductos()` | Retorna un arreglo con todos los productos registrados |
| `registrarVenta(codigo, cantidad)` | Registra una venta validando existencia y stock suficiente |
| `guardarVentaEnArchivo(venta)` | Guarda la información de una venta en ventas.txt |
| `getVentas()` | Retorna un arreglo con todas las ventas registradas |
| `generarReporteStock()` | Genera un archivo HTML con todos los productos del inventario |
| `generarReporteVentas()` | Genera un archivo HTML con el historial de ventas |

---

#### Clase `MainFrame.java`
Clase de la interfaz gráfica principal construida con Java Swing.

| Método | Descripción |
|--------|-------------|
| `MainFrame()` | Constructor que inicializa el inventario y los componentes gráficos |
| `initComponents()` | Configura y muestra la ventana principal con el menú de opciones |
| `mostrarVentanaAgregar()` | Muestra el diálogo para registrar un nuevo producto |
| `mostrarVentanaBuscar()` | Muestra el diálogo para buscar productos con tabla de resultados |
| `mostrarVentanaEliminar()` | Muestra el diálogo para eliminar un producto por código |
| `mostrarVentanaVenta()` | Muestra el diálogo para registrar una venta |
| `mostrarVentanaReportes()` | Muestra el diálogo para generar reportes HTML |
| `mostrarDatosEstudiante()` | Muestra los datos del estudiante en un cuadro de diálogo |

---

#### Clase `Main.java`
Clase principal que lanza la aplicación.

| Método | Descripción |
|--------|-------------|
| `main(String[] args)` | Método principal que inicia la interfaz gráfica en el hilo de eventos de Swing |

---

### Estructuras de Datos Utilizadas
- **Vectores (arrays):** Se utilizan dos arreglos de tamaño máximo 100 para almacenar productos y ventas. No se utilizan librerías como ArrayList o LinkedList.

---

### Archivos Generados
- `ventas.txt` — archivo de texto donde se almacena el historial de ventas
- `DD_MM_YYYY_HH_mm_ss_Stock.html` — reporte HTML del inventario
- `DD_MM_YYYY_HH_mm_ss_Venta.html` — reporte HTML de ventas

---

### Validaciones Implementadas
- Código de producto único
- Precio y stock con valores positivos
- Campos obligatorios no vacíos
- Stock suficiente al registrar una venta
- Entradas no numéricas controladas con try-catch













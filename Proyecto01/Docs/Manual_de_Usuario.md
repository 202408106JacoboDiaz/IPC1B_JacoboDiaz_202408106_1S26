# Manual de Usuario
----
#### Datos del Estudiante
- **Nombre:** Juan Jacobo Diaz Naola
- **Carnet:** 202408106
- **Curso:** Laboratorio de Introducción a la Programación y Computación I
- **Sección:** B
- **Universidad de San Carlos de Guatemala**
---
**¿Qué es el Sistema de Inventario?**
Es una aplicación de escritorio desarrollada en Java que permite gestionar el inventario de una tienda de ropa. Con la misma se pueden agregar productos, buscar, eliminar, registrar ventas y generar reportes en HTML.
---
### ¿Cómo ejecutar la aplicación?
#### Opción 1 — Desde NetBeans
1. Abrir NetBeans
2. Cargar el proyecto (Proyecto01)
3. Presionar **F6** o el botón de *Play* (color verde)
#### Opción 2 — Desde el archivo *JAR*
1. Localizar el archivo `InventarioRopa.jar` en la carpeta `dist`
2. Hacer doble clic sobre el mismo
3. La aplicación se abrirá automáticamente
---
### Menú Principal
Al iniciar la aplicación se mostrará la ventana principal con las siguientes opciones:
| Opción | Descripción |
|--------|-------------|
| Agregar Producto | Registra un nuevo producto en el inventario |
| Buscar Producto | Busca productos por nombre, código o categoría |
| Eliminar Producto | Elimina un producto del inventario |
| Registrar Venta | Registra la venta de un producto |
| Generar Reportes | Genera reportes en formato HTML |
| Ver Datos Estudiante | Muestra la información del estudiante |
| Salir | Cierra la aplicación |
---
### Agregar Producto
1. Hacer clic en el botón **Agregar Producto**
2. Se abrirá una ventana con los siguientes campos:
   - **Codigo:** identificador único del producto (ejemplo: QWERTY123)
   - **Nombre:** nombre del producto (ejemplo: Playera de Messi)
   - **Categoria:** tipo de producto (ejemplo: Ropa Deportiva)
   - **Precio:** precio en quetzales [Q] (ejemplo: 150.00)
   - **Stock:** cantidad disponible (ejemplo: 20)
3. Completar todos los campos y hacer clic en **Guardar**
4. El sistema mostrará un mensaje confirmando que el producto fue agregado
> **Nota:** El código debe ser único. Si ya existe un producto con ese código, el sistema lo rechazará.
---
### Buscar Producto
1. Hacer clic en el botón **Buscar Producto**
2. En el campo de búsqueda escribir el nombre, código o categoría del producto
3. Hacer clic en el botón **Buscar**
4. Los resultados aparecerán en la tabla con todos los datos del producto
5. Si no se encuentra ningún producto, el sistema mostrará un mensaje de aviso
6. Hacer clic en **Cerrar** para regresar al menú principal
---
### Eliminar Producto
1. Hacer clic en el botón **Eliminar Producto**
2. Ingresar el código del producto que se desea eliminar
3. Hacer clic en **Eliminar**
4. El sistema pedirá confirmación con un mensaje *¿Estás seguro?*
5. Hacer clic en **Sí** para confirmar la eliminación
6. El sistema mostrará un mensaje confirmando que el producto fue eliminado
> **Nota:** La eliminación es permanente, no se puede deshacer.
---
### Registrar Venta
1. Hacer clic en el botón **Registrar Venta**
2. Ingresar el código del producto vendido
3. Ingresar la cantidad vendida
4. Hacer clic en **Registrar Venta**
5. El sistema validará que el producto exista y que haya stock suficiente
6. Si la venta es exitosa, mostrará el total de la venta y descontará el stock automáticamente
> **Nota:** Si la cantidad ingresada es mayor al stock disponible, el sistema rechazará la venta e indicará el stock actual.
---
### Generar Reportes
1. Hacer clic en el botón **Generar Reportes**
2. Se mostrarán dos opciones:
#### - Reporte de Stock
- Hacer clic en **Generar Reporte de Stock**
- Se creará un archivo HTML en la carpeta del proyecto con el nombre `DD_MM_YYYY_HH_mm_ss_Stock.html`
- El archivo contiene una tabla con todos los productos registrados
#### - Reporte de Ventas
- Hacer clic en **Generar Reporte de Ventas**
- Se creará un archivo HTML con el nombre `DD_MM_YYYY_HH_mm_ss_Venta.html`
- El archivo contiene el historial completo de ventas con fechas y totales
> **Nota:** Para ver los reportes es necesario abrir los archivos HTML generados en cualquier navegador web (Google Chrome recomendado).
---
### Ver Datos del Estudiante
1. Hacer clic en el botón **Ver Datos Estudiante**
2. Se mostrará un cuadro con la información del desarrollador de la aplicación, demostrando su autoría sobre el mismo, que incluye su **nombre** completo, **carnet** universitario, **curso (y sección)** al cual pertenece el proyecto y **universidad** a la que pertenece.
---
### Salir
1. Hacer clic en el botón **Salir**
2. La aplicación se cerrará inmediatamente
---
### Mensajes de Error Comunes
| Mensaje | Causa | Solución/Alternativa |
|---------|-------|----------|
| "Ya existe un producto con ese codigo" | El código ingresado ya está registrado | Usar un código diferente |
| "Todos los campos son obligatorios" | Existen campos vacíos | Completar todos los campos |
| "Precio y stock deben ser valores numericos" | Se ingresaron carácteres de texto o alfanuméricos en precio o stock | Ingresar solo carácteres numéricos |
| "Stock insuficiente" | La cantidad a vender supera el stock | Verificar el stock disponible |
| "Producto no encontrado" | El código ingresado no existe | Verificar el código del producto |

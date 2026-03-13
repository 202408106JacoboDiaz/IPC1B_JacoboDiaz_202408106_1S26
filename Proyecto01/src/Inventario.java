//Importar librerias
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Inventario {
    //Vectores para almacenar productos y ventas
    private Producto[] productos;
    private Venta[] ventas;
    private int totalProductos;
    private int totalVentas;
    private static final int MAX = 100;
    //Constructor
    public Inventario() {
        productos = new Producto[MAX];
        ventas = new Venta[MAX];
        totalProductos = 0;
        totalVentas = 0;
    }
    //----- Productos -----
    //Codigo = existe
    private boolean codigoExiste(String codigo) {
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
    //Agregar producto
    public String agregarProducto(String codigo, String nombre, String categoria, double precio, int stock) {
        if (totalProductos >= MAX) {
            return "Error: Inventario lleno";
        }
        if (codigoExiste(codigo)) {
            return "Error: Ya existen productos con ese codigo";
        }
        if (precio <= 0 || stock < 0) {
            return "Error: Precio y stock deben ser positivos";
        }
        productos[totalProductos] = new Producto(codigo, nombre, categoria, precio, stock);
        totalProductos++;
        return "Producto agregado con exito";
    }
    //Buscar productos por codigo, nombre o categoria
    public Producto[] buscarProducto(String criterio) {
        Producto[] resultados = new Producto[MAX];
        int total = 0;
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(criterio) ||
                productos[i].getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                productos[i].getCategoria().toLowerCase().contains(criterio.toLowerCase())) {
                resultados[total] = productos[i];
                total++;
            }
        }
        //Devolver solo los encontrados
        Producto[] encontrados = new Producto[total];
        for (int i = 0; i < total; i++) {
            encontrados[i] = resultados[i];
        }
        return encontrados;
    }
    //Eliminar producto por codigo
    public String eliminarProducto(String codigo) {
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                // Recorrer el vector para eliminar
                for (int j = i; j < totalProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[totalProductos - 1] = null;
                totalProductos--;
                return "Producto eliminado con exito";
            }
        }
        return "Error: Producto no encontrado";
    }
    // Obtener todos los productos
    public Producto[] getProductos() {
        Producto[] lista = new Producto[totalProductos];
        for (int i = 0; i < totalProductos; i++) {
            lista[i] = productos[i];
        }
        return lista;
    }
    //------ Ventas ------
    //Registrar venta
    public String registrarVenta(String codigo, int cantidad) {
        if (totalVentas >= MAX) {
            return "Error: Limite de ventas alcanzado";
        }
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                if (productos[i].getStock() < cantidad) {
                    return "Error: Stock insuficiente. Stock disponible: " + productos[i].getStock();
                }
                if (cantidad <= 0) {
                    return "Error: La cantidad debe ser mayor a cero";
                }
                //Descontar stock
                productos[i].setStock(productos[i].getStock() - cantidad);
                //Crear venta
                Venta venta = new Venta(codigo, productos[i].getNombre(), cantidad, productos[i].getPrecio());
                ventas[totalVentas] = venta;
                totalVentas++;
                //Guardar en archivo de texto
                guardarVentaEnArchivo(venta);
                return "Venta registrada correctamente. Total: Q" + venta.getTotalV();
            }
        }
        return "Error: Producto no encontrado.";
    }
    //Guardar venta en .txt
    private void guardarVentaEnArchivo(Venta venta) {
        try {
            FileWriter escritor = new FileWriter("ventas.txt", true);
            escritor.write(venta.toString() + "\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }
    }
    //Obtener todas las ventas
    public Venta[] getVentas() {
        Venta[] lista = new Venta[totalVentas];
        for (int i = 0; i < totalVentas; i++) {
            lista[i] = ventas[i];
        }
        return lista;
    }
    //----- Reportes -----
    //Generar reporte de stock en archivo HTML
    public String generarReporteStock() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String nombreArchivo = ahora.format(formato) + "_Stock.html";
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.write("<html><head><title>Reporte de Stock</title></head><body>");
            escritor.write("<h1>Reporte de Stock</h1>");
            escritor.write("<table border='1'><tr><th>Codigo</th><th>Nombre</th><th>Categoria</th><th>Precio</th><th>Stock</th></tr>");
            for (int i = 0; i < totalProductos; i++) {
                escritor.write("<tr>");
                escritor.write("<td>" + productos[i].getCodigo() + "</td>");
                escritor.write("<td>" + productos[i].getNombre() + "</td>");
                escritor.write("<td>" + productos[i].getCategoria() + "</td>");
                escritor.write("<td>Q" + productos[i].getPrecio() + "</td>");
                escritor.write("<td>" + productos[i].getStock() + "</td>");
                escritor.write("</tr>");
            }
            escritor.write("</table></body></html>");
            escritor.close();
            return "Reporte de stock generado: " + nombreArchivo;
        } catch (IOException e) {
            return "Error al generar reporte: " + e.getMessage();
        }
    }
    //Generar reporte de ventas en archivo HTML
    public String generarReporteVentas() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String nombreArchivo = ahora.format(formato) + "_Venta.html";
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.write("<html><head><title>Reporte de Ventas</title></head><body>");
            escritor.write("<h1>Reporte de Ventas</h1>");
            escritor.write("<table border='1'><tr><th>Codigo</th><th>Producto</th><th>Cantidad</th><th>Total</th><th>Fecha</th></tr>");
            for (int i = 0; i < totalVentas; i++) {
                escritor.write("<tr>");
                escritor.write("<td>" + ventas[i].getCodProducto() + "</td>");
                escritor.write("<td>" + ventas[i].getNombProducto() + "</td>");
                escritor.write("<td>" + ventas[i].getCantidad() + "</td>");
                escritor.write("<td>Q" + ventas[i].getTotalV() + "</td>");
                escritor.write("<td>" + ventas[i].getFechaHora() + "</td>");
                escritor.write("</tr>");
            }
            escritor.write("</table></body></html>");
            escritor.close();
            return "Reporte de ventas generado: " + nombreArchivo;
        } catch (IOException e) {
            return "Error al generar reporte: " + e.getMessage();
        }
    }
}
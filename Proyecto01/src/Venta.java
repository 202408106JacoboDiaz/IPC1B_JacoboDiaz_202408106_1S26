//Librerias
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venta {
    //Atributos
    private String codProducto;
    private String nomProducto;
    private int cant;
    private double totalVenta;
    private String fechaHora;
    // Constructor
    public Venta(String codigoProducto, String nombreProducto, int cantidad, double precioU) {
        this.codProducto = codigoProducto;
        this.nomProducto = nombreProducto;
        this.cant = cantidad;
        this.totalVenta = cantidad*precioU;
        //Fecha y hora automatico
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fechaHora = ahora.format(formato);
    }
    //Getter codigo del producto
    public String getCodProducto() {
        return codProducto;
    }
    //Getter nombre del producto
    public String getNombProducto() {
        return nomProducto;
    }
    //Getter cantidad del producto
    public int getCantidad() {
        return cant;
    }
    //Getter total de la venta
    public double getTotalV() {
        return totalVenta;
    }
    //Getter fecha y hora
    public String getFechaHora() {
        return fechaHora;
    }
    //Informacion de la venta
    public String toString() {
        return "Codigo: " + codProducto +
               " | Producto: " + nomProducto +
               " | Cantidad: " + cant +
               " | Total: Q" + totalVenta +
               " | Fecha: " + fechaHora;
    }
}
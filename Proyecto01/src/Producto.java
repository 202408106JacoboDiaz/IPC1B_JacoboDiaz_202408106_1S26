
public class Producto {
    
    //Atributos Principales
    private String cod;
    private String nom;
    private String cat;
    private double presio;
    private int stk;
    //Constructor
    public Producto(String codigo, String nombre, String categoria, double precio, int stock) {
        this.cod = codigo;
        this.nom = nombre;
        this.cat = categoria;
        this.presio = precio;
        this.stk = stock;
    }
    //Getter Codigo
    public String getCodigo() {
        return cod;
    }
    //Getter Nombre
    public String getNombre() {
        return nom;
    }
    //Getter Categoria
    public String getCategoria() {
        return cat;
    }
    //Getter Precio
    public double getPrecio() {
        return presio;
    }
    //Getter Stock
    public int getStock() {
        return stk;
    }
    //Setter Precio
    public void setPrecio(double precio) {
        this.presio = precio;
    }
    //Setter Stock
    public void setStock(int stock) {
        this.stk = stock;
    }
    //Informacion del producto
    public String toString() {
        return "Codigo: " + cod + 
               " | Nombre: " + nom + 
               " | Categoria: " + cat + 
               " | Precio: Q" + presio + 
               " | Stock: " + stk;
    }
}
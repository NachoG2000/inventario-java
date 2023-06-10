public class Producto {
    private String nombre;
    private int precio;
    private int cantidad;
    private int indice;

    public Producto(String nombre, int precio, int cantidad){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }
    public int getPrecio(){
        return precio;
    }

    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }

    public int getIndice(){
        return indice;
    }
    public void setIndice(int indice){
        this.indice=indice;
    }
}

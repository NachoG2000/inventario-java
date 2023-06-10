import java.util.LinkedList;
import java.util.List;

public class Tienda implements Inventario {
    private LinkedList<Producto> inventario;
    private static int indice;

    public Tienda(){
        inventario = new LinkedList<Producto>();
        indice = 0;
    }

    public void agregarProducto(Producto producto) {
        producto.setIndice(indice);
        inventario.add(producto);
        indice++;
        // System.out.println(indice);
    }

    public void removerProducto(Producto producto) {
        if(inventario.contains(producto)){
            inventario.remove(producto);
            indice--;
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : inventario){
            if(producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public List<Producto> obtenerTodosLosProductos() {
        return inventario;
    }

    public static int getIndice(){
        return indice;
    }
    
}

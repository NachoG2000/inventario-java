import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Producto producto1 = new Producto("Manzana", 10, 5);
        Producto producto2 = new Producto("B", 10, 5);
        Producto producto3 = new Producto("c", 10, 5);
        Producto producto4 = new Producto("d", 10, 5);
        Producto producto5 = new Producto("e", 10, 5);
        Producto producto6 = new Producto("f", 10, 5);
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        tienda.agregarProducto(producto4);
        tienda.agregarProducto(producto5);
        tienda.agregarProducto(producto6);

        List<Producto> lista = tienda.obtenerTodosLosProductos();

        Iterator<Producto> it = lista.iterator();

        while(it.hasNext()){
            Producto i = it.next();
            System.out.println("El elemento siguiente es: " + i.getNombre() + ". Y su indice es: " + i.getIndice());
        }
    }
}
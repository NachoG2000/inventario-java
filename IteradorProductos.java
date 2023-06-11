import java.util.LinkedList;
import java.util.ListIterator;

public class IteradorProductos {
    private LinkedList<Producto> listaProductos;
    private ListIterator<Producto> iterator;

    public IteradorProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        this.iterator = listaProductos.listIterator();
    }

    public Producto siguienteProducto() {
        return iterator.next();
    }

    public Producto anteriorProducto() {
        return iterator.previous();
    }

    public Producto obtenerProductoActual() {
        return iterator.next();
    }

    public boolean haySiguienteProducto() {
        return iterator.hasNext();
    }

    public boolean hayAnteriorProducto() {
        int currentIndex = listaProductos.indexOf(iterator.next());
        return currentIndex > 0;
    }

    public void restablecer() {
        iterator = listaProductos.listIterator();
    }
}

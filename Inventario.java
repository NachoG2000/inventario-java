import java.util.List;

public interface Inventario {
    
    void agregarProducto(Producto producto);

    void removerProducto(Producto producto);

    Producto buscarProducto(String nombre);

    List<Producto> obtenerTodosLosProductos();

}
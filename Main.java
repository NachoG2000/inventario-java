import java.util.LinkedList;

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

        tienda.removerProducto(tienda.buscarProducto("d"));
        LinkedList<Producto> lista = tienda.obtenerTodosLosProductos();

        imprimirElementosEnOrden(lista);

    }
    
    public static void imprimirElementosEnOrden(LinkedList<Producto> lista){
        IteradorProductos iteradorProductos = new IteradorProductos(lista);
        int i = 0;

        while(iteradorProductos.haySiguienteProducto()){
            i++;
            Producto producto = iteradorProductos.siguienteProducto();
        
            System.out.println(i + ". " + producto.getNombre());
        }
    }
}
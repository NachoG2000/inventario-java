import java.util.LinkedList;

public class Tienda implements Inventario {
    private LinkedList<Producto> inventario;

    public Tienda(){
        inventario = new LinkedList<Producto>();
    }

    public void agregarProducto(Producto producto) {
        if (inventario.isEmpty()) {
            inventario.add(producto);
        } else {
            int indice = 0;
            while (indice < inventario.size() && producto.getPrecio() > inventario.get(indice).getPrecio()) {
                indice++;
            }
            inventario.add(indice, producto);
        }
    }

    public void agregarProducto(Producto[] productos){
        for(Producto producto : productos){
            this.agregarProducto(producto);
        }
    }

    public void removerProducto(Producto producto) {
        if(inventario.contains(producto)){
            inventario.remove(producto);
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

    public LinkedList<Producto> obtenerTodosLosProductos() {
        return inventario;
    }
}
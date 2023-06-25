import java.util.LinkedList;

enum SortingOption {
    PRECIO,
    CANTIDAD,
    ALFABETICAMENTE
}

public class Tienda implements Inventario {
    private LinkedList<Producto> inventario;
    private SortingOption sortingOption;

    public Tienda(){
        inventario = new LinkedList<Producto>();
        sortingOption = SortingOption.PRECIO;
    }

    public void agregarProducto(Producto producto) {
        inventario.addLast(producto);
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

    public void setSortingOption(SortingOption option){
        this.sortingOption = option;
    }

    public SortingOption getSortingOption(){
        return sortingOption;
    }
}
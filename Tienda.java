import java.util.LinkedList;

public class Tienda implements Inventario {
    private LinkedList<Producto> inventario;
    private String currentOrder;

    public Tienda() {
        inventario = new LinkedList<Producto>();
        this.currentOrder = "priceDesc";
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

    public void agregarProducto(Producto[] productos) {
        for (Producto producto : productos) {
            this.agregarProducto(producto);
        }
    }

    public void removerProducto(Producto producto) {
        if (inventario.contains(producto)) {
            inventario.remove(producto);
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public void ordenarProductos() {
        switch (currentOrder) {
            case "nameDesc":
                // Implement sorting by name in descending order
                QuickSort sortByName = new QuickSort();
                sortByName.quickSortByName(inventario, 0, inventario.size() - 1);
                break;
            case "priceDesc":
                // Implement sorting by price in descending order
                QuickSort sortByPrice = new QuickSort();
                sortByPrice.quickSortByPrice(inventario, 0, inventario.size() - 1);
                break;
            default:
                // Invalid order, do nothing
                break;
        }
    }

    public LinkedList<Producto> obtenerTodosLosProductos() {
        return inventario;
    }

    public void setCurrentOrder(String order) {
        this.currentOrder = order;
    }

}

import java.util.LinkedList;

public class QuickSort {
    
    public QuickSort() {
    }

    public void quickSortByName(LinkedList<Producto> array, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionByName(array, low, high);
            quickSortByName(array, low, partitionIndex - 1);
            quickSortByName(array, partitionIndex + 1, high);
        }
    }

    public int partitionByName(LinkedList<Producto> array, int low, int high) {
        Producto pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j).getNombre().compareTo(pivot.getNombre()) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public void quickSortByPrice(LinkedList<Producto> array, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionByPrice(array, low, high);
            quickSortByPrice(array, low, partitionIndex - 1);
            quickSortByPrice(array, partitionIndex + 1, high);
        }
    }

    public int partitionByPrice(LinkedList<Producto> array, int low, int high) {
        Producto pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j).getPrecio() < pivot.getPrecio()) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public void quickSortByQuantity(LinkedList<Producto> array, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionByQuantity(array, low, high);
            quickSortByQuantity(array, low, partitionIndex - 1);
            quickSortByQuantity(array, partitionIndex + 1, high);
        }
    }

    public int partitionByQuantity(LinkedList<Producto> array, int low, int high) {
        Producto pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j).getCantidad() < pivot.getCantidad()) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(LinkedList<Producto> array, int i, int j) {
        Producto temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

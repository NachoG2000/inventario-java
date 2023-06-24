import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainGUI extends JFrame {
    private Tienda tienda;
    private JTextArea textArea;

    public MainGUI() {
        tienda = new Tienda();
        agregarProductosParaVisualizacion(tienda);

        LinkedList<Producto> lista = tienda.obtenerTodosLosProductos();

        setTitle("Inventario tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        String welcomeMessage = "¡Bienvenido a la Tienda!\n\n";
        String tutorialMessage = "Este programa te permite interactuar con una tienda y realizar las siguientes acciones:\n\n"
                + "- Agregar Producto: Permite agregar un nuevo producto a la tienda.\n"
                + "- Eliminar Producto: Permite eliminar un producto existente en la tienda.\n"
                + "- Buscar Producto: Permite buscar un producto por su nombre en la tienda.\n"
                + "- Imprimir de menor a mayor: Muestra los productos de la tienda en orden ascendente según su precio.\n"
                + "- Imprimir de mayor a menor: Muestra los productos de la tienda en orden descendente según su precio.\n\n"
                + "Para realizar una acción, simplemente haz clic en el botón correspondiente.\n";

        textArea.setText(welcomeMessage + tutorialMessage);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton agregarButton = new JButton("Agregar Producto");
        JButton eliminarButton = new JButton("Eliminar Producto");
        JButton buscarButton = new JButton("Buscar Producto");
        JButton ordenAscendenteButton = new JButton("Imprimir de menor a mayor");
        JButton ordenDescendenteButton = new JButton("Imprimir de mayor a menor");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(agregarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(buscarButton);
        buttonPanel.add(ordenAscendenteButton);
        buttonPanel.add(ordenDescendenteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        ordenAscendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarElementosEnOrden(lista);
            }
        });

        ordenDescendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarElementosAlReves(lista);
            }
        });

        pack();
        setVisible(true);
    }

public void agregarProducto() {
    JTextField nombreField = new JTextField(10);
    JTextField precioField = new JTextField(10);
    JTextField cantidadField = new JTextField(10);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));
    panel.add(new JLabel("Nombre del producto:"));
    panel.add(nombreField);
    panel.add(new JLabel("Precio del producto:"));
    panel.add(precioField);
    panel.add(new JLabel("Cantidad del producto:"));
    panel.add(cantidadField);

    int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Producto",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
        try {
            String nombre = nombreField.getText();
            int precio = Integer.parseInt(precioField.getText());
            int cantidad = Integer.parseInt(cantidadField.getText());

            // Validar errores
            if (nombre.isEmpty() || precio <= 0 || cantidad <= 0) {
                throw new IllegalArgumentException("Hubo un problema al agregar el producto. Por favor, verifica los valores ingresados y vuelve a intentarlo.");
            }

            // Verificar si el nombre del producto ya existe
            if (tienda.buscarProducto(nombre) != null) {
                throw new IllegalArgumentException("Error: Ya existe un producto con ese nombre.");
            }

            Producto producto = new Producto(nombre, precio, cantidad);
            tienda.agregarProducto(producto);

            actualizarTextArea();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al agregar el producto. Por favor, verifica los valores ingresados y vuelve a intentarlo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



    public void eliminarProducto() {
        String nombreProductoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del producto a eliminar:");

        Producto productoEliminar = tienda.buscarProducto(nombreProductoEliminar);
        if (productoEliminar != null) {
            tienda.removerProducto(productoEliminar);
            JOptionPane.showMessageDialog(null, "Producto eliminado: " + productoEliminar.getNombre());
            actualizarTextArea();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto a eliminar.");
        }
    }

    public void buscarProducto() {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar:");

        Producto productoEncontrado = tienda.buscarProducto(nombreProducto);
        if (productoEncontrado != null) {
            JOptionPane.showMessageDialog(null, "Producto encontrado:\n" +
                    "Nombre: " + productoEncontrado.getNombre() + "\n" +
                    "Precio: $" + productoEncontrado.getPrecio() + "\n" +
                    "Cantidad: " + productoEncontrado.getCantidad());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto.");
        }
    }

public void mostrarElementosEnOrden(LinkedList<Producto> lista) {
    StringBuilder sb = new StringBuilder();
    ListIterator<Producto> iteradorProductos = lista.listIterator();
    int i = 1;

    while (iteradorProductos.hasNext()) {
        Producto producto = iteradorProductos.next();
        sb.append(i).append(". ").append(producto.getNombre()).append(" - Precio: $")
                .append(producto.getPrecio()).append(" - Cantidad: ").append(producto.getCantidad()).append(" unidades\n");
        i++;
    }

    JOptionPane.showMessageDialog(null, sb.toString());
}

public void mostrarElementosAlReves(LinkedList<Producto> lista) {
    StringBuilder sb = new StringBuilder();
    ListIterator<Producto> iteradorProductos = lista.listIterator(lista.size());
    int i = 1;

    while (iteradorProductos.hasPrevious()) {
        Producto producto = iteradorProductos.previous();
        sb.append(i).append(". ").append(producto.getNombre()).append(" - Precio: $")
                .append(producto.getPrecio()).append(" - Cantidad: ").append(producto.getCantidad()).append(" unidades\n");
        i++;
    }

    JOptionPane.showMessageDialog(null, sb.toString());
}

    public void actualizarTextArea() {
        LinkedList<Producto> lista = tienda.obtenerTodosLosProductos();
        mostrarElementosEnOrden(lista);
    }

    public void agregarProductosParaVisualizacion(Tienda tienda) {
        Producto producto1 = new Producto("MANZANA", 10, 100);
        Producto producto2 = new Producto("PERA", 20, 100);
        Producto producto3 = new Producto("BANANA", 15, 100);
        Producto producto4 = new Producto("NARANJA", 30, 100);
        Producto producto5 = new Producto("UVA", 50, 100);
        Producto producto6 = new Producto("FRUTILLA", 5, 100);
        Producto[] arrayProductos = new Producto[]{producto1, producto2, producto3, producto4, producto5, producto6};
        tienda.agregarProducto(arrayProductos);
    }

}
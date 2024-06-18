package spotiFy.ClientesServ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteArchi {
    private List<Cliente> clientes;
    private final File archivoClientes;

    public ClienteArchi(String rutaArchivo) {
        this.archivoClientes = new File(rutaArchivo);
        this.clientes = new ArrayList<>();
        cargarClientesDesdeArchivo();
    }

    private void cargarClientesDesdeArchivo() {
        if (!archivoClientes.exists()) {
            try {
                archivoClientes.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cliente cliente = Cliente.fromString(linea);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarClientesEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoClientes))) {
            for (Cliente cliente : clientes) {
                bw.write(cliente.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarClientesEnArchivo();
    }

    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
        guardarClientesEnArchivo();
    }

    public void modificarCliente(Cliente clienteModificado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == clienteModificado.getId()) {
                cliente.setNombre(clienteModificado.getNombre());
                cliente.setCorreo(clienteModificado.getCorreo());
                cliente.setContrasena(clienteModificado.getContrasena());
               
            }
        }
        guardarClientesEnArchivo();
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }

    public Cliente obtenerClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}

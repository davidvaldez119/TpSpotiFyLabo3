package spotiFy.ClientesServ;

import java.util.List;

public class ClienteService {
    private ClienteArchi clienteArchi;

    public ClienteService(ClienteArchi clienteArchi) {
        this.clienteArchi = clienteArchi;
    }

    public void registrarCliente(Cliente cliente) {
        clienteArchi.agregarCliente(cliente);
    }

    public void borrarCliente(int id) {
        clienteArchi.eliminarCliente(id);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteArchi.modificarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteArchi.obtenerTodosLosClientes();
    }

    public Cliente obtenerCliente(int id) {
        return clienteArchi.obtenerClientePorId(id);
    }
}

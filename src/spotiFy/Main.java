package spotiFy;
import spotiFy.ClientesServ.Cliente;
import spotiFy.ClientesServ.ClienteArchi;
import spotiFy.ClientesServ.ClienteService;

public class Main {
    public static void main(String[] args) {
        String archivoClientes = "clientes.txt";
        ClienteArchi clienteArchi = new ClienteArchi(archivoClientes);
        ClienteService clienteService = new ClienteService(clienteArchi);

        Cliente cliente1 = new Cliente(1, "Juan Perez", "juan@example.com", "password123");
        Cliente cliente2 = new Cliente(2, "Maria Lopez", "maria@example.com", "password456");

        // Registrar clientes
        clienteService.registrarCliente(cliente1);
        clienteService.registrarCliente(cliente2);

        // Listar clientes
        for (Cliente cliente : clienteService.listarClientes()) {
            System.out.println(cliente.getNombre());
        }

        // Modificar cliente
        cliente1.setNombre("Juan Carlos Perez");
        clienteService.actualizarCliente(cliente1);

        // Eliminar cliente
        clienteService.borrarCliente(2);

        // Listar clientes nuevamente
        for (Cliente cliente : clienteService.listarClientes()) {
            System.out.println(cliente.getNombre());
        }
    }
}

package spotiFy.ClientesServ;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;

    public Cliente(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    @Override
    public String toString() {
        return id + "," + nombre + "," + correo + "," + contrasena;
    }

    public static Cliente fromString(String data) {
        String[] fields = data.split(",");
        return new Cliente(
                Integer.parseInt(fields[0]),
                fields[1],
                fields[2],
                fields[3]
        			);
    }



}

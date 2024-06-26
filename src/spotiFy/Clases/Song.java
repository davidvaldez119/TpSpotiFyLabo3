package spotiFy.Clases;


public class Song  {
private String nombreCancion;
private String duracion; //HH:MM:SS
private String genero;
private String artistaCancion;
private Integer year;

private String URL;

    public Song() {
    }

    public Song(String nombreCancion, String duracion, String genero, String artistaCancion, Integer year, String URL) {
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
        this.genero = genero;
        this.artistaCancion = artistaCancion;
        this.year = year;
        this.URL = URL;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtistaCancion() {
        return artistaCancion;
    }

    public void setArtistaCancion(String artistaCancion) {
        this.artistaCancion = artistaCancion;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {

        return String.format("%s - %s\nGenero: %s\nDuration: (%s) %s\nLink:%s",
                nombreCancion, artistaCancion, genero, duracion, year,URL);

    }
}

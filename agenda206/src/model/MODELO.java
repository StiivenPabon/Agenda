package modelo;

public class MODELO {

    private int ID;
    private String Titulo = "";
    private String Nota = "";
    private String Hora = "";
    private int Evento;
    private String TipoNota = "";
    private String Visibilidad = "";
    private String Estado = "";
    private String Fecha_Registro = "";
    private String Fecha_Modificacion = "";

    public MODELO(int ID, String Titulo, String Nota, String Hora, int Evento, String Tipo_Nota, String Visibilidad, String Estado, String Fecha_Registro, String Fecha_Modificacion) {
        this.ID = ID;
        this.Titulo = Titulo;
        this.Nota = Nota;
        this.Hora = Hora;
        this.Evento = Evento;
        this.TipoNota = Tipo_Nota;
        this.Visibilidad = Visibilidad;
        this.Estado = Estado;
        this.Fecha_Registro = Fecha_Registro;
        this.Fecha_Modificacion = Fecha_Modificacion;

    }

    public MODELO() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public int getEvento() {
        return Evento;
    }

    public void setEvento(int Evento) {
        this.Evento = Evento;
    }

    public String getTipoNota() {
        return TipoNota;
    }

    public void setTipoNota(String TipoNota) {
        this.TipoNota = TipoNota;
    }

    public String getVisibilidad() {
        return Visibilidad;
    }

    public void setVisibilidad(String Visibilidad) {
        this.Visibilidad = Visibilidad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(String Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }

    public String getFecha_Modificacion() {
        return Fecha_Modificacion;
    }

    public void setFecha_Modificacion(String Fecha_Modificacion) {
        this.Fecha_Modificacion = Fecha_Modificacion;
    }
}

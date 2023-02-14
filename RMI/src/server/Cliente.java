package server;

public class Cliente {

    String usuario = "";
    String contraseña = "";
    int montoDisponible = 0;

    public Cliente(String usuario, String contraseña, int montoDisponible) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.montoDisponible = montoDisponible;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(int montoDisponible) {
        this.montoDisponible = montoDisponible;
    }
}

package modelo;

public class Login {
    private String rut;
    private String pass;
    private String nombre;
    private String tipouser;
    
    public Login() {
    }

    public Login(String rut, String pass, String nombre, String tipouser) {
        this.rut = rut;
        this.pass = pass;
        this.nombre=nombre;
        this.tipouser=tipouser;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

}



 




    


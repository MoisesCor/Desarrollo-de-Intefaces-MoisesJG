package datos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Citas {
	
	private final SimpleStringProperty nombre;
	private final SimpleStringProperty apellidos;
	private final SimpleIntegerProperty edad;
	private final SimpleStringProperty email;
	private final SimpleIntegerProperty telefono;
	private final SimpleStringProperty sexo;
	private final SimpleStringProperty box;
	private final SimpleStringProperty observaciones;
	private final SimpleStringProperty fecha;
	
	





	public Citas(SimpleStringProperty nombre, SimpleStringProperty apellidos, SimpleIntegerProperty edad,
			SimpleStringProperty email, SimpleIntegerProperty telefono, SimpleStringProperty sexo,
			SimpleStringProperty box, SimpleStringProperty observaciones, SimpleStringProperty fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
		this.telefono = telefono;
		this.sexo = sexo;
		this.box = box;
		this.observaciones = observaciones;
		this.fecha = fecha;
	}

	public String getNombre() {
        return nombre.get();
    }
    
    public void setNombre(String fnombre) {
        nombre.set(fnombre);
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public void setEmail(String femail) {
        email.set(femail);
    }
	
    public String getApellidos() {
        return apellidos.get();
    }
    
    public void setApellidos(String fapellidos) {
        apellidos.set(fapellidos);
    }
    
    public String getBox() {
        return box.get();
    }
    
    public void setBox(String fbox) {
        box.set(fbox);
    }
    
    public String getSexo() {
        return sexo.get();
    }
    
    public void setSexo(String fsexo) {
       sexo.set(fsexo);
    }
    
    public String getObservaciones() {
        return observaciones.get();
    }
    
    public void setObservaciones(String fobservaciones) {
        observaciones.set(fobservaciones);
    }
    
    public String getFecha() {
        return fecha.get();
    }
    
    public void setFecha(String ffecha) {
       fecha.set(ffecha);
    }
    
	public Integer getEdad() {
		return edad.get();
	}
	public void setEdad(Integer fedad) {
		edad.set(fedad);
    }   
	
	public Integer getTelefono() {
		return telefono.get();
	}
	public void setAge(Integer ftelefono) {
		telefono.set(ftelefono);
    }   
    
    
	
	
}

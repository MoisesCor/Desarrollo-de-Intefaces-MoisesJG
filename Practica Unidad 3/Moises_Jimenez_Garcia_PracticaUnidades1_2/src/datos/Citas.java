package datos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Citas {
	
	private SimpleStringProperty nombre;
	private SimpleStringProperty apellidos;
	private SimpleIntegerProperty edad;
	private SimpleStringProperty email;
	private SimpleIntegerProperty telefono;
	private SimpleStringProperty sexo;
	private SimpleStringProperty box;
	private SimpleStringProperty observaciones;
	private SimpleStringProperty fecha;
	private SimpleStringProperty DNI;
	
	



	public Citas() {

	}

	public Citas(String nombre, String apellidos, int edad,
			String email, int telefono, String sexo,
			String box, String observaciones, String fecha,String DNI) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.apellidos = new SimpleStringProperty(apellidos);
		this.edad = new SimpleIntegerProperty(edad);
		this.email = new SimpleStringProperty(email);
		this.telefono = new SimpleIntegerProperty(telefono);
		this.sexo = new SimpleStringProperty(sexo);
		this.box =new SimpleStringProperty(box);
		this.observaciones = new SimpleStringProperty(observaciones);;
		this.fecha = new SimpleStringProperty(fecha);
		this.DNI = new SimpleStringProperty(DNI);
	}
	

	
	




	public void setNombre(SimpleStringProperty nombre) {
		this.nombre = nombre;
	}




	public void setApellidos(SimpleStringProperty apellidos) {
		this.apellidos = apellidos;
	}




	public void setEdad(SimpleIntegerProperty edad) {
		this.edad = edad;
	}




	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}




	public void setTelefono(SimpleIntegerProperty telefono) {
		this.telefono = telefono;
	}




	public void setSexo(SimpleStringProperty sexo) {
		this.sexo = sexo;
	}




	public void setDNI(SimpleStringProperty dNI) {
		DNI = dNI;
	}

	public void setBox(SimpleStringProperty box) {
		this.box = box;
	}




	public void setObservaciones(SimpleStringProperty observaciones) {
		this.observaciones = observaciones;
	}




	public void setFecha(SimpleStringProperty fecha) {
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
    
    public String getDNI() {
        return DNI.get();
    }
    
    public void setDNI(String DDNI) {
       fecha.set(DDNI);
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
	public void setTelefono(Integer ftelefono) {
		telefono.set(ftelefono);
    }   
    
    
	
	
}

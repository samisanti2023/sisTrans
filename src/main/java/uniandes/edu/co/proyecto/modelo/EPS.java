package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="eps")
public class EPS {
    @Id
    private String id;
    
    private String nombre;
    
    public EPS() {;}
    
    public EPS(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return this.id + "|" + this.nombre;
    }
}


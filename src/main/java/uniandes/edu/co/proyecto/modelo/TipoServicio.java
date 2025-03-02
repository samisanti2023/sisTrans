package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tiposervicio")
public class TipoServicio {
    @Id
   
    private Long id;
    
    private String nombre;
    
    public TipoServicio() {;}
    
    public TipoServicio(Long id,String nombre) {
        this.id=id;
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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

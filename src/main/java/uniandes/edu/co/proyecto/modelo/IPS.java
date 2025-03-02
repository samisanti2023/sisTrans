package uniandes.edu.co.proyecto.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="ips")
public class IPS {
    @Id
    private String nit;
    
    private String nombre;
    
    private String direccion;
    
    private Long telefono;
    
    @ManyToOne
    @JoinColumn(name = "id_eps", nullable = false)
    private EPS eps;
    
    public IPS() {;}
    
    public IPS(String nit, String nombre, String direccion, Long telefono, EPS eps) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.eps = eps;
    }
    
    public String getNit() {
        return nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Long getTelefono() {
        return telefono;
    }
    
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
    public EPS getEps() {
        return eps;
    }
    
    public void setEps(EPS eps) {
        this.eps = eps;
    }
    
    @Override
    public String toString() {
        return this.nit + "|" + this.nombre + "|" + this.direccion + "|" + this.telefono + "|" + this.eps.getId();
    }
}


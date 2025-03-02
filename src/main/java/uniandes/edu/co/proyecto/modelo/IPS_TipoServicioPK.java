package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Embeddable
public class IPS_TipoServicioPK implements Serializable {
    private String id_ips; // Solo almacena el NIT de la IPS
    private Long id_servicio; // Solo almacena el ID del servicio

    public IPS_TipoServicioPK() {}

    public IPS_TipoServicioPK(String id_ips, Long id_servicio) {
        this.id_ips = id_ips;
        this.id_servicio = id_servicio;
    }

    // Getters y setters
    public String getId_ips() {
        return id_ips;
    }

    public void setId_ips(String id_ips) {
        this.id_ips = id_ips;
    }

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }
}
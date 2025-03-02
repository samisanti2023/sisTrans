package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ips_tiposervicio")
public class IPS_TipoServicio {

    @EmbeddedId
    private IPS_TipoServicioPK pk;

    @ManyToOne
    @JoinColumn(name = "id_ips", referencedColumnName = "nit", insertable = false, updatable = false)
    private IPS ips;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id", insertable = false, updatable = false)
    private TipoServicio tipoServicio;

    public IPS_TipoServicio() { }

    public IPS_TipoServicio(String id_ips, Long id_servicio) {
        this.pk = new IPS_TipoServicioPK(id_ips, id_servicio);
    }

    // Getters y setters
    public IPS_TipoServicioPK getPk() {
        return pk;
    }

    public void setPk(IPS_TipoServicioPK pk) {
        this.pk = pk;
    }

    public IPS getIps() {
        return ips;
    }

    public void setIps(IPS ips) {
        this.ips = ips;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}


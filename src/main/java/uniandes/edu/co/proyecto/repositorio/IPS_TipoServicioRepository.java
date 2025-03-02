package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.IPS_TipoServicio;
import uniandes.edu.co.proyecto.modelo.IPS_TipoServicioPK;

public interface IPS_TipoServicioRepository extends JpaRepository<IPS_TipoServicio, IPS_TipoServicioPK> {
    // JpaRepository ya proporciona el método save(IPS_TipoServicio ipsTipoServicio) para insertar o actualizar registros.
}


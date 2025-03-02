package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {
    // JpaRepository ya proporciona el método save(TipoServicio tipoServicio) para insertar o actualizar registros.
}


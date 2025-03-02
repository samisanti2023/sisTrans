package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.IPS;

public interface IPSRepository extends JpaRepository<IPS, String> {

    @Query(value = "SELECT * FROM ips", nativeQuery = true)
    Collection<IPS> obtenerTodasLasIPS();
}


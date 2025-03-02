package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.TipoServicio;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;

@RestController
public class TipoServicioController {

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @PostMapping("/tiposervicio/new/save")
    public ResponseEntity<String> crearTipoServicio(@RequestBody TipoServicio tipoServicio) {
        try {
            tipoServicioRepository.save(tipoServicio);
            return new ResponseEntity<>("Tipo de servicio creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el tipo de servicio"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


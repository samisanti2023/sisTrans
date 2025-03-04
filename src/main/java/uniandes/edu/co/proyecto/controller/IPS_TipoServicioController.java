package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IPS_TipoServicio;
import uniandes.edu.co.proyecto.modelo.IPS_TipoServicioPK;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;
import uniandes.edu.co.proyecto.repositorio.TipoServicioRepository;
import uniandes.edu.co.proyecto.repositorio.IPS_TipoServicioRepository;

@RestController
@RequestMapping("/ips-tipo-servicio")
public class IPS_TipoServicioController {

    @Autowired
    private IPS_TipoServicioRepository ipsTipoServicioRepository;

    @Autowired
    private IPSRepository ipsRepository;

    @Autowired
    private TipoServicioRepository tipoServicioRepository;

    @PostMapping("/new")
    public ResponseEntity<String> crearIPSTipoServicio(@RequestParam String ipsId, 
                                                       @RequestParam Long tipoServicioId) {
        try {
            // Validar que existan en la BD
            if (!ipsRepository.existsById(ipsId) || !tipoServicioRepository.existsById(tipoServicioId)) {
                return new ResponseEntity<>("IPS o TipoServicio no encontrados", HttpStatus.NOT_FOUND);
            }
    
            // Crear la clave primaria solo con los IDs
            IPS_TipoServicioPK pk = new IPS_TipoServicioPK(ipsId, tipoServicioId);
    
            // Crear la nueva relación
            IPS_TipoServicio nuevaRelacion = new IPS_TipoServicio();
            nuevaRelacion.setPk(pk);
    
            ipsTipoServicioRepository.save(nuevaRelacion);
    
            return new ResponseEntity<>("IPS_TipoServicio creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la relación"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
                                                       }}
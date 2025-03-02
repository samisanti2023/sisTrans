package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

@RestController
@RequestMapping("/ips")
public class IPSController {

    @Autowired
    private IPSRepository ipsRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> guardarIPS(@RequestBody IPS ips) {
        try {
            ipsRepository.save(ips);
            return new ResponseEntity<>("IPS creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la IPS"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

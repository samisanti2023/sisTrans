package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.modelo.IPS;
import uniandes.edu.co.proyecto.repositorio.IPSRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{
	@Autowired
	private IPSRepository ipsRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
	@Override
	public void run (String...arg){
		Collection<IPS> ips=ipsRepo.obtenerTodasLasIPS();

		for (IPS i:ips){System.out.println(i);}
	}

}

package br.dev.tsantana.ftclient.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.dev.tsantana.ftclient.domain.Client;
import br.dev.tsantana.ftclient.dto.ClientFullDTO;
import br.dev.tsantana.ftclient.dto.ClientInsertDTO;
import br.dev.tsantana.ftclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	private static Logger logger = LoggerFactory.getLogger(ClientResource.class);
	
	@Autowired
	private ClientService service;
	
	
	@GetMapping(value = "/status")
	public String status() {
		logger.info("Obtendo status do microsserviço de clientes");
		return "Ok";
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ClientFullDTO> findById(@PathVariable Long id){
		ClientFullDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(params = "cpf")
	public ResponseEntity findById(@RequestParam("cpf") String cpf){
		Optional<Client> client = service.findByCpf(cpf);
		if(client.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(client);
	}
	
	@GetMapping
	public ResponseEntity<List<ClientFullDTO>> findAll(){
		List<ClientFullDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity insert(@RequestBody ClientInsertDTO dto) {
		Client client = dto.toEntity();
		service.save(client);
		URI headerLocation = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.query("cpf={cpf}")
				.buildAndExpand(client.getCpf())
				.toUri();
		return ResponseEntity.created(headerLocation).build();
	}
}

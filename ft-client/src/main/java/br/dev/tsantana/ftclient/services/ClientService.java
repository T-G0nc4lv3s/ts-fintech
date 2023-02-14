package br.dev.tsantana.ftclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.tsantana.ftclient.domain.Client;
import br.dev.tsantana.ftclient.dto.ClientFullDTO;
import br.dev.tsantana.ftclient.infra.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public ClientFullDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new RuntimeException("Entity not found"));
		return new ClientFullDTO(entity);
	}
	
	public List<ClientFullDTO> findAll(){
		List<Client> clients = repository.findAll();
		List<ClientFullDTO> result = clients.stream().map(x -> new ClientFullDTO(x)).collect(Collectors.toList());
		return result;
	}
	
	public Optional<Client> findByCpf(String cpf) {
		Optional<Client> obj = repository.findByCpf(cpf);
		return obj;
	}

	@Transactional
	public Client save(Client client) {
		Client response = repository.save(client);
		return response;
	}
	
}

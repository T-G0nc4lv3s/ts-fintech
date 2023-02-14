package br.dev.tsantana.ftclient.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.dev.tsantana.ftclient.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("SELECT obj FROM Client obj WHERE "
			+ "obj.cpf = :cpf")
	Optional<Client> findByCpf(String cpf);

}

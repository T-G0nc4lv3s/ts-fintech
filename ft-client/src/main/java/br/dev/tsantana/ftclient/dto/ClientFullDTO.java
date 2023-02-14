package br.dev.tsantana.ftclient.dto;

import br.dev.tsantana.ftclient.domain.Client;

public class ClientFullDTO {
	
	private Long id;
	private String cpf;
	private String name;
	private Integer age;
	
	public ClientFullDTO() {}
	
	public ClientFullDTO(Long id, String cpf, String name, Integer age) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.age = age;
	}
	
	public ClientFullDTO(Client entity) {
		this.id = entity.getId();
		this.cpf = entity.getCpf();
		this.name = entity.getName();
		this.age = entity.getAge();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Client toEntity() {
		return new Client(id, cpf, name, age);
	}
}

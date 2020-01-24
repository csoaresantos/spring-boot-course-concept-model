package com.charlessantos.cardeal.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.charlessantos.cardeal.domain.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=32)
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="E-mail inválido!")
	private String email;
	private String cpfOrCnpj;

	public ClientDTO() {}

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.email = client.getEmail();
		this.cpfOrCnpj = client.getCpfOrCnpj();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}
}

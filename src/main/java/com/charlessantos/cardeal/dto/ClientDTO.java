package com.charlessantos.cardeal.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.services.validation.ClientInsert;

@ClientInsert
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
	private Integer typeClient;
	private String phone;

	private String publicPlace;
	private String number;
	private String complement;
	private String neighborhood;
	private String zipCode;
	private Integer cidadeId;

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

	public Integer getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(Integer typeClient) {
		this.typeClient = typeClient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}


}

package com.charlessantos.cardeal.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlessantos.cardeal.domain.Client;
import com.charlessantos.cardeal.domain.enums.TypeClient;
import com.charlessantos.cardeal.dto.ClientDTO;
import com.charlessantos.cardeal.repositories.ClientRepository;
import com.charlessantos.cardeal.resources.exception.FieldMessage;
import com.charlessantos.cardeal.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientDTO> {
	@Autowired
	ClientRepository clientRepo;

	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTypeClient().equals(TypeClient.LEGALPERSON.getCode()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "CPF inválido!"));
		}

		if (objDto.getTypeClient().equals(TypeClient.PHYSICALPERSON.getCode())
				&& !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
			list.add(new FieldMessage("cpfOrCnpj", "CPF inválido!"));
		}

		Client client = clientRepo.findByEmail(objDto.getEmail());

		if(client != null) {
			list.add(new FieldMessage("email", "Este e-mail já existe."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldDescription()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
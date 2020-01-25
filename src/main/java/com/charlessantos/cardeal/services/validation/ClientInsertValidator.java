package com.charlessantos.cardeal.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.charlessantos.cardeal.domain.enums.TypeClient;
import com.charlessantos.cardeal.dto.ClientDTO;
import com.charlessantos.cardeal.resources.exception.FieldMessage;
import com.charlessantos.cardeal.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientDTO> {
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

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getFieldDescription()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
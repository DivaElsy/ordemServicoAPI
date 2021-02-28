package com.br.ordemservico.ordemservico.controller.form;

import com.br.ordemservico.ordemservico.controller.dto.ResponsavelDTO;
import com.br.ordemservico.ordemservico.models.Ordem;
import com.br.ordemservico.ordemservico.models.Responsavel;

public class ResponsavelForm {
	
	public Responsavel converte(ResponsavelDTO r) {
		Responsavel responsavel = new Responsavel();
		responsavel.setId(r.getId());
		responsavel.setNome(r.getNome());
		
		return responsavel;
	}
}

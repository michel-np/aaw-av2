package com.newton.av2.aawav2.domain.entity;

import com.newton.av2.aawav2.api.MicroEmpresaDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MicroEmpresa {
	private Integer id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDateTime dataDeCadastro;
	
	public MicroEmpresa(MicroEmpresaDto m) {
		this.id = m.getId();
		this.nome = m.getNome();
		this.cnpj = m.getCnpj();
		this.email = m.getEmail();
		this.dataDeCadastro = m.getDataDeCadastro();
	}
}

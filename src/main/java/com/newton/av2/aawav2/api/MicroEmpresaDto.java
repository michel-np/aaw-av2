package com.newton.av2.aawav2.api;

import com.newton.av2.aawav2.domain.entity.MicroEmpresa;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MicroEmpresaDto {
	private Integer id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDateTime dataDeCadastro;
	
	public MicroEmpresaDto(MicroEmpresa microEmpresaDto) {
		this.id = microEmpresaDto.getId();
		this.nome = microEmpresaDto.getNome();
		this.cnpj = microEmpresaDto.getCnpj();
		this.email = microEmpresaDto.getEmail();
		this.dataDeCadastro = microEmpresaDto.getDataDeCadastro();
	}
}

package com.newton.av2.aawav2.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.newton.av2.aawav2.domain.entity.MicroEmpresa;
import com.newton.av2.aawav2.exception.NotFoundException;

@Service
public class MicroEmpresaService {
	
	private static int id=1;
	private Map<Integer, MicroEmpresa> microempresas = new HashMap<Integer, MicroEmpresa>();
	
	public MicroEmpresa create(MicroEmpresa m) {
		m.setId(id++);
		m.setDataDeCadastro(LocalDateTime.now());
		microempresas.put(id, m);
		return m;
	}
	public MicroEmpresa get(Integer id) {
		var microempresa = microempresas.get(id);
		
		if(microempresa == null) {
			throw new NotFoundException("Microempresa ID "+id+" nao encontrada.");
		}
		return microempresa;
	}
	
	public MicroEmpresa update(Integer id, MicroEmpresa m) {
		var existing = get(id);
		
		existing.setNome(m.getNome());
		existing.setCnpj(m.getCnpj());
		existing.setEmail(m.getEmail());
		existing.setDataDeCadastro(m.getDataDeCadastro());
		
		return existing;
		
	}
	
	public List<MicroEmpresa> getAll() {
		return new ArrayList<>(microempresas.values());
	}
	
	public void delete(Integer id) {
		get(id);
		microempresas.remove(id);
		
		
		
	}
	

}

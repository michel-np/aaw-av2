package com.newton.av2.aawav2.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.av2.aawav2.api.MicroEmpresaDto;
import com.newton.av2.aawav2.domain.entity.MicroEmpresa;
import com.newton.av2.aawav2.service.MicroEmpresaService;

@RestController
public class MicroEmpresaController {
	private final MicroEmpresaService microEmpresaService;
	
	public MicroEmpresaController(MicroEmpresaService microEmpresaService) {
		this.microEmpresaService = microEmpresaService;
	}

	@GetMapping("/microempresas/{id}")
	public MicroEmpresaDto getById(@PathVariable Integer id) {
		var microempresa = microEmpresaService.get(id);
		return new MicroEmpresaDto(microempresa);
	}
	
	@GetMapping("/microempresas")
	public List<MicroEmpresaDto> getAll() {
		var microempresas = microEmpresaService.getAll();
		var microEmpresasDto = new ArrayList<MicroEmpresaDto>();
		for (var microempresa: microempresas) {
			microEmpresasDto.add(new MicroEmpresaDto(microempresa));
		}
		return microEmpresasDto;
	}
	
	@PutMapping("/microempresas/{id}")
		public MicroEmpresaDto update(@PathVariable Integer id, @RequestBody MicroEmpresaDto m) {
			var microempresa = new MicroEmpresa(m);
			microempresa = microEmpresaService.update(id, microempresa);
			return new MicroEmpresaDto(microempresa);
		
	}
	
	@PostMapping("/microempresas")
	public MicroEmpresaDto create(@RequestBody MicroEmpresaDto m) {
		var microempresa = new MicroEmpresa(m);
		
		microempresa = microEmpresaService.create(microempresa);
		return new MicroEmpresaDto(microempresa);		
		
	}
	
	@DeleteMapping("/microempresas/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		microEmpresaService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
	


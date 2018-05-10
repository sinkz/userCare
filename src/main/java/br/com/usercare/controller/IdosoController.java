package br.com.usercare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.usercare.model.IdosoEntity;
import br.com.usercare.service.IdosoService;

@RestController
@RequestMapping("/idoso")
public class IdosoController {

	@Autowired
	private IdosoService idosoService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public IdosoEntity salvar(@RequestBody IdosoEntity idoso) {
		return idosoService.salvar(idoso);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public IdosoEntity alterar(@RequestBody IdosoEntity idoso) {
		return idosoService.alterar(idoso);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable("id") Long id) {
		idosoService.excluir(id);
	}

	@RequestMapping(value = "/idosos", method = RequestMethod.GET)
	public List<IdosoEntity> listar() {
		return idosoService.listar();
	}

	@RequestMapping(value = "/idoso/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public IdosoEntity pesquisaPorId(@PathVariable("id") Long id) {
		if(id == null)
			return null;
		
		return idosoService.pesquisaPorId(id);
	}
}

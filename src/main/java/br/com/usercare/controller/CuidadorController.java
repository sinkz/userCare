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

import br.com.usercare.model.CuidadorEntity;
import br.com.usercare.service.CuidadorService;

@RestController
@RequestMapping("/cuidador")
public class CuidadorController {

	@Autowired
	private CuidadorService cuidadorService;
	
	//POST SALVAR
	//PUT ALTERAR
	//DELETE REMOVER
	//GET LISTAR OU BUSCAR
	
	@RequestMapping(method = RequestMethod.POST) //localhost:8080/cuidador
	@ResponseStatus(HttpStatus.OK)
	public CuidadorEntity salvar(@RequestBody CuidadorEntity cuidador) { //Body é objeto
		//metodo para gerar token
		cuidador.setToken("novoTokenQueFoiGerado");
		return cuidadorService.salvar(cuidador);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public CuidadorEntity alterar(@RequestBody CuidadorEntity cuidador) { //Body é objeto
		return cuidadorService.alterar(cuidador);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) //localhost:8080/cuidador/1234
	@ResponseStatus(HttpStatus.OK)
	public void excluir(@PathVariable("id") String id) { //PathVariable é pra valor comum, strings, inteiros, long, double
		cuidadorService.excluir(id);//1234
	}

	@RequestMapping(value = "/cuidadores", method = RequestMethod.GET)//localhost:8080/cuidador/cuidadores
	public List<CuidadorEntity> listar() {
		return cuidadorService.listar();
	}

	@RequestMapping(value = "/cuidador/{id}", method = RequestMethod.GET)//localhost:8080/cuidador/cuidador/1234
	@ResponseStatus(HttpStatus.OK)
	public CuidadorEntity pesquisaPorId(@PathVariable("id") String id) {
		return cuidadorService.pesquisaPorId(id);
	}
	
	
}

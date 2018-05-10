package br.com.usercare.service;

import java.util.List;

import br.com.usercare.model.CuidadorEntity;


public interface CuidadorService {

	public CuidadorEntity pesquisaPorId(String id);
	public List<CuidadorEntity> listar();
	public CuidadorEntity salvar(CuidadorEntity cuidador);
	public CuidadorEntity alterar(CuidadorEntity cuidador);
	public void excluir(String id);
	
}

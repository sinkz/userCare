package br.com.usercare.service;

import java.util.List;

import br.com.usercare.model.IdosoEntity;

public interface IdosoService {

	public IdosoEntity pesquisaPorId(Long id);
	public List<IdosoEntity> listar();
	public IdosoEntity salvar(IdosoEntity idoso);
	public IdosoEntity alterar(IdosoEntity idoso);
	public void excluir(Long id);
}

package br.com.usercare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usercare.model.IdosoEntity;
import br.com.usercare.repository.IdosoRepository;
import br.com.usercare.service.IdosoService;

@Service("idosoService")
public class IdosoServiceImpl implements IdosoService {

	@Autowired
	IdosoRepository idosoRepository;

	@Override
	public IdosoEntity pesquisaPorId(Long id) {
		return idosoRepository.findByCodigo(id);
	}

	@Override
	public List<IdosoEntity> listar() {
		return idosoRepository.findAll();
	}

	@Override
	public IdosoEntity salvar(IdosoEntity idoso) {
		return idosoRepository.save(idoso);
	}

	@Override
	public IdosoEntity alterar(IdosoEntity idoso) {
		if (idoso == null)
			return null;

		IdosoEntity idosoEntityUpdate = idosoRepository.findByCodigo(idoso.getCodigo());
		if (idosoEntityUpdate != null) {
			return updateCuidador(idoso, idosoEntityUpdate);
		}
		return null;
	}

	@Override
	public void excluir(Long id) {
		IdosoEntity cuidador = idosoRepository.findByCodigo(id);
		if (id != null)
			idosoRepository.delete(cuidador);
	}

	private IdosoEntity updateCuidador(IdosoEntity idoso, IdosoEntity idosoEntityUpdate) {
		idosoEntityUpdate.setNome(idoso.getNome());
		idosoEntityUpdate.setNumCelular(idoso.getNumCelular());
		idosoEntityUpdate.setCuidador(idoso.getCuidador());
		return idosoRepository.save(idosoEntityUpdate);
	}

}

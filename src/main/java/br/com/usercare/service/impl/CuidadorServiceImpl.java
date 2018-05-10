package br.com.usercare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usercare.model.CuidadorEntity;
import br.com.usercare.repository.CuidadorRepository;
import br.com.usercare.service.CuidadorService;

@Service("cuidadorService")
public class CuidadorServiceImpl implements CuidadorService {

	@Autowired
	CuidadorRepository cuidadorRepository;
	
	@Override
	public CuidadorEntity pesquisaPorId(String id) {
		return cuidadorRepository.findOne(id);
	}

	@Override
	public List<CuidadorEntity> listar() {
		return cuidadorRepository.findAll();
	}

	@Override
	public CuidadorEntity salvar(CuidadorEntity cuidador) {
		return cuidadorRepository.save(cuidador);
	}

	@Override
	public CuidadorEntity alterar(CuidadorEntity cuidador) { //123 crislayne
		CuidadorEntity cuidadorEntityUpdate = cuidadorRepository.getOne(cuidador.getToken()); //Diego
		if(cuidadorEntityUpdate != null) {
			return updateCuidador(cuidador, cuidadorEntityUpdate);
		}
		return null;
	}

	@Override
	public void excluir(String id) {
		CuidadorEntity cuidador = cuidadorRepository.getOne(id);
		if(id != null)
			cuidadorRepository.delete(cuidador);
	}
	
	private CuidadorEntity updateCuidador(CuidadorEntity cuidador, CuidadorEntity cuidadorEntityUpdate) {
		cuidadorEntityUpdate.setNome(cuidador.getNome());
		cuidadorEntityUpdate.setNumCelular(cuidador.getNumCelular());
		return cuidadorRepository.save(cuidadorEntityUpdate);
	}

}

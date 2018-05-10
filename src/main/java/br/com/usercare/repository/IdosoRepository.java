package br.com.usercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usercare.model.IdosoEntity;

@Repository("idosoRepository")
public interface IdosoRepository extends JpaRepository<IdosoEntity, String> {
	
	public IdosoEntity findByCodigo(Long codigo);
	
	//Fazer pesquisas pelos atributos da classe, seguir esse padrão
	//public IdosoEntity findByNumCelular(String numCelular);

}

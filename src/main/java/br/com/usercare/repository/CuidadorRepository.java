package br.com.usercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usercare.model.CuidadorEntity;

@Repository("cuidadorRepository")
public interface CuidadorRepository extends JpaRepository<CuidadorEntity, String> {

}

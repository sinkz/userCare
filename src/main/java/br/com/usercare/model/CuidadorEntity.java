package br.com.usercare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuidador")
public class CuidadorEntity {
	
	public CuidadorEntity() {
	}

	public CuidadorEntity(String token, String nome, String numCelular) {
		super();
		this.token = token;
		this.nome = nome;
		this.numCelular = numCelular;
	}
	
	@Id
	@Column(name="token")
	private String token;

	@Column(name="nome")	
	private String  nome;

	@Column(name="numCelular")
	private String numCelular;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}//Fim da classe

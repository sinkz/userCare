package br.com.usercare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "idoso")
public class IdosoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "numCelular")
	private String numCelular;

	// @Column(name="token")
	// private String token;

	@OneToOne
	@JoinColumn(name = "token")
	private CuidadorEntity cuidador;
	
	
	public IdosoEntity() {
	}

	public IdosoEntity(String nome, String numCelular, CuidadorEntity cuidador) {
		super();
		this.nome = nome;
		this.numCelular = numCelular;
		this.cuidador = cuidador;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public CuidadorEntity getCuidador() {
		return cuidador;
	}

	public void setCuidador(CuidadorEntity cuidador) {
		this.cuidador = cuidador;
	}

	// public String getToken() {
	// return token;
	// }
	//
	// public void setToken(String token) {
	// this.token = token;
	// }

}

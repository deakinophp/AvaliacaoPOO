package br.edu.ifpi.poo.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Professor.buscarTodos", query="select a from Professor p"),
	@NamedQuery(name="Professor.buscarPorId", query="select a from Professor where p.id := id")
})
public class Professor {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String fone;

	public Professor(Long id, String nome, String cpf, String endereco,
			String fone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.fone = fone;
	}

	public Professor(String nome, String cpf, String endereco, String fone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.fone = fone;
	}

	public Professor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;

	}

	public String getFone() {
		return fone;
	}

	public void setFone(String string) {
		this.fone = fone;

	}

	public boolean verificarNome() {
		String regex = "[a-z]*";
		return this.nome.toLowerCase().matches(regex);
	}

	public boolean validarFone() {
		String g = "\\d{4}-\\d{4}";
		return this.fone.toLowerCase().matches(g);
	}

	public Professor(String nome) {
		super();
		if (nome == null || (nome.isEmpty())) {
			throw new IllegalArgumentException("Fran");
		}
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				+ ", endereco=" + endereco + ", fone=" + fone + "]";
	}

}

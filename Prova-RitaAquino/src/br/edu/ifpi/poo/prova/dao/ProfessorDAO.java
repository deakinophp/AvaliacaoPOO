package br.edu.ifpi.poo.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.ifpi.poo.prova.model.Professor;

public class ProfessorDAO {
	private EntityManager em = Persistence.createEntityManagerFactory(
			"professor-jpa").createEntityManager();

	public void fechar() {
		em.close();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void iniciar() {
		em.getTransaction().begin();
	}

	public void salvar(Professor p) {
		em.persist(p);
	}

	public void apagar(Professor p) {
		em.remove(p);
	}

	public void atualizar(Professor p) {
		em.merge(p);
	}

	public Professor procurar(Long id) {
		return em.find(Professor.class, id);
	}

	public List<Professor> listarTodos() {
		Query query = em.createNamedQuery("Professor.buscarTodos");
		return query.getResultList();
	}

	public Professor procurarPorCpf(String cpf) {
		Query query = em.createNamedQuery("Professor.buscarPorCpf");
		query.setParameter("cpf", cpf);
		return (Professor) query.getSingleResult();
	}

}

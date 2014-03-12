package br.edu.ifpi.poo.prova.ui;

import java.util.List;

import br.edu.ifpi.poo.prova.dao.ProfessorDAO;
import br.edu.ifpi.poo.prova.model.Professor;

public class Principal {


	public static void main(String[] args) {
		ProfessorDAO pdao = new ProfessorDAO();
		Professor p;
		
		pdao.iniciar();
		p = new Professor("Paulo", "123.455.678-97","Rua A","3323-4567");
		pdao.salvar(p);
		p = new Professor("Rita", "163.495.778-90","Rua B","9956-4567");
		pdao.salvar(p);
		pdao.commit();
		
		List<Professor> l = pdao.listarTodos();
		for (Professor professor : l) {
			System.out.println(professor);
		}
		
		p = pdao.procurar(10L);
		p.setCpf("124.567.891-89");
		pdao.atualizar(p);
		System.out.println(p);	
	}
}

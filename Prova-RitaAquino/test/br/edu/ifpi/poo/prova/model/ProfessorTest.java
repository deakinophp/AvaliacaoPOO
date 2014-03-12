package br.edu.ifpi.poo.prova.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProfessorTest {
	private static Professor p;

	@Test(expected = IllegalArgumentException.class)
	public void testNomeNulo(){
		Professor p = new Professor("");
		p  = new Professor(null);
	} 
	
	@Test
	public void verificarNome() {
		Professor p = new Professor("Rita");
		p.setNome("Diego");
		Assert.assertTrue(p.verificarNome());
	}

	public void validarFone() {
		p.setFone("9985-2356");
		Assert.assertFalse(p.validarFone());
	}

}

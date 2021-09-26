package br.ce.workspace.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.workspace.core.BaseTest;
import br.ce.workspace.core.Propriedades;
import br.ce.workspace.pages.TestRegistroPage;

public class TestRegistro extends BaseTest {
	
	private TestRegistroPage page = new TestRegistroPage();
	
	@Test
	public void registroSucesso() {
		page.botaoLogar();
		page.setEmail(Propriedades.EMAIL_ALEATORIO); //email  aleatorio
		page.botaoCriarConta();
		
		page.setPrimeiroNome("Sidney");
		page.setUltimoNome("Silva");
		page.setSenha("12345");
		page.setDataNascimento("5", "7", "2000");
		page.setEndereco("Rua aleatoria perto de algum lugar");
		page.setCidade("Jampa");
		page.setEstado("Florida");
		page.setZipCode("32004");
		page.setTelefone("983987654");
		page.registar();
		
		Assert.assertEquals("MY ACCOUNT", page.validacaoRegistro());
	}
	
	@Test
	public void emailInvalido() {
		page.botaoLogar();
		page.setEmail("email_invalido");
		page.botaoCriarConta();
		
		Assert.assertEquals("Invalid email address.", page.mensagemError());
	}
	
	@Test
	public void camposObrigatorios() {
		page.botaoLogar();
		page.setEmail("emailValido@yopmail.com");
		page.botaoCriarConta();
		page.registar();
		
		List<String> erros = page.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"You must register at least one phone number.",
				"lastname is required.",
				"firstname is required.",
				"passwd is required.",
				"address1 is required.",
				"city is required.",
				"The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
				"This country requires you to choose a State.")));
		Assert.assertEquals(8, erros.size());
	}
	
	@Test
	public void camposObrigatoriosDadosErrados() {
		page.botaoLogar();
		page.setEmail("emailValido@yopmail.com");
		page.botaoCriarConta();
		
		page.setPrimeiroNome("123");
		page.setUltimoNome("456");
		page.setSenha("123");
		page.setDataNascimento("5", "7", "2000");
		page.setEndereco("123");
		page.setCidade("123");
		page.setEstado("Florida");
		page.setZipCode("ASD");
		page.setTelefone("ABCDEFGHI");
		page.registar();
		
		List<String> erros = page.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"lastname is invalid.",
				"firstname is invalid.",
				"passwd is invalid.",
				"phone_mobile is invalid.",
				"The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
		Assert.assertEquals(5, erros.size());
	}
}
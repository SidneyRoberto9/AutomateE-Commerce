package br.workspace.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.workspace.test.TestComprarProduto;
import br.workspace.test.TestProcurarProduto;
import br.workspace.test.TestRegistro;

@RunWith(Suite.class)
@SuiteClasses({
	TestRegistro.class,
	TestComprarProduto.class,
	TestProcurarProduto.class
	
})
public class SuitesTest {

}

package br.ce.workspace.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.workspace.tests.TestComprarProduto;
import br.ce.workspace.tests.TestProcurarProduto;
import br.ce.workspace.tests.TestRegistro;

@RunWith(Suite.class)
@SuiteClasses({
	TestRegistro.class,
	TestComprarProduto.class,
	TestProcurarProduto.class
	
})
public class SuitesTest {

}

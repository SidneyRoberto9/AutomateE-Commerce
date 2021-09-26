package br.ce.workspace.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
	
	public static String EMAIL_ALEATORIO = "Email" + System.nanoTime() + "@yopmail.com";
	
	public enum Browsers{
		CHROME,
		FIREFOX
	}
	
	public enum TipoExecucao{
		LOCAL,
		GRID
	}
	
}

package testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.BaseTeste;
import core.DSL;

public class TesteSincronismo extends BaseTeste{

	private WebDriver driver;
	private DSL dsl;

	@Before
    public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().minimize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
    }
    
    @Test
    public void interagirRespostaDemorada () {
    	dsl.clicar("buttonDelay");
    	dsl.aguardarPorId(10, "novoCampo");
    	dsl.escrever("novoCampo", "escrevendo");
    	//assertEquals("escrevendo", dsl.obterTextoCampo("novoCampo"));
    }
}

package Prueba.Tecnica.Advantage.Online.Shopping.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/registroUsuario.feature",
		glue = "Prueba.Tecnica.Advantage.Online.Shopping.stepsdefinitions",
		snippets = SnippetType.CAMELCASE)
public class RegistroUsuarioRunner {

}

package Prueba.Tecnica.Advantage.Online.Shopping.stepsdefinitions;

import java.io.IOException;

import org.hamcrest.Matchers;

import Prueba.Tecnica.Advantage.Online.Shopping.drivers.WebDriverBrowser;
import Prueba.Tecnica.Advantage.Online.Shopping.questions.ValidarTexto;
import Prueba.Tecnica.Advantage.Online.Shopping.tasks.RegistrarNuevoUsuario;
import Prueba.Tecnica.Advantage.Online.Shopping.userinterface.HomeUserInterface;
import Prueba.Tecnica.Advantage.Online.Shopping.utils.Utils;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class RegistroUsuarioStepDefinitions {
	
	@Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        Utils.generarData();
    }
	
	@Dado("^Que el usuario se encuentra en la pagina de Advantage Online Shopping$")
	public void queElUsuarioSeEncuentraEnLaPaginaDeAdvantageOnlineShopping() {
		OnStage.theActorCalled("Edgar Duvan Lemus Ramos").can(BrowseTheWeb.with(WebDriverBrowser.chromeHisBrowserWeb().on("https://www.advantageonlineshopping.com/#/")));
	}


	@Cuando("^Se registra en la pagina$")
	public void seRegistraEnLaPagina() {
		OnStage.theActorInTheSpotlight().attemptsTo(RegistrarNuevoUsuario.enLaPagina());
	}

	@Entonces("^Puede validar que se encuentra registrado en la pagina$")
	public void puedeValidarQueSeEncuentraRegistradoEnLaPagina() {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarTexto.enLaPantalla(HomeUserInterface.LBL_NOMBREL_USUARIO), Matchers.equalTo(Utils.jsonObject.get("username").toString())));
	}
}

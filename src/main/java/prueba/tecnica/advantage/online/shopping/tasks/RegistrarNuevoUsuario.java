package Prueba.Tecnica.Advantage.Online.Shopping.tasks;

import Prueba.Tecnica.Advantage.Online.Shopping.interactions.Esperar;
import Prueba.Tecnica.Advantage.Online.Shopping.userinterface.HomeUserInterface;
import Prueba.Tecnica.Advantage.Online.Shopping.utils.Utils;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class RegistrarNuevoUsuario implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Esperar.estosSegundos(30),
				Click.on(HomeUserInterface.BTN_USUARIO),
				JavaScriptClick.on(HomeUserInterface.BTN_CREAR_NUEVO_USUARIO),
				Esperar.estosSegundos(30),
				Enter.theValue(Utils.jsonObject.get("username").toString()).into(HomeUserInterface.TXT_NUEVO_USUARIO),
				Enter.theValue(Utils.jsonObject.get("email").toString()).into(HomeUserInterface.TXT_EMAIL_USUARIO),
				Enter.theValue(Utils.jsonObject.get("password").toString()).into(HomeUserInterface.TXT_CONTRASEÑA_USUARIO),
				Enter.theValue(Utils.jsonObject.get("password").toString()).into(HomeUserInterface.TXT_CONFIRMAR_CONTRASEÑA_USUARIO),
				Enter.theValue(Utils.jsonObject.get("first_name").toString()).into(HomeUserInterface.TXT_PRIMER_NOMBRE_USUARIO),
				Enter.theValue(Utils.jsonObject.get("last_name").toString()).into(HomeUserInterface.TXT_PRIMER_APELLIDO_USUARIO),
				Enter.theValue(Utils.jsonObject.get("phone_number").toString().split(" ")[1].replace("-", "")).into(HomeUserInterface.TXT_NUMERO_TELEFONO_USUARIO),
				SelectFromOptions.byVisibleText(Utils.jsonObject.getJSONObject("address").get("country").toString()).from(HomeUserInterface.SELECT_PAIS_USUARIO),
				Enter.theValue(Utils.jsonObject.getJSONObject("address").get("city").toString()).into(HomeUserInterface.TXT_CIUDAD_USUARIO),
				Enter.theValue(Utils.jsonObject.getJSONObject("address").get("street_address").toString()).into(HomeUserInterface.TXT_DIRECCION_USUARIO),
				Enter.theValue(Utils.jsonObject.getJSONObject("address").get("state").toString()).into(HomeUserInterface.TXT_DEPARTAMENTO_USUARIO),
				Enter.theValue(Utils.jsonObject.getJSONObject("address").get("zip_code").toString()).into(HomeUserInterface.TXT_POSTAL_USUARIO),
				Click.on(HomeUserInterface.BTN_CONDICIONES)
				);
		try {
			HomeUserInterface.BTN_REGISTRAR_USUARIO.resolveFor(actor).click();
			actor.attemptsTo(WaitUntil.the(HomeUserInterface.LBL_NOMBREL_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds());
		} catch (Exception e) {
			Utils.generarData();
			actor.attemptsTo(RegistrarNuevoUsuario.enLaPagina());
		}
	}

	public static RegistrarNuevoUsuario enLaPagina() {
		return Instrumented.instanceOf(RegistrarNuevoUsuario.class).withProperties();
	}
	
}

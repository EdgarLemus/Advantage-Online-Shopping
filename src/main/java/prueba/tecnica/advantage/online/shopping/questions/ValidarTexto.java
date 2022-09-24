package Prueba.Tecnica.Advantage.Online.Shopping.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarTexto implements Question<String>{
	
	private Target target;	

	public ValidarTexto(Target target) {
		this.target = target;
	}

	@Override
	public String answeredBy(Actor actor) {		
		return target.resolveFor(actor).getText();
	}
	
	public static ValidarTexto enLaPantalla(Target target) {
		return new ValidarTexto(target);
	}
}

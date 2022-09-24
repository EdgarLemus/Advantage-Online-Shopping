# Advantage-Online-Shopping

Realiza la automatización en la pagina [Advantage Online Shopping](https://www.advantageonlineshopping.com/#/) de Registro de Usuario todo realizado con [Gradle](https://gradle.org/), [Java](https://www.java.com/es/), [SerenityBDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html), [Cucumber](https://cucumber.io/) y [Screenplay](https://serenity-bdd.info/).

## Estructura Codigo Fuente

La estructura del codigo fue realizada con Screenplay de la siguiente forma:
<table>
<tr>
  <th>Tasks</th>
  <td>
    <h6>Contiene todas las tareas que se ejecutaran en la automatizacion</h6>
  </td>
</tr>
  <tr>
  <th>Interactions</th>
  <td>
    <h6>Contiene todas las interaciones que se ejecutaran en la automatizacion</h6>
  </td>
</tr>
  <tr>
  <th>User Interface</th>
  <td>
    <h6>Contiene todos los elementos de la interface usuario mapeados en la pagina</h6>
  </td>
</tr>
  <tr>
  <th>Drivers</th>
  <td>
    <h6>Contiene todos los drivers de los navegadores</h6>
  </td>
</tr>
  <tr>
  <th>Runners</th>
  <td>
    <h6>Contiene todos los ejecutores de las pruebas automatizadas</h6>
  </td>
</tr>
  <tr>
  <th>Steps Definitions</th>
  <td>
    <h6>Contiene todos los pasos de la ejecucion de cada prueba automatizada</h6>
  </td>
</tr>
  <tr>
  <th>Features</th>
  <td>
    <h6>Contiene todos los esenarios codificados en lenguaje Gherking</h6>
  </td>
</tr>
</table>

#### Tasks

##### CrearNuevoUsuario

Permite registrar un nuevo usuario en la pagina Advantage Online Shopping, todo esto con informacion generada autonoma, es decir, no toca quemar la informacion en el codigo si no que esta es generada por el codigo, al igual tiene un auto mantenimiento en caso tal que la informacion no cumpla con cierto criterio de aceptacion de la pagina, intentara el registro con una nueva informacion.
```java
    public class CrearNuevoUsuario implements Task{

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
			actor.attemptsTo(CrearNuevoUsuario.enLaPagina());
		}
	}

	public static CrearNuevoUsuario enLaPagina() {
		return Instrumented.instanceOf(CrearNuevoUsuario.class).withProperties();
	}
	
}
```
### Interactions

#### Esperar

Realiza la espera implicita, esta tarea implementa la interfaz Interaction y sobreescribe su metodo, tambien recibe un parametro de tipo int.

```java
public class Esperar implements Interaction {

    private int seconds;

    public Esperar(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DriverRemoteBrowser.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static Performable estosSegundos(int seconds)
    {
        return Instrumented.instanceOf(Esperar.class).withProperties(seconds);
    }
}
```

### userintarface

#### HomeUserInterface

Esta clase contiene todos los mapeos necesario para la ejecucion de la prueba de la pagina Advantage Online Shopping.

```java
public class HomeUserInterface {

	public static final Target BTN_USUARIO = Target.the("").located(By.xpath("//a[@id='menuUserLink']"));
	public static final Target BTN_CREAR_NUEVO_USUARIO = Target.the("").located(By.xpath("//a[contains(text(),'CREATE')]"));
	public static final Target TXT_NUEVO_USUARIO = Target.the("").located(By.xpath("//input[@name='usernameRegisterPage']"));
	public static final Target TXT_EMAIL_USUARIO = Target.the("").located(By.xpath("//input[@name='emailRegisterPage']"));
	public static final Target TXT_CONTRASEÑA_USUARIO = Target.the("").located(By.xpath("//input[@name='passwordRegisterPage']"));
	public static final Target TXT_CONFIRMAR_CONTRASEÑA_USUARIO = Target.the("").located(By.xpath("//input[@name='confirm_passwordRegisterPage']"));
	public static final Target TXT_PRIMER_NOMBRE_USUARIO = Target.the("").located(By.xpath("//input[@name='first_nameRegisterPage']"));
	public static final Target TXT_PRIMER_APELLIDO_USUARIO = Target.the("").located(By.xpath("//input[@name='last_nameRegisterPage']"));
	public static final Target TXT_NUMERO_TELEFONO_USUARIO = Target.the("").located(By.xpath("//input[@name='phone_numberRegisterPage']"));
	public static final Target SELECT_PAIS_USUARIO = Target.the("").located(By.xpath("//select[@name='countryListboxRegisterPage']"));
	public static final Target TXT_CIUDAD_USUARIO = Target.the("").located(By.xpath("//input[@name='cityRegisterPage']"));
	public static final Target TXT_DIRECCION_USUARIO = Target.the("").located(By.xpath("//input[@name='addressRegisterPage']"));
	public static final Target TXT_DEPARTAMENTO_USUARIO = Target.the("").located(By.xpath("//input[@name='state_/_province_/_regionRegisterPage']"));
	public static final Target TXT_POSTAL_USUARIO = Target.the("").located(By.xpath("//input[@name='postal_codeRegisterPage']"));
	public static final Target BTN_CONDICIONES = Target.the("").located(By.xpath("//input[@name='i_agree']"));
	public static final Target BTN_REGISTRAR_USUARIO = Target.the("").located(By.xpath("//button[@id='register_btnundefined']"));
	public static final Target LBL_NOMBREL_USUARIO = Target.the("").located(By.xpath("//a[@id='menuUserLink']//span"));
	
}
```

### drivers

#### WebDriverBrowser

Esta clase contiene todos los lanzadores de los navegadores a utilizar para la automatizacion, se inicializa una variable WebDriver quien es utilizada en los metodos para levantar cada navegador y asignarle la url

```java
public class DriverRemoteBrowser {
	
	public static WebDriver driver;

	public static DriverRemoteBrowser chromeHisBrowserWeb() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-infobars");

		driver = new ChromeDriver(options);
		return new DriverRemoteBrowser();
	}
	
	public static WebDriver on(String url) {
		driver.get(url);
		return driver;
	}
}
```
### Questions

#### ValidarTexto

Realiza la obtencion del texto de un elemento para realizar la validacion contra informacion dada por el usuario.

```java
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
```

### Runners

#### RegistroUsuarioRunner

Ejecuta el llamado de los pasos asignados en el feature `registroUsuario.feature` y los busca los metodos correspondientes en el paquete de `stepDefinitios` para realizar la ejecucion. Esta clase corre mediante el `@RunWith` de la clase `CucumberWithSerenity.class` y mediante el `@CucumberOptions` llama al feature correspondiente, el paquete que contiene los `Steps Definitions` y el `CamelCase`.

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/registroUsuario.feature",
		glue = "Prueba.Tecnica.Advantage.Online.Shopping.stepsdefinitions",
		snippets = SnippetType.CAMELCASE)
public class RegistroUsuarioRunner {

}
```

### StepsDefinitions

Los steps definitions contienen todos los metodos llamados mediante el `Runner` al `Feature`. Los metodos ejecutan las `tasks`,`interactions` y `questions` mediante un `actor`.

#### RegistroUsuarioStepDefinitions

Contiene todos los pasos a pasos de la ejecucion de Buscar Tema, este llama a la tarea `BuscarTemaLibreriaNacional` y le envia un String con el valor del tema y ejecuta la questions `ValidarExistenciaElemento`.

```java
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

```

### Features

#### registroUsuario.feature

Contiene el escenario digitado en lenguaje Gherking.

```cucumber
#language: es
#Author: edgar_duvan_l_r@hotmail.com
Característica: Registro de usuario en la plataforma
  
  Escenario: Registrar usuario en Advantage Online Shopping
    Dado Que el usuario se encuentra en la pagina de Advantage Online Shopping
    Cuando Se registra en la pagina
    Entonces Puede validar que se encuentra registrado en la pagina
```

## Ejecucion

Descargamos o clonamos el proyecto en nuestra maquina, reemplazamos el archivo chromedriver.exe por el correspondiente a la [version](chrome://settings/help) de [Google Chrome](https://chromedriver.chromium.org/downloads)

Al momento de ejecutar el proyecto y obtener el reporte debemos ubicarnos en la carpeta del proyecto y abrir el `CMD` para ejecutar el siguiente comando

```yml
    gradle clean test aggregate
```

Este comando ejecutara todos los escenarios implementados en el proyecto

```cmd
    1 actionable tasks: 1 executed
```

Al finalizar debemos ingresar y abrir el archivo `index.html` que se encuentra en la siguiente ruta

```yml
  <ProyectoName>\target\site\serenity\index.html
```

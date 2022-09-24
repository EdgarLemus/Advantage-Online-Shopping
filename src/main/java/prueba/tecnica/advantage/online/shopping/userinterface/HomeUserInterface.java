package Prueba.Tecnica.Advantage.Online.Shopping.userinterface;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

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

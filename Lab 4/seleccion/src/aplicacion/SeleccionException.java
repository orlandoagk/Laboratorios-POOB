package aplicacion;

public class SeleccionException extends Exception{
	public static final String FALTA_INFORMACION = "Lo sentimos, pero falta informaci�n del jugador";
	public static final String ESTATURA = "Lo sentimos, pero la estatura debe ser un numero entero entre 0 y 250";
	public static final String YA_EXISTE = "El jugador ya se encuentra inscrito en la selecci�n";
	public static final String NO_EXISTE_POSICION = "La posici�n ingresada no es v�lida";
	public static final String NUMEROS_NOMBRE_APELLIDO = "Hay alg�n n�mero en el nombre o apellido";
	public SeleccionException(String message) {
		super(message);
		
	}
}

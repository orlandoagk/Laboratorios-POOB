package aplicacion;

public class SeleccionException extends Exception{
	public static final String FALTA_INFORMACION = "Lo sentimos, pero falta información del jugador";
	public static final String ESTATURA = "Lo sentimos, pero la estatura debe ser un numero entero entre 0 y 250";
	public static final String YA_EXISTE = "El jugador ya se encuentra inscrito en la selección";
	public static final String NO_EXISTE_POSICION = "La posición ingresada no es válida";
	public static final String NUMEROS_NOMBRE_APELLIDO = "Hay algún número en el nombre o apellido";
	public SeleccionException(String message) {
		super(message);
		
	}
}

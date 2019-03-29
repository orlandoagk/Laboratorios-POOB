

public class EquipoExcepcion extends Exception{

    public static final String  VALOR_DESCONOCIDO= "El valor no es conocido";
    public static final String  PERSONA_DESCONOCIDA="La persona no es conocida";
    public static final String  EQUIPO_VACIO="El equipo está vacio";
    public static final String  NO_HAY_VALOR="No se puede calcular el valor";
    
    public EquipoExcepcion(String message){
        super(message);
    }

}

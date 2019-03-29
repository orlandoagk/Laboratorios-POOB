package aplicacion;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @version ECI 2019-1
 */

public class Jugador{
    private String nombres;
    private String apellidos;
    private int estatura;    
    private String posicion;
    private String premios;  
    private static final String[] POSICIONES = {"Delantero", "Arquero", "Mediocampista", "Defensa"};
    
    
    public Jugador(String nombres, String apellidos,  String  estatura, String posicion,  String premios) throws SeleccionException{
    	boolean esEntero;
    	if(apellidos.length()==0)throw new SeleccionException(SeleccionException.FALTA_INFORMACION);
    	try {
    		Integer.parseInt(estatura.trim());
    		esEntero = true;
    	}catch(NumberFormatException e) {
    		esEntero = false;
    	}
    	if (comprobarNombres(nombres) || comprobarNombres(apellidos)) throw new SeleccionException(SeleccionException.NUMEROS_NOMBRE_APELLIDO);
    	if (!comprobarPosicion(posicion)) throw new SeleccionException(SeleccionException.NO_EXISTE_POSICION);
    	if(!esEntero || (Integer.parseInt(estatura.trim()) < 120 || Integer.parseInt(estatura.trim()) > 250)) throw new SeleccionException(SeleccionException.ESTATURA);
        this.nombres = nombres.trim();
        this.apellidos = apellidos.trim();
        this.estatura = Integer.parseInt(estatura.trim());
        this.posicion = posicion.trim();
        this.premios = premios.trim();        
    }
    
    
    
    /**
     * @return 
     */
    public String getNombres(){
        return nombres;
    }

    /**
     * @return 
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * @return 
     */
    public int getEstatura(){
        return estatura;
    }    

    /**
     * @return 
     */
    public String getPosicion(){
        return posicion;
    }
    
    /**
     * @return 
     */
    public String getPremios(){
        return premios;
    }
    
    /**
     * @return 
     */
    public String toString(){
        return nombres +" "+apellidos+ " (" + posicion + ")" + "\n" + estatura + "\n" + premios  ;
    }
    
    /**
     *  Comprueba que la posición sea válida
     */
    public boolean comprobarPosicion(String pos) {
    	boolean esta = false;
    	for (int i = 0;i<POSICIONES.length;i++) {
    		if (POSICIONES[i].equals(pos)) {
    			esta = true;
    		}
    	}
    	return esta;
    }
    
    /**
     * Comprueba que en el nombre y apellido no se encuentren números
     */
    public boolean comprobarNombres(String palabra) {
    	boolean existe_numero = false;
    	int[] numeros = {'1','2','3','4','5','6','7','8','9','0'};
    	int caracter = 0;
    	while (caracter<palabra.length() && !existe_numero) {
    		for (int numero = 0;numero<numeros.length;numero++) {
    			if (palabra.charAt(caracter)==numeros[numero]) {
    				existe_numero = true;
    			}
    		}
    		caracter++;
    		
    	}
    	return existe_numero;
    	
    }

}

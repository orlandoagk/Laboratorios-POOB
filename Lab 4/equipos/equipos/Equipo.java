import java.util.ArrayList;
import java.util.HashMap;
public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        for(int i=0; i<nombres.length; i++){
            personas.add(new Persona(nombres[i]));
        }
    }

    /**
     * Calcula el valor hora de un equipo
     * @throws EquipoExcepcion Si el equipo esta vacio se lanza la excepción de tipo EQUIPO_VACIO
     * @return valor Es el valor del equipo.
     */
    public int valorHora() throws EquipoExcepcion{
        int valor = 0;
        if(personas.size()>0){
            for(Persona p: personas){
                valor += p.valorHora();
             }
         }else{
             throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
         }
        return valor;
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * Más del 50% del equipo debe tener valores conocidos 
     * El valor de las personas a las que se desconoce su valor es el promedio entre el mínimo y el máximo de las conocidas
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor, si el equipo es vacio o existe una persona desconocida
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int valor = 0;
        int cantidadValorDesconocido = 0;
        int maximo = 0;
        int minimo = 100000000;
        if (personas.size()>0){
            for(Persona p: personas){
                try{
                    
                    valor +=p.valorHora();
                    if(maximo<p.valorHora()){
                        maximo = p.valorHora();
                    }
                    if(minimo>p.valorHora()){
                        minimo = p.valorHora();
                    }
                    
                    
                }catch(EquipoExcepcion e){
                    if (e.getMessage()==EquipoExcepcion.VALOR_DESCONOCIDO){
                        cantidadValorDesconocido+=1;
                    } else if (e.getMessage() == EquipoExcepcion.PERSONA_DESCONOCIDA){
                        throw new EquipoExcepcion(EquipoExcepcion.PERSONA_DESCONOCIDA);
                    }
                }
            }
        }else{
             throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        
        if(cantidadValorDesconocido<=(int)personas.size()/2){
            int prom = (int) ((minimo+maximo)/2);
            valor += (prom *cantidadValorDesconocido);
        } else {
            throw new EquipoExcepcion(EquipoExcepcion.NO_HAY_VALOR);
        }
        return valor;
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor hora de los desconocidos es el valor de la primera persona conocida
     * El valor hora de los que no se conoce su valor es el valor de la última persona conocida
     * @return el valor hora del equipo
     * @throws EquipoException si no es posible calcular el valor 
     */
    public int valorHoraAsumido() throws EquipoExcepcion{
        int valor = 0;
        int primerConocido = 0;
        int ultimoConocido = 0;
        for (int i = 0; i<personas.size();i++){
            try{
                primerConocido = personas.get(i).valorHora();
                break;
            }catch (EquipoExcepcion e){
            
            }
            
        }
        for (int i = personas.size()-1; i>=0;i--){
            try{
                ultimoConocido = personas.get(i).valorHora();
                break;
            }catch (EquipoExcepcion e){
            
            }
            
        }
        if (primerConocido == 0){
            throw new EquipoExcepcion(EquipoExcepcion.NO_HAY_VALOR);
        }
        for (int i = 0; i<personas.size();i++){
            try{
                valor+=personas.get(i).valorHora();
            }catch (EquipoExcepcion e){
                if (e.getMessage() == EquipoExcepcion.PERSONA_DESCONOCIDA){
                    valor+=primerConocido;
                } else if (e.getMessage() == EquipoExcepcion.VALOR_DESCONOCIDO){
                    valor+=ultimoConocido;
                }
            }

        }
        return valor;
    }
}

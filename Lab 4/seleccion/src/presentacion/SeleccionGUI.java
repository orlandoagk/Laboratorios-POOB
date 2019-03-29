package presentacion; 
  

import aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * @version ECI 2019
 */
public class SeleccionGUI extends JFrame{

    private static final int ANCHO_PREFERIDO = 450;
    private static final int ALTO_PREFERIDO= 450;
    private static final Dimension DIMENSION_PREFERIDA = new Dimension(ANCHO_PREFERIDO,ALTO_PREFERIDO);

    private Seleccion coleccion;

    /*Panel botonListar*/
    private JButton botonListar;
    private JButton botonReiniciarListar;
    private JTextArea textoInformacion;
    
    /*Panel botonAdicionar*/
    private JTextField textoNombres;   
    private JTextField textoApellidos;
    private JTextField textoEstatura;
    private JTextField textoPosicion;
    private JTextArea  textoPremios;
    
    private JButton botonAdicionar;
    private JButton botonReiniciarAdicionar;
    
    /*Panel buscar*/
    private JTextField busquedaTexto;
    private JTextArea resultadosTexto;
    

    
    
    private SeleccionGUI() throws SeleccionException{
        coleccion=new Seleccion();
        coleccion.adicione();
        prepareElementos();
        prepareAcciones();
    }


    private void prepareElementos(){
        setTitle("Seleccion Colombia. Jugadores.");
        textoNombres = new JTextField(50);
        textoApellidos = new JTextField(50);
        textoEstatura = new JTextField(50);
        textoPosicion = new JTextField(4);
        textoPremios = new JTextArea(10, 50);
        textoPremios.setLineWrap(true);
        textoPremios.setWrapStyleWord(true);
        JTabbedPane etiquetas = new JTabbedPane();
        etiquetas.add("Listar",   prepareListar());
        etiquetas.add("Adicionar",  prepareAdicionar());
        etiquetas.add("Buscar", prepareBuscar());
        getContentPane().add(etiquetas);
        setSize(DIMENSION_PREFERIDA);
        
    }


    /**
     * Prepara el panel para listar
     * @return
     */
    private JPanel prepareListar(){

        textoInformacion = new JTextArea(10, 50);
        textoInformacion.setEditable(false);
        textoInformacion.setLineWrap(true);
        textoInformacion.setWrapStyleWord(true);
        JScrollPane scrollArea =
                new JScrollPane(textoInformacion,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                                
        JPanel  botones = new JPanel();
        botonListar = new JButton("Listar");
        botonReiniciarListar = new JButton("Limpiar");
        botones.add(botonListar);
        botones.add(botonReiniciarListar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollArea, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);

        return panel;
     }
     
    /**
     * Prepara el area de adición
     * @return El area de adición
     */
    private JPanel prepareAdicionar(){
        
        Box textoNombresArea = Box.createHorizontalBox();
        textoNombresArea.add(new JLabel("Nombres", JLabel.LEFT));
        textoNombresArea.add(Box.createGlue());
        Box nombresArea = Box.createVerticalBox();
        nombresArea.add(textoNombresArea);
        nombresArea.add(textoNombres);

        Box textoApellidosArea = Box.createHorizontalBox();
        textoApellidosArea.add(new JLabel("Apellidos", JLabel.LEFT));
        textoApellidosArea.add(Box.createGlue());
        Box apellidosArea = Box.createVerticalBox();
        apellidosArea.add(textoApellidosArea);
        apellidosArea.add(textoApellidos);
        
        Box textoEstaturaArea = Box.createHorizontalBox();
        textoEstaturaArea.add(new JLabel("Estatura", JLabel.LEFT));
        textoEstaturaArea.add(Box.createGlue());
        Box estaturaArea = Box.createVerticalBox();
        estaturaArea.add(textoEstaturaArea);
        estaturaArea.add(textoEstatura);

        Box textoPosicionArea = Box.createHorizontalBox();
        textoPosicionArea.add(new JLabel("Posicion", JLabel.LEFT));
        textoPosicionArea.add(Box.createGlue());
        Box posicionArea = Box.createVerticalBox();
        posicionArea.add(textoPosicionArea);
        posicionArea.add(textoPosicion);
        
        Box textoPremiosArea = Box.createHorizontalBox();
        textoPremiosArea.add(new JLabel("Premios", JLabel.LEFT));
        textoPremiosArea.add(Box.createGlue());
        Box premiosArea = Box.createVerticalBox();
        premiosArea.add(textoPremiosArea);
        premiosArea.add(textoPremios);
 
        Box singleLineFields = Box.createVerticalBox();
        singleLineFields.add(nombresArea);
        singleLineFields.add(apellidosArea);
        singleLineFields.add(estaturaArea);
        singleLineFields.add(posicionArea);        

        JPanel textoInformacionPanel = new JPanel();
        textoInformacionPanel.setLayout(new BorderLayout());
        textoInformacionPanel.add(singleLineFields, BorderLayout.NORTH);
        textoInformacionPanel.add(premiosArea, BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botonAdicionar = new JButton("Adicionar");
        botonReiniciarAdicionar = new JButton("Limpiar");

        botones.add(botonAdicionar);
        botones.add(botonReiniciarAdicionar);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textoInformacionPanel, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
    }

    



   /**
     * Prepara el area de listar
     * @return El panel para buscar coleccions
     */
    private JPanel prepareBuscar(){

        Box busquedaEtiquetaArea = Box.createHorizontalBox();
        busquedaEtiquetaArea.add(new JLabel("Buscar", JLabel.LEFT));
        busquedaEtiquetaArea.add(Box.createGlue());
        busquedaTexto = new JTextField(50);
        Box busquedaArea = Box.createHorizontalBox();
        busquedaArea.add(busquedaEtiquetaArea);
        busquedaArea.add(busquedaTexto);
        
        resultadosTexto = new JTextArea(10,50);
        resultadosTexto.setEditable(false);
        resultadosTexto.setLineWrap(true);
        resultadosTexto.setWrapStyleWord(true);
        JScrollPane scrollArea = new JScrollPane(resultadosTexto,
                                     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel botonListarArea = new JPanel();
        botonListarArea.setLayout(new BorderLayout());
        botonListarArea.add(busquedaArea, BorderLayout.NORTH);
        botonListarArea.add(scrollArea, BorderLayout.CENTER);

        return botonListarArea;
    }


    public void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
                setVisible(false);
                System.exit(0);
            }
        });
        
        /*Listar*/
        botonListar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                accionListar();
            }
        });

        botonReiniciarListar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                textoInformacion.setText("");
            }
        });
        
        /*Adicionar*/
        botonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                accionAdicionar();                    
            }
        });
        
        botonReiniciarAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                textoNombres.setText("");
                textoApellidos.setText("");
                textoEstatura.setText("");
                textoPosicion.setText("");
                textoPremios.setText("");
            }
        });
        
        /*Buscarr*/
        busquedaTexto.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent ev){
                accionBuscar();

            }
           
            public void insertUpdate(DocumentEvent ev){
                accionBuscar();
            }
            
            public void removeUpdate(DocumentEvent ev){
                accionBuscar();
            }
            

        });
    }    

    
    private void accionListar(){
        textoInformacion.setText(coleccion.toString());
    }
    
    
    private void  accionAdicionar(){
    	
    	try {
    		 coleccion.adicione(textoNombres.getText(),textoApellidos.getText(), textoEstatura.getText(), 
    			        textoPosicion.getText(),textoPremios.getText());
    	}catch(SeleccionException e) {
    		JPanel panel = new JPanel();
    		panel.add(new JLabel(e.getMessage()));
    		JOptionPane.showConfirmDialog(null, panel, "ERROR",JOptionPane.DEFAULT_OPTION);
    	}
       
    }

    private void accionBuscar(){
        String patronBusqueda=busquedaTexto.getText();
        StringBuffer buffer = new StringBuffer();
        if(patronBusqueda.length() > 0) {
            ArrayList <Jugador> results = coleccion.busque(patronBusqueda);
            for(int i = 0; i < results.size(); i++) {
                buffer.append(results.get(i).toString());
                buffer.append('\n');
                buffer.append('\n');
             }
        }
        resultadosTexto.setText(buffer.toString());
    } 
    
   public static void main(String args[]) throws SeleccionException{
       SeleccionGUI gui=new SeleccionGUI();
       gui.setVisible(true);
   }    
}

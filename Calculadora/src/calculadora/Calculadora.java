/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebas
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
   MarcoCalculadora mimarco = new MarcoCalculadora();
	  mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mimarco.setVisible(true);
	  
	  

	 }
	}

	class MarcoCalculadora extends JFrame{
	 public MarcoCalculadora(){
	   setTitle("Calculadora");
	   setBounds(500, 300, 450, 300);
	   LaminaCalculadora milamina = new LaminaCalculadora();   
	   add(milamina);
	   pack();
	 }
	}

	class LaminaCalculadora extends JPanel{
	 public LaminaCalculadora(){
	   principio = true;
	   setLayout(new BorderLayout());
	   pantalla = new JButton("0");
	   pantalla.setEnabled(false);
	   add(pantalla, BorderLayout.NORTH);
	   
	   milamina2 = new JPanel();
	   milamina2.setLayout(new GridLayout(5, 4));
	   ActionListener insertar = new InsertarNumero();
	   
	   ActionListener orden=new Accionorden();
	  ponerBoton("7", insertar);
	  ponerBoton("8", insertar);
	   ponerBoton("9", insertar);
	   ponerBoton("/",orden);
	   ponerBoton("4", insertar);
	   ponerBoton("5", insertar);
	   ponerBoton("6", insertar);
	   ponerBoton("*",orden);
	   ponerBoton("1", insertar);
	   ponerBoton("2", insertar);
	   ponerBoton("3", insertar);
	   ponerBoton("-",orden);
	   ponerBoton("0", insertar);
	  ponerBoton(".",insertar);
	  ponerBoton("=",orden);
	  ponerBoton("+",orden);   
          
          ponerBoton("CE", orden);
	 
	   //Otra forma de hacer los botones
           
	   /* JButton boton1 = new JButton("1");
	   milamina2.add(boton1);
	   JButton boton2 = new JButton("2");
	   milamina2.add(boton2);
	   JButton boton3 = new JButton("3");
	   milamina2.add(boton3);
	   JButton boton4 = new JButton("4");
	   milamina2.add(boton4);
	   
	   JButton boton5 = new JButton("5");
	   milamina2.add(boton5);
	   JButton boton6 = new JButton("6");
	   milamina2.add(boton6);
	   JButton boton7 = new JButton("7");
	   milamina2.add(boton7);
	   JButton boton8 = new JButton("8");
	   milamina2.add(boton8);
	   
	   JButton boton9 = new JButton("9");
	   milamina2.add(boton9);
	   JButton boton10 = new JButton("10");
	   milamina2.add(boton10);
	   JButton boton11 = new JButton("11");
	   milamina2.add(boton11);
	   JButton boton12 = new JButton("12");
	   milamina2.add(boton12);
	   
	   JButton boton13 = new JButton("13");
	   milamina2.add(boton13);
	   JButton boton14 = new JButton("14");
	   milamina2.add(boton14);
	   JButton boton15 = new JButton("15");
	   milamina2.add(boton15);
	   JButton boton16 = new JButton("16");
	   milamina2.add(boton16); */
	   
	   add(milamina2, BorderLayout.CENTER);  
	   ultimaoperacion="=";
	   
	 }
	 
	 private void ponerBoton(String rotulo, ActionListener oyente) {
	  JButton boton = new JButton(rotulo);
	  boton.addActionListener(oyente);
	  milamina2.add(boton);  
	 }
	 
	 private class InsertarNumero implements ActionListener{

	  @Override
	  public void actionPerformed(ActionEvent e) {
	   String entrada = e.getActionCommand();
	   
	   if(principio) {
	    pantalla.setText("");
	    principio = false;
	   }
	   pantalla.setText(pantalla.getText() + entrada);
	   
	  }
	   
	 }
	 private class Accionorden implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String operacion=e.getActionCommand();
			
			
			calcular (Double.parseDouble(pantalla.getText()));
			
			
			ultimaoperacion=operacion;
			
			principio=true;
		}
		public void calcular(double x) { //esto es el cerebro de la calculadora
		
			if(ultimaoperacion.equals("+")) {
				resultado+=x;
				
			}
			else if(ultimaoperacion.equals("/")) {
				resultado/=x;
				
			}
			else if (ultimaoperacion.equals("*")) {
				resultado*=x;
				
			}
			
			else if (ultimaoperacion.equals("-")) {
				resultado-=x;
				
			}
			else if(ultimaoperacion.equals("=")) {
				resultado=x;
			}
                        else if (ultimaoperacion.equals("CE")){
                            resultado=0;
                        }
			
			pantalla.setText(""+ resultado);
			
		}
		 
	 }
	 //variables
	 private JPanel milamina2;
	 private JButton pantalla;
	 private Boolean principio;  //false por defecto

	private double resultado;
	
	private String ultimaoperacion;
	
	
        }
    


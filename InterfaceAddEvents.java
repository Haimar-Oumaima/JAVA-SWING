package jPanel;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class InterfaceAddEvents extends JFrame{
	  public InterfaceAddEvents(){
	this.setTitle("Add new event");
	this.setSize(800,700);
	  }
	  
	  public void afficher(){
		  this.setVisible(true);
	  }
  public static void main(String[] args) {
	  InterfaceAddEvents o= new InterfaceAddEvents();
	  o.afficher();
 
	
	  
	  
	  
	  
	  
	  
	    
	JFrame h=new JFrame("windows");
             h.setSize(1000,800);
             JPanel panneau=new JPanel();
             h.setContentPane(panneau);
             
             
             
             JTextField textField = new JTextField();
     		textField.setColumns(14);
      
     		h.add(textField);
             
             JButton a=new JButton("Ajouter un évenement");
             h.getContentPane().add(a);
             JLabel l=new JLabel("");
             h.getContentPane().add(l);
             h.setVisible(true);

            a.addActionListener(new ActionListener(){  
         		public void actionPerformed(ActionEvent e){  
         		            l.setText("Votre évenement a été ajouter!");  }  
         		    });  
             
}
  
} 





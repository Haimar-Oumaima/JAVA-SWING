package jPanel;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import com.toedter.calendar.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;


public class AddEvents extends ListEvents  {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	 static JLabel l; 
	 private JLabel l_2;
	 private JButton btnNewButton;
	 private JTextField textField_2;
	 private JLabel lblId;
	 private JButton btnAfficherLesArchives;
	  

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEvents window = new AddEvents();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddEvents() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 757, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().getDayPanel().setForeground(SystemColor.controlLtHighlight);
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.controlHighlight);
		calendar.getDayChooser().getDayPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		
		l = new JLabel(); 
		  
        // add text to label 
		JLabel l_1=new JLabel("Le nom de votre événement:");
		
		
		textField = new JTextField();
		textField.setBackground(SystemColor.textHighlightText);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblId = new JLabel("ID");
		
		l_2 = new JLabel("Description de l'événement");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
       
       
       JButton a=new JButton("Ajouter l'évenement");
       a.setBackground(UIManager.getColor("Button.highlight"));
       a.addMouseListener(new MouseAdapter() {
    	   
       	@Override
       	public void mouseClicked(MouseEvent arg0) {
       		
       		//textField.setText("ddd");
       	 
       	}
       });
       
       btnNewButton = new JButton("Afficher tout les events");
       btnNewButton.setBackground(UIManager.getColor("Button.highlight"));
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		
       		ListEvents Second = new ListEvents();
       		Second.setLocationRelativeTo(null);
       		//Second.setExtendedState(JFrame.MAXIMIZED_BOTH);
       		Second.pack();
       		Second.setVisible(true);
       		
       	}
       });
       
       btnAfficherLesArchives = new JButton("Afficher les archives");
       btnAfficherLesArchives.setBackground(UIManager.getColor("Button.highlight"));
       btnAfficherLesArchives.addActionListener(new ActionListener()
       {
       	public void actionPerformed(ActionEvent e) {
       		
       		Archive AR = new Archive();
       		AR.setLocationRelativeTo(null);
       		//Second.setExtendedState(JFrame.MAXIMIZED_BOTH);
       		AR.pack();
       		AR.setVisible(true);       		
       	}
       });
       
       JLabel lblDateDvenement = new JLabel("Date D'\u00E9venement");
       GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
       groupLayout.setHorizontalGroup(
       	groupLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(groupLayout.createSequentialGroup()
       			.addGap(16)
       			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
       				.addGroup(groupLayout.createSequentialGroup()
       					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addComponent(l_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       							.addGap(10))
       						.addComponent(l_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       						.addComponent(lblId))
       					.addGap(21))
       				.addGroup(groupLayout.createSequentialGroup()
       					.addGap(2)
       					.addComponent(lblDateDvenement, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
       					.addPreferredGap(ComponentPlacement.UNRELATED)))
       			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(textField_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
       				.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
       				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
       					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
       					.addGap(141))
       				.addComponent(calendar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       			.addGap(48)
       			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       				.addComponent(btnAfficherLesArchives, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
       				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
       			.addGap(26))
       		.addGroup(groupLayout.createSequentialGroup()
       			.addGap(235)
       			.addComponent(a, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
       			.addGap(321))
       );
       groupLayout.setVerticalGroup(
       	groupLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(groupLayout.createSequentialGroup()
       			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       				.addGroup(groupLayout.createSequentialGroup()
       					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addGap(37)
       							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
       						.addGroup(groupLayout.createSequentialGroup()
       							.addGap(50)
       							.addComponent(lblDateDvenement, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
       					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addGap(64)
       							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       								.addComponent(lblId)
       								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
       								.addComponent(l_1)
       								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
       						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
       							.addGap(18)
       							.addComponent(btnAfficherLesArchives, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
       					.addPreferredGap(ComponentPlacement.RELATED)
       					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(groupLayout.createSequentialGroup()
       							.addGap(18)
       							.addComponent(l_2))
       						.addGroup(groupLayout.createSequentialGroup()
       							.addPreferredGap(ComponentPlacement.RELATED)
       							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
       				.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addComponent(a, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
       			.addGap(29))
       );
       frame.getContentPane().setLayout(groupLayout);
       
        a.addActionListener(new ActionListener(){  
      		public void actionPerformed(ActionEvent e){ 
      			
      			
      			//textField.setText("ddd");
      			//calendar.getDate(); 
      			//Date date = calendar.getDate().toInstant();  
      		    //SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
      		   // String strDate = formatter.format(date);  
      			//JOptionPane.showMessageDialog(null,calendar.getDate().toInstant(),"Ajout",1);
      			
      			
      			
      			  //String x = calendar.getDate().toInstant().toString();
      			try {
      	             PreparedStatement pst= Connexion.GetCon().prepareStatement("INSERT INTO events VALUES(?,?,?,?,?)"); 
      	             pst.clearParameters();
      	             pst.setString(1,textField.getText());
      	             pst.setString(2,textField_1.getText());
      	             pst.setString(3,calendar.getDate().toInstant().toString());
      	             pst.setInt(4,0);
      	             pst.setString(5,textField_2.getText());
      	             pst.executeUpdate();
      	            
      	             /* Pop Up*/
      	            JOptionPane.showMessageDialog(null,"Evénement Bien Ajouté","Success",1);
      	         } catch (Exception e1) {
      	              System.err.println(e1.getMessage());
      	         }  }  
      		    });  
        frame.setVisible(true);
          
		
	
	}
}

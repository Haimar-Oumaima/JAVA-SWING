package jPanel;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Label;

public class ListEvents extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	private JButton btnModifier;
	private JButton btnArchiver;
	private JTextField textField_3;
	/**
	 * @wbp.nonvisual location=293,289
	 */
	private final Label label = new Label("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEvents window = new ListEvents();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public ListEvents() {
		
		initialize();
		
		table = new JTable();
		table.setBackground(new Color(175, 238, 238));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int ID = table.getSelectedRow();
				
				String nom = table.getModel().getValueAt(ID,0).toString();
				String desc = table.getModel().getValueAt(ID,1).toString();
				String Date = table.getModel().getValueAt(ID,2).toString();
				
				
				textField.setText(nom);
				textField_1.setText(desc);
				textField_3.setText(Date);

			}
		});
		
		JButton btnAfficher = new JButton("Actualiser");
		btnAfficher.setBackground(UIManager.getColor("Button.highlight"));
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
			            Statement st = Connexion.GetCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			            ResultSet rs =st.executeQuery("SELECT * FROM events where archive = 0");
			            
			            Vector<String> titre= new Vector<String>();
			        titre.add("Nom Events");
			        titre.add("Description");
			        titre.add("Date");
			        titre.add("ID");
			        
			        
			        Vector<Vector<Object>> matrice = new Vector<Vector<Object>>();
			        
			        while (rs.next()) {
			           // Contact C=new Contact(rs.getString("CIN"),rs.getString("NOM"),rs.getString("TEL"),rs.getString("PRENOM"));
			            Vector<Object> V= new Vector<Object>();
			        
			            V.add(rs.getString("nom"));
			            V.add(rs.getString("description"));
			            V.add(rs.getString("dateEvent"));
			            V.add(rs.getString("ID"));
			           
			            
			            matrice.add(V);
			        
			        table.setModel(new javax.swing.table.DefaultTableModel(matrice,titre));
			            
			        }
			        
			       
			        } catch (Exception e) {
			            System.err.println(e.getMessage());
			        }
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBackground(UIManager.getColor("Button.highlight"));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int ID = table.getSelectedRow();
					
					String IDD = table.getModel().getValueAt(ID,3).toString();
     	             PreparedStatement pst= Connexion.GetCon().prepareStatement("UPDATE  events SET nom = ? , description = ? WHERE ID = ?"); 
     	            
     	             pst.setString(3,IDD);
     	             pst.setString(1,textField.getText());
     	             pst.setString(2,textField_1.getText()); 
     	            
     	             pst.executeUpdate();
     	            
     	             /* Pop Up*/
     	            JOptionPane.showMessageDialog(null,"Evénement Bien Modifiée","Success",1);
     	         } catch (Exception e1) {
     	              System.err.println(e1.getMessage());
     	         }
				
				
			}
		});
		
		btnArchiver = new JButton("Archiver");
		btnArchiver.setBackground(UIManager.getColor("Button.highlight"));
		btnArchiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int ID = table.getSelectedRow();
					
					String IDD = table.getModel().getValueAt(ID,3).toString();
     	             PreparedStatement pst= Connexion.GetCon().prepareStatement("UPDATE  events SET archive = 1  WHERE ID = ?"); 
     	            
     	             pst.setString(1,IDD);
     	           
     	            
     	     
     	             pst.executeUpdate();
     	            
     	             /* Pop Up*/
     	            JOptionPane.showMessageDialog(null,"Evénement Bien Archivée","Archivée",1);
     	         } catch (Exception e1) {
     	              System.err.println(e1.getMessage());
     	         }
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addComponent(btnAfficher, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(74)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addGap(98)
									.addComponent(btnArchiver, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAfficher, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnArchiver, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

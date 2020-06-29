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

public class ListEvents extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnModifier;
	private JButton btnArchiver;

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
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int ID = table.getSelectedRow();
				
				String nom = table.getModel().getValueAt(ID,0).toString();
				String desc = table.getModel().getValueAt(ID,1).toString();
				
				textField.setText(nom);
				textField_1.setText(desc);
			}
		});
		
		JButton btnAfficher = new JButton("Afficher");
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
		btnArchiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int ID = table.getSelectedRow();
					
					String IDD = table.getModel().getValueAt(ID,3).toString();
     	             PreparedStatement pst= Connexion.GetCon().prepareStatement("UPDATE  events SET archive = 1  WHERE ID = ?"); 
     	            
     	             pst.setString(1,IDD);
     	           
     	            
     	            
     	             pst.executeUpdate();
     	            
     	             /* Pop Up*/
     	            JOptionPane.showMessageDialog(null,"Evénement Bien Modifiée","Success",1);
     	         } catch (Exception e1) {
     	              System.err.println(e1.getMessage());
     	         }
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnAfficher)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(btnModifier)
							.addGap(30))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnArchiver)
							.addGap(20))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAfficher)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModifier))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnArchiver)
							.addGap(1))))
		);
		getContentPane().setLayout(groupLayout);
		initialize();
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

package jPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;

public class Archive extends JFrame {

	private JFrame frame1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Archive window = new Archive();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	/**
	 * Create the application.
	 */
	public Archive() {
		initialize();
	
		table = new JTable();
		table.setBackground(new Color(175, 238, 238));
		
		JButton btnAfficherLesArchives = new JButton("Actualiser les archives");
		btnAfficherLesArchives.setBackground(UIManager.getColor("Button.highlight"));
		btnAfficherLesArchives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
			            Statement st = Connexion.GetCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			            ResultSet rs =st.executeQuery("SELECT * FROM events where archive = 1");
			            
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
			        
			       
			        } catch (Exception ee) {
			            System.err.println(ee.getMessage());
			        }
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame1.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(btnAfficherLesArchives, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAfficherLesArchives, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		frame1.getContentPane().setLayout(groupLayout);
	}
	
	private void initialize() {
		
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 646, 361);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame1.setVisible(true);

	}

	
	

}

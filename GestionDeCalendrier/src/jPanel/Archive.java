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

public class Archive {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Archive window = new Archive();
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
	public Archive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		
		JButton btnAfficherLesArchives = new JButton("Afficher les archives");
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(165)
					.addComponent(btnAfficherLesArchives)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnAfficherLesArchives)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}

package transport;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Customers extends JFrame {

	private JPanel contentPane;
	private JTable table_customers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers frame = new Customers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField in_fname;
	private JTextField in_address;
	private JTextField in_tk;
	private JTextField in_afm;
	private JTextField in_tel2;
	private JTextField in_lname;
	private JTextField in_city;
	private JTextField in_country;
	private JTextField in_tel;
	private JTextField in_sxolia;
	private JTable table_packages;
	private JScrollPane scrollPane_1;
	private JTextField in_pelatis_id;
	private JButton button;
	private JTextField tf_apostolea;
	private JTextField tf_paralipti;
	private JTextField tf_varos;
	private JTextField tf_apostasi;
	private JTextField tf_paralavi;
	private JTextField tf_siskeuasia;
	private JTextField tf_apostoli;
	private JTextField tf_paradosi;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel label;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_13;
	private JLabel label_2;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JTextField tf_pack_id;
	private JButton btnNewButton;
	private JTextField tf_timi;
	
	
	/**
	 * Create the frame.
	 */
	public Customers() {
		setTitle("Customers");
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1765, 928);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent arg0) {
				
				
			}});
		scrollPane.setBounds(20, 243, 778, 640);
		contentPane.add(scrollPane);
		
		table_customers = new JTable();
		table_customers.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=table_customers.getSelectedRow();
					String pelatis2_id=(table_customers.getModel() .getValueAt(row, 0)).toString();
					String query ="select * from customers where pelatis_id="+pelatis2_id;
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						while(rs.next())
						{
							in_pelatis_id.setText(rs.getString("pelatis_id"));
							in_fname.setText(rs.getString("fname"));
							in_lname.setText(rs.getString("lname"));
							in_address.setText(rs.getString("address"));
							in_tk.setText(rs.getString("tk"));
							in_city.setText(rs.getString("city"));
							in_afm.setText(rs.getString("afm"));
							in_country.setText(rs.getString("country"));
							in_tel.setText(rs.getString("tel"));
							in_tel2.setText(rs.getString("tel2"));
							in_sxolia.setText(rs.getString("sxolia"));
				}
				
				{String query2="select * from packages where apostoleas="+pelatis2_id;
					PreparedStatement pst2=connection.prepareStatement(query2);
					ResultSet rs2=pst2.executeQuery();
					table_packages.setModel(DbUtils.resultSetToTableModel(rs2));
						
				pst.close();}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table_customers);
		
		JButton btnLoadTable = new JButton("\u0395\u039C\u03A6\u0391\u039D\u0399\u03A3\u0397 \u03A0\u0395\u039B\u0391\u03A4\u03A9\u039D");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Query=" select * from customers ";
					
					PreparedStatement pst=connection.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_customers.setModel(DbUtils.resultSetToTableModel(rs));
				}  catch (Exception e1) {
					e1.printStackTrace();
				}
				}
			
			
		});
		btnLoadTable.setBounds(420, 15, 281, 68);
		contentPane.add(btnLoadTable);
		
		in_fname = new JTextField();
		in_fname.setBounds(132, 11, 86, 20);
		contentPane.add(in_fname);
		in_fname.setColumns(10);
		
		in_address = new JTextField();
		in_address.setBounds(132, 42, 86, 20);
		contentPane.add(in_address);
		in_address.setColumns(10);
		
		in_tk = new JTextField();
		in_tk.setBounds(132, 73, 86, 20);
		contentPane.add(in_tk);
		in_tk.setColumns(10);
		
		in_afm = new JTextField();
		in_afm.setBounds(320, 104, 90, 20);
		contentPane.add(in_afm);
		in_afm.setColumns(10);
		
		in_tel2 = new JTextField();
		in_tel2.setBounds(132, 138, 86, 20);
		contentPane.add(in_tel2);
		in_tel2.setColumns(10);
		
		in_lname = new JTextField();
		in_lname.setBounds(324, 15, 86, 20);
		contentPane.add(in_lname);
		in_lname.setColumns(10);
		
		in_city = new JTextField();
		in_city.setBounds(324, 42, 86, 20);
		contentPane.add(in_city);
		in_city.setColumns(10);
		
		in_country = new JTextField();
		in_country.setBounds(320, 73, 90, 20);
		contentPane.add(in_country);
		in_country.setColumns(10);
		
		in_tel = new JTextField();
		in_tel.setBounds(132, 104, 86, 20);
		contentPane.add(in_tel);
		in_tel.setColumns(10);
		
		in_sxolia = new JTextField();
		in_sxolia.setBounds(320, 138, 270, 68);
		contentPane.add(in_sxolia);
		in_sxolia.setColumns(10);
		
		JButton btn_Save = new JButton("\u0391\u03A0\u039F\u0398\u0397\u039A\u0395\u03A5\u03A3\u0397");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="insert into customers(lname,fname,address,city,tk,country,afm,tel,tel2,sxolia) values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,in_fname.getText());
					pst.setString(2,in_lname.getText());
					pst.setString(3,in_address.getText());
					pst.setString(4,in_city.getText());
					pst.setString(5,in_tk.getText());
					pst.setString(6,in_country.getText());
					pst.setString(7,in_afm.getText());
					pst.setString(8,in_tel.getText());
					pst.setString(9,in_tel2.getText());
					pst.setString(10,in_sxolia.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					pst.close();
				}catch (Exception e) {
					e.printStackTrace();
					
				}
				
			}
		});
		btn_Save.setBounds(17, 169, 201, 37);
		contentPane.add(btn_Save);
		
		JLabel lblNewLabel = new JLabel("\u038C\u039D\u039F\u039C\u0391");
		lblNewLabel.setBounds(37, 14, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03A0\u03A9\u039D\u03A5\u039C\u039F");
		lblNewLabel_1.setBounds(264, 18, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0394\u0399\u0395\u03A5\u0398\u03A5\u039D\u03A3\u0397");
		lblNewLabel_2.setBounds(35, 45, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("T.K");
		lblNewLabel_3.setBounds(37, 76, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0391.\u03A6.\u039C.");
		lblNewLabel_4.setBounds(264, 110, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u039A\u0399\u039D\u0397\u03A4\u039F");
		lblNewLabel_5.setBounds(35, 141, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u03A0\u039F\u039B\u0397");
		lblNewLabel_6.setBounds(264, 45, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u03A7\u03A9\u03A1\u0391");
		lblNewLabel_7.setBounds(264, 76, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u03A4\u0397\u039B\u0395\u03A6\u03A9\u039D\u039F");
		lblNewLabel_8.setBounds(37, 107, 85, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u03A3\u03A7\u039F\u039B\u0399\u0391");
		lblNewLabel_9.setBounds(264, 141, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(808, 37, 740, 846);
		contentPane.add(scrollPane_1);
		
		table_packages = new JTable();
		table_packages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table_packages.getSelectedRow();
					String pelatis2_id=(table_packages.getModel() .getValueAt(row, 0)).toString();
					String query ="select * from packages where pack_id="+pelatis2_id;
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						while(rs.next())
						{	
							tf_pack_id.setText(rs.getString("pack_ID"));
							tf_apostolea.setText(rs.getString("apostoleas"));
							tf_paralipti.setText(rs.getString("paraliptis"));
							tf_varos.setText(rs.getString("weight"));
							tf_apostasi.setText(rs.getString("kilometer"));
							tf_paralavi.setText(rs.getString("date_paralavi"));
							tf_siskeuasia.setText(rs.getString("date_siskeyasias"));
							tf_apostoli.setText(rs.getString("date_apostolis"));
							tf_paradosi.setText(rs.getString("date_paradosis"));
							
							
						}
						pst.close();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table_packages);
		
		JButton bt_update = new JButton("UPDATE");
		bt_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="update customers set fname='"+in_fname.getText()+"',lname='"+in_lname.getText()+"',address='"+in_address.getText()+"'where pelatis_id='"+in_pelatis_id.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
							pst.execute();
					JOptionPane.showMessageDialog(null,"Data saved");
					String Query=" select * from customers ";
					
					PreparedStatement pst2=connection.prepareStatement(Query);
					ResultSet rs=pst2.executeQuery();
					table_customers.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					e.printStackTrace();
				
				}
			}
		});
		bt_update.setBounds(228, 169, 89, 37);
		contentPane.add(bt_update);
		
		in_pelatis_id = new JTextField();
		in_pelatis_id.setEditable(false);
		in_pelatis_id.setBounds(0, 12, 28, 20);
		contentPane.add(in_pelatis_id);
		in_pelatis_id.setColumns(10);
		
		button = new JButton("\u0394\u0399\u0391\u0393\u03A1\u0391\u03A6\u0397");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from customers where pelatis_id='"+in_pelatis_id.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"data deleted successfully" );
					String Query=" select * from customers ";
					PreparedStatement pst2=connection.prepareStatement(Query);
					ResultSet rs=pst2.executeQuery();
					table_customers.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (Exception eh) {
					eh.printStackTrace();
				}
			}
		});
		button.setBounds(600, 183, 129, 23);
		contentPane.add(button);
		
		tf_apostolea = new JTextField();
		tf_apostolea.setBounds(1558, 73, 86, 20);
		contentPane.add(tf_apostolea);
		tf_apostolea.setColumns(10);
		
		tf_paralipti = new JTextField();
		tf_paralipti.setBounds(1558, 138, 86, 20);
		contentPane.add(tf_paralipti);
		tf_paralipti.setColumns(10);
		
		tf_varos = new JTextField();
		tf_varos.setBounds(1558, 202, 86, 20);
		contentPane.add(tf_varos);
		tf_varos.setColumns(10);
		
		tf_apostasi = new JTextField();
		tf_apostasi.setBounds(1558, 258, 86, 20);
		contentPane.add(tf_apostasi);
		tf_apostasi.setColumns(10);
		
		tf_paralavi = new JTextField();
		tf_paralavi.setBounds(1558, 331, 86, 20);
		contentPane.add(tf_paralavi);
		tf_paralavi.setColumns(10);
		
		tf_siskeuasia = new JTextField();
		tf_siskeuasia.setText("");
		tf_siskeuasia.setBounds(1558, 395, 86, 20);
		contentPane.add(tf_siskeuasia);
		tf_siskeuasia.setColumns(10);
		
		tf_apostoli = new JTextField();
		tf_apostoli.setText("");
		tf_apostoli.setBounds(1558, 451, 86, 20);
		contentPane.add(tf_apostoli);
		tf_apostoli.setColumns(10);
		
		tf_paradosi = new JTextField();
		tf_paradosi.setText("");
		tf_paradosi.setBounds(1558, 517, 86, 20);
		contentPane.add(tf_paradosi);
		tf_paradosi.setColumns(10);
		
		lblNewLabel_11 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A0\u0391\u03A1\u0391\u039B\u0391\u0392\u0397\u03A3");
		lblNewLabel_11.setBounds(1558, 307, 185, 14);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A3\u03A5\u03A3\u039A\u0395\u0391\u03A3\u0399\u0391\u03A3");
		lblNewLabel_12.setBounds(1558, 364, 185, 20);
		contentPane.add(lblNewLabel_12);
		
		label = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u0391\u03A0\u039F\u03A3\u03A4\u039F\u039B\u0397\u03A3");
		label.setBounds(1558, 426, 185, 14);
		contentPane.add(label);
		
		lblNewLabel_14 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A0\u0391\u03A1\u0391\u0394\u039F\u03A3\u0397\u03A3");
		lblNewLabel_14.setBounds(1558, 492, 185, 14);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_13 = new JLabel("\u0391\u03A0\u039F\u03A3\u03A4\u039F\u039B\u0395\u0391\u03A3");
		lblNewLabel_13.setBounds(1558, 45, 86, 14);
		contentPane.add(lblNewLabel_13);
		
		label_2 = new JLabel("\u0392\u0391\u03A1\u039F\u03A3");
		label_2.setBounds(1558, 179, 46, 14);
		contentPane.add(label_2);
		
		lblNewLabel_15 = new JLabel("\u0391\u03A0\u039F\u03A3\u03A4\u0391\u03A3\u0397");
		lblNewLabel_15.setBounds(1558, 233, 86, 14);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("\u03A0\u0391\u03A1\u0391\u039B\u0397\u03A0\u03A4\u0397\u03A3");
		lblNewLabel_16.setBounds(1558, 107, 118, 14);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("\u039B\u0399\u03A3\u03A4\u0391 \u03A0\u0395\u039B\u0391\u03A4\u03A9\u039D");
		lblNewLabel_17.setFont(lblNewLabel_17.getFont().deriveFont(lblNewLabel_17.getFont().getStyle() | Font.BOLD | Font.ITALIC, 21f));
		lblNewLabel_17.setBounds(290, 217, 192, 23);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("\u039B\u0399\u03A3\u03A4\u0391 \u0394\u0395\u039C\u0391\u03A4\u03A9\u039D/\u03A0\u0395\u039B\u0391\u03A4\u0397");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_18.setBounds(1030, 11, 386, 20);
		contentPane.add(lblNewLabel_18);
		
		JButton bt_np = new JButton("\u039D\u0395\u039F \u03A0\u0391\u039A\u0395\u03A4\u039F");
		bt_np.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insert_apostolea inst=new insert_apostolea(); 
				inst.setVisible(true);
			}
			
		});
		bt_np.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		bt_np.setBounds(1558, 10, 141, 23);
		contentPane.add(bt_np);
		
		JButton pack_update = new JButton("UPDATE PACKAGES");
		pack_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="update packages set weight='"+tf_varos.getText()+"',kilometer='"+tf_apostasi.getText()+"',date_siskeyasias='"+tf_siskeuasia.getText()+"',date_paralavi='"+tf_paralavi.getText()+"',date_apostolis='"+tf_apostoli.getText()+"',date_paradosis='"+tf_paralavi.getText()+"'where pack_ID='"+tf_pack_id.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
							pst.execute();
					JOptionPane.showMessageDialog(null,"Data saved");
					String Query=" select * from packages where pack_ID="+tf_pack_id.getText();
					
					PreparedStatement pst2=connection.prepareStatement(Query);
					ResultSet rs=pst2.executeQuery();
					table_packages.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					e.printStackTrace();
				
				}
		}
			
		});
		pack_update.setBounds(1558, 565, 159, 57);
		contentPane.add(pack_update);
		
		JButton pack_delete = new JButton("DELETE PACKAGE");
		pack_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from packages where pack_ID='"+tf_pack_id.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"data deleted successfully" );
					String Query=" select * from packages where pack_ID="+tf_pack_id.getText();
					PreparedStatement pst2=connection.prepareStatement(Query);
					ResultSet rs=pst2.executeQuery();
					table_packages.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch (Exception eh) {
					eh.printStackTrace();
				}
			}
		});
		pack_delete.setBounds(1558, 829, 159, 49);
		contentPane.add(pack_delete);
		
		tf_pack_id = new JTextField();
		tf_pack_id.setEditable(false);
		tf_pack_id.setBounds(1410, 11, 86, 20);
		contentPane.add(tf_pack_id);
		tf_pack_id.setColumns(10);
		
		btnNewButton = new JButton("\u03A4\u0399\u039C\u039F\u039A\u0391\u03A4\u0391\u039B\u039F\u0393\u039F\u03A3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pricelist prst=new pricelist();
				prst.setVisible(true);
			}
		});
		btnNewButton.setBounds(822, 10, 153, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u03A5\u03A0\u039F\u039B\u039F\u0393\u0399\u03A3\u039C\u039F\u03A3 \u03A4\u0399\u039C\u0397\u03A3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select price from pricelist where stop_weight='" +tf_varos.getText()+"and stop_kilometer="+tf_apostasi.getText()+"'";
					
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{		
						tf_timi.setText(rs.getString("price"));	
						
					}
					pst.close();
					String query2="update packages set pack_price='"+tf_timi.getText()+"where pack_ID="+tf_pack_id.getText();
					PreparedStatement pst2=connection.prepareStatement(query);
					ResultSet rs2=pst2.executeQuery();
					

				}catch(Exception e) {
					e.printStackTrace();
				
				}
			}
		});
		btnNewButton_1.setBounds(1558, 744, 159, 23);
		contentPane.add(btnNewButton_1);
		
		tf_timi = new JTextField();
		tf_timi.setBounds(1558, 713, 159, 20);
		contentPane.add(tf_timi);
		tf_timi.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u03A4\u0399\u039C\u0397");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_10.setBounds(1608, 688, 70, 14);
		contentPane.add(lblNewLabel_10);
	}
	
}


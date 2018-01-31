package transport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import java.util.Date;
import com.toedter.calendar.JDateChooser;
public class insert_apostolea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_apostolea frame = new insert_apostolea();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTable table;
	private JTable table_apostolea;
	private JTable table_paralipti;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField tf_kila;
	private JTextField tf_apostasi;
	private JTextField tf_dateparalavi;
	private JTextField tf_date_siskeyasia;
	private JTextField tf_dateapostoli;
	private JTextField tf_dateparadosi;
	private JLabel lblNewLabel_1;
	private JTextField id_apostolea;
	private JTextField id_paralipti;
	public String id;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	
	/**
	 * Create the frame.
	 */
	public insert_apostolea() {
		
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0395\u039C\u03A6\u0391\u039D\u0399\u03A3\u0397 \u03A0\u0395\u039B\u0391\u03A4\u03A9\u039D");
		btnNewButton.setBounds(39, 16, 145, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String Query=" select * from customers ";
					
					PreparedStatement pst=connection.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_apostolea.setModel(DbUtils.resultSetToTableModel(rs));
				}  catch (Exception e1) {
					e1.printStackTrace();
				}
				
			try {
				String Query=" select * from customers ";
				PreparedStatement pst=connection.prepareStatement(Query);
				ResultSet rs2=pst.executeQuery();
				table_paralipti.setModel(DbUtils.resultSetToTableModel(rs2));
			}  catch (Exception e1) {
				e1.printStackTrace();
			}
			}
				
			
		});
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(75, 85, 0, 46);
		contentPane.add(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 85, 483, 634);
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.add(scrollPane_1);
		
		table_apostolea = new JTable();
		table_apostolea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table_apostolea.getSelectedRow();
					String pelatis2_id=(table_apostolea.getModel() .getValueAt(row, 0)).toString();
					String query ="select * from customers where pelatis_id="+pelatis2_id;
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						while(rs.next())
						{	
							id_apostolea.setText(rs.getString("pelatis_id"));}
							
				pst.close();
				}catch (Exception ex) {
			ex.printStackTrace();
			
		}
				
			}
		});
		scrollPane_1.setViewportView(table_apostolea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 85, 483, 634);
		contentPane.add(scrollPane);
		
		table_paralipti = new JTable();
		table_paralipti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=table_paralipti.getSelectedRow();
					String pelatis_id=(table_paralipti.getModel() .getValueAt(row, 0)).toString();
					String query ="select * from customers where pelatis_id="+pelatis_id;
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						while(rs.next())
						{	
							id_paralipti.setText(rs.getString("pelatis_id"));}
				pst.close();
				
		}catch (Exception ei) {
			ei.printStackTrace();
		}
			}
		});
		scrollPane.setViewportView(table_paralipti);
		
		JLabel jlabelapostolea = new JLabel("\u0391\u03A0\u039F\u03A3\u03A4\u039F\u039B\u0395\u0391\u03A3");
		jlabelapostolea.setBounds(112, 48, 179, 24);
		jlabelapostolea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(jlabelapostolea);
		
		JLabel lblNewLabel = new JLabel("\u03A0\u0391\u03A1\u0391\u039B\u0397\u03A0\u03A4\u0397\u03A3");
		lblNewLabel.setBounds(664, 48, 203, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblNewLabel);
		
		tf_kila = new JTextField();
		tf_kila.setBounds(1043, 111, 86, 20);
		contentPane.add(tf_kila);
		tf_kila.setColumns(10);
		
		tf_apostasi = new JTextField();
		tf_apostasi.setBounds(1043, 195, 86, 20);
		contentPane.add(tf_apostasi);
		tf_apostasi.setColumns(10);
		
		tf_dateparalavi = new JTextField();
		tf_dateparalavi.setBounds(1043, 321, 86, 20);
		tf_dateparalavi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			 	
				
				
			}
		});
		contentPane.add(tf_dateparalavi);
		tf_dateparalavi.setColumns(10);
		
		tf_date_siskeyasia = new JTextField();
		tf_date_siskeyasia.setBounds(1043, 377, 86, 20);
		contentPane.add(tf_date_siskeyasia);
		tf_date_siskeyasia.setColumns(10);
		
		tf_dateapostoli = new JTextField();
		tf_dateapostoli.setBounds(1043, 437, 86, 20);
		contentPane.add(tf_dateapostoli);
		tf_dateapostoli.setColumns(10);
		
		tf_dateparadosi = new JTextField();
		tf_dateparadosi.setBounds(1043, 497, 86, 20);
		contentPane.add(tf_dateparadosi);
		tf_dateparadosi.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u0392\u0391\u03A1\u039F\u03A3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(1043, 74, 86, 26);
		contentPane.add(lblNewLabel_1);
		
		id_apostolea = new JTextField();
		id_apostolea.setEditable(false);
		id_apostolea.setBounds(1043, 671, 86, 20);
		contentPane.add(id_apostolea);
		id_apostolea.setColumns(10);
		
		id_paralipti = new JTextField();
		id_paralipti.setEditable(false);
		id_paralipti.setBounds(1043, 699, 86, 20);
		contentPane.add(id_paralipti);
		id_paralipti.setColumns(10);
		
		btnNewButton_1 = new JButton("\u039A\u0391\u03A4\u0391\u03A7\u03A9\u03A1\u0397\u03A3\u0397");
		btnNewButton_1.setBounds(1040, 602, 135, 58);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String query="insert into packages(apostoleas,paraliptis,weight,kilometer,date_paralavi,date_siskeyasias,date_apostolis,date_paradosis) values(?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1,id_apostolea.getText());
					pst.setString(2,id_paralipti.getText());
					pst.setString(3,tf_kila.getText());
					pst.setString(4,tf_apostasi.getText());
					pst.setString(5,tf_dateparalavi.getText());
					pst.setString(6,tf_date_siskeyasia.getText());
					pst.setString(7,tf_dateapostoli.getText());
					pst.setString(8, tf_dateparadosi.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					pst.close();
				}catch (Exception e) {
					e.printStackTrace();
					
				}
				
			}
			
		});
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("\u03A7\u0399\u039B\u0399\u039F\u039C\u0395\u03A4\u03A1\u0391");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setBounds(1040, 152, 166, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A0\u0391\u03A1\u0391\u039B\u0391\u0392\u0397\u03A3");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(1013, 296, 239, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A0\u0391\u03A1\u0391\u0394\u039F\u03A3\u0397\u03A3");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(1013, 352, 183, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u0391\u03A0\u039F\u03A3\u03A4\u039F\u039B\u0397\u03A3");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setBounds(1013, 412, 183, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u0397\u039C\u0395\u03A1\u039F\u039C\u0397\u039D\u0399\u0391 \u03A0\u0391\u03A1\u0391\u0394\u039F\u03A3\u0397\u03A3");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7.setBounds(1013, 472, 182, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("dd/mm/yyyy");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_8.setBounds(1043, 265, 132, 20);
		contentPane.add(lblNewLabel_8);
	}
}


			



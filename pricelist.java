package transport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pricelist extends JFrame {

	private JPanel contentPane;
	private JTable table_pricelist;
	private JTextField tf_kstart;
	private JTextField tf_kstop;
	private JTextField tf_wstart;
	private JTextField tf_wstop;
	private JTextField tf_price;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pricelist frame = new pricelist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JButton update;
	private JTextField tf_price_ID;
	private JButton btnNewButton_2;
	/**
	 * Create the frame.
	 */
	public pricelist() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 802, 436);
		contentPane.add(scrollPane);
		
		JScrollPane table_ = new JScrollPane();
		scrollPane.setViewportView(table_);
		
		table_pricelist = new JTable();
		table_pricelist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {try {
				int row=table_pricelist.getSelectedRow();
				String pelatis2_id=(table_pricelist.getModel() .getValueAt(row, 0)).toString();
				String query ="select * from pricelist where price_id="+pelatis2_id;
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					tf_kstart.setText(rs.getString("start_weight"));
					tf_kstop.setText(rs.getString("stop_weight"));
					tf_wstart.setText(rs.getString("start_kilometer"));
					tf_wstop.setText(rs.getString("stop_kilometer"));
					tf_price.setText(rs.getString("price"));
					tf_price_ID.setText(rs.getString("price_ID"));
					
				
			
				}pst.close();
			}catch (Exception ex) {
				ex.printStackTrace();
				}
			}
		});
		table_.setViewportView(table_pricelist);
		
		tf_kstart = new JTextField();
		tf_kstart.setBounds(162, 38, 86, 20);
		contentPane.add(tf_kstart);
		tf_kstart.setColumns(10);
		
		tf_kstop = new JTextField();
		tf_kstop.setBounds(326, 38, 86, 20);
		contentPane.add(tf_kstop);
		tf_kstop.setColumns(10);
		
		tf_wstart = new JTextField();
		tf_wstart.setBounds(162, 86, 86, 20);
		contentPane.add(tf_wstart);
		tf_wstart.setColumns(10);
		
		tf_wstop = new JTextField();
		tf_wstop.setBounds(326, 86, 86, 20);
		contentPane.add(tf_wstop);
		tf_wstop.setColumns(10);
		
		tf_price = new JTextField();
		tf_price.setBounds(484, 60, 128, 20);
		contentPane.add(tf_price);
		tf_price.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0391\u03A0\u039F\u03A3\u03A4\u0391\u03A3\u0397");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 41, 128, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0392\u0391\u03A1\u039F\u03A3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 89, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0391\u03A0\u039F");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(180, 13, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0395\u03A9\u03A3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(340, 13, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u03A4\u0399\u039C\u0397");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(506, 41, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("\u0395\u039C\u03A6\u0391\u039D\u0399\u03A3\u0397 \u03A4\u0399\u039C\u03A9\u039D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Query=" select * from pricelist ";
					
					PreparedStatement pst=connection.prepareStatement(Query);
					ResultSet rs=pst.executeQuery();
					table_pricelist.setModel(DbUtils.resultSetToTableModel(rs));
				}  catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(652, 12, 160, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u039A\u0391\u03A4\u0391\u03A7\u03A9\u03A1\u0397\u03A3\u0397");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
					String query="insert into pricelist(start_weight,stop_weight,start_kilometer,stop_kilometer,price) values(?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1,tf_wstart.getText());
					pst.setString(2,tf_wstop.getText());
					pst.setString(3,tf_kstart.getText());
					pst.setString(4,tf_kstop.getText());
					pst.setString(5,tf_price.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					String query1="select * from pricelist";
					PreparedStatement pst1=connection.prepareStatement(query1);
					pst1.executeQuery();
					ResultSet rs=pst1.executeQuery();
					table_pricelist.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				}catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton_1.setBounds(652, 37, 160, 23);
		contentPane.add(btnNewButton_1);
		
		update = new JButton("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="update pricelist set start_weight='"+tf_wstart.getText()+"',stop_weight='"+tf_wstop.getText()+"',start_kilometer='"+tf_kstart.getText()+"',stop_kilometer='"+tf_kstop.getText()+"',price='"+tf_price.getText()+"'where price_ID='"+tf_price_ID.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data updated");
					String Query="select * from pricelist";
					PreparedStatement pst2=connection.prepareStatement(Query);
					ResultSet rs=pst2.executeQuery();
					table_pricelist.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					e.printStackTrace();
				
				}
		}
			
		});
		update.setBounds(652, 114, 160, 23);
		contentPane.add(update);
		
		tf_price_ID = new JTextField();
		tf_price_ID.setEditable(false);
		tf_price_ID.setBounds(10, 11, 56, 20);
		contentPane.add(tf_price_ID);
		tf_price_ID.setColumns(10);
		
		btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String query="delete from pricelist where price_ID="+tf_price_ID.getText();
				PreparedStatement pst=connection.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null,"Data deleted ");
				String Query="select * from pricelist";
				PreparedStatement pst2=connection.prepareStatement(Query);
				ResultSet rs=pst2.executeQuery();
				table_pricelist.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					e.printStackTrace();
				
				}
				
			}
		});
		btnNewButton_2.setBounds(652, 138, 160, 23);
		contentPane.add(btnNewButton_2);
	}
}


package hotel.pro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Customerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Customerinfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 40, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(70, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(130, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(190, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(250, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(310, 10, 50, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin time");
        l7.setBounds(370, 10, 50, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(430, 10, 100, 20);
        add(l8);
        
        table=new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select *from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);
        
        setBounds(280,100,600,600);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
    new Customerinfo();
}


}

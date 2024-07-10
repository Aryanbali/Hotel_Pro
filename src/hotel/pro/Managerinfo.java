
package hotel.pro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Managerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Managerinfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(20, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(80, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(140, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Salary");
        l4.setBounds(200, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Phone");
        l5.setBounds(260, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(320, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(380, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Job");
        l8.setBounds(440, 10, 100, 20);
        add(l8);
        
        table=new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select *from employee where job = 'Manager'");
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
        
        setBounds(250,100,600,600);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
    new Managerinfo();
}


}

package hotel.pro;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        
         username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel Pass = new JLabel("Password");
        Pass.setBounds(40,70,100,30);
        add(Pass);
        
         password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
         login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
         cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(200, 200,);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(380,10,200,200);
        add(image);
        
       setBounds(350,200,600,300);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){        //this ActionEvent Class helps to identify which button has triggered login or cancel
        if (ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                Conn c = new Conn();
                String query ="select * from login where username = '"+user+"' and password = '"+pass+"'";
                
               ResultSet rs =  c.s.executeQuery(query);
               
               if(rs.next()){
                   setVisible(false);
                    new Dashboard();
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid  username or password");
                   setVisible(false);               //to close frame
               }
                
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

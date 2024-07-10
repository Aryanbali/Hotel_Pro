package hotel.pro;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class HotelPro extends JFrame implements ActionListener{
    
    HotelPro(){
        setSize(745, 1800);
        setLocation(100,100);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,745,1800);
        add(image);
        
        JLabel text = new JLabel("HOTEL PRO");
        text.setBounds(20, 600, 1200, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 600, 120, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,28));
        image.add(next);
        
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new HotelPro();
        
        
    }
    
}

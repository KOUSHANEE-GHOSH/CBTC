import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//jdbc connectivity
public class Home extends JFrame implements ActionListener {
    //constructor
    JButton login, exit, update;
    JTextField userin;
    JPasswordField  pwdin;
    Home(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        setTitle("Online Examination.java");

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/pic1.png"));
        JLabel i = new JLabel(image1);
        i.setBounds(0,0,250, 390);
        add(i);

        JLabel head = new JLabel("Exam Form");
        head.setBounds(600, 60, 300, 45);
        head.setFont(new Font("Mongolian Baiti", Font.BOLD, 50));
        add(head);

        JLabel username = new JLabel("Username: ");
        username.setBounds(609, 200, 300, 25);
        username.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(username);

        userin = new JTextField();
        userin.setBounds(750,200, 300,28);
        userin.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(userin);

        JLabel pwd = new JLabel("Password: ");
        pwd.setBounds(609, 290, 300, 25);
        pwd.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pwd);

        pwdin = new JPasswordField();
        pwdin.setBounds(750,290, 300,28);
        pwdin.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(pwdin);


        login = new JButton("Login");
        login.setBounds(600, 410, 120, 25);
        login.setBackground(Color.green);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        update = new JButton("Update");
        update.setBounds(800, 410, 120, 25);
        update.setBackground(Color.orange);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        exit = new JButton("Exit");
        exit.setBounds(1000, 410, 120, 25);
        exit.setBackground(Color.blue);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setSize(1260, 600);
        setLocation(5, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a){

            String str =  userin.getText();
            String str1 = "" + pwdin.getText();
            try {
                if(userin.equals("")){
                    JOptionPane.showMessageDialog(null, "Username is required");
                }else{
                    Conn c = new Conn();
                    String query = "insert into login values ('" + str + "', '" + str1 + "')";
                    c.s.executeUpdate(query);
                    new Login(str);
                }

            } catch (Exception e){
                System.out.println(e);
            }

        if (a.getSource() == exit){
            setVisible(false);
        }
        if (a.getSource() == update){
            setVisible(true);
            new Home();
        }
    }
    public static void main(String[] args){

        new Home(); //object
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener {
    String str;
    JButton logout, start;
    Login(String str){
        this.str=str;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        setTitle("Logged in.java");

        JLabel head = new JLabel("Welcome back " + str + "!");
        head.setBounds(20, 20, 700, 40);
        head.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        add(head);

        JLabel head1 = new JLabel("Are You Ready to Take your Test?");
        head1.setBounds(380, 90, 700, 40);
        head1.setFont(new Font("Gill Sans MT", Font.BOLD, 30));
        head1.setForeground(Color.BLUE);
        add(head1);

        JLabel head2 = new JLabel("Here are few rules to follow the test:");
        head2.setBounds(380, 150, 700, 40);
        head2.setFont(new Font("Rockwell", Font.BOLD, 20));
        head2.setForeground(Color.black);
        add(head2);

        JLabel rules = new JLabel();
        rules.setBounds(380, 200, 700, 200);
        rules.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        rules.setForeground(Color.red);
        rules.setText(
                "<html>"+
                        "1. You have to answer every question."+ "<br><br>"+
                        "2. You have to complete the test within the given timeframe." + "<br><br>"+
                        "3. You cannot pause or press back button during the test."+ "<br><br>"+
                        "4. If not submitted within the timeframe, your exam will be auto submitted."+"<br><br>"+
                        "<html>"
        );
        add(rules);

        JLabel head3 = new JLabel("All the best!");
        head3.setBounds(380, 390, 700, 40);
        head3.setFont(new Font("Rockwell", Font.BOLD, 20));
        head3.setForeground(Color.black);
        add(head3);

        setSize(1260, 600);
        setLocation(5, 30);
        setVisible(true);

        logout = new JButton("Logout");
        logout.setBounds(1100, 20, 120, 25);
        logout.setBackground(Color.red);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);

        start = new JButton("Start");
        start.setBounds(380, 480, 500, 30);
        start.setBackground(Color.darkGray);
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == logout){
            new Home();
            setVisible(false);
        }
        if (ae.getSource() == start){
            setVisible(false);
            new Exam(str);
        } else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){

        new Login("User");
    }
}

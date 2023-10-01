import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener {
    JButton ep;

    Score(String str, int score){
        setBounds(5, 30, 1260, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        setTitle("Score.java");

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/pic1.png"));
        JLabel i2 = new JLabel(image2);
        i2.setBounds(0,0,250, 390);
        add(i2);

        JLabel head = new JLabel("Thank You " + str + " for giving the Exam.");
        head.setBounds(380 ,100, 800 , 40);
        head.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        add(head);

        JLabel res = new JLabel("Your Score is: " + score);
        res.setBounds(380 ,200, 800 , 40);
        res.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        add(res);

        ep = new JButton("Exit");
        ep.setBounds(1000, 450, 200, 40);
        ep.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ep.setBackground(Color.blue);
        ep.setForeground(Color.white);
        ep.addActionListener(this);
        add(ep);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ep){
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}

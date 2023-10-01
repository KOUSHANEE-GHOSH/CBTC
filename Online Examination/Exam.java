import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam extends JFrame implements ActionListener {

    String ques[][] = new String[5][5];
    String ans[][] = new String[5][2];
    String check[][] = new String [5][1];

    JLabel num, q;
    JRadioButton ob1, ob2, ob3, ob4;
    ButtonGroup grp;
    JButton ne, submit;
    public static int timer = 15;
    public static int given = 0;
    public static int c =0;
    public static int score =0;

    String str;

    Exam(String str){
        this.str =str;
        setBounds(5, 30, 1260, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        setTitle("Examination.java");

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/pic1.png"));
        JLabel i2 = new JLabel(image2);
        i2.setBounds(0,0,250, 390);
        add(i2);

        num = new JLabel();
        num.setBounds(380 ,100, 300 , 40);
        num.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        add(num);

        q = new JLabel();
        q.setBounds(450 ,100, 1260 , 40);
        q.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        add(q);

        ques[0][0] = "Total constructor string class have?";
        ques[0][1] = "3";
        ques[0][2] = "7";
        ques[0][3] = "13";
        ques[0][4] = "20";

        ques[1][0] = "To which of the following does the class string belong to?";
        ques[1][1] = "java.lang";
        ques[1][2] = "java.awt";
        ques[1][3] = "java.applet";
        ques[1][4] = "java.string";

        ques[2][0] = "Which package contains the Random class?";
        ques[2][1] = "java.util package";
        ques[2][2] = "java.lang package";
        ques[2][3] = "java.awt package";
        ques[2][4] = "java.io package";

        ques[3][0] = "compareTo() returns?";
        ques[3][1] = "True";
        ques[3][2] = "False";
        ques[3][3] = "An int value";
        ques[3][4] = "None";

        ques[4][0] = "In which of the following is toString() method defined?";
        ques[4][1] = "java.lang.Object";
        ques[4][2] = "java.lang.String";
        ques[4][3] = "java.lang.util";
        ques[4][4] = "None";



        ans[0][1] = "13";
        ans[1][1] = "java.lang";
        ans[2][1] = "java.util package";
        ans[3][1] = "An int value";
        ans[4][1] = "java.lang.Object";

        ob1 = new JRadioButton();
        ob1.setBounds(450, 200,700, 50);
        ob1.setBackground(Color.white);
        ob1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ob1);

        ob2 = new JRadioButton();
        ob2.setBounds(450, 240,700, 50);
        ob2.setBackground(Color.white);
        ob2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ob2);

        ob3 = new JRadioButton();
        ob3.setBounds(450, 280,700, 50);
        ob3.setBackground(Color.white);
        ob3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ob3);

        ob4 = new JRadioButton();
        ob4.setBounds(450, 320,700, 50);
        ob4.setBackground(Color.white);
        ob4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(ob4);

        grp = new ButtonGroup();
        grp.add(ob1);
        grp.add(ob2);
        grp.add(ob3);
        grp.add(ob4);

        ne = new JButton("Click Next");
        ne.setBounds(450, 450, 200, 40);
        ne.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ne.setBackground(Color.BLUE);
        ne.setForeground(Color.WHITE);
        ne.addActionListener(this);
        add(ne);

        submit = new JButton("Submit");
        submit.setBounds(1000, 450, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 25));
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(c);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ne){
            repaint();
            given = 1;

            if(grp.getSelection() == null){
                check[c][0] = "";
            }else{
                check[c][0] = grp.getSelection().getActionCommand();
            }
            if(c == 3){
                ne.setEnabled(false);
                submit.setEnabled(true);
            }
            c++;
            start(c);
        } else if(ae.getSource() == submit){
            given = 1;
            if (grp.getSelection() == null) {
                check[c][0] = "";
            } else {
                check[c][0] = grp.getSelection().getActionCommand();
            }
            for (int i = 0; i<check.length; i++){
                if(check[i][0].equals(ans[i][1])){
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(str, score);
        }
    }

    public void paint(Graphics gh){
        super.paint(gh);
        String t = "Time : " + timer + " seconds left"; //15
        gh.setColor(Color.red);
        gh.setFont(new Font("Times New Roman", Font.BOLD, 20));

        if(timer>0){
            gh.drawString(t, 1010, 90);
        }else {
            gh.drawString("Times UP!", 1010, 90);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(given == 1){
            given = 0;
            timer = 15;
        }else if(timer < 0){
            timer =15;
            if(c == 8){
                ne.setEnabled(false);
                submit.setEnabled(true);
            }
            if(c ==9 ) {
                if (grp.getSelection() == null) {
                    check[c][0] = "";
                } else {
                    check[c][0] = grp.getSelection().getActionCommand();
                }
                for (int i = 0; i<check.length; i++){
                    if(check[i][0].equals(ans[i][1])){
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(str, score);
            }else {
                if (grp.getSelection() == null) {
                    check[c][0] = "";

                } else {
                    check[c][0] = grp.getSelection().getActionCommand();
                }
                c++;
                start(c);
            }
        }
    }
    public void start (int c) {
        num.setText("" + (c + 1) + ". ");
        q.setText(ques[c][0]);
        ob1.setText(ques[c][1]);
        ob1.setActionCommand(ques[c][1]);
        ob2.setText(ques[c][2]);
        ob2.setActionCommand(ques[c][2]);
        ob3.setText(ques[c][3]);
        ob3.setActionCommand(ques[c][3]);
        ob4.setText(ques[c][4]);
        ob4.setActionCommand(ques[c][4]);
        grp.clearSelection();
    }
    public static void main(String[] args){
        new Exam("User");
    }

}

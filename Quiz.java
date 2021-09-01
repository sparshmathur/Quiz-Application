package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JButton next, Submit, lifeline;
    public static int count = 0;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int score = 0;
    JLabel qno, question;
    JRadioButton op1, op2, op3, op4;
    String q[][] = new String[10][5];
    String pa[][] = new String[10][1];
    String qa[][] = new String[10][2];
    ButtonGroup options;
    String username;

    Quiz(String username) {
        this.username = username;
        setBounds(250, 50, 1440, 950);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("practice/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1440, 392);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setBounds(100, 450, 50, 30);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setBounds(150, 450, 900, 30);
        add(question);

        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        qa[0][1] = "JDB";
        qa[1][1] = "int";
        qa[2][1] = "java.util package";
        qa[3][1] = "Marker Interface";
        qa[4][1] = "Heap memory";
        qa[5][1] = "Remote interface";
        qa[6][1] = "import";
        qa[7][1] = "Java Archive";
        qa[8][1] = "java.lang.StringBuilder";
        qa[9][1] = "Bytecode is executed by JVM";


        op1 = new JRadioButton("");
        op1.setBounds(170, 520, 700, 30);
        op1.setFont(new Font("Dialog", Font.PLAIN, 20));
        op1.setBackground(Color.WHITE);
        add(op1);

        op2 = new JRadioButton("");
        op2.setBounds(170, 560, 700, 30);
        op2.setFont(new Font("Dialog", Font.PLAIN, 20));
        op2.setBackground(Color.WHITE);
        add(op2);

        op3 = new JRadioButton("");
        op3.setBounds(170, 600, 700, 30);
        op3.setFont(new Font("Dialog", Font.PLAIN, 20));
        op3.setBackground(Color.WHITE);
        add(op3);

        op4 = new JRadioButton("");
        op4.setBounds(170, 640, 700, 30);
        op4.setFont(new Font("Dialog", Font.PLAIN, 20));
        op4.setBackground(Color.WHITE);
        add(op4);

        options = new ButtonGroup();
        options.add(op1);
        options.add(op2);
        options.add(op3);
        options.add(op4);

        lifeline = new JButton("50-50 lifeline");
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.setBounds(1100, 550, 200, 40);
        lifeline.addActionListener(this);
        add(lifeline);

        next = new JButton("Next");
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBounds(1100, 630, 200, 40);
        add(next);

        Submit = new JButton("Submit");
        Submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Submit.setEnabled(false);
        Submit.setBackground(new Color(30, 144, 255));
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setBounds(1100, 710, 200, 40);
        add(Submit);

        start(0);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            ans_given = 1;
            if(options.getSelection()==null){
                pa[count] [0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }
            if(count==8){
                next.setEnabled(false);
                Submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == Submit) {
            ans_given=1;
            if(options.getSelection()==null){
                pa[count] [0] = "";
            }else {
                pa[count][0] = options.getSelection().getActionCommand();
            }
            for(int i =0 ; i<pa.length; i++){
                if(pa[i][0].equals(qa[i][1])){
                    score+=10;
                }else {
                    score+=0;
                }
            }
            this.setVisible(false);
            new Score(username, score).setVisible(true);

        } else if (ae.getSource() == lifeline) {
            if(count ==2 || count ==4 || count==6 || count==8 || count==9){
                op2.setEnabled(false);
                op3.setEnabled(false);
            }
            else {
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left - " + timer+" seconds";
        g.setColor(Color.blue);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if(timer > 0){
            g.drawString(time,1100,500);
        }
        else{
            g.drawString("Oops Times up!!",1100,500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ans_given ==1) {
            ans_given =0;
            timer = 15;
        }else if(timer<0){
            timer = 15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);

            if(count==8){
                next.setEnabled(false);
                Submit.setEnabled(true);
            }
            if(count ==9){
                if(options.getSelection()==null){
                    pa[count] [0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                for(int i =0 ; i<pa.length; i++){
                    if(pa[i][0].equals(qa[i][1])){
                        score+=10;
                    }else {
                        score+=0;
                    }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            }else{
                if(options.getSelection()==null){
                    pa[count] [0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(q[count][0]);
        op1.setLabel(q[count][1]);
        op1.setActionCommand(q[count][1]);
        op2.setLabel(q[count][2]);
        op2.setActionCommand(q[count][2]);
        op3.setLabel(q[count][3]);
        op3.setActionCommand(q[count][3]);
        op4.setLabel(q[count][4]);
        op4.setActionCommand(q[count][4]);
        options.clearSelection();

    }

    public static void main(String[] args) {
        new Quiz("").setVisible(true);
    }
}
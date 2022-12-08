package affichage;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.Random;
import listener.*;
public class Recever{
JButton ok=new JButton();
JLabel error=new JLabel();
    public Recever()throws Exception{
        this.formulera();
    }
    public JButton get_jb(){
        return this.ok;
    }
    public void set_error(String error){
        this.error.setText(error);
    }

	public JFrame formulera()throws Exception{
        JFrame jdp=new JFrame();
        jdp.setVisible(true);
        jdp.setSize(425,300);
        jdp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdp.setResizable(false);
        jdp.setLayout(null);
        int size=2;
        String[] attribut=new String[size];
        for (int a=0;a<attribut.length;a++) {
            attribut[a]=new String();
        }
            attribut[0]="Port";
            attribut[1]="Personne";
        JTextField[] formulaire=new JTextField[size];
        JLabel[] title=new JLabel[size];
        int x=10;
        int y=100;
        for (int index=0;index<size;index++) {
            title[index]=new JLabel();
            title[index].setBounds(x,y,50,25);
                formulaire[index]=new JTextField();
                formulaire[index].setBounds(x+50,y,250,25);
                title[index].setText(attribut[index]);
            jdp.add(title[index]);
            jdp.add(formulaire[index]);
                y=y+50;
        }
        Lis_sv volavo=new Lis_sv(formulaire,this);
        ok.setBounds(130,20,100,25);
        ok.setText("Receive");
        ok.addActionListener(volavo);
        jdp.add(ok);
        JLabel m=new JLabel();
        m.setText("Message:");
        m.setBounds(10,150,100,100);
        jdp.add(m);
        error.setBounds(135,150,100,100);
        jdp.add(error);
        return jdp;
    }
}
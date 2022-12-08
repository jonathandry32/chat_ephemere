package affichage;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.Random;
import listener.*;
import outil.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Forima_s extends JPanel{
JButton ok=new JButton();
JLabel error=new JLabel();
    public Forima_s()throws Exception{
        JFrame a=this.formulera();
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
        jdp.setSize(200,200);
        jdp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdp.setResizable(false);
        jdp.setLayout(null);
        JLabel m=new JLabel();
        m.setText("Serveur en cours:");
        m.setBounds(10,10,150,50);
        jdp.add(m);
        set_error("0 clients en ligne");
        error.setBounds(10,25,150,50);
        jdp.add(error);
        ok=new JButton("OK");
        ok.setBounds(10,100,100,25);
        ok.addActionListener(new Ecouteur_s(this));
        jdp.add(ok);
        return jdp;
    }
}
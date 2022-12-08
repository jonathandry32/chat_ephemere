package affichage;
import java.awt.*;
import javax.swing.*;
import outil.*;
import listener.*;

public class Forima extends JPanel{
    Groupy thisFrame;
    JTextField texte;
    JTextArea txt;
    JButton jb=new JButton();
    public Forima(Groupy fr){
        this.thisFrame=fr;
    }
    public Groupy get_frame(){
        return this.thisFrame;
    }

    public JTextArea getTxt() {
        return txt;
    }
    public JButton get_jb(){
        return this.jb;
    }
    public void setTxt(JTextArea txt) {
        this.txt = txt;
    }
    public JTextField getTexte(){
        return this.texte;
    }
    public JPanel anarana(){
        JPanel result=new JPanel();
        result.setBackground(Color.GREEN);
        result.setLayout(null);
        int x=10;
        int y=10;
        int width=100;
        int height=50;
        JLabel legend=new JLabel("Iza ihanao? ");
        legend.setBounds(x,y,width,height);
        result.add(legend);
        this.texte=new JTextField();
        texte.setBounds(width,y,width*2,height);
        result.add(texte);
        y+=height+5;
        jb=new JButton("Eny");
        jb.setFocusable(false);
        jb.setBounds((width*3+x)/3,y,width,height/2);
        jb.addActionListener(new Ecouteur(this));
        result.add(jb);
        result.setPreferredSize(new Dimension(width*3+x,y/2+y/4+height));
        return result;
    }
    public JPanel sera(Clients client){
        JPanel result=new JPanel();
        result.setBackground(Color.GREEN);
        result.setLayout(null);
        int x=10;
        int y=10;
        int width=100;
        int height=50;
        txt=new JTextArea();
        txt.setBounds(x,y,width*4,height*5);
        result.add(txt);
        txt.setEditable(false);
        y+=txt.getHeight()+5;
        texte=new JTextField();
        texte.setBounds(x,y,width*3,height/2);
        result.add(texte);
        jb=new JButton("Alefa");
        jb.setBounds(texte.getWidth()+12,y,width,height/2);
        jb.addActionListener(new Ecouteur(this,client));
        result.add(jb);
        result.setPreferredSize(new Dimension(txt.getWidth()+20,y+texte.getHeight()+7));
        client.listenForMessage(this);
        return result;
    }
}
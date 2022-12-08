package listener;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.reflect.*;
import affichage.*;
import outil.*;
public class Lis_sv implements ActionListener{
JTextField[] jtf_log;
Recever rec;
Serveur serv;
ServerSocket ss;
	public Lis_sv(JTextField[] jtf_log,Recever rec)throws Exception{
		this.jtf_log=jtf_log;
		this.rec=rec;
	}

	public void actionPerformed(ActionEvent e){
		try{
			if (e.getSource()==rec.get_jb()) {
				out_vide(jtf_log[0].getText());
				out_vide(jtf_log[1].getText());
			/*
				InetAddress local=InetAddress.getLocalHost();
				ServerSocket ss=new ServerSocket(serv.get_port(),3,local);
			*/
				if (serv==null||ss==null) {
					serv=new Serveur(Integer.valueOf(jtf_log[0].getText()));
					ss=new ServerSocket(serv.get_port());
				}
				Socket s=serv.connect_client(ss);
				Thread getm=new Thread(new Runnable(){
					public void run(){
						String mess;
						try{	
							DataInputStream isr=new DataInputStream(s.getInputStream());
							mess=isr.readUTF();
							while(mess!=null){
								rec.set_error(mess);
								System.out.println(mess);
								break;
							}
							String[] part=jtf_log[1].getText().split("-");
							int count=0;
							for (int a=0;a<part.length;a++) {
								if(mess.split(":")[0].equalsIgnoreCase(part[a])){
									count++;
								}	
							}
							if(count==0){
								rec.set_error("It's a private message");
							}
							isr.close();
							s.close();
						}
						catch(Exception e){}
					}
				});
				getm.start();
			}
		}
		catch(Exception ex){
			rec.set_error(ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}

	public void out_vide(String alt)throws Exception{
		if (alt.equals("")||alt.equals(" ")) {
			throw new Exception("veuillez remplir les champs");
		}
	}
}
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Escritor {

	static Socket[] sockets = new Socket[3];	
	static DataOutputStream[] dos = new DataOutputStream[3];
	static DataInputStream[] dis =  new DataInputStream[3];

	public static void main(String[] args) throws IOException {

		try {
			int porta[] = {6789, 6790, 6791};
			String[] ip = {"localhost", "localhost", "localhost"}; 
			for (int i=0; i<3; i++) {
				sockets[i] = new Socket(ip[i], porta[i]);
				System.out.println("Conectado com IP: "+ ip[i] + " - Porta: "+porta[i]);
				System.out.println("Conectado ao Servidor!");
				DataOutputStream dop = new DataOutputStream(sockets[i].getOutputStream());
				dos[i] = dop;
			}

			String mensagem = "";
			do {
				mensagem = JOptionPane.showInputDialog("Mensagem: ");
				for(int i=0; i<3; i++){
					dos[i].writeUTF(mensagem);
				}

			} while(!mensagem.equalsIgnoreCase("sair"));

		} catch (IOException ex) {
			
		}
		
		for(int i=0; i<3; i++){
			sockets[i].close();
		}
	}
}

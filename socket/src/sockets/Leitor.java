package sockets;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Leitor {

	public static void main(String[] args) throws IOException {
		
		DataInputStream in;
		Socket listenSocket = null;
		ServerSocket serverSocket = null;

		try {
			String portaString = JOptionPane.showInputDialog("Porta: ");
			int porta = Integer.parseInt(portaString);
			serverSocket = new ServerSocket(porta);
			Janela janela = new Janela(portaString);
			janela.adicionaTexto("Aguardando conexão...");
			listenSocket = serverSocket.accept();
			janela.adicionaTexto("Cliente conectado!");
			in = new DataInputStream(listenSocket.getInputStream());
			String mensagem = "";
			
			do {
				mensagem = in.readUTF();
				janela.adicionaTexto(mensagem);
			} while(!mensagem.equalsIgnoreCase("sair"));
	
			janela.dispose();
	
		} catch(EOFException e) {
			System.out.println(e.getMessage());
		}
		serverSocket.close();
		listenSocket.close();
	}
}
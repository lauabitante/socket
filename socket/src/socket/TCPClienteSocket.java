package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TCPClienteSocket {

    public static void main(String[] args) {
        Socket socketCliente = null;
        try {
        	//instancia socketcliente / canal de comunicação -  na porta 6789 - agora ele existe
            socketCliente = new Socket("192.168.1.237", 6789);
            System.out.println("Conectado ao Servidor!");
            //cliente escreve no buffer
            DataInputStream dis = new DataInputStream(
                    socketCliente.getInputStream());
            //cliente escreve oq vai enviar para o servidor, o servidor fara algo e devolverá
            DataOutputStream dos = new DataOutputStream(
                    socketCliente.getOutputStream());
            
            String nome = JOptionPane.showInputDialog("Nome: ");
            dos.writeUTF(nome);
            System.out.println("Enviando "+nome);
            
            String mensagem = dis.readUTF();
            System.out.println("Mensagem recebida: "+mensagem);
            JOptionPane.showMessageDialog(null, mensagem);
            
            
        } catch (IOException ex) {
            Logger.getLogger(TCPClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if(socketCliente != null)
                    socketCliente.close();
            } catch (IOException ex) {
                Logger.getLogger(TCPClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

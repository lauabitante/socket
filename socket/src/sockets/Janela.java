package sockets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Janela extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextArea textoArea;

    public Janela() {
        super("Janela do Escritor");
        setBounds(100, 100, 400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciaComponentes();
        Janela.this.setVisible(true);
    }
    
    public Janela(String nome) {
        this();
        this.setTitle(nome);
    }    

    private void iniciaComponentes() {
        textoArea = new JTextArea();
        this.add(new JScrollPane(textoArea));
    }

    public void adicionaTexto(String texto) {
        textoArea.append(texto + "\n");
    }

    public void limpaTexto() {
        textoArea.setText("");
    }
}
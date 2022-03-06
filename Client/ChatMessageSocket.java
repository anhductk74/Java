package Client;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatMessageSocket {
    private Socket socket;
    private JTextPane txpMess;
    private PrintWriter out;
    private BufferedReader reader;

    public ChatMessageSocket(Socket socket, JTextPane txpMess) throws IOException {
        this.socket = socket;
        this.txpMess = txpMess;

        out  = new PrintWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        receive();
    }
    private void receive() {
        Thread th = new Thread() {
            public void run() {
                while (true) {
                    try {
                        String line = reader.readLine();
                        if(line != null){
                            txpMess.setText(txpMess.getText()+ "\nFriend: "+line);
                        }
                    } catch (Exception e){

                    }
                }
            }
        };
        th.start();
    }
    public void send(String msg){
        String current = txpMess.getText();
        txpMess.setText(current+"\nYou: "+msg);
        out.println(msg);
        out.flush();
    }
    public void close(){
        try{
            out.close();
            reader.close();
            socket.close();
        } catch(Exception e){

        }
    }
}

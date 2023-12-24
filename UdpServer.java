import java.io.*;
import java.net.*;

public class UdpServer {
    public static void main(String[] args) throws IOException{
        DatagramSocket serverSocket = new DatagramSocket(1234);
        
        try{
        byte message[] = new byte[255];
        DatagramPacket dp = new DatagramPacket(message, message.length);
        while (true) {
            serverSocket.receive(dp);
            System.out.print("RECEIVED: ");
            System.out.println(new String(dp.getData()));
            if(new String(dp.getData()).contains("bye")){
                
                DatagramPacket resp = new DatagramPacket(new byte[]{'s','e','e',' ','y','a'}, 6, dp.getSocketAddress());
                serverSocket.send(resp);
            }else{
            DatagramPacket resp = new DatagramPacket(new byte[]{'o','k'}, 2, dp.getSocketAddress());
                serverSocket.send(resp);
                
            }
        }
        }catch(Exception e){
            e.printStackTrace();
            serverSocket.close();    
        }
    }
}

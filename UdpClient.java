import java.net.*;
import java.io.*;

public class UdpClient {

    public static void main(String args[])throws SocketException,IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        DatagramSocket clientSocket = new DatagramSocket();
        try{
        while (true) {
            byte message[] = br.readLine().getBytes();
            DatagramPacket packet = new DatagramPacket(message, message.length,InetAddress.getLocalHost(),1234);
            clientSocket.send(packet);
            byte respbyte[] = new byte[255];
            DatagramPacket response = new DatagramPacket(respbyte,respbyte.length);
            clientSocket.receive(response);
            if(new String(respbyte).equalsIgnoreCase("terminated")){
                System.out.println("ALRIGHT TERMINATED");
            }else{
                System.out.println(new String(respbyte));
            }
        }}catch(Exception e){
            e.printStackTrace();
            clientSocket.close();
        }
    }
}
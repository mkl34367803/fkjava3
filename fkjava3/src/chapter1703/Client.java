package chapter1703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("127.0.0.1",30000);
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=br.readLine();
		System.out.println("���Է����������ݣ�"+line);
		br.close();
		socket.close();
	}
}

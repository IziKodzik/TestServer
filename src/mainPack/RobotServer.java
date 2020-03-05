package mainPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

public class RobotServer {

	ServerSocket socket;

	public RobotServer(int port) throws IOException {

		socket = new ServerSocket(port);

	}

	public void beginAccepting(){

		while (true){

			try {

				System.out.println("Waiting...");
				Socket client = socket.accept();
				Handeling handeling = new Handeling(client);
				new Thread(handeling).start();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	class Handeling
		implements Runnable{

		Socket s;

		public Handeling(Socket socket){

			s = socket;

		}

		@Override
		public void run(){

			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

				while (true) {

					try {
						String str = in.readLine();
						if(str!= null)
							System.out.println(str);
						else
							break;
					}catch (IOException ex){
						break;
					}
				}
			}catch (IOException e){
			}

		}
	}

}

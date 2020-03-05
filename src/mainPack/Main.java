package mainPack;

import java.io.IOException;

public
	class Main {

	public static void main(String[] args){

		try {

			RobotServer server = new RobotServer(2137);
			server.beginAccepting();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}

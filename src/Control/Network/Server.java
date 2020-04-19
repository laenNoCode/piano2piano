package Control.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import Model.ServerModel;

public class Server {
	ServerModel SM;
	public Server(int port) throws IOException {
		this.SM = new ServerModel();
		this.SM.port = port;
		this.SM.SS = new ServerSocket(port);
	}
	
	public void listen() {
		this.SM.listening = true;
		this.SM.listener  = new Thread(new ServerListener(this.SM));
		this.SM.listener.start();
	}
}

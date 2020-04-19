package Control.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import Model.ServerModel;

public class ClientCommandExecutor implements Runnable{
	ServerModel SM;
	BufferedReader br;
	Socket client;
	public ClientCommandExecutor(ServerModel SM, Socket client) {
		this.SM = SM;
		this.client = client;
	}
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			while (this.SM.listening) {
				String command = br.readLine();
				for (Socket dest:this.SM.clients) {
					//broadcast
					dest.getOutputStream().write((command + "\n").getBytes());
				}
			}
			int index = this.SM.clients.indexOf(client);
			this.SM.clients.remove(index);
			this.SM.workers.remove(index);
			this.client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			int index = this.SM.clients.indexOf(client);
			this.SM.clients.remove(index);
			this.SM.workers.remove(index);
			try {
				this.client.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
}

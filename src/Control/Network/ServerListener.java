package Control.Network;

import java.io.IOException;
import java.net.Socket;

import Model.ServerModel;

public class ServerListener implements Runnable {
	ServerModel SM;
	public ServerListener(ServerModel sm) {
		SM = sm;
	}
	@Override
	public void run() {
		try {
			while (this.SM.listening) 
			{
			Socket s = SM.SS.accept();
			ClientCommandExecutor CCE = new ClientCommandExecutor(this.SM, s);
			Thread t = new Thread(CCE);
			SM.clients.add(s);
			SM.workers.add(t);
			t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package Model;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerModel {
	public ServerSocket SS;
	public Vector<Socket> clients;
	public Vector<Thread> workers;
	public Thread listener;
	public int port;
	public boolean listening = false;
	public ServerModel() {
		clients = new Vector<Socket>();
		workers = new Vector<Thread>();
	}
}

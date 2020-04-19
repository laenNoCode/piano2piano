package piano2piano;

import java.io.IOException;

import Control.Network.Server;

public class test {

	public static void main(String[] args) throws IOException {
		Server s = new Server(8030);
		s.listen();
	}

}

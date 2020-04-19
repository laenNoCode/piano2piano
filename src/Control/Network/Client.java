package Control.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import Model.Note;

public class Client {
	public static void main(String...strings) throws UnknownHostException, IOException, MidiUnavailableException, InvalidMidiDataException {
		Socket s = new Socket("127.0.0.1", 8030);
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String notes;
		while(true) {
			notes = in.readLine();
			if (notes.length() == 9) {
			System.out.println(notes);
			Note n = new Note(notes);
			n.play();
			}
		}
	}
}

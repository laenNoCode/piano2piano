package Model;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Note {
	int ton;
	int volume;
	boolean on;
	public static final String notes = "C D EF G A B";
	public Note(int ton, int volume, boolean on) {
		this.ton = ton;
		this.volume = volume;
		this.on = on;
	}
	public Note(String not) 
	{
		// model"A 7 20 1"
		System.out.println("creating note" + not);
		String nom = not.charAt(0) + "" + not.charAt(1);
		int octave = Integer.parseInt("" + not.charAt(2));
		this.ton = 12*octave + notes.indexOf(not.charAt(0)) + (not.charAt(1) == '#' ? 1:0);
		not = not.substring(4);
		System.out.println(not);
		this.volume = Integer.parseInt(not.split(" ")[0]);
		this.on     = (Integer.parseInt(not.split(" ")[1]) == 1); 
	}
	public String toString() {
		String toRet = "";
		int octave = this.ton / 12;
		int name = this.ton % 12;
		if (notes.charAt(name) == ' ') {
			toRet += notes.charAt(name - 1) + "#";
		}else 
		{
			toRet += notes.charAt(name) + " ";
		}
		toRet += octave + " ";
		toRet += this.volume + " " + ((this.on) ? 1 : 0);
		
		return toRet;
	}
	public void play() throws MidiUnavailableException, InvalidMidiDataException {
		Receiver rcvr = MidiSystem.getReceiver();
		
		ShortMessage sm = new ShortMessage();
		if(on)
			sm.setMessage(ShortMessage.NOTE_ON,0,this.ton,this.volume);
		else
			sm.setMessage(ShortMessage.NOTE_OFF,0,this.ton,this.volume);
		rcvr.send(sm, 0);
	}

}

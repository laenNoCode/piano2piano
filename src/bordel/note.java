package bordel;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class note {
	int ton;
	int volume;
	int quand;
	int duree;
	public note(int ton, int volume, int quand, int duree) {
		super();
		this.ton = ton;
		this.volume = volume;
		this.quand = quand;
		this.duree = duree;
	}
	public note(String not) 
	{
		String notes = "C D EF G A B";
		// model"A 7 20 20 2"
		String nom = not.charAt(0) + "" + not.charAt(1);
		int octave = Integer.parseInt("" + not.charAt(2));
		this.ton = 12*octave + notes.indexOf(not.charAt(0)) + (not.charAt(1) == '#' ? 1:0);
		not = not.substring(4);
		System.out.println(not);
		this.volume = Integer.parseInt(not.split(" ")[0]);
		this.quand = Integer.parseInt(not.split(" ")[1]);
		this.duree = Integer.parseInt(not.split(" ")[2]);
	}
	public void addToTrack(Track tra) throws InvalidMidiDataException {
		System.out.println(this.ton + " " + this.volume + " " + this.quand + " " + this.duree);
		ShortMessage on = new ShortMessage();
		ShortMessage off = new ShortMessage();
		on.setMessage(ShortMessage.NOTE_ON, 0, this.ton, this.volume);
		off.setMessage(ShortMessage.NOTE_OFF, 0, this.ton, this.volume);
		MidiEvent mon = new MidiEvent(on, this.quand);
		MidiEvent moff = new MidiEvent(off, this.quand + this.duree);
		tra.add(mon);
		tra.add(moff);
	}
}

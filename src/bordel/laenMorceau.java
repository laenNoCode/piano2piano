package bordel;
import java.util.Vector;

import javax.sound.midi.*;

public class laenMorceau {
	public static void main(String...strings) throws Exception{
	Sequencer player = MidiSystem.getSequencer();
	player.open();
	Sequence seq = new Sequence(Sequence.PPQ, 4);
	//on fait le f* prelude de Bach
	Track tra = seq.createTrack();
	String morceau = "C 4 100 0 2;E 4 100 2 2;G 4 100 4 2;C 5 100 6 2;E 5 100 8 2";
	morceau += ";G 4 100 10 2;C 5 100 12 2;E 5 100 14 2";
	morceau += ";C 4 100 16 2;E 4 100 18 2;G 4 100 20 2;C 5 100 22 2;E 5 100 24 2";
	morceau += ";G 4 100 26 2;C 5 100 28 2;E 5 100 30 2";
	for (String n: morceau.split(";")) {
		note act = new note(n);
		act.addToTrack(tra);
	}
	player.setSequence(seq);
	player.start();
	}
}

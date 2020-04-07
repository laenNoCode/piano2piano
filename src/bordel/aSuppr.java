package bordel;


import javax.sound.midi.*;


public class aSuppr {

	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		Receiver rcvr = MidiSystem.getReceiver();
		ShortMessage sm = new ShortMessage();
		sm.setMessage(ShortMessage.NOTE_ON,0,57,127);
		rcvr.send(sm, -1);
		Thread.sleep(2000);
	}

}

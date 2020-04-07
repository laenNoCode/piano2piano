package bordel;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.*;
import javax.swing.JFrame;


public class aSuppr {

	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		JFrame jeff = new JFrame();
		jeff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeff.setVisible(true);
		jeff.setSize(500, 500);
		String keys = "qzsedftgyhujk";
		jeff.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
				Receiver rcvr = MidiSystem.getReceiver();
				ShortMessage sm = new ShortMessage();
				sm.setMessage(ShortMessage.NOTE_ON,0,48+keys.indexOf(e.getKeyChar()),127);
				rcvr.send(sm, -1);
				//do do# re re# mi fa fa# sol sol# la la# si 
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

}

/**
 * @author 07013418 Luke Potter
 * @course 3rd B.Sc. I.T.
 * @date 29/January/2010
 */

package ct326.assignment09.applet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.applet.Applet;
import java.util.Date;

public class TimeApplet extends Applet implements Runnable, MouseListener {

	//Default Serialisation
	private static final long serialVersionUID = 1L;
	
	//Declare Variables
	Thread timeThread = null;
	String time;
	Date date;
	Font font;
	boolean isRunning;
	
	//Initializion
	public void init () {
		
		setSize(520, 200);
		font = new Font ("TimesRoman", Font.BOLD, 24);
		isRunning = true;
	}

	//Start method
	public void start () {
		
		if (timeThread == null) {
			
			timeThread = new Thread (this);
			timeThread.start();
		}
	}

	@Override
	//Run method
	public void run() {
		
		//Add a Mouse Listener
		addMouseListener(this);
		
		while (true) {

			if(isRunning == true){
				
				date = new Date ();
				date.getTime();
				time = date.toString();	
			}
			
			repaint();
			
			try {
				
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

	//Paint method
	public void paint (Graphics g) {

		g.setFont(font);
		g.drawString(time, 100, 100);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Change the value of isRunning to its opposite
		if (isRunning == true) isRunning = false;
		else isRunning = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}

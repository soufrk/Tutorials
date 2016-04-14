package learn.tutorials.observerdesignpattern;

import java.util.Observable;
import java.util.Observer;

public class MCESBMCResponse implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("new job started");		
	}

}

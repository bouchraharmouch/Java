
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
// import java.util.EventListener;

public class TimerDemo {
	private int counter;//if I declare it inside "main" method then I should declare it to static variable but static variable: can't change it since it will change anywhere.
	
	public TimerDemo(int counter) {  //constructor of TimerDemo class
		this.counter = counter;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count;
		
		System.out.println("Enter an initial value for the counter: ");// get the count from the user 
		count = scan.nextInt();
		
		TimerDemo application = new TimerDemo(count);// put count to counter
		application.startCountdown();// method declared down 
		
		scan.close();

	}
	public void startCountdown() {
		Timer timer = new Timer(1000, new ActionListener() {// 1000 in ms 
			public void actionPerformed(ActionEvent e) {
				if(counter >= 0) {
					
					System.out.println(counter);
					
				}
				if(counter == -1) {
					
					System.out.println("LiftOff");
					
				}
				counter--;
			}
		});	// close the timer method
		timer.setInitialDelay(0);// don't perform the timer in the first number
		timer.start();// start the timer
		
		while(timer.isRunning()) {
			if(counter <= -2) {
				timer.stop();
			}
			
		}
	}
	
	/*private class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(counter >= 0) {
				
				System.out.println(counter);
				
			}
			if(counter ==-1) {
				
				System.out.println("LiftOff");
				
			}
			counter--;
		}
	}*//inner class since it is a class defined inside an outer class

}

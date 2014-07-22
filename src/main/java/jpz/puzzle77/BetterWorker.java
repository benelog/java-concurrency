package jpz.puzzle77;
import java.util.*;

public class BetterWorker extends Thread {
    private volatile boolean quittingTime = false;
    private Object lock = new Object();
    
    public void run() {
        while (!quittingTime)
            pretendToWork();
        System.out.println("Beer is good");
    }
    private void pretendToWork() {
        try {
            Thread.sleep(300); // Sleeping on the job?
        } catch (InterruptedException ex) { }
    }

    // It's quitting time, wait for worker - Called by good boss
    void quit() throws InterruptedException {
    	 synchronized(lock){
    		 quittingTime = true;
    		 join();
    	 }
    }
    // Rescind quitting time - Called by evil boss
    void keepWorking() {
   	 	synchronized(lock){
        quittingTime = false;
   	 	}
    }

    public static void main(String[] args)
            throws InterruptedException {
        final BetterWorker worker = new BetterWorker();
        worker.start();

        Timer t = new Timer(true); // Daemon thread
        t.schedule(new TimerTask() {
            public void run() { worker.keepWorking(); }
        }, 500);

        Thread.sleep(400);
        worker.quit();
    }
}

package realTimeData;

import org.apache.log4j.Logger;


public class Task implements Runnable {
	final static Logger logger = Logger.getLogger(Task.class);

	@Override
	public void run() {
		logger.info("running the thread for  ::" + Thread.currentThread().getName());
		while (true) {
			System.out.println("I am executing" + Thread.currentThread().getName());
		}

	}

}

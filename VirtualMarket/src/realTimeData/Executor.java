package realTimeData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import Entity.Property;

public class Executor   {
	private List<String> urlList = null;

	public Executor(List<String> uRLS) {
		this.urlList = uRLS;
	}
	
	public void executorTask() {
		BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(50);
        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandelerImpl();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 10, TimeUnit.SECONDS, worksQueue, rejectionHandler);
 
        executor.prestartAllCoreThreads();
         
        List<Runnable> taskGroup = new ArrayList<Runnable>();
        taskGroup.add(new Task());
  
        worksQueue.add(new MultiRunnable(taskGroup));
    }
}
 
class RejectedExecutionHandelerImpl implements RejectedExecutionHandler
{
    @Override
    public void rejectedExecution(Runnable runnable,
            ThreadPoolExecutor executor)
    {
        System.out.println(runnable.toString() + " : Thread Rejected ");
    }
}

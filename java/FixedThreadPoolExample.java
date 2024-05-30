import java.util.concurrent.ExecutorService;
import jva.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExample {
    public static void main(String[]args) throws InterruptedException{

        int poolSize = 4;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        Runnable task = () -> {
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < 10000000; i++){
                Math.sqrt(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Thread"+Thread.currentThread().getName()+"completed in"+(endTime - startTime)+"milliseconds");
        };
        for(int i = 0; i < 10; i++){
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("all tasks submitted");
    }
    
}

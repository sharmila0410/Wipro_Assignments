public class ThreadStates {

    private static final Object LOCK = new Object();

    public static void main(String[]args) throws InterruptedException{

        Thread t = new Thread(()->{
            System.out.println("Thread state:NEW");

        try{
           Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        synchronized(LOCK){
            System.out.println("Thread State:WAITING");
            try{
                LOCK.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        synchronized(LOCK){
            System.out.println("Thread state:TIMED_WAITING");
            try{
                LOCK.wait(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        synchronized(LOCK){
            System.out.println("Thread state:BLOCKED");
            LOCK.notify();
        }
        System.out.println("Thread state:TERMINATED");
        });

        t.start();

        t.join();

    }

    
}

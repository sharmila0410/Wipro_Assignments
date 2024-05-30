public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private int[] buffer = new int[BUFFER_SIZE];
    private int in = 0, out = 0, count = 0;

    public synchronized void produce(int item) throws InterruptedException{
        while(count == BUFFER_SIZE){
            wait();
        }
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        count ++;
        notify();
        System.out.println("produced:"+item);
    }
    public synchronized int consume() throws InterruptedException{
        while(count == 0){
            wait();
        }
        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        count--;
        notify();
        Syste.out.println("consumed:"+item);
        return item;
    }

    public static void main(String[]args){
        ProducerConsumer pc = new ProducerConsumer();
        Thread ProducerThread = new Thread(() ->{
        for(int i = 1; i<= 10; i++){
            try{
                pc.produce(i);
                thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    });
    Thread consumerThread = new Thread(() -> {
        for(int i = 1; i <= 10; i++){
            try{
                pc.consume();
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    });
    ProducerThread.start();
    consumerThread.start();
}
    
}

public class ThreadPrgm {
    public static void main(String[] args) {
        // Create two instances of the NumberPrinter and pass them to separate threads
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));

        // Start both threads
        thread1.start();
        thread2.start();
    }

    // Runnable implementation to print numbers from 1 to 10 with a 1-second delay between each number
    static class NumberPrinter implements Runnable {
        private final String threadName;

        public NumberPrinter(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println(threadName + " started.");
            try {
                // Print numbers from 1 to 10 with a 1-second delay between each number
                for (int i = 1; i <= 10; i++) {
                    System.out.println(threadName + ": " + i);
                    Thread.sleep(1000); // Delay for 1 second
                }
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
            System.out.println(threadName + " finished.");
        }
    }
}
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLockeentrantLock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count;
    private final Lock lock;

    public Counter() {
        this.count = 0;
        this.lock = new ReentrantLock();
    }

    // Increment method
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    // Decrement method
    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    // Get current count
    public int getCount() {
        return count;
    }
}

// Immutable class to share data between threads
final class ImmutableData {
    private final int value;

    public ImmutableData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class CounterPrgm {

    public static void main(String[] args) {
        
        Counter counter = new Counter();

        ImmutableData immutableData = new ImmutableData(42);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                counter.increment();
                System.out.println("Incremented count: " + counter.getCount());
            });

            executor.execute(() -> {
                counter.decrement();
                System.out.println("Decremented count: " + counter.getCount());
            });

            executor.execute(() -> {
                
                System.out.println("Immutable data value: " + immutableData.getValue());
            });
        }

        executor.shutdown();
    }
}
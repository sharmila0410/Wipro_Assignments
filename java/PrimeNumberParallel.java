import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PrimeNumberParallel {

  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    int upperLimit = 1000;
    int numThreads = 4; 
    
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);

    List<Integer> primes = new ArrayList<>();

    int chunkSize = (int) Math.ceil((double) upperLimit / numThreads);
    List<CompletableFuture<List<Integer>>> tasks = new ArrayList<>();

    for (int start = 2; start <= upperLimit; start += chunkSize) {
      int end = Math.min(start + chunkSize - 1, upperLimit);
      tasks.add(CompletableFuture.supplyAsync(() -> {
        List<Integer> chunkPrimes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
          if (isPrime(num)) {
            chunkPrimes.add(num);
          }
        }
        return chunkPrimes;
      }, executor));
    }

    primes = tasks.stream().map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList());

   
    CompletableFuture<Void> writeTask = CompletableFuture.runAsync(() -> {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
        for (int prime : primes) {
          writer.write(prime + "\n");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    CompletableFuture.allOf(writeTask).get();

    executor.shutdown();
    System.out.println("Prime numbers found and written to primes.txt");
  }
}
package TaskOne;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        try {
           
            FileReader inputFileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(inputFileReader);
            
          
            Map<String, Integer> wordFrequencyMap = new HashMap<>();
            
      
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] words = line.split("\\s+");
                for (String word : words) {
                  
                    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                   
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
 
            bufferedReader.close();
          
            FileWriter outputFileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
            
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                bufferedWriter.newLine();
            }
           
            bufferedWriter.close();
            
            System.out.println("Word frequencies have been written to output.txt.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.nio.channels.*;


public class FileCopyWithNIO {
    public static void main(String[]args){
        Path sourcePath = Paths.get("source.get");
        Path destinationPath = Paths.get("destination.get");

        try(FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
               FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)){
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                while(sourceChannel.read(buffer)!=-1){
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        destinationChannel.write(buffer);
                    }
                    buffer.clear();
                }
                System.out.println("file copied successfully");
               }catch(IOException e){
                e.printStackTrace();
               }
    }
    
}

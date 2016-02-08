import java.io.*;
import java.util.*;
import java.lang.*;


public class writeFile {
    public Formatter f;

    public void open(String filename){
        try {
            f = new Formatter("/Users/pepe/Documents/Development/cs2lab2/src/data.txt");
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }

    public void close(){
        f.close();
    }

}

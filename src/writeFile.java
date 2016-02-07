import java.io.*;
import java.util.*;
import java.lang.*;


public class writeFile {
    public Formatter f;

    public void open(){
        try {
            f = new Formatter("D:/Development/cs2lab1/src/output.txt");
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }

    public void close(){
        f.close();
    }

}

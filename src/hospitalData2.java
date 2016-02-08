import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class hospitalData2 {
    static Scanner fileScanner;
    static int c = 0;
    static int r = 0;
    static int x = 0;
    static int y = 0;
    static DecimalFormat df = new DecimalFormat("#.##");
    static String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
            "Sunday"};

    ////// Extra Methods
    public static void methodSeparator(int howLong){
        for (x = 0; x <= howLong; x++){
            System.out.print("-");
        }
        System.out.println("");
    }

    /// Methods
    public static double[][] dataOnArray(String fileName){
        writeFile file = new writeFile();
        double[][] data = new double[7][];
        x = 0;
        y = 0;

        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            int i = 0;
            while (fileScanner.hasNextLine()) {

                i = 0;
                String line = fileScanner.nextLine();
                Scanner lineScann = fileScanner = new Scanner(line);
                String[] splited = line.split(" ");

                for(int j = 0 ; j < splited.length; j++){
                    data[i][j] = Double.parseDouble(splited[j]);
                }

                i++;
            }
        }
        catch (Exception e){
            System.out.println("error => " + e.getMessage());
        }
        fileScanner.close();

        return data;
    }

    public static void main(String[] args) throws IOException{
        //double[][] data = dataOnArray("/Users/pepe/Documents/Development/cs2lab2/src/data2.txt");
        double[][] d = dataOnArray("/Users/pepe/Documents/Development/cs2lab2/src/data2.txt");

        for(x = 0; x < d.length; x++ ){
            System.out.println(" " + d[x]);
        }
//        for(c = 0; c < data.length; c++){
//
//            for(r = 0; r < data[c].length; r++){
//               System.out.print(" "+ data[c][r]);
//            }
//            System.out.println();
//        }

    }
}

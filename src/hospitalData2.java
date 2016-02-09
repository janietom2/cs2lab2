import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class hospitalData2 {
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

    public static int Longest(double[][] a){
        int longest = a[0].length;
        for (x = 1; x < a.length; x++){
            if (a[x].length > longest)
                longest = a[x].length;
        }
        return longest;
    }

    /// Methods
    public static double[][] dataOnArray(String fileName){
        double[][] data = new double[7][];
        Scanner fileScanner;

        try {
            fileScanner = new Scanner(new File(fileName));
             x = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splited = line.split("\\s+");
                data[x] = new double[splited.length];

                for(y = 0 ; y < splited.length; y++){
                    data[x][y] = Double.parseDouble(splited[y] + "");
                }
                x++;
            }
            fileScanner.close();
        } catch (Exception e){
            System.out.println("error => " + e.getMessage());
        }
        return data;
    }

    public static double[] avgEachDay(double[][] a){
        double sum = 0;
        double[] sums = new double[7];

        for(c = 0; c < a.length; c++){
            sum = 0;
            for(r = 0; r < a[c].length; r++){
                sum += a[c][r];
                sums[c] = sum/a[c].length;
            }
        }
        return sums;
    }

    public static double[] avgTemp(double[][] a){
        double sum = 0;
        int len = Longest(a);
        double[] sumx = new double[len];

        for (c = 0; c < a.length; c++){

            for (r = 0; r < a[c].length; r++){
                sumx[r] += a[c][r];
            }
        }

        return sumx;
    }

    public static void main(String[] args) throws IOException{
        double[][] d = dataOnArray("/Users/pepe/Documents/Development/cs2lab2/src/data2.txt");

        for(c = 0; c < d.length; c++){

            for(r = 0; r < d[c].length; r++){
               System.out.print(" "+ d[c][r]);
            }
            System.out.println();
        }

        methodSeparator(20);

        System.out.println("The average temperature of a patient each day from Monday to Sunday:");
        double[] eachDay = avgEachDay(d);

        for (x = 0; x < eachDay.length; x++){
            System.out.println("Average for " + days[x] + ": " + df.format(eachDay[x]));
        }

        methodSeparator(20);

        System.out.println("The average temperature of a patient at times covered in the data:");
        double[] eachTemp = avgTemp(d);

        for (x = 0; x < eachTemp.length; x++){
            System.out.println("The average for T" + (x+1) + " : " + df.format(eachTemp[x]));
        }
    }
}

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class hospitalData {
////// I heard you like variables
    static Scanner fileScanner;
    static int c = 0;
    static int r = 0;
    static int x = 0;
    static int y = 0;
    int max = 1;
    static DecimalFormat df = new DecimalFormat("#.##");

////// Extra Methods
    public static void methodSeparator(int howLong){
        for (x = 0; x <= howLong; x++){
            System.out.print("-");
        }
        System.out.println("");
    }

////// Methods

    public static double[][] dataOnArray(String fileName){
        double[][] data = new double[7][6];
        writeFile file = new writeFile();
        file.open();

        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            while (fileScanner.hasNext()) {
                for(y = 0; y < 6; y++ ){
                    data[x][y] = Double.parseDouble(fileScanner.next());
                }
                x++;
            }
        }catch (Exception e){
            System.out.println("error => " + e.getMessage());
        }
        file.close();

        return data;
    }

    public static double[] avgEachDay(double[][] a){
        double sum = 0;
        double[] sums = new double[7];

        for(c = 0; c < a.length; c++){
            sum = 0;
            for(r = 0; r < a[c].length; r++){
                sum += a[c][r];
                sums[c] = sum/6;
            }
        }
        return sums;
    }

    public static double avgOfWeek(double[][] a){
        double sum = 0;
        double[] sums = new double[7];

        for(c = 0; c < a.length; c++){
            sum = 0;
            for(r = 0; r < a[c].length; r++){
                sum += a[c][r];
                sums[c] = sum;
            }
        }
        sum = 0;
        for(x = 0; x < sums.length; x++){
            sum += sums[x];
        }
        return sum/7;
    }

    public static double maxTempWeek(double[][] a){

        for(c = 0; c < a.length){

        }

        return
    }


    public static void main(String[] args) throws IOException{
        double[][] data = dataOnArray("D:/Development/cs2lab2/src/data.txt");

        methodSeparator(20);

        System.out.println("The average temperature of a patient each day from Monday to Sunday:");
        double[] eachDay = avgEachDay(data);
        for (x = 0; x < eachDay.length; x++){
            System.out.println("Average for day #"+(x+1)+": "+df.format(eachDay[x]));
        }

        methodSeparator(20);

        System.out.println("The average temperature of a patient over the week at times T1, T2, T3, T4, T5, and T6:");
        System.out.println("Average of week: " + df.format(avgOfWeek(data)));

        methodSeparator(20);

        System.out.println("The maximum temperature of a patient over the week at each times of " +
                "the day T1, T2, T3, T4, T5, and T6:");

    }

}

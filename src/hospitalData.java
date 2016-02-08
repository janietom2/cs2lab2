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

////// Methods

    public static double[][] dataOnArray(String fileName){
        double[][] data = new double[7][6];
        writeFile file = new writeFile();
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
        fileScanner.close();

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
        double max = Double.MIN_VALUE;
        for(c = 0; c < a.length; c++){
            for(r = 0; r < a[c].length; r++){
                if(a[c][r] > max){
                    max = a[c][r];
                }
            }
        }
        return max;
    }

    public static double[] maxTempDay(double[][] a){

        double[] data = new double[a.length];
        double max = 0;

        for(x = 0 ; x < a.length; x++){
            for(int y = 0; y < a[x].length; y++){
                if(max < a[x][y]){
                    max = a[x][y];
                }
            }
            data[x] = max;
            max = 0;
        }
        return data;
    }

    public static int maxAvgDay(double[][] a){
        double max = Double.MIN_VALUE;
        int index = 0;

        for(c = 0; c < a.length; c++){
            double sum = 0;
            for(r = 0; r < a[c].length; r++){
                sum += a[c][r];
            }
            if(sum > max){
                max = sum;
                index = c;
            }
        }
        return index;
    }

    public static int maxAvgTime(double[][] a){
            int maxLength = 0;
            double max = Double.MIN_VALUE;
            int index = 0;

            for (int i = 0; i < a.length; i++) {
                if (a[i].length > maxLength)
                    maxLength = a[i].length;
            }
            for (int c = 0; c < maxLength; c++) {
                int sum = 0;
                for (int r = 0; r < a.length; r++) {
                    if (a[r].length > c){
                    sum += a[r][c];
                    }
                }
                if (sum > max){
                    max = sum;
                    index = c;
                }
            }
            return index;
    }


    public static void main(String[] args) throws IOException{
        double[][] data = dataOnArray("/Users/pepe/Documents/Development/cs2lab2/src/data.txt");

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
        System.out.println(df.format(maxTempWeek(data)));

        methodSeparator(20);

        System.out.println("The maximum temperature of a patient each day from Monday to Sunday:");
        double[] maxTempDay = maxTempDay(data);
        for(x = 0; x < maxTempDay.length; x++){
            System.out.println("The max temperature for " + days[x] + " is " + maxTempDay[x]);
        }
        methodSeparator(20);

        System.out.println("On which day the patient had maximum average temperature:");
        System.out.println(days[maxAvgDay(data)] + " is the day with max average.");

        methodSeparator(20);

        System.out.println("At which time of the day (T1, T2, T3, T4, T5, or T6) the patient had " +
                "maximum average temperature:");
        System.out.println("T" + (maxAvgTime(data)+1));
    }

}

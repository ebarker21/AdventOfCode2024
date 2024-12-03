import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File input = new File(args[0]);
        int safeReports = 0;
        int safeReportsBL = 0;
        try {
            Scanner sc = new Scanner(input);
            do{
                //converting the report to a usable integer array
                String reportString = sc.nextLine();
                String[] reportStringArray = reportString.split(" ");
                int[] reportList = new int[reportStringArray.length];
                for(int i = 0; i < reportList.length; i++){
                    reportList[i] = Integer.parseInt(reportStringArray[i]);
                }
                if(isSafe(reportList)){
                    safeReports++;
                }
                if(isSafeBadLevel(reportList)){
                    safeReportsBL++;
                }
            }while(sc.hasNextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Safe reports: "+safeReports);
        System.out.println("Safe reports with a bad Level: "+safeReportsBL);
    }

    private static boolean isSafe(int[] report){
        boolean increasing = false;
        if(report[0] < report[1]){
            increasing = true;
        }
        for(int i = 0; i < report.length-1; i++){
            if(increasing){
                if(report[i] > report[i+1]){
                    return false;
                }
            }
            else{
                if(report[i] < report[i+1]){
                    return false;
                }
            }
            if(Math.abs(report[i] - report[i+1]) > 3){
                return false;
            }
            if(report[i] == report[i+1]){
                return false;
            }
        }
        return true;
    }

    //Part 2 Methods
    private static boolean isSafeBadLevel(int[] report) {
        int[] badLevelArray;
        if(isSafe(report)){
            return true;
        }
        else {
            for (int i = 0; i < report.length; i++){
                badLevelArray = removeIndex(report, i);
                if(isSafe(badLevelArray)){
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] removeIndex(int[] array, int index){
        int[] newArray = new int[array.length-1];
        int newIndex = 0;
        for(int i = 0; i < newArray.length+1; i++){
            if(i != index){
                newArray[newIndex] = array[i];
                newIndex++;
            }
        }
        return newArray;
    }
}

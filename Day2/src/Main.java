import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File input = new File(args[0]);
        int safeReports = 0;
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
            }while(sc.hasNextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Safe Reports: "+safeReports);
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


}

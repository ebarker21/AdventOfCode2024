import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File input = new File(args[0]);
        boolean isSafe = false;
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
                //starting values
                int level = reportList[0];
                int nextLevel = reportList[1];
                //decreasing
                if(level > nextLevel && Math.abs(level - nextLevel) < 4 && level != nextLevel){
                    for(int i = 1; i < reportList.length-1; i++){
                        if(level > nextLevel && Math.abs(level - nextLevel) < 4 && level != nextLevel){
                            level = reportList[i];
                            nextLevel = reportList[i+1];
                        }
                        else{
                            isSafe = false;
                            break;
                        }
                        isSafe = true;
                    }
                    if(isSafe) {
                        safeReports++;
                    }
                }
                //increasing
                else if(level < nextLevel && Math.abs(level - nextLevel) < 4 && level != nextLevel){
                    for(int i = 1; i < reportList.length-1; i++){
                        if(level < nextLevel && Math.abs(level - nextLevel) < 4 && level != nextLevel){
                            level = reportList[i];
                            nextLevel = reportList[i+1];
                        }
                        else{
                            isSafe = false;
                            break;
                        }
                        isSafe = true;
                    }
                    if(isSafe) {
                        safeReports++;
                    }
                }
            }while(sc.hasNextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Safe Reports: "+safeReports);
    }

    private static boolean isSafe(int[] report){
        int increment = 1;
        boolean increasing = false;
        if(report[0] < report[1]){
            increasing = true;
        }

        for(int i = 0; i < report.length; i++){

        }

        return true;
    }


}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int total = 0;
        File input = new File("C:\\Users\\Eric\\Documents\\AdventOfCode2024\\Day1\\example");
        String[] array1;
        String[] array2;
        String[] splitStrings = new String[2];
        try {
            Scanner sc = new Scanner(input);
            while(sc.hasNextLine()){
                String inputString = sc.nextLine();
                splitStrings = inputString.split("   ");
                String inputString1 = splitStrings[0];
                String inputString2 = splitStrings[1];
                array1 = inputString1.split("");
                array2 = inputString2.split("");
                array1 = BubbleSort(array1);
                array2 = BubbleSort(array2);
                System.out.println("testing Compare: "+Compare(array1,array2));
                total = total + Compare(array1, array2);
            }
            System.out.print("ideally the total: "+total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int Compare(String[] input1, String[] input2){
        int total = 0;
        for(int i = 0; i < input1.length || i < input2.length; i++){
            total = total + Math.abs(Integer.parseInt(input1[i]) - Integer.parseInt(input2[i]));
        }
        return total;
    }

    private static String[] BubbleSort(String[] input){
        System.out.print("input before sorting: ");
        printArray(input);
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length-1; j++){
                if(Integer.parseInt(input[j]) > Integer.parseInt(input[j+1])){
                    String temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        System.out.print("input after sorting: ");
        printArray(input);
        return input;
    }

    private static void printArray(String[] input){
        for(String i : input){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

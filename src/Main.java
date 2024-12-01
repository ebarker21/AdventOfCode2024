import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        int total = 0;
        File input = new File("C:\\Users\\Eric\\Documents\\AdventOfCode2024\\Day1\\input.txt");
        ArrayList<Integer> array1 = new ArrayList<>(2);
        ArrayList<Integer> array2 = new ArrayList<>(2);
        int index = 0;
        try {
            Scanner sc = new Scanner(input);
            while(sc.hasNextLine()){
                array1.add(sc.nextInt());
                array2.add(sc.nextInt());
                sc.nextLine();
            }
            Collections.sort(array1);
            Collections.sort(array2);
            total = Compare(array1, array2);

            //Part 2
            total = 0;
            for(int i = 0; i < array1.size(); i++){
                int indexValue = array1.get(i);
                int count = findSimilar(indexValue, array1);
                 total += indexValue * count;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int Compare(ArrayList<Integer> input1, ArrayList<Integer> input2){
        int total = 0;
        int index = 0;
        for(int i = 0; i < input1.size(); i++){
            total = total + Math.abs(input1.get(i) - input2.get(i));
        }
        return total;
    }

    private static void printArray(String[] input){
        for(String i : input){
            System.out.print(i + ",");
        }
        System.out.println();
    }
    private static int findSimilar(int target,ArrayList<Integer> list){
        int counter = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == target){
                counter++;
            }
        }
        return counter;
    }

}

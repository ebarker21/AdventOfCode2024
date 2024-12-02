import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        int total;
        File input = new File(args[0]);
        ArrayList<Integer> array1 = new ArrayList<>(2);
        ArrayList<Integer> array2 = new ArrayList<>(2);
        try {
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                array1.add(sc.nextInt());
                array2.add(sc.nextInt());
                sc.nextLine();
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            }
            Collections.sort(array1);
            Collections.sort(array2);
            total = Compare(array1, array2);
            System.out.println("Total distance: "+total);

            //Part 2
            total = 0;
            for(int i = 0; i < array1.size(); i++){
                int indexValue = array1.get(i);
                int count = findSimilar(indexValue, array2);
                 total += indexValue * count;
            }
            System.out.print("Total similarity: "+total);
        }

    private static int Compare(ArrayList<Integer> input1, ArrayList<Integer> input2){
        int total = 0;
        for(int i = 0; i < input1.size(); i++){
            total = total + Math.abs(input1.get(i) - input2.get(i));
        }
        return total;
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

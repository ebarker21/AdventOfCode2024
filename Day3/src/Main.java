import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;

public class Main {
    public static void main(String[] args){
        File input = new File(args[0]);
        String inputString = inputToString(input);
        int total = mulParser(inputString);
        System.out.println("total: "+total);
        total = mulParser(removeDonts(inputString));
        System.out.println("total without don'ts: "+total);
    }

    private static int mulParser(String input){
        LinkedList<int[]> foundMuls = new LinkedList();
        int[] mul = new int[2];
        Scanner sc = new Scanner(input);
        int total = 0;
        //Searches for and adds valid muls to foundMuls
        String Number = "";
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'm'){
                i++;
                if(input.charAt(i) == 'u'){
                    i++;
                    if(input.charAt(i) == 'l'){
                        i++;
                        if(input.charAt(i) == '('){
                            i++;
                            if(Character.isDigit(input.charAt(i))){
                                do{
                                    Number += input.charAt(i);
                                    i++;
                                }while(Character.isDigit(input.charAt(i)));
                                mul[0] = Integer.parseInt(Number);
                                Number = "";
                                if(input.charAt(i) == ','){
                                    i++;
                                    if(Character.isDigit(input.charAt(i))) {
                                        do{
                                            Number += input.charAt(i);
                                            i++;
                                        }while (Character.isDigit(input.charAt(i)));
                                        mul[1] = Integer.parseInt(Number);
                                        Number = "";
                                        if(input.charAt(i) == ')'){
                                            foundMuls.add(mul);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            mul = new int[2];
        }

        //Adds up the muls
        for(int i = 0; i < foundMuls.size(); i++){
            mul = foundMuls.get(i);
            total += mul[0] * mul[1];
        }
        return total;
    }
//BUG the outputted string includes do_not_mul() instead of don't()
    private static String inputToString(File input){
        Scanner sc;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String output = "";
        while(sc.hasNextLine()){
            output += sc.nextLine();
        }
        return output;
    }

    private static String removeDonts(String input){
        int begin = 0;
        boolean good = true;
        String doString = "";
        for(int i = 0; i < input.length(); i++){
            if(good){
                if(input.charAt(i) == 'd'){
                    i++;
                    if(input.charAt(i) == 'o'){
                        i++;
                        if(input.charAt(i) == 'n'){
                            i++;
                            if(input.charAt(i) == '\''){
                                i++;
                                if(input.charAt(i) == 't'){
                                    i++;
                                    if(input.charAt(i) == '('){
                                        i++;
                                        if(input.charAt(i) == ')'){
                                            i++;
                                            doString += input.substring(begin, i);
                                            good = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                if(input.charAt(i) == 'd') {
                    i++;
                    if (input.charAt(i) == 'o') {
                        i++;
                        if (input.charAt(i) == '(') {
                            i++;
                            if (input.charAt(i) == ')') {
                                begin = i;
                                good = true;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return doString;
    }
}

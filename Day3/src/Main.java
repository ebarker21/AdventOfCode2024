import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

    }
    private static int mulParser(String input){
        LinkedList<int[]> foundMuls = new LinkedList();
        int[] mul = new int[2];
        Scanner sc = new Scanner(input);
        while(sc.hasNext()){
            if(sc.next().equalsIgnoreCase("m")){
                if(sc.next().equalsIgnoreCase("u")){
                    if(sc.next().equalsIgnoreCase("l")){
                        if(sc.next().equals("(")){
                            if(sc.next().matches("[0-9]")){
                                mul[0] = sc.nextInt();
                                if(sc.next().equals(",")){
                                    if(sc.next().matches("[0-9]")){
                                        mul[1] = sc.nextInt();
                                        if(sc.next().equals(")")){
                                            foundMuls.add(mul);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sc.next();
        }


    }
}

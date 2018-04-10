package fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> oneToHundred = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            oneToHundred.add(i + 1);
        }

        oneToHundred.forEach(n -> {
            String buzzWord = "";
            if(n % 3 == 0){
                buzzWord += "fizz";
            }
            if(n % 5 == 0){
                buzzWord += "buzz";
            }
            if(buzzWord.equals("")){
                buzzWord += n;
            }
            System.out.println(buzzWord);
        });

    }
}

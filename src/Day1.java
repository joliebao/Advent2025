import java.util.ArrayList;

public class Day1 {
    private ArrayList<String> input;
    private int dial;
    private int zeroes;
    private int passesZero; // part 2: find amount of times it is rotated past 0

    public Day1(ArrayList<String> list){
        input = list;
        dial = 50;
    }

    // part 1: find amount of times it is rotated at 0
    public void rotate(String rotation){
        String direction = rotation.substring(0,1);
        int turnValue = Integer.parseInt(rotation.substring(1));

        if (direction.equals("L")){
            dial -= turnValue;
            while (dial < 0){
                dial += 100;
                passesZero++;
            }
        } else {
            dial += turnValue;
            while (dial > 99){
                dial -= 100;
                passesZero++;
            }
        }
    }

    public int atZero(){
        for (String r : input){
            rotate(r);
            if (dial == 0) zeroes++;
        }
        return zeroes;
    }

    // Part 2
    public int getPassesZero(){
        for (String r : input){
            rotate(r);
            System.out.println(passesZero);
            if (dial == 0) passesZero++;
        }
        return passesZero;
    }
}
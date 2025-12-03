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
    public int rotate1(String rotation){
        String direction = rotation.substring(0,1);
        int turnValue = Integer.parseInt(rotation.substring(1));
        while (turnValue > 99){
            turnValue -= 100;
        }
        System.out.println(turnValue);
        if (direction.equals("L")){
            dial -= turnValue;
            if (dial < 0){
                dial = 100 + dial; // because it is negative add dial amount
            } else if (dial > 99){
                dial = dial - 100; // reset back to 0 + dial overflow
            }
        } else {
            dial += turnValue;
            if (dial > 99){
                dial = dial - 100;
            } else if (dial < 0){
                dial = 100 + dial;
            }
        }
        System.out.println(dial);
        return dial;
    }

    public int atZero(){
        for (String r : input){
            rotate1(r);
            if (dial == 0) zeroes++;
        }
        return zeroes;
    }

    // Part 2
    public void rotate2(String rotation){
        String direction = rotation.substring(0,1);
        int turnValue = Integer.parseInt(rotation.substring(1));

        // iterates through every value
        if (direction.equals("L")){
            while (turnValue > 0){
                dial--;
                if (dial == 0) passesZero++;
                if (dial == -1) dial = 99;
                turnValue--;
            }
        } else {
            while (turnValue > 0){
                dial++;
                dial %= 100;
                if (dial == 0) passesZero++;
                turnValue--;
            }
        }
    }

    public int getPassesZero(){
        dial = 50;
        for (String r : input){
            rotate2(r);
        }
        return passesZero;
    }
}
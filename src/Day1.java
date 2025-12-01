import java.util.ArrayList;

public class Day1 {
    private ArrayList<String> input;
    private int dial;
    private int zeroes;

    public Day1(ArrayList<String> list){
        input = list;
        dial = 50;
    }

    public int rotate(String rotation){
//        System.out.println(dial);
        String direction = rotation.substring(0,1);
        String 
        if (rotation.substring(0,1).equals("L")){
            dial -= Integer.parseInt(rotation.substring(1));
            if (dial < 0){
                dial = 100 + dial; // because it is negative add dial amount
            } else if (dial > 99){
                dial = dial - 100; // reset back to 0 + dial overflow
            }
        } else {
            dial += Integer.parseInt(rotation.substring(1));
            if (dial > 99){
                dial = dial - 100;
            } else if (dial < 0){
                dial = 100 + dial;
            }
        }
//        System.out.println(dial);
        return dial;
    }

    public int atZero(){
        for (int i = 0; i < input.size(); i++){
            if (rotate(input.get(i)) == 0){
                System.out.println(i + ": " + input.get(i));
                zeroes++;
            }
        }
        return zeroes; // change
    }
}
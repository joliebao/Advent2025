import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day3 {
    private ArrayList<String> input;
    int num1;
    int num2;
    int sum;

    public Day3(ArrayList<String> list) {
        input = list;
    }

    // part 1
    private int getLargest(String line){
        String[] list = line.split("");
        ArrayList<Integer> numerical = new ArrayList<Integer>();

        for (String number: list){
            numerical.add(Integer.parseInt(number));
        }

        num1 = Collections.max(numerical);
        int position1 = numerical.indexOf(num1);
        numerical.set(position1, 0);

        if (position1 == numerical.size() - 1){
            num2 = Collections.max(numerical);
            return (num2*10 + num1);
        }

        for (int i = 0; i < position1; i++){
            numerical.set(i, 0);
        }
        num2 = Collections.max(numerical);
        return (num1*10 + num2);
    }

    public int getSum(){
        for (String l: input){
            sum += getLargest(l);
        }
        return sum;
    }
}
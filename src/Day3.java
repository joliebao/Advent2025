import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day3 {
    private ArrayList<String> input;
    int num1;
    int num2;
    int sum;
    
    long sum12;

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

    // part 2
    private long getLargest12(String line){
        String num = "";
        String[] list = line.split("");
        ArrayList<Integer> numerical = new ArrayList<Integer>();

        for (String number: list){
            numerical.add(Integer.parseInt(number));
        }

        int max = -1;
        int index = -1;
        for (int i = 0; i < numerical.size() - 11; i++) { // get first digit (max that still leaves 11 digits)
            if (numerical.get(i) > max){
                max = numerical.get(i);
                index = i;
            }
        }
        num += max;

        for (int n = 0; n < 11; n++) { // running for 12 digits
            max = -1;
            for (int i = index+1; i <= numerical.size() - 11 + n; i++) {
                if (numerical.get(i) > max){
                    max = numerical.get(i);
                    index = i;
                }
            }
            num += max;
        }
        System.out.println(num);

        return Long.parseLong(num);
    }

    public long getSum12(){
        for (String l: input){
            sum12 += getLargest12(l);
        }
        return sum12;
    }
}
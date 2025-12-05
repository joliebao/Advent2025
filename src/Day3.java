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
        long num = 0;
        String[] list = line.split("");
        ArrayList<Integer> numerical = new ArrayList<Integer>();

        for (String number: list){
            numerical.add(Integer.parseInt(number));
        }

        int max = Collections.max(numerical);
        int position1 = numerical.indexOf(max);

        if (numerical.size() - position1 > 12){ // if there are more than 12 characters left after the max position
            for (int i = 0; i <= position1; i++){ // shorten list to last values
                numerical.remove(i);
            }

            int index = numerical.indexOf(max);

            String strNum = max+line.substring(index, index+11);
            num = Long.parseLong(strNum);
            System.out.println(num);
        } else if (numerical.size() - position1 - 1 == 12){ // perfectly 12 strings
            num = Long.parseLong(line.substring(position1));
            System.out.println(num);
        } else { // less than 12 strings

        }

        return num;
    }

    public long getSum12(){
        for (String l: input){
            sum12 += getLargest12(l);
        }
        return sum12;
    }
}
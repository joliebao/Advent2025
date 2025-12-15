import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Day6 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> operations;
    private ArrayList<Long> results = new ArrayList<Long>();
    private Long ans=0L;
    private Long ans2=0L;

    public Day6(ArrayList<String> list) {
        input = list;
    }

    // part 1
    private void lineMath(String line){
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(line.split(" ")));
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i).isBlank()) {
                numbers.remove(i);
                i--;
            } else {
                String num = numbers.get(i);
                numbers.set(i, num.trim());
            }
        }

        for (int i = 0; i < numbers.size(); i++){
            Long num = Long.parseLong(numbers.get(i));
            if (Objects.equals(operations.get(i), "*")){
                num *= results.get(i);
                results.set(i, num);
            } else if (Objects.equals(operations.get(i), "+")){
                num += results.get(i);
                results.set(i, num);
            }
        }
    }

    public long doMath(){
        String ops = input.get(input.size() - 1);
        operations = new ArrayList<>(Arrays.asList(ops.split(" ")));
        for (int i = 0; i < operations.size(); i++){
            if (operations.get(i).contains("*")){
                operations.set(i, "*");
                results.add(1L);
            } else if (operations.get(i).contains("+")) {
                operations.set(i, "+");
                results.add(0L);
            } else {
                operations.remove(i);
                i--;
            }
        }

        for (int i = 0; i < input.size() - 1; i++){
            lineMath(input.get(i));
        }

        for (long num: results){
            ans += num;
        }

        return ans;
    }

    //part 2
    private void addNum(int i){
        // get numbers by iterating through the horizontal values of each row
        // if all four are 0; skip
        // if one is " ", replace with a 0
        // add as a string to a list
        String num = "";
        num += input.get(0).substring(i,i+1);
        num += input.get(1).substring(i,i+1);
        num += input.get(2).substring(i,i+1);
        num += input.get(3).substring(i,i+1);

    }

    public long doColMath(){
        for (int i = 0; i < input.getFirst().length() - 1; i++){
            addNum(i);
        }

        return ans2;
    }
}

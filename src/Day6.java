import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Day6 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> operations;
    private ArrayList<Integer> results = new ArrayList<Integer>();

    public Day6(ArrayList<String> list) {
        input = list;
    }

    // part 1
    // find way to separate by any num of spaces
    // for each operations, run through lind
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
            int num = Integer.parseInt(numbers.get(i));
            if (Objects.equals(operations.get(i), "*")){
                num *= results.get(i);
                results.set(i, num);
            }
        }
    }

    public long doMath(){
        String ops = input.get(4);
        operations = new ArrayList<>(Arrays.asList(ops.split(" ")));
        for (int i = 0; i < operations.size(); i++){
            if (operations.get(i).contains("*")){
                operations.set(i, "*");
                results.add(1);
            } else if (operations.get(i).contains("+")) {
                operations.set(i, "+");
                results.add(0);
            } else {
                operations.remove(i);
                i--;
            }
        }

        for (int i = 0; i < input.size() - 1; i++){
            lineMath(input.get(i));
        }
        return 0; // PLACEHOLDER
    }
}

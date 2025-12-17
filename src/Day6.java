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
        // separating numbers
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(line.split(" ")));
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i).isBlank()) { // removing empty indexes bc it's split by one space
                numbers.remove(i);
                i--;
            } else {
                String num = numbers.get(i); // trim spaces so that parsing is possible
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
    private String addNum(int i){
        String num = "";
        num += input.get(0).substring(i,i+1);
        num += input.get(1).substring(i,i+1);
        num += input.get(2).substring(i,i+1);
        num += input.get(3).substring(i,i+1);
        num = num.trim();
        return num;
    }

    public long doColMath(){
        ArrayList<String> numbers = new ArrayList<String>();
        for (int i = 0; i < input.getFirst().length(); i++){
            numbers.add(addNum(i));
        }
        numbers.add("");

        for (String op: operations){
            if (op.equals("*")){
                long product = 1L;
                for (int i = 0; i < numbers.indexOf(""); i++){
                    product *= Integer.parseInt(numbers.removeFirst());
                    i--;
                }
                ans2 += product;
            } else {
                int sum = 0;
                for (int i = 0; i < numbers.indexOf(""); i++){
                    sum += Integer.parseInt(numbers.removeFirst());
                    i--;
                }
                ans2 += sum;
            }
            numbers.removeFirst();
        }
        return ans2;
    }
}

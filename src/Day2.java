import java.util.ArrayList;

public class Day2 {
    private ArrayList<String> input;
    private int sum;

    public Day2(ArrayList<String> list){
        input = list;
        sum = 0;
    }

    // part 1
    private void findInvalid(String id){
        // split into each ID range
        String[] IDs = id.split(",");
        for (String range : IDs){
            String first = range.substring(0, range.indexOf("-"));
            String last = range.substring(range.indexOf("-") + 1);

            // if even (because they need to repeat patterns)
            if (first.length() % 2 == 0){
                int num1 = Integer.parseInt(first);
                int num2 = Integer.parseInt(last);
                if (first.substring(0,first.length()/2).equals(first.substring(first.length()/2)+1)){
                    sum += num1;
                }
                if (last.substring(0,last.length()/2).equals(last.substring(last.length()/2)+1)){
                    sum += num2;
                }
                // finish this part
                while (num1 < num2){
                    num1 ++;

                }
            }
            System.out.println(first + " " + last);
        }
    }

    public int getSum(){
        for (String line : input){
            findInvalid(line);
        }
        return sum;
    }
}

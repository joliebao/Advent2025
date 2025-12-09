import java.util.ArrayList;

public class Day5 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> ranges = new ArrayList<String>();
    private long lower;
    private long higher;
    private boolean fresh;
    private int counter;
    private int count;

    public Day5(ArrayList<String> list){
        input = list;
        for (int i = 0; i < input.size(); i++){
            if (input.get(i).contains("-")){
                ranges.add(input.get(i));
                input.remove(i);
                i--;
            }
        }
    }

    public boolean getFresh(){
        for (int i = 0; i < ranges.size(); i++){
            String range = ranges.get(i);
            lower = Long.parseLong(range.substring(0, range.indexOf("-")));
            higher = Long.parseLong(range.substring(range.indexOf("-") + 1));
            long num = Long.parseLong(input.get(counter));
            if (num > lower && num < higher){
                   input.remove(counter);
                   counter--;
            }
            counter++;
        }
        return fresh; // placeholder
    }

    public int getSum(){
        counter = 0;
        while (!fresh || counter < input.size()){
            if (getFresh()){
                count++;
            }
            counter ++;
        }
        return count;
    }

    // first separate lines with dashes and just numbers
    // iterate through the dashed values each time
    // if number is between the bounds, add to count
    // return count
    // end loop at first case of pass (to prevent overlap)
}

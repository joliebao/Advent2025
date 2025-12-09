import java.util.ArrayList;

public class Day5 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> ranges = new ArrayList<String>();
    private int lower;
    private int higher;

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
        return false; // placeholder
    }

    // first separate lines with dashes and just numbers
    // iterate through the dashed values each time
    // if number is between the bounds, add to count
    // return count
    // end loop at first case of pass (to prevent overlap)
}

import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    private ArrayList<String> input = new ArrayList<String>();


    public Day6(ArrayList<String> list) {
        input = list;
    }

    // part 1

    // find way to separate by any num of spaces
    // separate operations
    // for each operations, run through lind
    private void lineMath(String line){
        line = line.replaceAll("\\s", "-");
        String[] StringNum = line.split("-");
        System.out.println(Arrays.toString(StringNum));
    }

    public long doMath(){
        for (String problem : input){
            lineMath(problem);
        }
        return 0; // PLACEHOLDER
    }
}

import java.util.ArrayList;

public class Day5 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> ranges = new ArrayList<String>();
    private long lower;
    private long higher;
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

    public boolean isFresh(long num){
        for (int i = 0; i < ranges.size(); i++){
            String range = ranges.get(i);
            lower = Long.parseLong(range.substring(0, range.indexOf("-")));
            higher = Long.parseLong(range.substring(range.indexOf("-") + 1));
            if (num <= higher && num >= lower){
                return true;
            }
        }
        return false;
    }

    public int getSum(){
        for (String id: input){
            long num = Long.parseLong(id);
            if (isFresh(num)){
                count++;
            }
        }
        return count;
    }
}

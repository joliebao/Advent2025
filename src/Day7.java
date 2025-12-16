import java.util.ArrayList;

public class Day7 {
    private ArrayList<String> input = new ArrayList<String>();

    public Day7(ArrayList<String> list) {
        input = list;
    }

    private int getCount(String line){
        int count = 0;
        String[] chars = line.split("");
        for (String character: chars){
            if (character.equals("^")){
                count++;
            }
        }
        return count;
    }

    public int getSplit(){
        int split = 0;
        for (int i = 0; i < input.size(); i++){
            split += getCount(input.get(i));
        }
        return split - 1;
    }
}


import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {
    private ArrayList<String> input;
    private int rolls;
    private String[][] diagram;

    public Day4(ArrayList<String> list) {
        input = list;
    }

    private String[][] twoDMaker(){
        String[][] trash = new String[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++){
            String[] splitList = input.get(i).split("");
            for (int j = 0; j < input.get(0).length(); j++){
                trash[i][j] = splitList[j];
            }
        }
        return trash;
    }

    private boolean checkRolls(int r, int c){
        int paper = 0;
        if (r > 0){
            if (diagram[r-1][c].equals("@")){
                paper++;
            }
        }
        if (c > 0){

        }

        return (paper < 4);
    }

    public int getRolls(){
        diagram = twoDMaker();
        // trash count < 4
        // do exceptions for the ends
        for (int i = 0; i < diagram.length; i++){
            for (int j = 0; j < diagram[0].length; j++){
                if (diagram[i][j].equals("@")){
                    checkRolls(i, j);
                }
            }
        }

        return rolls;
    }
}

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
        String[][] trash = new String[input.size()+1][input.get(0).length()+1];
        for (int i = 0; i < input.size(); i++){
            String[] splitList = input.get(i).split("");
            for (int j = 0; j < input.get(0).length(); j++) {
                trash[i+1][j+1] = splitList[j];
            }
        }
        for (int i = 0; i < input.size(); i++){
            trash[i][0] = "-";
            trash[i][input.get(0).length()] = "-";
        }
        for (int j = 0; j < input.size(); j++){
            trash[0][j] = "-";
            trash[input.size()][j] = "-";
        }
        System.out.println(Arrays.deepToString(trash));
        return trash;
    }

    private boolean checkRolls(int r, int c){
        int paper = 0;
        if (r > 0 && r < diagram.length){ // row (y) is 1 or more and (y) is less than max y
            // check sides
            // o o o
            // X @ X
            // o o o
            if (diagram[r-1][c].equals("@")){
                paper++;
            }
            if (diagram[r+1][c].equals("@")){
                paper++;
            }
        } else if (r == 0){
            // X @ X
            // o o o
            if (diagram[r+1][c].equals("@")){
                paper++;
            }
        } else if (r == diagram.length){
            // o o o
            // X @ X
            if (diagram[r-1][c].equals("@")){
                paper++;
            }
        }
        if (c > 0 && c < diagram[0].length){ // col (x) is 1 or more and col (x) is less than max x
            // o X o
            // o @ o
            // o X o
            if (diagram[r][c+1].equals("@")){
                paper++;
            }
            if (diagram[r][c-1].equals("@")){
                paper++;
            }
        } else if (c == 0 && r > 0){
            // @ @ @
            // X X X
            if (diagram[r][c+1].equals("@")){
                paper++;
            }
        } else if (c == diagram[0].length){
            // X X X
            // @ @ @
            if (diagram[r][c-1].equals("@")){
                paper++;
            }
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

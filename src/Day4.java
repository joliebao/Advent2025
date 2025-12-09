import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {
    private ArrayList<String> input;
    private int rolls;
    private int paper;
    private String[][] diagram;

    public Day4(ArrayList<String> list) {
        input = list;
        diagram = twoDMaker();
    }

    private String[][] twoDMaker(){
        String[][] trash = new String[input.size()+2][input.get(0).length()+2];
        for (int i = 0; i < input.size(); i++){
            String[] splitList = input.get(i).split("");
            for (int j = 0; j < splitList.length; j++) {
                trash[i+1][j+1] = splitList[j];
            }
        }
        for (int i = 0; i < trash.length; i++){
            trash[i][0] = "-";
            trash[i][trash.length-1] = "-";
        }
        for (int j = 0; j < trash[0].length; j++){
            trash[0][j] = "-";
            trash[trash[0].length-1][j] = "-";
        }
        return trash;
    }

    private boolean checkRolls(int r, int c){
        paper = 0;
        if (diagram[r-1][c].equals("@")){ // below
            paper++;
        }
        if (diagram[r+1][c].equals("@")){ // above
            paper++;
        }
        if (diagram[r][c+1].equals("@")){ // right
            paper++;
        }
        if (diagram[r][c-1].equals("@")){ // left
            paper++;
        }
        if (diagram[r+1][c+1].equals("@")){ // top right
            paper++;
        }
        if (diagram[r+1][c-1].equals("@")){ // top left
            paper++;
        }
        if (diagram[r-1][c+1].equals("@")){ // bottom right
            paper++;
        }
        if (diagram[r-1][c-1].equals("@")){ // bottom left
            paper++;
        }
        return (paper < 4);
    }

    public int getRolls(){
        for (int i = 1; i < diagram.length - 1; i++){
            for (int j = 1; j < diagram[0].length - 1; j++){
                if (diagram[i][j].equals("@")){
                    if (checkRolls(i, j)){
                        rolls++;
                        diagram[i][j] = "X"; // part 2
                    }
                }
            }
        }
        return rolls;
    }

    // part 2
    public int reroll(){
        for (int i = 0; i < 250; i++){ //change i max until it the rolls removed is the same
            getRolls();
        }

        return rolls;
    }
}

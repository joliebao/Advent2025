import java.util.ArrayList;

public class Day2 {
    private ArrayList<String> input;
    private long sum = 0;

    public Day2(ArrayList<String> list){
        input = list;
    }

    // part 1
    private void findInvalid(String id){
        // split into each ID range
        String[] IDs = id.split(",");
        for (String range : IDs){
            String first = range.substring(0, range.indexOf("-"));
            String last = range.substring(range.indexOf("-") + 1);

            // if even (because they need to repeat patterns)
            if (first.length() % 2 == 0 || last.length() % 2 == 0){
                long num1 = Long.parseLong(first);
                long num2 = Long.parseLong(last);

                if (num2 > num1) {
                    while (num1 <= num2) {
                        if (repeatedValue(num1)){;
                            sum += num1;
                            System.out.println("SUM = " + sum + ": " + num1);
                        }
                        num1++;
                    }
                } else if (num1 > num2){
                    while (num1 >= num2) {
                        if (repeatedValue(num1)){
                            sum += num1;
                            System.out.println("SUM = " + sum + ": " + num1);
                        }
                        num1--;
                    }
                }
            }

//            // if even (because they need to repeat patterns)
//            if (first.length() % 2 == 0 || last.length() % 2 == 0){
//                long num1 = Long.parseLong(first);
//                long num2 = Long.parseLong(last);
//
//                if (num2 > num1) {
//                    while (num1 <= num2) {
//                        String middle = String.valueOf(num1);
//                        if (middle.substring(0, middle.length() / 2).equals(middle.substring(middle.length() / 2))) {
//                            sum += num1;;
//                        }
//                        num1++;
//                    }
//                } else if (num1 > num2){
//                    while (num1 >= num2) {
//                        String middle = String.valueOf(num1);
//                        if (middle.substring(0, middle.length() / 2).equals(middle.substring(middle.length() / 2))) {
//                            sum += num1;
//                        }
//                        num1--;
//                    }
//                }
//            }
        }
    }

    // change so that it can test repetitions of 1s and repetitions of more than 2
    private boolean repeatedValue(long numberInt){
        String num = String.valueOf(numberInt);
        String repVal = num.substring(0,1);

        for (int index = 1; index < num.length()/2; index++) { // while less than half way repeating
            System.out.println(num.length()/2);
            System.out.println(repVal);
            repVal += num.substring(index,index+1); // add another letter to the repeating value
            num = num.replaceAll(repVal, "");
        }
        if (num.isEmpty()) return true;
        return false;
    }

    public long getSum(){
        for (String line : input){
            findInvalid(line);
        }
        return sum;
    }
}

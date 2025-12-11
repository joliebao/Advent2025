import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day5 {
    private ArrayList<String> input = new ArrayList<String>();
    private ArrayList<String> ranges = new ArrayList<String>();
    private long lower;
    private long higher;
    private int count;

    public Day5(ArrayList<String> list) {
        input = list;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).contains("-")) {
                ranges.add(input.get(i));
                input.remove(i);
                i--;
            }
        }
    }

    public boolean isFresh(long num) {
        for (int i = 0; i < ranges.size(); i++) {
            String range = ranges.get(i);
            lower = Long.parseLong(range.substring(0, range.indexOf("-")));
            higher = Long.parseLong(range.substring(range.indexOf("-") + 1));
            if (num <= higher && num >= lower) {
                return true;
            }
        }
        return false;
    }

    public int getSum() {
        for (String id : input) {
            long num = Long.parseLong(id);
            if (isFresh(num)) {
                count++;
            }
        }
        return count;
    }

    // part 2
    private void sortRange() {
        for (int i = 1; i < ranges.size(); i++) {
            // sorts by length
            String r2 = ranges.get(i);
            String r1 = ranges.get(i - 1);
            long l2 = Long.parseLong(r2.substring(0, r2.indexOf("-")));
            long l1 = Long.parseLong(r1.substring(0, r1.indexOf("-")));
            while (l2 < l1 && i >= 1) {
                ranges.add(i - 1, ranges.get(i));
                ranges.remove(i + 1);
                i--;
            }
        }
    }

    private ArrayList<Long[]> makeList() {
        ArrayList<Long[]> l = new ArrayList<Long[]>();
        for (int i = 1; i < ranges.size(); i++) {
            String r = ranges.get(i);
            long lower = Long.parseLong(r.substring(0, r.indexOf("-")));
            long upper = Long.parseLong(r.substring(r.indexOf("-")));
            System.out.println(lower);
            System.out.println(upper);
            Long[] a = new Long[]{lower, upper};
            l.add(a);
        }
        return l;
    }

    public long getMaxFresh() {
        ArrayList<Long[]> list = makeList();
        for (Long[] l : list){
            System.out.println(Arrays.toString(l));
        }
        long total = 0;
        long lastUpper;
        for (int i = 0; i < ranges.size(); i++) {
            if (i == 0) {
                lastUpper = 0;
            } else {
                String lastRange = ranges.get(i - 1);
                lastUpper = Long.parseLong(lastRange.substring(lastRange.indexOf("-") + 1));
            }
            String range = ranges.get(i);
            lower = Long.parseLong(range.substring(0, range.indexOf("-")));
            if (lower < lastUpper) {
                lower = lastUpper + 1;
            }
            higher = Long.parseLong(range.substring(range.indexOf("-") + 1));
            total += (higher - lower) + 1;
        }
        return total;
    }
}

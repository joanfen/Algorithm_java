package Week3;

import java.util.*;

public class LeetCode_433_0256 {
    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();

                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {

                    char old = currArray[i];
                    for (char c : charSet) {
                        if (old == c) continue;

                        currArray[i] = c;
                        String next = new String(currArray);
                        if (bankSet.contains(next)) {
                            if (next.equals(end)) return level + 1;
                            bankSet.remove(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] bank = {"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"};
        int result = minMutation("AACCGGTT", "AAACGGTA", bank);
        System.out.println(result);
    }
}

package graph;


import java.util.*;

public class BFS {

    private char[] four = {'A', 'G', 'T', 'C'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; count--) {
                char[] currentChars = queue.poll().toCharArray();
                for (int i = 0; i < currentChars.length; i++) {
                    char old = currentChars[i];
                    for (char ch : four) {
                        currentChars[i] = ch;
                        String generatedString = new String(currentChars);
                        if (end.equals(generatedString)) {
                            return step;
                        } else if (set.contains(generatedString)) {
                            queue.offer(generatedString);
                            set.remove(generatedString);
                        }
                    }
                    currentChars[i] = old;
                }
            }
        }
        return -1;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

        int len = 1;

        HashSet<String> visited = new HashSet<>();

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }


        return 0;

    }

    public static void main(String[] args) {
        int result = new BFS().ladderLength("hit",
                "cog",
                Arrays.asList("hot", "cog", "dot", "dog", "hit", "lot", "log"));
        System.out.println(result);
    }

}

package Week3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_127_0256 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                String string = queue.poll();
                char[] words = string.toCharArray();

                for (int j = 0; j < words.length; j++) {
                    char originalChar = words[j];
                    for (char c = 'a'; c < 'z'; c++) {

                        String newWord = String.valueOf(words);
                        words[j] = c;
                        if (originalChar == c) continue;
                        if (newWord.equals(endWord)) return level + 1;
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    words[j] = originalChar;
                }

            }
            level ++;

        }
        return 0;
    }
}

package graph;

import java.util.*;

public class numDecoding {

    public static int numDecoding(String s) {
        char[] chs = s.toCharArray();
        List<List<String>>[] dp = new List[chs.length];
        if (chs.length == 0) return 0;
        dp[0] = new ArrayList();
        if (Integer.parseInt(String.valueOf(chs[0])) > 0) {
            dp[0].add(Arrays.asList(String.valueOf(chs[0])));
        }
        for (int i = 1; i < chs.length; i++) {
            dp[i] = new ArrayList<>();
            int numc = Integer.parseInt(String.valueOf(chs[i]));

            String c = String.valueOf(chs[i]);
            for (List<String> list : dp[i - 1]) {
                List<String> curr = new ArrayList<>(list);
                if (numc > 0) {
                    curr.add(c);
                    dp[i].add(new ArrayList<>(curr));
                }
                String last = list.get(list.size() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append(last);
                sb.append(c);
                int num = Integer.parseInt(sb.toString());

                if (num <= 26 && num > 0) {
                    List<String> curr2 = new ArrayList<>(list);
                    curr2.remove(curr2.size() - 1);
                    curr2.add(String.valueOf(num));
                    dp[i].add(new ArrayList<>(curr2));
                }
            }
            System.out.println(dp[i]);
        }

        return dp[chs.length - 1].size();
    }

    public static void main(String[] args) {
        int result = numDecoding("101");
        System.out.println(result);
    }

}

import java.util.*;

public class WordBreak {
    static int n = 0;
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        Stack<Character> a = new Stack<>();
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            n++;
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
////                System.out.println(s.substring(j, i));
//                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[s.length()];
//    }

    public static void main(String args[]) {
        WordBreak a = new WordBreak();
        String[] l = {"leet",  "code"};

        System.out.println(a.wordBreak("leetcode", Arrays.asList(l.clone())));
        System.out.println(n);
    }
}

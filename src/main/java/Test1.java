import java.util.*;

public class Test1 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char c : s.toCharArray()) {

            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                Character top = stack.isEmpty() ? 'x' : stack.pop();
                if (c != map.get(top)) {
                    return false;
                }

            }
        }

        return stack.isEmpty();

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static boolean checkSameBinary(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        int l = 0, r = s.length() - 1;
        char lChar = s.charAt(l), rChar = s.charAt(r);

        while (r > l) {

            if (lChar != s.charAt(l++) || rChar != s.charAt(r--) || rChar == lChar) {
                return false;
            }
        }

        return true;
    }

    public static int countBinarySubstrings(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }


    public static void main(String args[]) throws InterruptedException {
        int [][] arr = {
                {3,4}
                ,{2,1}
        };
        for (int[] i : arr) {
            Arrays.stream(i).forEach(System.out::println);
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        for (int[] i : arr) {
            Arrays.stream(i).forEach(System.out::println);
        }

//        Arrays.sort(a, (a, b) -> b[1] - a[1]);

    }
}



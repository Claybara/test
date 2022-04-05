import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> res = new ArrayList();

    public static void main(String args[]) {
//        int a[][] = {{4,3,1},{3,2,4},{3},{4},{}};
//        allPathsSourceTarget(a);

        char[] a = {'a', 'b'};
        System.out.println(a.toString());
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return allPathsSourceTarget(graph, 0, null);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph, int idx, List<Integer> list) {

        if (graph[idx].length > 0) {
            for (int i = 0; i < graph[idx].length; i++) {
                List<Integer> valList = new ArrayList<Integer>();
                if (list != null) valList = list;
                valList.add(idx);
                allPathsSourceTarget(graph, graph[idx][i], valList);
            }
        } else {
            List<Integer> valList = new ArrayList<Integer>();
            if (list != null) valList = list;
            valList.add(idx);
            res.add(valList);
        }

        return res;
    }

    public String restoreString(String s, int[] indices) {
        char[] replace = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            replace[indices[i]] = s.charAt(indices[i]);
        }

        return replace.toString();

    }
}
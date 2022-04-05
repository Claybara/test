import java.util.HashSet;

public class UnionFind2 {

    static HashSet<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) {
//        System.out.println("test");
        int[] a = {1,23,4};
        int res = sol(a);
        System.out.println(res);
    }

    public static int sol(int[] arr) {
        int[] root = new int[arr.length + 1];
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            union(root, arr[i], arr[i] - 1);

            if (root[i] == 0 && set.size() == 1) {
                res++;
            }
        }
        return res;
    }

    public static int find(int[] root, int val) {
        if (root[val] == val) return val;
        else return find(root, root[val]);
    }

    public static void union(int[] root, int cur, int prev) {
        int curVal = find(root, cur);
        int prevVal = find(root, prev);
        set.add(prevVal);
        set.remove(curVal);
        root[curVal] = prevVal;
    }
}

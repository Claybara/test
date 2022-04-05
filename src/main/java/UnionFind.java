import java.util.HashSet;

public class UnionFind {

    static HashSet<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) {
        int[] a = {1,2,5,6,7,8,9,3,4};
        int res = sol(a);
        System.out.println(res);
    }

    public static int sol(int[] arr) {
        int[] root = new int[arr.length + 1];
        int count = 0;
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            union(root, arr[i], arr[i] - 1);

            if (root[arr[i]] == 0 && set.size() == 1) {
                count++;
            }
        }

        return count;
    }

    public static int find(int[] root, int val) {
        if (root[val] == val) {
            return val;
        } else {
            return find(root, root[val]);
        }
    }

    public static void union(int[] root, int cur, int prev) {
        int curRoot = find(root, cur);
        int prevRoot = find(root, prev);
        set.add(prevRoot);
        set.remove(curRoot);
        root[curRoot] = prevRoot;
    }
}

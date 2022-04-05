public class Solution2 {


    static int[] root;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int []A = {3,2,1,4,5,10,9,8,7,6};
        System.out.println(s2(A));


    }

    public static void s1(int[] A) {

        int[] onBulbArray = new int[A.length];
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int onBulbIndex = A[i] - 1;
            onBulbArray[onBulbIndex] = 1;

            boolean isOnBulb = true;
            for (int j = 0; j < onBulbIndex; j++) {
                if (onBulbArray[j] == 0) {
                    isOnBulb = false;
                }

            }

            if (isOnBulb) {
                result++;
            }

        }

//		return result;

        System.out.println(result);
    }

    public static int s2(int[] A) {
        root = new int[A.length + 1];
        for (int i = 1; i < A.length + 1; i++) {
            root[i] = i;
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {

            union(A[i], A[i] - 1);

            if (root[A[i]] == 0) {
                count++;
            }
        }

        return count;
    }

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return find(root[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        root[x] = y;
    }
}

package Tree;

public class SatisfiabilityOfEqualityEquations990 {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(equations.length);
            for (String e : equations) {
                if (e.charAt(1) == '=') {
                    uf.union(e.charAt(0), e.charAt(3));
                }
            }
            for (String e : equations) {
                if (e.charAt(1) == '!') {
                    if (uf.connected(e.charAt(0), e.charAt(3))) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * Union-Find
         */
        public class UF {
            private int count;
            private int[] parent;
            private int[] size;

            // init with n size
            public UF(int n) {
                parent = new int[n];
                size = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public void union(int a, int b) {
                int p = findRoot(a);
                int q = findRoot(b);
                if (p == q) {
                    return;
                }
                if (size[p] > size[q]) {
                    parent[q] = p;
                    size[p] += size[q];
                } else {
                    parent[p] = q;
                    size[q] += size[p];
                }
                count--;
            }

            public boolean connected(int a, int b) {
                int p = findRoot(a);
                int q = findRoot(b);
                return p == q;
            }

            public int findRoot(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
        }
    }
}

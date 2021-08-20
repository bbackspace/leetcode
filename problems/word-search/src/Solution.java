class Solution {
    static class Board {
        int m;
        int n;
        char[][] b;
        BitSet v;
        String word;
        
        Board(char[][] b, String word) {
            this.m = b.length;
            this.n = b[0].length;
            this.b = b;
            this.v = new BitSet(m * n);
            this.word = word;
        }
        boolean search(int i, int j, int len) {
            if (word.length() == len) {
                return true;
            }
            if (i < 0 || j < 0 || i >= m || j >= n || v.get(i * n + j)) {
                return false;
            }
            if (word.charAt(len) != b[i][j]) {
                return false;
            }
            v.set(i * n + j);
            if (search(i + 1, j, len + 1)) return true;
            if (search(i, j + 1, len + 1)) return true;
            if (search(i - 1, j, len + 1)) return true;
            if (search(i, j - 1, len + 1)) return true;
            v.clear(i * n + j);
            return false;
        }
        
        boolean searchAllCells() {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (search(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        boolean preFilter() {
            Set<Character> characters = new HashSet<>();
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    characters.add(b[i][j]);
            for (int i = 0; i < word.length(); i++)
                if (!characters.contains(word.charAt(i)))
                    return false;
            return true;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        Board b = new Board(board, word);
        if (!b.preFilter()) return false;
        return b.searchAllCells();
    }
}


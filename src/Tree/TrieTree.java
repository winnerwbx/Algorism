package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
class TrieTree {
    class Trie {
        private static final char START_CHAR = ' ';
        private static final char END_CHAR = '#';
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode(START_CHAR);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char a = word.charAt(i);
                if (!node.nodes.containsKey(a)) {
                    node.nodes.put(a, new TrieNode(a));
                }
                node = node.nodes.get(a);
            }
            node.nodes.put(END_CHAR, new TrieNode(END_CHAR));
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char a = word.charAt(i);
                if (!node.nodes.containsKey(a)) {
                    return false;
                }
                node = node.nodes.get(a);
            }
            if (node.nodes.containsKey(END_CHAR)) {
                return true;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char a = prefix.charAt(i);
                if (!node.nodes.containsKey(a)) {
                    return false;
                }
                node = node.nodes.get(a);
            }
            return true;
        }
    }

    class TrieNode {
        public char c;
        public Map<Character, TrieNode> nodes = new HashMap<>();

        public TrieNode(char c) {
            this.c = c;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
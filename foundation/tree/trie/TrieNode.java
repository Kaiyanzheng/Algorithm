package foundation.tree.trie;

import foundation.tree.binarySearchTree.TreeNode;

import java.util.HashMap;

public class TrieNode {

    TrieNode[] children;
    boolean isWord;

    //char c;
    //HashMap<Character, TrieNode> map;
    //String word;

    public TrieNode() {
        children = new TrieNode[26];  //不一定有26个，可以放各种标点
        isWord = false;
    }

    public static void main(String[] args) {

    }
}

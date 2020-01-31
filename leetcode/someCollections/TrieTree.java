package leetcode.someCollections;

/** Trie树，用于存储、检索ip地址, 叶子节点标记为ip地址对应的ISP
 *
 * Trie树使用公共前缀，降低查询时间，减小了存储空间。为了构建Trie树，将IP地址二进制化（32位的二进制）。用于查询的Trie树一棵二叉树，满足以下性质：
 * 1. 非叶子节点的左孩子节点为0，右孩子节点为1；
 * 2. 叶子节点存储IP地址所对应的ISP。 */
public class TrieTree {
    private TrieNode root = null;   //根节点

    /**二叉树的节点*/
    class TrieNode {
        String element;  //非叶子节点为空 叶子节点标记为ISP
        TrieNode[] children; //左孩子节点为0 右孩子节点为1

        public TrieNode() {
            element = "";
            children = new TrieNode[2];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public TrieTree() { root = new TrieNode(); }

    /** 插入ip地址 */
    public void insert(TrieNode root, String ipAddress, String isp) {
        if(ipAddress.length() > 32) {
            System.out.println("invalid IP");
        } else {
            TrieNode crawl = root;
            for (int i = 0; i < ipAddress.length(); i++) {
                int index = (int) ipAddress.charAt(i) - '0';
                if(crawl.children[index] == null) {
                    crawl.children[index] = new TrieNode();
                }
                crawl = crawl.children[index];
            }
            crawl.element = isp;
        }
    }

    public void insert(String ipAddress, String isp) {
        insert(root, ipAddress, isp);
    }

    /** 检索ip地址，返回其所对应的ISP, 若不在Trie树中，则返回null */
    public String search(String binaryIP) {
        TrieNode crawl = root;
        for (int i = 0; crawl.element.length() == 0; i++) {
            int index = (int) binaryIP.charAt(i) - '0';
            if (crawl.children[index] == null) {
                return null;
            }
            crawl = crawl.children[index];
        }
        return crawl.element;
    }
}





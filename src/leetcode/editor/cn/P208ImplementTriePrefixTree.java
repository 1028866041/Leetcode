//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 496 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P208ImplementTriePrefixTree{
    public static void main(String[] args) {
        Trie solution = new P208ImplementTriePrefixTree().new Trie();
        // TO TEST
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    Trie[] next;
    boolean end;
    /** Initialize your data structure here. */
    public Trie() {
        next= new Trie[26];
        end= false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur= this;
        for(int i=0;i<word.length();i++){
            int j= word.charAt(i)-'a';
            if(cur.next[j]==null)
                cur.next[j]= new Trie();
            cur= cur.next[j];
        }
        cur.end= true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur= this;
        for(int i=0;i<word.length();i++){
            int j= word.charAt(i)-'a';
            if(cur.next[j]==null)
                return false;
            cur= cur.next[j];
        }
        return cur.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur= this;
        for(int i=0;i<prefix.length();i++){
            int j= prefix.charAt(i)-'a';
            if(cur.next[j]==null)
                return false;
            cur= cur.next[j];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
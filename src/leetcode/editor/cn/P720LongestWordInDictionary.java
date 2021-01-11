//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入: 
//words = ["w","wo","wor","worl", "world"]
//输出: "world"
//解释: 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2:
//
// 
//输入: 
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出: "apple"
//解释: 
//"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
// 
//
// 注意: 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

//Java：词典中最长的单词
public class P720LongestWordInDictionary{
    public static void main(String[] args) {
        Solution solution = new P720LongestWordInDictionary().new Solution();
        // TO TEST
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestWord(String[] words) {
        Trie trie= new Trie();
        int index=0;
        for(String word:words){
            trie.insert(word, ++index);
        }
        //todo throw debug
        trie.words= words;
        return trie.traverse();
    }
}

class Node{
    char c;
    int end;
    HashMap<Character,Node> child= new HashMap<>();
    public Node(char c){
        this.c=c;
    }
}
class Trie{
    Node root;
    String[] words;
    public Trie(){
        root = new Node('0');
    }
    public void insert(String str, int idx){
        Node cur= root;
        for(char c:str.toCharArray()){
            cur.child.putIfAbsent(c, new Node(c));
            cur= cur.child.get(c);
        }
        cur.end= idx;
    }

    public String traverse(){
        String result= "";
        Stack<Node> stack= new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node node= stack.pop();
            if(node.end>0|| node==root){
                if(node!= root){
                    String word= words[node.end-1];
                    if(word.length()>result.length()||word.length()==result.length()){
                        result= word;
                    }
                }
                for(Node nei:node.child.values()){
                    stack.push(nei);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
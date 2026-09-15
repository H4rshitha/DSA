/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> lis = new ArrayList<Integer>();
        TreeNode node = root;
        while(true){
            if(node !=null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                lis.add(node.val);
                node = node.right;
            }
        }
        return lis;
    }
}
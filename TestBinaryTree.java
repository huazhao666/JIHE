import java.util.*;
/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-06
 * Time : 17:52
 */
class TreeNode {
    public  char val;
    public  TreeNode left;
    public  TreeNode right;

    public  TreeNode (char val){
        this.val = val;
    }
}

public class TestBinaryTree {
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    //前序遍历
    void preOrger(TreeNode root){
        if(root == null) return;
        System.out.println(root.val + " ");
        preOrger(root.left);
        preOrger(root.right);
    }
    //中序遍历
    void inOreder(TreeNode root){
        if(root == null) return;
        inOreder(root.left);
        System.out.println(root.val + " ");
        inOreder(root.right);
    }
    //后续遍历
    void  postOreder(TreeNode root){
        if(root == null) return;
        postOreder(root.left);
        postOreder(root.right);
        System.out.println(root.val + " ");
    }
    //二叉树的节点数量
    static int size = 0;
    void getSize2(TreeNode root){
        if(root == null) return;
        size++;
        getSize2(root.left);
        getSize2(root.right);
    }
    int getSize3(TreeNode root){
        if (root == null) return 0;
        return getSize3(root.left)+getSize3(root.right) + 1;
    }
    //叶节点数量
    static  int leafSize = 0;
    void getLeafSize(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leafSize ++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    int getLeafSize2(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null ){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    //k层的节点数量；
    int getaKleve1Size(TreeNode root ,int k){
        if(root == null) return 0;
        if(k == 1) return 1;
        return getaKleve1Size(root.left,k-1)+getaKleve1Size(root.right,k-1);
    }
    //获取二叉树的高度；
    int getHigh(TreeNode root){
        if(root == null) return  0;
        int leftHigh = getHigh(root.left);
        int rightHigh = getHigh(root.right);
        if(leftHigh > rightHigh){
            return leftHigh + 1;
        }else {
            return rightHigh + 1;
        }
    }
    //查找值为val的节点（根->左->右）
    TreeNode find(TreeNode root ,char val){
        if(root == null) return  null;
        if(root.val == val) return root;
        TreeNode ret = find(root.left,val);
        if(ret != null){
            return ret;
        }else {
            return find(root.right,val);
        }
    }

    //检查两个数是否相同
    boolean isSame(TreeNode s,TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }
    //一颗树是不是另外一棵树的子数
    boolean isSubtree(TreeNode tree,TreeNode tree1){
        if(tree == null ) return false;
        return isSubtree(tree.left,tree1) || isSubtree(tree.right,tree1)|| isSame(tree,tree1);
    }
    //判断是否是平衡树
    boolean isBalanced (TreeNode root){
        if(root == null) return true;
        if(Math.abs(getHigh(root.left)- getHigh(root.right)) > 1){
            return  false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //是不是对称二叉树;
    boolean isSymmericChild(TreeNode leftTree ,TreeNode rightTree){
        if(leftTree == null &&  rightTree == null) return true;
        if(leftTree == null || rightTree == null) return  false;
        if(leftTree.val != rightTree.val) return  false;
        return isSymmericChild(leftTree.left,rightTree.right)
              &&  isSymmericChild(leftTree.right,rightTree.left);
    }

    boolean isSYmmeric(TreeNode root){
        if(root == null) return true;
        return isSymmericChild(root.left,root.right);
    }
    //层序遍历
     void levelOrederTraversal(TreeNode root){
        if(root == null) return;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()){
             TreeNode cur = queue.poll();
             if(cur != null){
                 System.out.println(cur.val+ " ");
             }
         }
         if(root.left != null) queue.offer(root.left);
         if(root.right != null) queue.offer(root.right);
     }
    public  List<List<Character>> levelOrderTraversal2(TreeNode root) {
        List<List<Character>> list = new ArrayList<>();
        if(root == null) return  list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Character> rowList = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                TreeNode prev = queue.poll();
                if(prev != null){
                    rowList.add(prev.val);
                    if(prev.left != null) queue.offer(prev.left);
                    if(prev.right != null) queue.offer(prev.right);
                    size--;
                }
            }
        }
        return list;
    }
    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum-root.val);
    }
    // 给你一个树，请你按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
    public TreeNode increasingBST(TreeNode root) {
        List<Character> list = new ArrayList<>();
        inOreder(root,list);
        TreeNode ans = new TreeNode('0');
        TreeNode cur = ans;
        for(char n : list){
            cur.right = new TreeNode( n );
            cur = cur.right;
        }
        return ans.right;

    }
    public void inOreder(TreeNode root,List<Character> list){
        if(root == null) return ;
        inOreder(root.left,list);
        list.add(root.val);
        inOreder(root.right,list);
    }

}
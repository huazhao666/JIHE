import java.util.*;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-05
 * Time : 10:39
 */
class  Node1{
    public  char val ;
    public  Node1 left ;
    public  Node1 right ;

    public  Node1(char val){
        this.val = val;
    }


}
public class TestTree {

    public Node1 createTree() {
        Node1 A = new Node1('A');
        Node1 B = new Node1('B');
        Node1 C = new Node1('C');
        Node1 D = new Node1('D');
        Node1 E = new Node1('E');
        Node1 F = new Node1('F');
        Node1 G = new Node1('G');
        Node1 H = new Node1('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    void preOrger(Node1 root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrger(root.left);
        preOrger(root.right);
    }

    void inOrder(Node1 root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    void postOreder(Node1 root) {
        if (root == null) return;
        postOreder(root.left);
        postOreder(root.right);
        System.out.print(root.val + " ");
    }

    //打印出二叉树的节点数量
    static int size = 0;

    void getSize1(Node1 root) { //遍历
        if (root == null) return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    int getSize2(Node1 root) { //子问题思路
        if (root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;//左数加右数在加1；
    }


    //打印叶节点数量
    static int leafsize = 0; //遍历法

    void getLeafSize(Node1 root) {
        if (root == null) return;
        if (root.left == null && root.right == null) leafsize++;
        getLeafSize(root.left);
        getLeafSize(root.right);
    }


    int getLeafSize2(Node1 root) { //子节点法
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getLeafSize2(root.left) + getLeafSize2(root.right);

    }

    //打印k层的节点数量
    int getKLevelSize(Node1 root, int k) {
        if (root == null) return 0;
        if (k == 1) return 1;
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);//左侧k-1层的节点数加上右侧k-1层的节点
    }

    //获取二叉树的高度
    int getHeight(Node1 root) { //判断左树和右树的高度；
        if (root == null) return 0;
        int leftHeight = getHeight(root.left); //左边高度
        int rightHeight = getHeight(root.right);//右边高度
        if (leftHeight < rightHeight) {
            return rightHeight + 1; //加上根节点的的那一层高度；
        }
        return leftHeight + 1;
    }

    //查找 val 所在结点，没有找到返回 null，按照 根 -> 左子树 -> 右子树的顺序进行查找，一旦找到，立即返回，不需要继续在其他位置查找
    Node1 find(Node1 root, char val) {
        if (root == null) return null;
        if (root.val == val) return root;
        Node1 ret1 = find(root.left, val);
        if (ret1 != null) {
            return ret1;
        } else {
            return find(root.right, val);
        }
    }

    //检查两棵树是否相同；
    public boolean isSame(Node1 tree, Node1 tree2) {
        if (tree == null && tree2 != null || tree != null && tree2 == null) return false;
        if (tree == null && tree2 == null) return true;
        if (tree.val != tree2.val) return false; //两个根节点是否相同；
        return isSame(tree.left, tree2.left) && isSame(tree.right, tree2.right);
    }

    //这个也是思路更快；
    public boolean isSame2(Node1 tree, Node1 tree2) {
        if (tree == null && tree2 == null) return true;
        if (tree == null || tree2 == null) return false; //如果第一个不成立，那么只要有一个为空，另外一个一定不是空；
        if (tree.val != tree2.val) return false;
        return isSame2(tree.left, tree2.left) && isSame2(tree.right, tree2.right);
    }

    //判断一棵树是不是另外一棵树的子shu；(t 是不是s的子树)；
    public boolean isSubtree(Node1 s, Node1 t) {
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSame2(s, t); //这里需要写一个判断两个树是相等的方法；
    }

    //判断一棵树是不是平衡树；
    public boolean isBalanced(Node1 root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false; //这里需要写一个方法是求树的高度，
        return isBalanced(root.left) && isBalanced(root.right);//检差左树和右数是否平衡；

    }

    //判断一棵树是不是对称的二叉树
    public boolean isSymmetricChild(Node1 leftTree, Node1 rightTree) { //自己写的方法，
        if (leftTree == null && rightTree == null) return true; //都为空的话，就是平衡的
        if (leftTree == null || rightTree == null) return false; // 有一个空就是不平衡；
        if (leftTree.val != rightTree.val) return false; //左数的节点值不等于右树的节点值，假的
        return isSymmetricChild(leftTree.left, rightTree.right)  //满足左树的左边等于右树的右边，左数的右边等于右树的左边；
                && isSymmetricChild(leftTree.right, rightTree.left);
    }

    public boolean isSymmetric(Node1 root) { //题目要求；
        if (root == null) return true;
        return isSymmetricChild(root.left, root.right);//调用判断左右是否平衡的方法
    }

    //层序遍历；
    void levelOrderTraversal(Node1 root) {
        if (root == null) return;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node1 cur = queue.poll();//记录队列弹出的值；
            System.out.println(cur.val);
            if (cur.left != null) queue.offer(cur.left); //如果cur的左边不是空的，那就把他左边放进来；
            if (cur.right != null) queue.offer(cur.right);//如果cur的右边不是空的，那就把他右边放进来；
        }
    }

    //有返回值的层序遍历
    public List<List<Character>> levelOrderTraversal2(Node1 root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //row 保证每一行的数据；
            List<Character> row = new ArrayList<>();
            int count = queue.size();//记录每一行的数据
            while (count != 0) { //当前行数据子数不为0时；
                Node1 cur = queue.poll();
                if (cur != null) {
                    row.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    count--;
                }
            }
            ret.add(row);
        }
        return ret;
    }

    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(Node1 root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //给你一个树，请你按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点
    public TreeNode increasingBST(Node1 root) {
        List<Character> list = new ArrayList<>();
        inOreder(root, list);
        TreeNode prev = new TreeNode('0');
        TreeNode cur = prev;
        for (char n : list) {
            cur.right = new TreeNode(n);
            cur = cur.right;
        }
        return prev.right;

    }

    public void inOreder(Node1 root, List<Character> list) {
        if (root == null) return;
        inOreder(root.left, list);
        list.add(root.val);
        inOreder(root.right, list);
    }

    //判断是不是完全二叉树；
    boolean isCompleteTree(Node1 root) {
        if (root == null) return true;
        Queue<Node1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node1 cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            Node1 cur = queue.peek();
            if (cur != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }

    //字符串构建二叉树；
    public int i = 0;
    public Node1 createTreeBinary(String str) {
        Node1 root = null;
        if (str.charAt(i) != '#') {
            root = new Node1(str.charAt(i));//构建根节点
            i++;
            root.left = createTreeBinary(str);//构建左
            root.right = createTreeBinary(str);//构建右；
        } else {
            i++;
        }
        return root;
    }

    //二叉树的最近公共祖先
    public Node1 lowestCommonAncestor(Node1 root, Node1 p, Node1 q) {
        if(root == null) return  null;
        if(root == p || root == q) return root;
        Node1 leftTree = lowestCommonAncestor(root.left ,p,q);//找左边；
        Node1 rightTree = lowestCommonAncestor(root.right,p,q);//找右边；
        if(leftTree != null && rightTree != null){//说明一左一右
            return  root;
        }
        if(leftTree != null){ //说明都在左边
            return leftTree;
        }
        return  rightTree;
    }
    //二叉搜索树转换为排序双向链表；
    public  Node1 prev = null;
    public void ConvertChild(Node1 root) {
        if(root == null)  return;
        ConvertChild(root.left);
        root.left = prev; //left是前驱
        if(prev != null)  prev.right = root;//注意是否位第一次情况，right是后驱；
        prev = root; //更新情况；
        ConvertChild(root.right);

    }
    public Node1 Convert(Node1 pRootOfTree) {
        if(pRootOfTree == null) return  null;
        ConvertChild(pRootOfTree);
        Node1 head = pRootOfTree; //寻找链表的头；
        while (head.left != null){
            head =head.left;
        }
        return  head;
    }
    //二叉树创建字符串；
    public  void treeStrChild(Node1 t ,StringBuilder sb){
        if(t == null) return;
        sb.append(t.val);
        if(t.left == null){ //当左边位空的话
            if(t.right == null){ //如果右边也是空的，说明这棵树结束；
                return;
            }else {//右边不是空的话九加上（）
                sb.append(" ()");
            }
        }else { //左边不是空，此时就先加上（；然后递归左边，在加上）；
            sb.append('(');
            treeStrChild(t.left,sb);
            sb.append(')');
        }
        if(t.right == null){ //当右边为空的时候，直接返回
            return;
        }else { //右边不是空的话，递归右边；
            sb.append('(');
            treeStrChild(t.right,sb);
            sb.append(')');
        }
    }
    public  String  treeStr(Node1 t){
        if(t == null) return  "";
        StringBuilder sb = new StringBuilder();
        treeStrChild(t,sb);//调用函数；
        return  sb.toString();
    }
    //前序中序构建二叉树；
    public int prelndex = 0; //前序遍历的第一位，
    public  Node1 buildTreeChild(char[] preorder ,char[]inorder ,int inbegin,int inend){
        if(inbegin > inend){ //如果中序遍历的开始位置大于结束位置，说明没有左右孩子了；
            return  null;
        }
        Node1 root = new Node1(preorder[prelndex]);//根节点
        int inorderindex = findinorderIndexOfRoot(inorder,inbegin,inend,preorder[prelndex]);//中序遍历中的根节点所在位置；
        prelndex ++; //第二个根节点
        root.left = buildTreeChild(preorder,inorder,inbegin,inorderindex-1);//左边从开始位置到根节点位置前一位
        root.right = buildTreeChild(preorder,inorder,inorderindex +1,inend);//右边根节点后一位到结束位置；
        return  root;
    }

    public int findinorderIndexOfRoot(char[] inorder,int inbegin, int inend ,char val){ //寻找中序遍历中的根节点位置
        for(int j = inbegin;j <= inend;j++){
            if(inorder[j] == val){ //这里的val就是中序遍历的的根节点的值；
                return j;
            }
        }
        return -1;
    }
    public Node1 buildTree(char[] preorder,char[] inorder){
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length == 0) return  null;
        return buildTreeChild(preorder,inorder,0,inorder.length-1) ;//从中序遍历的0号位置开始寻找，结束位置为中序遍历的最后一位；
    }
    //中序遍历和后续遍历；
    public  Node1 buildTreeChild2(char[] inorder ,char[]postorder ,int inbegin,int inend){
        if(inbegin > inend){ //如果中序遍历的开始位置大于结束位置，说明没有左右孩子了；
            return  null;
        }
        Node1 root = new Node1(postorder[prelndex]);//根节点
        int inorderindex = findinorderIndexOfRoot2(inorder,inbegin,inend,postorder[prelndex]);
        prelndex --; //第二个根节点
        root.right = buildTreeChild(inorder,postorder,inorderindex +1,inend);
        root.left = buildTreeChild(inorder,postorder,inbegin,inorderindex-1);
        return  root;
    }

    public int findinorderIndexOfRoot2(char[] inorder,int inbegin, int inend ,char val){
        for(int j = inbegin;j <= inend;j++){
            if(inorder[j] == val){
                return j;
            }
        }
        return -1;
    }
    public Node1 buildTree2(char[] inorder,char[] postorder){
        if(inorder == null || postorder == null) return null;
        if(inorder.length == 0 || postorder.length == 0) return  null;
        prelndex = postorder.length-1;
        return buildTreeChild(inorder,inorder,0,inorder.length-1) ;
    }
}


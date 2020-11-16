package SetAndMap;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-16
 * Time : 11:41
 */
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int val){
           this.val = val;
        }
    }
    TreeNode root =  null;
    public void put(int key){
        TreeNode node = new TreeNode(key);
        if(root == null) {
            root = node;
            return;
        }
        TreeNode partent = null;
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == key){
                cur = node;
                return;
            }else if (cur.val < key){
                partent = cur;
                cur = cur.right;
            }else {
                partent = cur;
                cur = cur.left;
            }
        }
        if(partent.val < key){
            partent.right = node;
        }else {
            partent.left = node;
        }
    }
    public TreeNode findKey(int key){
        if(root == null) return null;
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == key){
                return cur;
            }else if (cur.val < key){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
    public void postorder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        postorder(root.left);
        postorder(root.right);
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = {23, 54, 12, 45, 64, 67, 76, 25, 65};
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i]);
        }
        tree.postorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        tree.put(52);
        System.out.println();
        tree.inorder(tree.root);
        tree.put(23);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        TreeNode ret = tree.findKey(52);
        if(ret == null){
            System.out.println("找不到");
        }else {
            System.out.println(ret.val + " ");
        }
    }
}

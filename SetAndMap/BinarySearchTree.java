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
    //插入元素；
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
            if(cur.val == key){ //二叉搜索数不存在数值相同的节点，因此加入一个已经存在的元素，就会自动替换掉；
                cur.val = node.val;
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
    //寻找关键字key
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
    public void preorder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    //删除关键字；
    public void remove(int key){
        TreeNode partent = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == key){
                break;
            }else if(cur.val < key){
                partent = cur;
                cur = cur.right;
            }else {
                partent = cur;
                cur = cur.left;
            }
        }
        if(cur == null) return;
        removeNode(partent,cur);
    }
    public void removeNode(TreeNode partent,TreeNode cur) {
        if(cur.left == null){
            if (cur == root){
                root = cur.right;
            }else if(partent.left == cur){
                partent.left = cur.right;
            }else {
                partent.right = cur.right;
            }
        }else if(cur.right == null){
            if (cur == root){
                root = cur.left;
            }else if(partent.right == cur){
                partent.left = cur.left;
            }else {
                partent.right = cur.left;
            }
        }else {
            TreeNode targetPartent = cur;
            TreeNode target = targetPartent.right;
            while (target.left != null){
                targetPartent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetPartent.left){
                targetPartent.left = target.right;
            }else {
                targetPartent.right = target.right;
            }
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] array = {23, 54, 12, 45, 64, 67, 76, 25, 65};
        for (int i = 0; i < array.length; i++) {
            tree.put(array[i]);
        }
        tree.preorder(tree.root);
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
        try {
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("找不到这个节点");
        }
    }
}

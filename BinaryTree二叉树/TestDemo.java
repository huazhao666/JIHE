package BinaryTree二叉树;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-16
 * Time : 10:47
 */
public class TestDemo {
    public static void main (String[] args){
        TestTree  testTree = new TestTree();
        Node1 root = testTree.createTree();
        /*testTree.postOrder(root);
        System.out.println();
        testTree.inOrder(root);
        System.out.println();
        testTree.inOrderTraversal(root);
        System.out.println();
        testTree.postOrder(root);
        System.out.println();
        testTree.postOrderTraversal(root);*/
        testTree.inOrderTraversal(root);
        System.out.println();

//        System.out.println();
//        System.out.println(testTree.getSize2(root));
//        testTree.getSize1(root);
//        System.out.println(TestTree.size);
//        System.out.println(testTree.getLeafSize2(root));
//        testTree.getLeafSize(root);
//        System.out.println(TestTree.leafsize);
//        System.out.println("==============");
//        System.out.println(testTree.getKLevelSize(root,3));
//        System.out.println("==========");
//        System.out.println(testTree.getHeight(root));
//        Node1 ret2 = testTree.find(root,'M');
//        if(ret2 == null){
//            System.out.println("找不到");
//        }else {
//            System.out.println(ret2.val);
//        }
//        System.out.println("--------");
//        System.out.println(testTree.isCompleteTree(root));
    }
}

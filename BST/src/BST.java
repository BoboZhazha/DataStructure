
// 二分搜索树要求存储的元素具有可比性
public class BST<E extends Comparable<E>> {

    // 节点, 私有的内部类, 对用户来说是屏蔽的
    private class Node {

        //存放元素
        public E e;

        //指向左右孩子的成员变量
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // 根节点
    private Node root;

    // 存储了多少个元素
    private int size;


    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // 向二分搜索树中添加新的元素
    public void add(E e) {
        root = add(root, e);
    }

    // 向以 node为根 的二分搜索树中插入元素E, 递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }


}

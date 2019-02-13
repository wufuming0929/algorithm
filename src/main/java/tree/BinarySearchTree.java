package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 项目名称：algorithm
 * 包： tree
 * 类名称：BinarySearchTree.java
 * 类描述：二叉搜索树(不包含重复数据)
 * 创建人：wufuming
 * 创建时间：2019年02月13日
 */
public class BinarySearchTree {

    private Node root;
    private List<Integer> order = new ArrayList<>();

    /**
     * 获取二叉树的深度：递归实现
     */
    public int level() {
        return getLevel(root);
    }

    private int getLevel(Node p) {
        if (p == null) return 0;
        return Math.max(getLevel(p.left), getLevel(p.right)) + 1;
    }
    /**
     * 获取二叉树的深度：层续遍历实现
     */
    public  int maxDepth() {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelNum = 1;//每一层节点数量，递减
        int levelCount = 0;//每一层节点数量，递增

        int level = 0;//层数

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            levelNum--;

            if (p.left != null) {
                queue.offer(p.left);
                levelCount++;
            }
            if (p.right != null) {
                queue.offer(p.right);
                levelCount++;
            }

            if (levelNum == 0) {
                levelNum = levelCount;
                levelCount = 0;
                level++;
            }
        }
        return level;
    }


    public Node preNode(int data) {
        Node p = root;
        Node pre = null;
        while (p != null && data != p.data) {
            pre = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return null;//不存在节点
        return pre;
    }

    public Node nextNode(int data) {
        Node target = get(data);
        Node ret = null;
        if (target != null) {
            if (target.right != null) {
                ret = target.right;
            }
        }
        return ret;
    }

    public Node maxNode() {
        Node p = root;
        Node max = null;
        while (p != null) {
            max = p;
            p = p.right;
        }
        return max;
    }

    public Node minNode() {
        Node p = root;
        Node min = null;
        while (p != null) {
            min = p;
            p = p.left;
        }
        return min;
    }

    /**
     * 插入操作
     */
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 查找操作
     */
    public Node get(int data) {
        Node p = root;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;

    }

    /**
     * 删除操作，待删除节点分三种情况：
     * 1）没有子节点：父节点指向该节点的指针设为NULL。
     * 2）只有一个子节点：父节点指向该节点的子节点。
     * 3）有两个子节点：找出该节点右子树中的最小节点，用最小节点的值替换掉该节点的值，
     * 然后删除掉最小节点，此时删除最小节点符合上面2种情况之一(最小值没有左子树，否则就不是最小值)。
     */
    public void remove(int data) {

        Node p = root;//待删除节点
        Node pp = null;//待删除节点的父节点

        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;//节点不存在
        //待删除节点有两个子节点，找出右子树中的最小节点替换待删除节点
        if (p.right != null && p.left != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;//替换值
            p = minP;
            pp = minPP;
        }
        //待删除节点只有一个子节点或者没有子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else child = null;

        if (pp == null) root = child;//删除根节点
        if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 前序遍历
     */
    public List<Integer> preOrder() {
        order.clear();
        preOrderInternally(root);
        return order;
    }

    private void preOrderInternally(Node p) {
        if (p == null) return;
        order.add(p.data);
        preOrderInternally(p.left);
        preOrderInternally(p.right);
    }

    /**
     * 中序遍历
     */
    public List<Integer> inOrder() {
        order.clear();
        inOrderInternally(root);
        return order;
    }

    private void inOrderInternally(Node p) {
        if (p == null) return;
        inOrderInternally(p.left);
        order.add(p.data);
        inOrderInternally(p.right);
    }

    /**
     * 后续遍历
     */
    public List<Integer> postOrder() {
        order.clear();
        postOrderInternally(root);
        return order;
    }

    private void postOrderInternally(Node p) {
        if (p == null) return;
        postOrderInternally(p.left);
        postOrderInternally(p.right);
        order.add(p.data);
    }

    /**
     * 层序遍历
     */
    public List<Integer> levelOrder() {
        if (root == null) return null;
        order.clear();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node p = queue.poll();
            order.add(p.data);
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return order;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + (left == null ? "null" : left.data) +
                    ", right=" + (right == null ? "null" : right.data) +
                    '}';
        }
    }

    public static void main(String[] arges) {

        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {8, 9, 3, 5, 7, 6, 2, 11, 12};
        for (int i : arr) {
            tree.add(i);
        }
        System.out.println("前序遍历：" + tree.preOrder());
        System.out.println("中序遍历：" + tree.inOrder());
        System.out.println("后序遍历：" + tree.postOrder());
        System.out.println("层序遍历：" + tree.levelOrder());
    }

   


}
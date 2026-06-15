import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        t1.data += t2.data;

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    static Node buildTree(Scanner sc) {
        int val = sc.nextInt();

        if (val == -1)
            return null;

        Node root = new Node(val);

        root.left = buildTree(sc);
        root.right = buildTree(sc);

        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first tree in preorder (-1 for NULL):");
        Node root1 = buildTree(sc);

        System.out.println("Enter second tree in preorder (-1 for NULL):");
        Node root2 = buildTree(sc);

        Node mergedRoot = mergeTrees(root1, root2);

        System.out.println("Inorder traversal of merged tree:");
        inorder(mergedRoot);

        sc.close();
    }
}

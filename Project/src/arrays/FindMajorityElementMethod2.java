package arrays;

// Complexidade O(n²) - No pior dos casos, cada valor terá que percorrer a árvore inteira para ser adicionado

public class FindMajorityElementMethod2 {

    public static int ma = 0;

    public static void main(String[] args) {

        int[] a = { 1, 3, 3, 3, 2 };
        int size = a.length;
        Node root = null;

        for (int i = 0; i < size; i++) {
            root = insert(root, a[i]);
        }

        if (ma > ( size / 2 )) {
            inorder(root, size);
        }
        else {
            System.out.println("No majority element");
        }
    }

    public static Node newNode(int item) {

        Node temp = new Node();
        temp.key = item;
        temp.c = 1;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    public static Node insert(Node node, int key) {

        if (node == null) {
            if (ma == 0) {
                ma = 1;
            }

            return newNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        else {
            node.c++;
        }

        ma = Math.max(ma, node.c);

        return node;
    }

    public static void inorder(Node root, int s) {

        if (root != null) {
            inorder(root.left, s); // Percorre todo o lado esquerdo da árvore, até encontrar um ponteiro que seja nulo.

            if (root.c > (s / 2)) {
                System.out.println(root.key + "\n");
            }

            inorder(root.right, s); // De cada um dos lados esquerdos percorridos, percorre todos os direitos, até encontrar um ponteiro nulo.
        }
    }
}

class Node {
    int key;
    int c = 0;
    Node left;
    Node right;
}
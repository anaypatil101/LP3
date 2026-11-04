import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}
public class Huffman {

    static void print(Node root, String code) {
        if(root == null)
            return;

        if(root.ch != '$')
            System.out.println(root.ch + " : " + code);

        print(root.left, code + "0");
        print(root.right, code + "1");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
        int n = sc.nextInt();
        
        for(int i=0; i<n; i++) {
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        while(pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('$', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        print(pq.peek(), "");
        sc.close();
    }
}

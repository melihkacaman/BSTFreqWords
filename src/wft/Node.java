package wft;

public class Node {
    String data;
    Node leftChild, rightChild;
    LinkedList info;

    public Node(String data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.info = new LinkedList();
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}

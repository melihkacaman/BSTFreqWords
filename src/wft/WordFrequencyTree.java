package wft;

public class WordFrequencyTree {
    private Node root;
    private int size;

    public WordFrequencyTree(){
        this.size = 0;
        this.root = null;
    }

    // TO DO: make the recursive
    public void insert(String newWord, String fileName){
        Node newNode = new Node(newWord);

        if (isEmpty()){
            newNode.info.addFirst(new NodeForLL(fileName));
            this.root = newNode;
        }
        else {
            Node temp = this.root;

            while (temp!= null){
                if (newWord.compareTo(temp.data) > 0) {
                    if(temp.rightChild == null) {
                        temp.rightChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.rightChild;
                }
                else if(newWord.compareTo(temp.data) < 0){
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.leftChild;
                }else {
                    NodeForLL newNodeForLL = temp.info.Find(fileName);
                    System.out.print(newWord+"-->");
                    if(newNodeForLL != null) {  // it might be caused
                       newNodeForLL.count = newNodeForLL.count + 1;
                    }
                    else {
                        newNodeForLL = new NodeForLL(fileName);
                        temp.info.addFirst(newNodeForLL);
                    }
                    return;
                }
            }
        }
    }

    private boolean isEmpty(){
        return this.root == null;
    }
}

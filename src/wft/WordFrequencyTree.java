package wft;

public class WordFrequencyTree {
    private Node root;
    private int size;

    public WordFrequencyTree() {
        this.size = 0;
        this.root = null;
    }

    // TO DO: make the recursive
    public void insert(String newWord, String fileName) {
        Node newNode = new Node(newWord);

        if (isEmpty()) {
            newNode.info.addFirst(new NodeForLL(fileName));
            this.root = newNode;
        } else {
            Node temp = this.root;

            while (temp != null) {
                if (newWord.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.rightChild;
                } else if (newWord.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.leftChild;
                } else {
                    NodeForLL newNodeForLL = temp.info.Find(fileName);
                    System.out.print(newWord + "-->");
                    if (newNodeForLL != null) {  // it might be caused
                        newNodeForLL.count = newNodeForLL.count + 1;
                    } else {
                        newNodeForLL = new NodeForLL(fileName);
                        temp.info.addFirst(newNodeForLL);
                    }
                    return;
                }
            }
        }
    }

    public void query(String query) {
        String[] queryWords = query.toLowerCase().split(" ");
        int count = 0;
        LinkedList resultFreq = new LinkedList();

        for(String word : queryWords) {
            Node resultSearch = search(word);

            NodeForLL temp = resultSearch.info.head;
            while (temp!= null){
                resultFreq.addFirst(temp);
                temp = temp.nextNode;
            }
        }
    }

    private Node search(String searchData) {
        Node result = null;
        if (isEmpty()) {
            System.out.println("Word Freq. Tree is empty!");
        } else {
            Node temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.rightChild;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.leftChild;
                } else {
                    result = temp;
                }
            }
        }
        return result;
    }

    private boolean isEmpty() {
        return this.root == null;
    }
}

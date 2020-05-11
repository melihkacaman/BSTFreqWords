package wft;

public class WordFrequencyTree {
    private Node root;
    private int size;

    // TO DO: make the recursive
    public void insert(String newWord, String fileName) {
        String resultWord = chekcState(newWord);
        if (resultWord == null)
            return;

        Node newNode = new Node(resultWord);

        if (isEmpty()) {
            newNode.info.addFirst(new NodeForLL(fileName));
            this.root = newNode;
        } else {
            Node temp = this.root;

            while (temp != null) {
                if (resultWord.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.rightChild;
                } else if (resultWord.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        newNode.info.addFirst(new NodeForLL(fileName));
                        return;
                    }
                    temp = temp.leftChild;
                } else {
                    NodeForLL newNodeForLL = temp.info.Find(fileName);
                    if (newNodeForLL != null) {  // it might be caused
                        newNodeForLL.freq = newNodeForLL.freq + 1;
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
        String[] queryWords = query.trim().toLowerCase().split(" ");
        int count = 0;
        MinHeap minHeap = new MinHeap(10);

        for (String word : queryWords) {
            Node resultSearch = search(word);

            if (resultSearch != null) {
                NodeForLL temp = resultSearch.info.head;
                while (temp != null) {
                    minHeap.insert(temp.freq, temp.fileName);
                    temp = temp.nextNode;
                }
            }
        }

        minHeap.print();
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
                    return temp;
                }
            }
        }
        return result;
    }

    private String chekcState(String word){
        String result = word.trim().toLowerCase();
        if (result.length() == 1 && Character.isLetter(result.toCharArray()[0])) {
            return result;
        }else if(result.length() > 1){
            String res = "";
            int i = 0;
            for(Character c : result.toCharArray()){
                if(i == 0 && !Character.isLetter(c)) {
                    continue;
                }
                if(i == result.length() -1 && !Character.isLetter(c)){
                    continue;
                }
                res = res + c;
                i++;
            }
            return res;
        }else {
            return null;
        }
    }

    private boolean isEmpty() {
        return this.root == null;
    }
}

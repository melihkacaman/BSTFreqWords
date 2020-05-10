package wft;

class LinkedList {
    protected NodeForLL head;

    public LinkedList() {
        this.head = null;
    }

    void addFirst(NodeForLL newNode) {
        newNode.nextNode = this.head;
        this.head = newNode;
    }

    void addFirst(String fileName) {
        NodeForLL newNode = new NodeForLL(fileName);
        addFirst(newNode);
    }

    NodeForLL Find(String fileName) {
        NodeForLL temp = this.head;

        while (temp != null && !temp.fileName.equals(fileName)) {
            temp = temp.nextNode;
        }

        return temp;
    }



    private boolean isEmpty() {
        return head == null;
    }
}

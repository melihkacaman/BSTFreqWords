package wft;

class NodeForLL {
    String fileName;
    int count;
    NodeForLL nextNode;

    NodeForLL(String fileName) {
        this.fileName = fileName;
        this.count = 1;
        this.nextNode = null;
    }
}

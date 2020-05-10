package wft;

class NodeForLL {
    String fileName;
    int freq;
    NodeForLL nextNode;

    NodeForLL(String fileName) {
        this.fileName = fileName;
        this.freq = 1;
        this.nextNode = null;
    }
}

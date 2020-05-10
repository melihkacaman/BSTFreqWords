package wft;

class MinHeap {
    protected NodeForHeap[] heap;
    private int size = 0;

    MinHeap(int capacity) {
        this.heap = new NodeForHeap[capacity];
    }

    void insert(int freq, String fileName) {
        if (increaseKey(fileName, freq))
            return;
        if (this.size < this.heap.length) {
            heap[size] = new NodeForHeap(fileName, freq);
            int current = size++;

            while (heap[current].freq.compareTo(heap[parent(current)].freq) < 0) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    void swap(int i, int j) {
        NodeForHeap temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    void print() {
        if (this.size > 0){
            for (int i = size-1; i>=0; i--) {
                System.out.print(this.heap[i].fileName + "("+this.heap[i].freq + ") -->");
            }
            System.out.println();
        }
    }

    private boolean increaseKey(String fileName, int amount) {
        for (int i = 0; i < size; i++) {
            if (heap[i].fileName.equals(fileName)) {
                heap[i].freq = heap[i].freq + amount;
                minHeap(i);
                return true;
            }
        }
        return false;
    }


    private void minHeap(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;

        if (left < size && heap[min].freq.compareTo(heap[left].freq) > 0) {
            min = left;
        }

        if (right < size && heap[min].freq.compareTo(heap[right].freq) > 0) {
            min = right;
        }

        if (min != i) {
            swap(min, i);
            minHeap(min);
        }
    }


    private int parent(int current) {
        return (current - 1) / 2;
    }
}

package wft;

class MinHeap {
    protected Integer[] heap;
    private int size = 0;

    MinHeap(int capacity) {
        this.heap = new Integer[capacity];
    }

    void insert(int newData){
        if (this.size < this.heap.length){
            heap[size] = newData;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) < 0){
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    void swap(int i, int j){
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    void print(){
        for(int i: heap){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int parent(int current){
        return (current-1) / 2;
    }
}

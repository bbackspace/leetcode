class MyCircularQueue {

    private List<Integer> circularBuf;
    
    // [start, end) form the queue elements. start == end == -1 denotes empty. 0 <= start == end <= k denotes full.
    private int start;
    private int end;
    private int k;

    public MyCircularQueue(int k) {
        this.k = k;
        this.circularBuf = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            this.circularBuf.add(0);
        }
        
        this.start = -1;
        this.end = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            start = 0;
            end = 1;
        } else {
            end = (end + 1) % k;
        }
        circularBuf.set((end + k - 1) % k, value);
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if ((start + 1) % k == end) { // 1 element
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % k;
        }
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return circularBuf.get(start);
        }
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return circularBuf.get((end + k - 1) % k);
        }
    }
    
    public boolean isEmpty() {
        return start == -1 && end == -1;
    }
    
    public boolean isFull() {
        return start != -1 && start == end;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */


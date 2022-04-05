class MinStack {

    int[] arr;
    int top = -1;
    int capacity = 0;

    /** initialize your data structure here. */
    public MinStack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int val) {
        if (top + 2 > capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[++top] = val;
    }

    public void pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[top--] = 0;
    }

    public int top() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[top];
    }

//    public int getMin() {
//
//    }
}

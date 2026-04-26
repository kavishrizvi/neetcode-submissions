class DynamicArray {
    //use primitives to reduce boxing cost and reduce memory
    private int[] array;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.array = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        checkIndex(i);
        return array[i];
    }

    public void set(int i, int n) {
        checkIndex(i);
        array[i] = n;
    }

    public void pushback(int n) {
        if(size == array.length) {
            resize();
        }
        array[size++] = n;
    }

    public int popback() {
        if(size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        return array[--size];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void checkIndex(int i) {
        if(i < 0 || i>=size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

}

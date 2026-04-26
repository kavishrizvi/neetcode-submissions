class DynamicArray {

    private Integer[] array;
    private Integer size;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.array = new Integer[capacity];
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
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        }
        Integer popped = array[size - 1];
        size--;
        return popped;
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

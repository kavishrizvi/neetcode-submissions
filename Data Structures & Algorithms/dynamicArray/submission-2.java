class DynamicArray {

    private Integer[] array;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.array = new Integer[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (isFull()) {
            resize();
        }
        push(getSize(),n);
    }

    public int popback() {
        Integer lastIndex = array.length - 1;
        while (array[lastIndex] == null) {
            lastIndex--;
        }
        Integer popped = array[lastIndex];
        array = pop(lastIndex);
        return popped;
    }

    public void resize() {
        array = Arrays.copyOf(array, getCapacity() * 2);
    }

    public int getSize() {
        int size = 0;
        for (Integer i : array) {
            if (i != null) {
                size++;
            }
        }
        return size;//return number of elements
    }

    public int getCapacity() {
        return array.length;
    }

    public boolean isFull() {
        return array[array.length - 1] != null;
    }
    private Integer[] pop(Integer index) {
        array[index] = null;
        return array;
    }
    private void push(Integer index, Integer n) {
        array[index] = n;
    }

}

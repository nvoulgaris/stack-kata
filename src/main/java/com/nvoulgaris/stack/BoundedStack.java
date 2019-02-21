package com.nvoulgaris.stack;

public class BoundedStack implements Stack {
    private boolean isEmpty = true;
    private int size;
    private int capacity;
    private int elements[];

    public static Stack Make(int capacity) {
        if (capacity < 0)
            throw new IllegalCapacityException();
        if (capacity == 0)
            return new ZeroCapacityStack();
        return new BoundedStack(capacity);
    }

    private BoundedStack(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(int element) {
        if (size == capacity)
            throw new OverflowException();
        this.elements[size++] = element;
    }

    @Override
    public int pop() {
        if (size == 0)
            throw new UnderflowException();
        return this.elements[--size];
    }

    private static class ZeroCapacityStack implements Stack {
        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void push(int element) {
            throw new OverflowException();
        }

        @Override
        public int pop() {
            throw new UnderflowException();
        }
    }
}

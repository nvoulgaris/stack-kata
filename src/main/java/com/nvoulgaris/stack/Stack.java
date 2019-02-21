package com.nvoulgaris.stack;

public interface Stack {
    boolean isEmpty();

    int size();

    void push(int element);

    int pop();

    class IllegalCapacityException extends RuntimeException {
    }

    class OverflowException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }
}

package com.nvoulgaris.stack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackShould {

    private Stack stack;

    public StackShould() {
        stack = BoundedStack.Make(2);
    }

    @Test
    public void beEmptyWhenIsNewlyCreated() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void incrementItsSizeWithAnyPush() {
        stack.push(1);

        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    public void decrementItsSizeWithAnyPop() {
        stack.push(1);
        stack.pop();

        assertThat(stack.size()).isEqualTo(0);
    }

    @Test(expected = BoundedStack.OverflowException.class)
    public void throwOverflowExceptionWhenPushedPassedLimit() {
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }

    @Test(expected = BoundedStack.UnderflowException.class)
    public void throwUnderflowExceptionWithAnyPopWhenEmpty() {
        stack.pop();
    }

    @Test
    public void popOneWhenOneIsPushed() {
        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void popTwoThenOneWhenOneThenTwoArePushed() {
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test(expected = BoundedStack.IllegalCapacityException.class)
    public void throwIllegalCapacityExceptionWhenCapacityIsNegative() {
        stack = BoundedStack.Make(-1);
    }

    @Test(expected = BoundedStack.OverflowException.class)
    public void overflowWithAnyPushedWhenCapacityIsZero() {
        stack = BoundedStack.Make(0);

        stack.push(1);
    }
}

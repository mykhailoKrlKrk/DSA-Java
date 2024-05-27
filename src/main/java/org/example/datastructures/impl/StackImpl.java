package org.example.datastructures.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.datastructures.Stack;

public class StackImpl implements Stack {
    private final List<Double> stack = new ArrayList<>();

    public void push(Double element) {
        stack.add(element);
    }

    public Double pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack.remove(stack.size() - 1);
    }

    public Double peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }

    public Double findMin() {
        return stack.stream()
                .min(Double::compare)
                .orElseThrow(RuntimeException::new);
    }

    public Double findMax() {
        return stack.stream()
                .max(Double::compare)
                .orElseThrow(RuntimeException::new);
    }

    public Double getThirdFromStart() {
        if (size() < 3) {
            return Double.NaN;
        }
        return stack.get(2);
    }

    public Double getSecondFromEnd() {
        if (size() < 2) {
            return Double.NaN;
        }
        return stack.get(size() - 2);
    }

    public Double getElementBeforeMin() {
        Double minElement = findMin();
        int index = findPosition(minElement);

        if (index == 0) {
            return Double.NaN;
        }
        return stack.get(index - 1);
    }

    public Double getElementAfterMax() {
        Double maxElement = findMax();
        int index = findPosition(maxElement);

        if (index == size() - 1) {
            return Double.NaN;
        }
        return stack.get(index + 1);
    }

    public int findPosition(Double element) {
        if (!stack.contains(element)) {
            return 0;
        }
        return stack.indexOf(element);
    }

    public StackImpl merge(StackImpl otherStack) {
        StackImpl mergedStack = new StackImpl();
        mergedStack.stack.addAll(this.stack);
        mergedStack.stack.addAll(otherStack.stack);
        return mergedStack;
    }
}

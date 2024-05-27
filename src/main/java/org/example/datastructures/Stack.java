package org.example.datastructures;

import org.example.datastructures.impl.StackImpl;

public interface Stack {
    void push(Double element);

    public Double pop();

    Double peek();

    boolean isEmpty();

    int size();

    void clear();

    Double findMin();

    Double findMax();

    Double getThirdFromStart();

    Double getSecondFromEnd();

    Double getElementBeforeMin();

    Double getElementAfterMax();

    int findPosition(Double element);

    StackImpl merge(StackImpl otherStack);
}

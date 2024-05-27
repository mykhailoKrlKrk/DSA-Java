package org.example.datastructures;

import java.util.ArrayList;
import org.example.datastructures.impl.BinarySearchThreeImpl;

public interface BinarySearchThree {
    boolean insert(Double value);

    boolean contains(Double value);

    ArrayList<Double> DFSPreOrder();

    int height();

    BinarySearchThreeImpl.Node findNode(Double value);

    BinarySearchThreeImpl.Node getParent(Double value);

    ArrayList<Double> getDescendants(Double value);
}

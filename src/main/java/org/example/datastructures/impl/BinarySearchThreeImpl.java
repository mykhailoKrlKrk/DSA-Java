package org.example.datastructures.impl;

import java.util.ArrayList;
import java.util.Objects;
import org.example.datastructures.BinarySearchThree;
public class BinarySearchThreeImpl implements BinarySearchThree {
    private Node root;

    public static class Node {
        public Double value;
        public Node right;
        public Node left;
        public Node previous;

        private Node(Double value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public boolean insert(Double value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (Objects.equals(newNode.value, temp.value)) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    newNode.previous = temp;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    newNode.previous = temp;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    @Override
    public boolean contains(Double value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Double> DFSPreOrder() {
        ArrayList<Double> results = new ArrayList<>();
        class Traverse {
            Traverse(Node current) {
                results.add(current.value);
                if (current.left != null) {
                    new Traverse(current.left);
                }
                if (current.right != null) {
                    new Traverse(current.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public int height() {
        return calculateHeight(getRoot());
    }

    private int calculateHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = 1;
        while (root.left != null) {
            leftHigh++;
            root = root.left;
        }
        int rightHigh = 1;
        while (root.right != null) {
            rightHigh++;
            root = root.right;
        }
        return Math.max(rightHigh, leftHigh);
    }

    public Node findNode(Double value) {
        return findNode(root, value);
    }

    private Node findNode(Node root, Double value) {
        if (root == null) {
            return null;
        }
        if (root.value.equals(value)) {
            return root;
        }

        while (root.left != null) {
            if (Objects.equals(root.left.value, value)) {
                return root.left;
            }
            root = root.left;
        }
        while (root.right != null) {
            if (Objects.equals(root.right.value, value)) {
                return root.right;
            }
            root = root.right;
        }
        return null;
    }

    public Node getParent(Double value) {
        return findParentNode(root, value);
    }

    private Node findParentNode(Node node, Double value) {
        if (node == null || node.left.value.equals(value)
                || node.right.value.equals(value)) {
            return node;
        }
        if (value < node.value) {
            return findParentNode(node.left, value);
        } else {
            return findParentNode(node.right, value);
        }
    }

    public ArrayList<Double> getDescendants(Double value) {
        ArrayList<Double> descendants = new ArrayList<>();
        Node node = findNode(value);
        if (node.right != null) {
            descendants.add(node.right.value);
        } else if (node.left != null) {
            descendants.add(node.left.value);
        }
        return descendants;
    }
}

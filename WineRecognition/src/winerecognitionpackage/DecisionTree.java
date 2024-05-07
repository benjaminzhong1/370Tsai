package winerecognitionpackage;

import java.util.HashMap;
import java.util.Map;

public class DecisionTree {
    private TreeNode root;

    // Constructor
    public DecisionTree(TreeNode root) {
        this.root = root;
    }

    // Predict method to predict the class label for a given instance
    public int predict(double[] instance) {
        return traverseTree(instance, root);
    }

    // Traverse the decision tree to predict the class label for a given instance
    private int traverseTree(double[] instance, TreeNode node) {
        if (node.isLeaf()) {
            return node.getPredictedClass(); // Return the predicted class label
        } else {
            DecisionNode decisionNode = node.getDecisionNode();
            int attributeIndex = decisionNode.getAttributeIndex();
            double threshold = decisionNode.getThreshold();

            // Check the attribute value of the instance
            if (instance[attributeIndex] <= threshold) {
                return traverseTree(instance, node.getLeftChild()); // Traverse left
            } else {
                return traverseTree(instance, node.getRightChild()); // Traverse right
            }
        }
    }

    // Method to print the decision tree (for debugging purposes)
    public void printTree() {
        printNode(root, 0);
    }

    private void printNode(TreeNode node, int depth) {
        if (node.isLeaf()) {
            System.out.println(getIndent(depth) + "Predicted Class: " + node.getPredictedClass());
        } else {
            DecisionNode decisionNode = node.getDecisionNode();
            System.out.println(getIndent(depth) + "Decision Node: Attribute " +
                    decisionNode.getAttributeIndex() + " <= " + decisionNode.getThreshold());
            printNode(node.getLeftChild(), depth + 1);
            printNode(node.getRightChild(), depth + 1);
        }
    }

    private String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        DecisionNode decisionNode = new DecisionNode(0, 5.0); // Example decision node
        TreeNode leftChild = new TreeNode(1); // Example left child (leaf node)
        TreeNode rightChild = new TreeNode(0); // Example right child (leaf node)
        decisionNode.setLeftChild(leftChild);
        decisionNode.setRightChild(rightChild);

        DecisionTree tree = new DecisionTree(new TreeNode(decisionNode));
        tree.printTree();

        double[] instance = {4.0}; // Example instance
        int predictedClass = tree.predict(instance);
        System.out.println("Predicted Class: " + predictedClass);
    }
}

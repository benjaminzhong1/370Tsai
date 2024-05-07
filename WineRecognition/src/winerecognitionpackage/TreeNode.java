package winerecognitionpackage;

public class TreeNode {
	private boolean isLeaf;
    private int predictedClass;
    private DecisionNode decisionNode;
    private TreeNode leftChild;
    private TreeNode rightChild;

    // Constructor for leaf node
    public TreeNode(int predictedClass) {
        this.isLeaf = true;
        this.predictedClass = predictedClass;
        this.decisionNode = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Constructor for decision node
    public TreeNode(DecisionNode decisionNode, TreeNode leftChild, TreeNode rightChild) {
        this.isLeaf = false;
        this.predictedClass = -1; // Invalid predicted class for non-leaf nodes
        this.decisionNode = decisionNode;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    // Check if the node is a leaf
    public boolean isLeaf() {
        return isLeaf;
    }

    // Get the predicted class for leaf nodes
    public int getPredictedClass() {
        if (isLeaf) {
            return predictedClass;
        } else {
            throw new IllegalStateException("This node is not a leaf node.");
        }
    }

    // Get the decision node for non-leaf nodes
    public DecisionNode getDecisionNode() {
        if (!isLeaf) {
            return decisionNode;
        } else {
            throw new IllegalStateException("This node is a leaf node.");
        }
    }

    // Get the left child node
    public TreeNode getLeftChild() {
        if (!isLeaf) {
            return leftChild;
        } else {
            throw new IllegalStateException("This node is a leaf node.");
        }
    }

    // Get the right child node
    public TreeNode getRightChild() {
        if (!isLeaf) {
            return rightChild;
        } else {
            throw new IllegalStateException("This node is a leaf node.");
        }
    }
}

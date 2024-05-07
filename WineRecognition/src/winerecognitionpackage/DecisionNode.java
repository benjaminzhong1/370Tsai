package winerecognitionpackage;

public class DecisionNode {
	 	private int attributeIndex; // Index of the attribute used for splitting
	    private double threshold; // Threshold value for splitting
	    private DecisionNode leftChild; // Left child node
	    private DecisionNode rightChild; // Right child node
	    private boolean isLeaf; // Indicates if the node is a leaf
	    private int predictedClass; // Predicted class label for leaf node

	    // Constructor for decision node
	    public DecisionNode(int attributeIndex, double threshold) {
	        this.attributeIndex = attributeIndex;
	        this.threshold = threshold;
	        this.leftChild = null;
	        this.rightChild = null;
	        this.isLeaf = false;
	        this.predictedClass = -1; // Initialize to an invalid class label
	    }

	    // Getters and setters
	    public int getAttributeIndex() {
	        return attributeIndex;
	    }

	    public void setAttributeIndex(int attributeIndex) {
	        this.attributeIndex = attributeIndex;
	    }

	    public double getThreshold() {
	        return threshold;
	    }

	    public void setThreshold(double threshold) {
	        this.threshold = threshold;
	    }

	    public DecisionNode getLeftChild() {
	        return leftChild;
	    }

	    public void setLeftChild(DecisionNode leftChild) {
	        this.leftChild = leftChild;
	    }

	    public DecisionNode getRightChild() {
	        return rightChild;
	    }

	    public void setRightChild(DecisionNode rightChild) {
	        this.rightChild = rightChild;
	    }

	    public boolean isLeaf() {
	        return isLeaf;
	    }

	    public void setLeaf(boolean leaf) {
	        isLeaf = leaf;
	    }

	    public int getPredictedClass() {
	        return predictedClass;
	    }

	    public void setPredictedClass(int predictedClass) {
	        this.predictedClass = predictedClass;
	    }
}

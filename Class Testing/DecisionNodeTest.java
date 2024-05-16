package RandomForestNodes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class DecisionNodeTest {

    @Test
    public void testGettersAndSetters() {
        DecisionNode node = new DecisionNode(1, 5.0);
        assertEquals(1, node.getSplittingFeatureIndex());
        assertEquals(5.0, node.getSplittingValue(), 0.001); // Using delta for double comparison

        TreeNode leftChild = new LeafNode(3, List.of(0, 1, 1));
        node.setLeftChild(leftChild);
        assertEquals(leftChild, node.getLeftChild());

        TreeNode rightChild = new LeafNode(3, List.of(1, 0, 1));
        node.setRightChild(rightChild);
        assertEquals(rightChild, node.getRightChild());
    }

    @Test
    public void testDepth() {
        DecisionNode node = new DecisionNode(2, 10.0);
        node.setDepth(3);
        assertEquals(3, node.getDepth());
    }
}
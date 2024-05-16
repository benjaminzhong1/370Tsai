package RandomForestNodes;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class LeafNodeTest {

    @Test
    public void testConstructor() {
        List<Integer> labels = new ArrayList<>();
        labels.add(0);
        labels.add(0);
        labels.add(1);

        LeafNode leafNode = new LeafNode(3, labels);

        assertNotNull(leafNode);
        assertArrayEquals(new double[]{0.67, 0.33, 0.0}, leafNode.getLabelProbDist(), 0.01); // Use delta for double comparison
    }

    @Test
    public void testGetLabelProbDist() {
        List<Integer> labels = new ArrayList<>();
        labels.add(1);
        labels.add(2);

        LeafNode leafNode = new LeafNode(3, labels);

        assertNotNull(leafNode);
        assertArrayEquals(new double[]{0.0, 0.5, 0.5}, leafNode.getLabelProbDist(), 0.01); // Use delta for double comparison
    }
}